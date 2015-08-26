///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.jsoft.centralfinanceira.agendadores;
//
//import br.com.jsoft.centralfinanceira.bo.controleacesso.UsuarioBO;
//import br.com.jsoft.centralfinanceira.bo.email.ConfiguracaoEmailBO;
//import br.com.jsoft.centralfinanceira.bo.email.EmailBO;
//import br.com.jsoft.centralfinanceira.dao.controleacesso.UsuarioDAO;
//import br.com.jsoft.centralfinanceira.modelo.controleacesso.Usuario;
//import com.xpert.core.exception.BusinessException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.ejb.EJB;
//import javax.ejb.Schedule;
//import javax.ejb.Singleton;
//import javax.swing.text.MaskFormatter;
//
///**
// *
// * @author killerbee
// * @see classe para envio de emails
// */
//@Singleton
//public class EnviarEmail {
//
////    @EJB
////    private ContratoBO contratoBO;
//
//    @EJB
//    private EmailBO emailBO;
//
//    @EJB
//    private ConfiguracaoEmailBO configuracao;
//
//    @EJB
//    private UsuarioDAO usuarioDAO;
//
//    @Schedule(dayOfMonth = "*", hour = "8,14", minute = "0", second = "0")
//    public void dispararAlarme() {
//        StringBuilder mensagem = new StringBuilder("<h2>Os Seguintes contratos estao proximos do termino:</h2> <br/> "
//                + "<TABLE BORDER=\"1\" WIDTH=\"80%\">");
//        mensagem.append("<tr> <td width=\"15%\"> <Strong>Terminal</Strong> </td>"
//                + "<td width=\"55%\"><Strong>Nome Fantasia</Strong></td>"
//                + "<td width=\"10%\"><Strong>Data Final</Strong></td>"
//                + "</tr>");
//        List<Contrato> contratos;
//        List<Usuario> usuarios;
//        usuarios = usuarioDAO.listAll();
//
//        contratos = contratoBO.getDAO().list("ativo", true, "posto_id ASC");
//
//        if (contratos.size() > 0 && usuarios.size() > 0) {
//            boolean existeEmail = false;
//            for (Contrato contrato : contratos) {
//                //montando o email
//                if ((diferencaDatas(contrato.getDataFinal(),new Date()) == 2)) {
//                    mensagem.append("<tr> <td width=\"15%\">").append(contrato.getPosto().getId()).append("</td>").
//                            append("<td width=\"55%\">").append(contrato.getPosto().getNome()).append("</td>").
//                            append("<td width=\"10%\">").append(formataData(contrato.getDataFinal())).append("</td>").
//                            append("</tr>");
//                    existeEmail = true;
//                }
//                //verificando se contrato está vencido se sim ele setar false no ativo
//                if ((diferencaDatas(new Date(),contrato.getDataFinal())==1)) {
//                    contrato.setAtivo(false);
//                }
//            }
//
//            if (existeEmail) {
//                for (Usuario usuario : usuarios) {
//                    if (usuario.isReceberEmail()) {
//                        try {
//                            emailBO.enviar("[Importante] - Termino contratuais Funcionarios",
//                                    mensagem.append("</TABLE>").toString(),
//                                    configuracao.getDAO().find(3L), usuario.getEmail());
//                        } catch (BusinessException ex) {
//                            Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            }
//        }
//
//    }
//
//    private int diferencaDatas(Date data1, Date data2) {
//
//        Calendar a = Calendar.getInstance();
//        a.setTime(data1);//data maior  
//
//        Calendar b = Calendar.getInstance();
//        b.setTime(data2);// data menor  
//
//        a.add(Calendar.DATE, -b.get(Calendar.DAY_OF_MONTH));
//
//        return a.get(Calendar.DAY_OF_MONTH);
//    }
//
//    private String formataData(Date data1) {
//        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
//        return sd.format(data1);
//    }
//
//    private static String format(String pattern, Object value) {
//        MaskFormatter mask;
//        try {
//            mask = new MaskFormatter(pattern);
//            mask.setValueContainsLiteralCharacters(false);
//            return mask.valueToString(value);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
