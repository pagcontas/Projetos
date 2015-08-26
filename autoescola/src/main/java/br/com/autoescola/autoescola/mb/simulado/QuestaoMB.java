package br.com.autoescola.autoescola.mb.simulado;

import br.com.autoescola.autoescola.bo.simulado.AlternativaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.autoescola.autoescola.bo.simulado.QuestaoBO;
import br.com.autoescola.autoescola.modelo.simulado.Alternativa;
import br.com.autoescola.autoescola.modelo.simulado.Questao;
import com.xpert.core.exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author killerbee
 */
@ManagedBean
@ViewScoped
public class QuestaoMB extends AbstractBaseBean<Questao> implements Serializable {

    @EJB
    private QuestaoBO questaoBO;

    @EJB
    private AlternativaBO alternativaBO;

    private List<Alternativa> alternativasTemp;

    private Alternativa alternativaTemp;
    
    private Alternativa alternativaDel;

    @Override
    public QuestaoBO getBO() {
        return questaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        alternativaTemp = new Alternativa();
        alternativaDel = new Alternativa();
        alternativasTemp = new ArrayList<Alternativa>();
    }

    public List<Alternativa> getAlternativasTemp() {
        return alternativasTemp;
    }

    public void setAlternativasTemp(List<Alternativa> alternativasTemp) {
        this.alternativasTemp = alternativasTemp;
    }

    public Alternativa getAlternativaTemp() {
        return alternativaTemp;
    }

    public void setAlternativaTemp(Alternativa alternativaTemp) {
        this.alternativaTemp = alternativaTemp;
    }

    public Alternativa getAlternativaDel() {
        return alternativaDel;
    }

    public void setAlternativaDel(Alternativa alternativaDel) {
        this.alternativaDel = alternativaDel;
    }
    
    public void addAlternativas() {
        Alternativa alternativaAdd = new Alternativa();
        int contCorreta = 0;
        int contLetra = 0;
        int contFalsas = 0;

        if (alternativasTemp.size() > 0) {
            for (Alternativa alternativa : alternativasTemp) {
                if (alternativa.isCorreta() && alternativaTemp.isCorreta()) {
                    contCorreta++;
                }
                if (alternativa.getLetra() == alternativaTemp.getLetra()) {
                    contLetra++;
                }
                if (!alternativa.isCorreta() && !alternativaTemp.isCorreta()) {
                    contFalsas++;
                }
            }
        }

        if (contCorreta > 0) {
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não pode existir mais de uma resposta correta!", null);
            FacesContext.getCurrentInstance().addMessage(null, message1);
        }
        if (contLetra > 0) {
            FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não pode existir a mesma letra para uma questão!", null);
            FacesContext.getCurrentInstance().addMessage(null, message2);
        }
        if (contFalsas == 4) {
            FacesMessage message4 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deve Existir uma resposta Correta!", null);
            FacesContext.getCurrentInstance().addMessage(null, message4);
            contFalsas++;
        }
        if (contCorreta < 1 && contLetra < 1 && contFalsas < 5) {
            alternativaAdd.setLetra(alternativaTemp.getLetra());
            alternativaAdd.setDescricao(alternativaTemp.getDescricao());
            alternativaAdd.setCorreta(alternativaTemp.isCorreta());
            alternativaAdd.setCaminhoIMG(alternativaTemp.getCaminhoIMG());
            alternativaAdd.setQuestao(getEntity());

            alternativasTemp.add(alternativaAdd);
        }

    }
    
    public void deleteAlternativa(){
        alternativasTemp.remove(alternativaDel);
    }

    @Override
    public void save() {
        if (alternativasTemp.size() == 5) {
            super.save();
            for (Alternativa alternativa : alternativasTemp) {
                try {
                    alternativa.setQuestao(getEntity());
                    alternativaBO.save(alternativa);
                } catch (BusinessException ex) {
                    Logger.getLogger(QuestaoMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } else {
            FacesMessage message3 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "As alternativas tem que ser de A-D ou de A-E!", null);
            FacesContext.getCurrentInstance().addMessage(null, message3);
        }
    }

}
