package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cor_araci")
@Schema(description = "Tabela para as paletas de cores dísponíveis para a personaliação")
public class Cor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_cor_araci")
    @Schema(description = "ID da cor Araci, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "var_primaria", nullable = true)
    @Schema(description = "Cor primária", example = "#E45F15")
    private String corPrimaria;

    @Column(name = "var_secundaria", nullable = true)
    @Schema(description = "Cor secundária", example = "#006996")
    private String corSecundaria;

    @Column(name = "var_fundo", nullable = true)
    @Schema(description = "Cor de fundo", example = "#32B6F4")
    private String corFundo;

    public Cor(){}

    public Cor(String corPrimaria, String corSecundaria, String corFundo) {
        this.corPrimaria = corPrimaria;
        this.corSecundaria = corSecundaria;
        this.corFundo = corFundo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorPrimaria() {
        return corPrimaria;
    }

    public void setCorPrimaria(String corPrimaria) {
        this.corPrimaria = corPrimaria;
    }

    public String getCorSecundaria() {
        return corSecundaria;
    }

    public void setCorSecundaria(String corSecundaria) {
        this.corSecundaria = corSecundaria;
    }

    public String getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(String corFundo) {
        this.corFundo = corFundo;
    }

    @Override
    public String toString() {
        return "Cor{" +
                "id=" + id +
                ", corPrimaria='" + corPrimaria + '\'' +
                ", corSecundaria='" + corSecundaria + '\'' +
                ", corFundo='" + corFundo + '\'' +
                '}';
    }
}
