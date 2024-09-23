package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_venda_evento")
@Schema(description = "Modelo da tabela tb_venda_evento, representando uma venda realizada em um evento")
public class VendaEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_venda_evento")
    @Schema(description = "ID da venda no evento, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "num_valor", nullable = false)
    @Schema(description = "Valor da venda", example = "250")
    private Integer valor;

    @Column(name = "createdAt", nullable = true)
    @Schema(description = "Data de criação do registro da venda", example = "2024-01-01")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "deletedAt", nullable = true)
    @Schema(description = "Data de exclusão do registro da venda", example = "2024-12-31")
    @Temporal(TemporalType.DATE)
    private Date deletedAt;

    @Column(name = "fk_int_id_barraca", nullable = false)
    @Schema(description = "ID da barraca onde a venda foi realizada", example = "5")
    private Integer idBarraca;

    @Column(name = "fk_int_id_usuario", nullable = false)
    @Schema(description = "ID do usuário que realizou a venda", example = "10")
    private Integer idUsuario;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
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

    public Integer getIdBarraca() {
        return idBarraca;
    }

    public void setIdBarraca(Integer idBarraca) {
        this.idBarraca = idBarraca;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
