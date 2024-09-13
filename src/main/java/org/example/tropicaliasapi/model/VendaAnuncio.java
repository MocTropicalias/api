package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_venda_anuncio")
@Schema(description = "Modelo da tabela tb_venda_anuncio, representando uma venda de anúncio")
public class VendaAnuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_venda_anuncio")
    @Schema(description = "ID da venda de anúncio, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "var_nota_fiscal", nullable = false)
    @Schema(description = "Número da nota fiscal", example = "NF123456")
    private String notaFiscal;

    @Column(name = "dt_data", nullable = false)
    @Schema(description = "Data da venda", example = "2024-01-01")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "num_valor", nullable = false)
    @Schema(description = "Valor da venda", example = "1500")
    private Integer valor;

    @Column(name = "var_produto", nullable = false)
    @Schema(description = "Nome do produto vendido", example = "Cadeira Gamer")
    private String produto;

    @Column(name = "int_quantidade", nullable = false)
    @Schema(description = "Quantidade de produtos vendidos", example = "3")
    private Integer quantidade;

    @Column(name = "createdAt", nullable = true)
    @Schema(description = "Data de criação do registro", example = "2024-01-01")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "deletedAt", nullable = true)
    @Schema(description = "Data de exclusão do registro", example = "2024-12-31")
    @Temporal(TemporalType.DATE)
    private Date deletedAt;

    @Column(name = "fk_int_id_usuario", nullable = false)
    @Schema(description = "ID do usuário que realizou a venda", example = "10")
    private Integer idUsuario;

    @Column(name = "fk_int_id_status_venda", nullable = false)
    @Schema(description = "ID do status da venda", example = "1")
    private Integer idStatusVenda;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdStatusVenda() {
        return idStatusVenda;
    }

    public void setIdStatusVenda(Integer idStatusVenda) {
        this.idStatusVenda = idStatusVenda;
    }
}