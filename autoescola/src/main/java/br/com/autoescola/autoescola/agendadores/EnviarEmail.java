package br.com.autoescola.autoescola.agendadores;

import br.com.autoescola.autoescola.bo.cadastro.AlunoBO;
import br.com.autoescola.autoescola.bo.email.ConfiguracaoEmailBO;
import br.com.autoescola.autoescola.bo.email.EmailBO;
import br.com.autoescola.autoescola.bo.financeiro.ParcelasBO;
import br.com.autoescola.autoescola.dao.controleacesso.UsuarioDAO;
import br.com.autoescola.autoescola.modelo.cadastro.Aluno;
import br.com.autoescola.autoescola.modelo.controleacesso.Usuario;
import br.com.autoescola.autoescola.modelo.financeiro.Parcelas;
import com.xpert.core.exception.BusinessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author killerbee
 * @see classe para envio de emails
 */
@Singleton
public class EnviarEmail {

    @EJB
    private ParcelasBO parcelaBO;

    @EJB
    private AlunoBO alunoBO;

    @EJB
    private EmailBO emailBO;

    @EJB
    private ConfiguracaoEmailBO configuracao;

    @EJB
    private UsuarioDAO usuarioDAO;

    @Schedule(dayOfMonth = "*", hour = "9,15", minute = "0", second = "0")
    public void vencimentoPagamentos() throws ParseException {
        StringBuilder mensagem = new StringBuilder("<h2>Os Seguintes Alunos estão próximos do vencimento do Pagamento da Parcela:</h2> <br/> "
                + "<TABLE BORDER=\"1\" WIDTH=\"80%\">");
        mensagem.append("<tr> <td width=\"15%\"> <Strong>CPF</Strong> </td>"
                + "<td width=\"55%\"><Strong>Nome</Strong></td>"
                + "<td width=\"10%\"><Strong>Data de Vencimento</Strong></td>"
                + "</tr>");
        List<Parcelas> parcelas;
        List<Usuario> usuarios;
        usuarios = usuarioDAO.listAll();

        parcelas = parcelaBO.getDAO().list("situacao", false, "datavencimento ASC");

        if (parcelas.size() > 0 && usuarios.size() > 0) {
            boolean existeEmail = false;
            for (Parcelas parcela : parcelas) {
                //montando o email
                if ((diferencaEntreDatas(new Date(), parcela.getDataVencimento()) == 1)) {
                    mensagem.append("<tr> <td width=\"15%\">").append(parcela.getPagamento().getAluno().getCpf()).append("</td>").
                            append("<td width=\"55%\">").append(parcela.getPagamento().getAluno().getNome()).append("</td>").
                            append("<td width=\"10%\">").append(formataData(parcela.getDataVencimento())).append("</td>").
                            append("</tr>");
                    existeEmail = true;
                }
            }

            if (existeEmail) {
                for (Usuario usuario : usuarios) {
                    if (usuario.isReceberEmail()) {
                        try {
                            emailBO.enviar("[Importante] - Vencimentos parcelas",
                                    mensagem.append("</TABLE>").toString(),
                                    configuracao.getDAO().find(2L), usuario.getEmail());
                        } catch (BusinessException ex) {
                            Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

    }

    @Schedule(dayOfMonth = "*", hour = "9,15", minute = "0", second = "0")
    public void vencimentoProcesso() throws ParseException {
        StringBuilder mensagem = new StringBuilder("<h2>Os Seguintes Alunos estão próximos do vencimento do Processo:</h2> <br/> "
                + "<TABLE BORDER=\"1\" WIDTH=\"80%\">");
        mensagem.append("<tr> <td width=\"15%\"> <Strong>CPF</Strong> </td>"
                + "<td width=\"55%\"><Strong>Nome</Strong></td>"
                + "<td width=\"10%\"><Strong>Data de Vencimento</Strong></td>"
                + "</tr>");
        List<Aluno> alunos;
        List<Usuario> usuarios;
        usuarios = usuarioDAO.listAll();

        alunos = alunoBO.getDAO().list("active", true, "nome ASC");

        if (alunos.size() > 0 && usuarios.size() > 0) {
            boolean existeEmail = false;
            for (Aluno aluno : alunos) {
                //montando o email
                if ((diferencaEntreDatas(aluno.getDataDoProcesso(), new Date()) == 15)) {
                    mensagem.append("<tr> <td width=\"15%\">").append(aluno.getCpf()).append("</td>").
                            append("<td width=\"55%\">").append(aluno.getNome()).append("</td>").
                            append("<td width=\"10%\">").append(formataData(aluno.getDataDoProcesso())).append("</td>").
                            append("</tr>");
                    existeEmail = true;
                }
            }

            if (existeEmail) {
                for (Usuario usuario : usuarios) {
                    if (usuario.isReceberEmail()) {
                        try {
                            emailBO.enviar("[Importante] - Termino prazo processos",
                                    mensagem.append("</TABLE>").toString(),
                                    configuracao.getDAO().find(2L), usuario.getEmail());
                        } catch (BusinessException ex) {
                            Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

    }

    private int diferencaEntreDatas(Date data1, Date data2) throws ParseException {
        GregorianCalendar ini = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        ini.setTime(data1);
        fim.setTime(data2);
        long dt1 = ini.getTimeInMillis();
        long dt2 = fim.getTimeInMillis();
        return (int) (((dt2 - dt1) / 86400000) + 1);
    }

    private String formataData(Date data1) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        return sd.format(data1);
    }
}
