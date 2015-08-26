/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.cadastro;

import com.mycompany.controleestoque.modelo.cadastro.enums.UnidadeDeMedida;
import com.mycompany.controleestoque.modelo.faturamento.Estoque;
import com.mycompany.controleestoque.modelo.faturamento.ItemPedido;
import com.mycompany.controleestoque.modelo.faturamento.ItemVenda;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja_Filial empresa;

    @Size(max = 200)
    private String codigoDeBarra;

    @NotBlank
    @Size(max = 200)
    private String descricao;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fabricante;

    @Size(max = 200)
    private String marca;

    private boolean produtoFracionado = false;

    private boolean comissionado = true;
   
    @Enumerated
    private UnidadeDeMedida unidadeDeFracao;

    @NotNull
    @Enumerated
    private UnidadeDeMedida unidadeDeVenda;

    private Integer qtdFracoes = 2;

    private boolean medicamento = false;

    private boolean pesavel = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private SecoesProduto secao;

    @ManyToOne(fetch = FetchType.LAZY)
    private GruposDeSecoes grupo;

    @NotNull(message = "Preço de Compra é Obrigatório")
    private BigDecimal valorDaCompra;

    @NotNull
    private BigDecimal icmsPreco = BigDecimal.ZERO;

    @NotNull
    private BigDecimal icmsCompra = BigDecimal.ZERO;

    @ManyToOne(fetch = FetchType.LAZY)
    private SituacaoTributaria situacaoTributaria;

    @NotNull
    private BigDecimal ipi = BigDecimal.ZERO;

    private BigDecimal frete = BigDecimal.ZERO;

    @NotNull
    private BigDecimal lucroBruto;

    private BigDecimal lucroLiquido;

    @NotNull
    private BigDecimal precoDeCusto;

    @NotNull(message = "Preço de Venda é Obrigatório")
    private BigDecimal valorDeVenda;

    private BigDecimal valorFracionado;

    private BigDecimal valorRevenda;

    @NotBlank
    @Size(max = 10)
    private String codigoNCM;

    @NotBlank
    @Size(max = 10)
    private String cfop;

    @NotBlank
    @Size(max = 10)
    private String codigoCst;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataInclusao = new Date();

    private boolean ativo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    private GrupoLoja grupoDeLojas;

    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itensPedidos;

    @OneToMany(mappedBy = "produto")
    private List<ItemVenda> itensVenda;

    @NotAudited
    @OrderBy("descricao")
    @OneToMany(mappedBy = "produto")
    private List<Estoque> estoques;

    @Override
    public String toString() {
        return getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fornecedor fabricante) {
        this.fabricante = fabricante;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isProdutoFracionado() {
        return produtoFracionado;
    }

    public void setProdutoFracionado(boolean produtoFracionado) {
        this.produtoFracionado = produtoFracionado;
    }

    public boolean isComissionado() {
        return comissionado;
    }

    public void setComissionado(boolean comissionado) {
        this.comissionado = comissionado;
    }

    public UnidadeDeMedida getUnidadeDeFracao() {
        return unidadeDeFracao;
    }

    public void setUnidadeDeFracao(UnidadeDeMedida unidadeDeFracao) {
        this.unidadeDeFracao = unidadeDeFracao;
    }

    public UnidadeDeMedida getUnidadeDeVenda() {
        return unidadeDeVenda;
    }

    public void setUnidadeDeVenda(UnidadeDeMedida unidadeDeVenda) {
        this.unidadeDeVenda = unidadeDeVenda;
    }

    public Integer getQtdFracoes() {
        return qtdFracoes;
    }

    public void setQtdFracoes(Integer qtdFracoes) {
        this.qtdFracoes = qtdFracoes;
    }

    public boolean isMedicamento() {
        return medicamento;
    }

    public void setMedicamento(boolean medicamento) {
        this.medicamento = medicamento;
    }

    public boolean isPesavel() {
        return pesavel;
    }

    public void setPesavel(boolean pesavel) {
        this.pesavel = pesavel;
    }

    public GruposDeSecoes getGrupo() {
        return grupo;
    }

    public void setGrupo(GruposDeSecoes grupo) {
        this.grupo = grupo;
    }

    public BigDecimal getValorDaCompra() {
        return valorDaCompra;
    }

    public void setValorDaCompra(BigDecimal valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    public BigDecimal getIcmsPreco() {
        return icmsPreco;
    }

    public void setIcmsPreco(BigDecimal icmsPreco) {
        this.icmsPreco = icmsPreco;
    }

    public BigDecimal getIcmsCompra() {
        return icmsCompra;
    }

    public void setIcmsCompra(BigDecimal icmsCompra) {
        this.icmsCompra = icmsCompra;
    }

    public SituacaoTributaria getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public void setSituacaoTributaria(SituacaoTributaria situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public BigDecimal getIpi() {
        return ipi;
    }

    public Loja_Filial getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Loja_Filial empresa) {
        this.empresa = empresa;
    }

    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public BigDecimal getLucroBruto() {
        return lucroBruto;
    }

    public void setLucroBruto(BigDecimal lucroBruto) {
        this.lucroBruto = lucroBruto;
    }

    public BigDecimal getLucroLiquido() {
        return lucroLiquido;
    }

    public void setLucroLiquido(BigDecimal lucroLiquido) {
        this.lucroLiquido = lucroLiquido;
    }

    public BigDecimal getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(BigDecimal precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public BigDecimal getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(BigDecimal valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    public BigDecimal getValorFracionado() {
        return valorFracionado;
    }

    public void setValorFracionado(BigDecimal valorFracionado) {
        this.valorFracionado = valorFracionado;
    }

    public BigDecimal getValorRevenda() {
        return valorRevenda;
    }

    public void setValorRevenda(BigDecimal valorRevenda) {
        this.valorRevenda = valorRevenda;
    }

    public GrupoLoja getGrupoDeLojas() {
        return grupoDeLojas;
    }

    public void setGrupoDeLojas(GrupoLoja grupoDeLojas) {
        this.grupoDeLojas = grupoDeLojas;
    }

    public String getCodigoNCM() {
        return codigoNCM;
    }

    public void setCodigoNCM(String codigoNCM) {
        this.codigoNCM = codigoNCM;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getCodigoCst() {
        return codigoCst;
    }

    public void setCodigoCst(String codigoCst) {
        this.codigoCst = codigoCst;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public SecoesProduto getSecao() {
        return secao;
    }

    public void setSecao(SecoesProduto secao) {
        this.secao = secao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public List<Estoque> getEstoques() {
        return estoques;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public void setEstoques(List<Estoque> estoques) {
        this.estoques = estoques;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
