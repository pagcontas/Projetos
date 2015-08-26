package com.sislaud.mb.laudo;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.sislaud.bo.laudo.DowloadArquivosBO;
import com.sislaud.modelo.laudo.DowloadArquivos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class DowloadArquivosMB extends AbstractBaseBean<DowloadArquivos> implements Serializable {

    @EJB
    private DowloadArquivosBO dowloadArquivosBO;
    
    private DowloadArquivos arquivo;

    @Override
    public DowloadArquivosBO getBO() {
        return dowloadArquivosBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public StreamedContent downloadArquivo(DowloadArquivos arquivo) throws IOException {

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (DowloadArquivos) proxy.getHibernateLazyInitializer().getImplementation();
        }

        String nomeArquivo = arquivo.getNome();
        String extensaoArquivo = arquivo.getExtensao();

        File file = File.createTempFile(nomeArquivo, extensaoArquivo);

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(arquivo.getConteudo());
        outputStream.flush();
        outputStream.close();

        return new DefaultStreamedContent(new FileInputStream(file), extensaoArquivo, nomeArquivo);
    }

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        arquivo = new DowloadArquivos();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        arquivo.setConteudo(uploadedFile.getContents());
        getEntity().(arquivo);

        MensagensUtil.adicionaMensagemInfo("Sucesso: ", "Arquivo " + event.getFile().getFileName() + " carregado com sucesso.");
    }

    private String getExtension(String name) {
        return name.replaceAll(".+\\.(.+)", "$1");
    }
}
