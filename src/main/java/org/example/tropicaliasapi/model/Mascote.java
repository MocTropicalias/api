package org.example.tropicaliasapi.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_mascote")
@Schema(description = "Detalhes sobre o mascote")
public class Mascote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_mascote")
    @Schema(description = "O ID único do mascote", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "var_nome")
    @Schema(description = "O nome do mascote", example = "Fido")
    private String nome;

    @Column(name = "fk_int_id_usuario")
    @Schema(description = "O ID do usuário associado ao mascote", example = "101")
    private Long usuarioId;

    @ManyToOne
    @JoinColumn(name = "fk_int_id_cor_araci", referencedColumnName = "pk_int_id_cor_araci", nullable = false)
    @Schema(description = "A cor araci associada ao mascote")
    private Cor corAraci;

    // Construtor padrão
    public Mascote() {}

    // Construtor com parâmetros
    public Mascote(String nome, Long usuarioId, Cor corAraci) {
        this.nome = nome;
        this.usuarioId = usuarioId;
        this.corAraci = corAraci;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Cor getCorAraci() {
        return corAraci;
    }

    public void setCorAraci(Cor corAraci) {
        this.corAraci = corAraci;
    }

    // Método toString
    @Override
    public String toString() {
        return "Mascote{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", usuarioId=" + usuarioId +
                ", corAraci=" + corAraci +
                '}';
    }
}

