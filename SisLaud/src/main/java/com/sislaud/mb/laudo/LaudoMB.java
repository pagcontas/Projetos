package com.sislaud.mb.laudo;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.sislaud.bo.laudo.LaudoBO;
import com.sislaud.modelo.laudo.Laudo;
import javax.faces.event.PhaseId;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class LaudoMB extends AbstractBaseBean<Laudo> implements Serializable {

    @EJB
    private LaudoBO laudoBO;

    @Override
    public LaudoBO getBO() {
        return laudoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void uploadArquivo(FileUploadEvent event) {
        //esse if eh para resolver um problema que o upload nao processa os elementos da tela
        if (!PhaseId.INVOKE_APPLICATION.equals(event.getPhaseId())) {
            event.setPhaseId(PhaseId.INVOKE_APPLICATION);
            event.queue();
        } else {

        //aqui vc pode acessar o arquivo
            //nome: event.getFile().getFileName()
            //bytes: event.getFile().getContents()
            //tamanho: event.getFile().getContents().length
            //content type: event.getFile().getContentType()
        //se for escrever o arquivo em pasta pode usar o FileOutpustream, exemplo:
  /*
             FileOutputStream fileOutputStream = new FileOutputStream("/pastaDoArquivo/nomeDoArquivo.extensao");
             try {
             fileOutputStream.write(bytes);
             } finally {
             fileOutputStream.close();
             }


             */
        }
    }

}
