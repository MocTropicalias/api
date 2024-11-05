package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

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

    @Column(name = "fk_int_id_usuario", nullable = false)
    @Schema(description = "ID do usuário que comprou o ticket", example = "10")
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "fk_int_id_evento", referencedColumnName = "pk_int_id_evento", nullable = false)
    @Schema(description = "Evento relacionado ao ticket")
    private Evento evento; // Relacionamento com Evento

    public Ticket(Integer quantidade, Long idUsuario, Evento evento) {
        this.quantidade = quantidade;
        this.idUsuario = idUsuario;
        this.evento = evento;
    }

    public Ticket() {}

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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", evento=" + (evento != null ? evento.getNome() : "null") +
                '}';
    }
}
