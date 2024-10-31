package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_barraca")
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

    @Column(name = "fk_int_id_evento", nullable = false)
    @Schema(description = "ID do evento ao qual a barraca está associada", example = "10")
    private Integer idEvento;

    public Barraca(){}

    public Barraca(String nome, Integer numTickets, Integer idEvento) {
        this.nome = nome;
        this.numTickets = numTickets;
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
                ", idEvento=" + idEvento +
                '}';
    }
}
