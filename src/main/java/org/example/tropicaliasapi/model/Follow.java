package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Table(name = "tb_follow")
@Entity
@Schema(description = "Representa o ato de seguir uma pessoa -> Cada pessoa que segue outra gera um registro nessa tabela")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_follow")
    @Schema(description = "ID do relacionamento de follow, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "fk_int_id_seguidor", nullable = false)
    @Schema(description = "ID do usuário que segue", example = "101")
    private Integer idSeguidor;

    @Column(name = "fk_int_id_seguido", nullable = false)
    @Schema(description = "ID do usuário que é seguido", example = "202")
    private Integer idSeguido;

    @Column(name = "createdAt", nullable = true)
    @Schema(description = "Data em que o follow foi criado", example = "2024-01-01")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "deletedAt", nullable = true)
    @Schema(description = "Data em que o follow foi removido", example = "2024-12-31")
    @Temporal(TemporalType.DATE)
    private Date deletedAt;

    public Follow(Integer idSeguidor, Integer idSeguido) {
        this.idSeguidor = idSeguidor;
        this.idSeguido = idSeguido;
    }

    public Follow(){}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdSeguidor() {
        return idSeguidor;
    }

    public void setIdSeguidor(Integer idSeguidor) {
        this.idSeguidor = idSeguidor;
    }

    public Integer getIdSeguido() {
        return idSeguido;
    }

    public void setIdSeguido(Integer idSeguido) {
        this.idSeguido = idSeguido;
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

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", idSeguidor=" + idSeguidor +
                ", idSeguido=" + idSeguido +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
