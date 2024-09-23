package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_status_venda")
@Schema(description = "Modelo da tabela tb_status_venda, representando o status de uma venda")
public class StatusVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_status_venda")
    @Schema(description = "ID do status de venda, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "var_status_venda", nullable = false)
    @Schema(description = "Descrição do status da venda", example = "Concluída")
    private String statusVenda;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }
}
