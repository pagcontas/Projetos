package com.uparquivos.mb.arquivos;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.uparquivos.bo.arquivos.BaseLegalBO;
import com.uparquivos.modelo.upArquivos.Arquivo;
import com.uparquivos.modelo.upArquivos.BaseLegal;
import com.xpert.faces.utils.FacesMessageUtils;
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
public class BaseLegalMB extends AbstractBaseBean<BaseLegal> implements Serializable {

    @EJB
    private BaseLegalBO baseLegalBO;
    
    private Arquivo arquivo;

    @Override
    public BaseLegalBO getBO() {
        return baseLegalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        arquivo = new Arquivo();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        arquivo.setConteudo(uploadedFile.getContents());
        getEntity().setArquivo(arquivo);

        FacesMessageUtils.info("Arquivo carregado com Sucesso!");
    }

    private String getExtension(String name) {
        return name.replaceAll(".+\\.(.+)", "$1");
    }
    
    public StreamedContent downloadArquivo( Arquivo arquivo ) throws IOException {

        if ( arquivo instanceof HibernateProxy ) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (Arquivo) proxy.getHibernateLazyInitializer().getImplementation();
        }

        String nomeArquivo = arquivo.getNome();
        String extensaoArquivo = arquivo.getExtensao();

        File file = File.createTempFile( nomeArquivo, extensaoArquivo );

        FileOutputStream outputStream = new FileOutputStream( file );
        outputStream.write( arquivo.getConteudo() );
        outputStream.flush();
        outputStream.close();

        return new DefaultStreamedContent( new FileInputStream( file ), extensaoArquivo, nomeArquivo );
}
}
