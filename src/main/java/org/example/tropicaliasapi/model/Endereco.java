package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "tb_endereco")
@Schema(description = "Informações do endereço dos usuários")
public class Endereco {
    @Id
    @Column(name = "int_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "var_cep")
    @Schema(description = "CEP", example = "12345678")
    private String cep;

    @Column(name = "var_cidade")
    @Schema(description = "Nome da Cidade", example = "São Paulo")
    private String cidade;

    @Column(name = "var_rua")
    @Schema(description = "Logradouro do Usuário", example = "Av. Exemplo")
    private String rua;

    @Column(name = "var_estado")
    @Schema(description = "Sigla do estado", example = "SP")
    private String estado;

    @Column(name = "var_complemento")
    @Schema(description = "Complemento do Endereço", examples = {"Casa 20", "Apartamento 28B"})
    private String complemento;

    @Column(name = "int_num_casa")
    @Schema(description = "Número do Terreno", example = "400")
    private long numCasa;

    @Column(name = "deleted_at")
    @Schema(description = "Timestamp da deleção do usuário", example = "1567865345")
    private Long deletedAt;

    @Column(name = "created_at")
    @Schema(description = "Timestamp da criação do usuário", example = "1567865345")
    private Long createdAt;

    public Endereco(long id, String cep, String cidade, String rua, String estado, String complemento, long numCasa, Long deletedAt, Long createdAt) {
        this.id = id;
        this.cep = cep;
        this.cidade = cidade;
        this.rua = rua;
        this.estado = estado;
        this.complemento = complemento;
        this.numCasa = numCasa;
        this.deletedAt = deletedAt;
        this.createdAt = createdAt;
    }

    public Endereco(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public long getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(long numCasa) {
        this.numCasa = numCasa;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", rua='" + rua + '\'' +
                ", estado='" + estado + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numCasa=" + numCasa +
                ", deletedAt=" + deletedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
