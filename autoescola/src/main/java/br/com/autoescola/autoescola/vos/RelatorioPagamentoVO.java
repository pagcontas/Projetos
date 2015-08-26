/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.vos;

import br.com.autoescola.autoescola.modelo.financeiro.enums.Bandeira;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author killerbee
 */
public class RelatorioPagamentoVO {
    
    private String cpf;
    
    private String aluno;
    
    private Bandeira tipoPagamento;
    
    private String parcela;
    
    private Date pagamento;
    
    private BigDecimal valor;
    
    private Date dataInicial;
    
    private Date dataFinal;

    public RelatorioPagamentoVO() {
    }

    public String getAluno() {
        return aluno;
    }

    public Bandeira getTipoPagamento() {        
        return tipoPagamento;
    }

    public String getParcela() {
        return parcela;
    }

    public Date getPagamento() {
        return pagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public void setTipoPagamento(Bandeira tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public void setPagamento(Date pagamento) {
        this.pagamento = pagamento;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }   
    
}
