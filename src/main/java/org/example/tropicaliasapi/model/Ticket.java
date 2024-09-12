package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_ticket")
@Schema(description = "Representa os tickets de um usuário em um evento")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_ticket")
    @Schema(description = "ID do ticket, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "int_quant", nullable = false)
    @Schema(description = "Quantidade de tickets", example = "2")
    private Integer quantidade;

    @Column(name = "createdAt", nullable = true)
    @Schema(description = "Data de criação do ticket", example = "2024-01-01")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "deletedAt", nullable = true)
    @Schema(description = "Data de exclusão do ticket", example = "2024-12-31")
    @Temporal(TemporalType.DATE)
    private Date deletedAt;

    @Column(name = "fk_int_id_usuario", nullable = false)
    @Schema(description = "ID do usuário que comprou o ticket", example = "10")
    private Integer idUsuario;

    @Column(name = "fk_int_id_evento", nullable = false)
    @Schema(description = "ID do evento relacionado ao ticket", example = "5")
    private Integer idEvento;

    public Ticket(Integer quantidade, Integer idUsuario, Integer idEvento) {
        this.quantidade = quantidade;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
    }

    public Ticket(){}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", idUsuario=" + idUsuario +
                ", idEvento=" + idEvento +
                '}';
    }
}
