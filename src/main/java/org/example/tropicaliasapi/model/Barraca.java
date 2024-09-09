package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Table(name = "tb_barraca")
@Entity
@Schema(description = "Representa uma barraca do evento")
public class Barraca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_barraca")
    @Schema(description = "ID da barraca, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "var_nome", nullable = true)
    @Schema(description = "Nome da barraca", example = "Barraca do João")
    private String nome;

    @Column(name = "int_num_tickets", nullable = true)
    @Schema(description = "Número de tickets Usados na Barraca", example = "100")
    private Integer numTickets;

    @Column(name = "createdAt", nullable = true)
    @Schema(description = "Data de criação da barraca", example = "2024-09-01")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "deletedAt", nullable = true)
    @Schema(description = "Data de exclusão da barraca", example = "2024-09-30")
    @Temporal(TemporalType.DATE)
    private Date deletedAt;

    @Column(name = "fk_int_id_evento", nullable = false)
    @Schema(description = "ID do evento ao qual a barraca está associada", example = "10")
    private Integer idEvento;

    public Barraca(){}

    public Barraca(String nome, Integer numTickets, Date createdAt, Date deletedAt, Integer idEvento) {
        this.nome = nome;
        this.numTickets = numTickets;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.idEvento = idEvento;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(Integer numTickets) {
        this.numTickets = numTickets;
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

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "Barraca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numTickets=" + numTickets +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", idEvento=" + idEvento +
                '}';
    }
}
