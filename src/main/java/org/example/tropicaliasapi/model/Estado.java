package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

//Criar apenas o consulta geral e por id, o resto dos controles será feito via jdbc pelo 1°
@Table(name = "tb_estado")
@Entity
@Schema(description = "Representa um estado federativo do Brasil")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_estado")
    @Schema(description = "ID do estado, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "var_estado", nullable = false)
    @Schema(description = "Nome do estado", example = "Bahia")
    private String nomeEstado;

    public Estado(){}

    public Estado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nomeEstado='" + nomeEstado + '\'' +
                '}';
    }
}
