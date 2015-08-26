/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.cadastro;

import br.com.autoescola.autoescola.modelo.cadastro.enums.Categoria;
import br.com.autoescola.autoescola.modelo.cadastro.enums.TipoCNH;
import br.com.autoescola.autoescola.modelo.financeiro.Pagamento;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author killerbee
 */
@Entity
@DiscriminatorValue("1")
public class Aluno extends Pessoa implements Serializable {

    @Size(max = 30)
    private String numeroRenach;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDaMatricula;

    @Temporal(TemporalType.DATE)
    private Date dataDoProcesso;

    private Categoria categoria;

    private TipoCNH tipoCNH;

    @Size(max = 50)
    private String numeroCNH;

    @Temporal(TemporalType.DATE)
    private Date validadeCNH;
    
    @Temporal(TemporalType.DATE)
    private Date dataValidadeProcesso;

    @NotAudited
    @OrderBy("dataPrimeiraParcela")
    @OneToMany(mappedBy = "aluno")
    private List<Pagamento> pagamento;

    public List<Pagamento> getPagamento() {
        return pagamento;
    }

    public void setPagamento(List<Pagamento> pagamento) {
        this.pagamento = pagamento;
    }

    public String getNumeroRenach() {
        return numeroRenach;
    }

    public void setNumeroRenach(String numeroRenach) {
        this.numeroRenach = numeroRenach;
    }

    public Date getDataDaMatricula() {
        return dataDaMatricula;
    }

    public void setDataDaMatricula(Date dataDaMatricula) {
        this.dataDaMatricula = dataDaMatricula;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoCNH getTipoCNH() {
        return tipoCNH;
    }

    public void setTipoCNH(TipoCNH tipoCNH) {
        this.tipoCNH = tipoCNH;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public Date getValidadeCNH() {
        return validadeCNH;
    }

    public void setValidadeCNH(Date validadeCNH) {
        this.validadeCNH = validadeCNH;
    }

    public Date getDataDoProcesso() {
        return dataDoProcesso;
    }

    public void setDataDoProcesso(Date dataDoProcesso) {
        this.dataDoProcesso = dataDoProcesso;
    }

    public Aluno() {
    }

    public Date getDataValidadeProcesso() {
        return dataValidadeProcesso;
    }

    public void setDataValidadeProcesso(Date dataValidadeProcesso) {
        this.dataValidadeProcesso = dataValidadeProcesso;
    }   
      
}
