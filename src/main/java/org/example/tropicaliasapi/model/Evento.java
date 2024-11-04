package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_evento")
@Schema(description = "Representa um evento cadastrado")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_int_id_evento")
    @Schema(description = "ID do evento, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "var_nome", nullable = false)
    @Schema(description = "Nome do evento", example = "Festa Junina")
    private String nome;

    @Column(name = "var_local", nullable = false)
    @Schema(description = "Local do evento", example = "Praça Central")
    private String local;

    @Column(name = "float_preco_ticket", nullable = true)
    @Schema(description = "Preço do ticket", example = "50.0")
    private Float precoTicket;

    @Column(name = "dt_data_inicio", nullable = false)
    @Schema(description = "Data de início do evento", example = "2024-06-01")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column(name = "dt_data_final", nullable = true)
    @Schema(description = "Data de término do evento", example = "2024-06-30")
    @Temporal(TemporalType.DATE)
    private Date dataFinal;

    @Column(name = "fk_int_id_usuario", nullable = false)
    @Schema(description = "ID do usuário organizador do evento", example = "10")
    private Integer idUsuario;

    @Column(name = "var_imagem")
    @Schema(description = "Imagem do evento")
    private String imagem;

    @Column(name = "var_descricao")
    @Schema(description = "Descrição do evento")
    private String descricao;

    @OneToMany
    @JoinColumn(name = "fk_int_id_evento", referencedColumnName = "pk_int_id_evento")
    @Schema(description = "Lista de barracas associadas ao evento")
    private List<Barraca> barracas;

    public Evento(String nome, String local, Float precoTicket, Date dataInicio, Date dataFinal, Integer idUsuario, String imagem, String descricao) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.precoTicket = precoTicket;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.idUsuario = idUsuario;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public Evento(){}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Float getPrecoTicket() {
        return precoTicket;
    }

    public void setPrecoTicket(Float precoTicket) {
        this.precoTicket = precoTicket;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Barraca> getBarracas() {
        return barracas;
    }

    public void setBarracas(List<Barraca> barracas) {
        this.barracas = barracas;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                ", precoTicket=" + precoTicket +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", idUsuario=" + idUsuario +
                ", imagem='" + imagem + '\'' +
                ", descricao='" + descricao + '\'' +
                ", barracas=" + barracas +
                '}';
    }
}
