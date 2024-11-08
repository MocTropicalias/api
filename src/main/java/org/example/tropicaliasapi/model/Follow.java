package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_follow")
@Schema(description = "Representa o ato de seguir uma pessoa -> Cada pessoa que segue outra gera um registro nessa tabela")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_follow")
    @Schema(description = "ID do relacionamento de follow, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "fk_int_id_seguidor", nullable = false)
    @Schema(description = "ID do usuário que segue", example = "101")
    private Long idSeguidor;

    @Column(name = "fk_int_id_seguido", nullable = false)
    @Schema(description = "ID do usuário que é seguido", example = "202")
    private Long idSeguido;

    public Follow(Long idSeguidor, Long idSeguido) {
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

    public Long getIdSeguidor() {
        return idSeguidor;
    }

    public void setIdSeguidor(Long idSeguidor) {
        this.idSeguidor = idSeguidor;
    }

    public Long getIdSeguido() {
        return idSeguido;
    }

    public void setIdSeguido(Long idSeguido) {
        this.idSeguido = idSeguido;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", idSeguidor=" + idSeguidor +
                ", idSeguido=" + idSeguido +
                '}';
    }
}
