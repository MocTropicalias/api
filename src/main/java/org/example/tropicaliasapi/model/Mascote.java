package org.example.tropicaliasapi.model;

import jakarta.persistence.*;
import java.util.Date;
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

    @Column(name = "fk_int_id_cor_araci")
    @Schema(description = "O ID da cor araci associada ao mascote", example = "202")
    private Integer corAraciId;

    // Construtores
    public Mascote() {
    }

    public Mascote(String nome, Long usuarioId, Integer corAraciId) {
        this.nome = nome;
        this.usuarioId = usuarioId;
        this.corAraciId = corAraciId;
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

    public Integer getCorAraciId() {
        return corAraciId;
    }

    public void setCorAraciId(Integer corAraciId) {
        this.corAraciId = corAraciId;
    }

    // Método toString
    @Override
    public String toString() {
        return "Mascote{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", usuarioId=" + usuarioId +
                ", corAraciId=" + corAraciId +
                '}';
    }
}
