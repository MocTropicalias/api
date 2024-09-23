package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.example.tropicaliasapi.domain.UserUpdate;

import java.sql.Date;

@Entity
@Table(name = "tb_usuario")
@Schema(description = "Informações do usuário")
public class User {

    // Atributos /////////////////////////////////////////////////////////////

    @Id
    @Column(name = "pk_int_id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do usuário, gerado automaticamente", example = "1")
    private long id;

    @Column(name = "var_email", nullable = false, unique = true)
    @Schema(description = "Email do usuário", example = "example@example.com")
    private String email;

    @Column(name = "var_user_name", nullable = false, unique = true)
    @Schema(description = "Nome do usuário", example = "usuario1")
    private String userName;

    @Column(name = "var_descricao_usuario")
    @Schema(description = "Biografia do usuário", example = "Lorem ipsum dolor sit amet")
    private String descricaoUsuario;

    @Column(name = "var_cpf", unique = true)
    @Schema(description = "CPF do usuário", example = "12345678901")
    private String cpf;

    @Column(name = "var_nome")
    @Schema(description = "Nome de exibição do usuário", example = "Lagostin Branco")
    private String nome;

    @Column(name = "dt_nascimento")
    @Schema(description = "Data de Nascimento do usuário", example = "1990-12-12")
    private Date nascimento;

    @Column(name = "var_senha", nullable = false)
    @Schema(description = "Senha do usuário", example = "HLsdasdBDibadhAsaIUidabspaADdiub")
    private String senha;

    @Column(name = "text_foto")
    @Schema(description = "URL da foto do usuário", example = "https://url.com/foto.jpg")
    private String urlFoto;

    @Column(name = "deleted_at")
    @Schema(description = "Timestamp da deleção do usuário", example = "1622567890")
    private Long deletedAt;

    @Column(name = "created_at", nullable = false)
    @Schema(description = "Timestamp da criação do usuário", example = "1612567890")
    private Long createdAt;

    @Column(name = "var_id_firebase", nullable = false, unique = true)
    @Schema(description = "ID gerado pelo Firebase para o usuário", example = "tKBGsn4xIRMWWzyT2Okim6YuoZ23")
    private String firebaseId;

    // Construtores /////////////////////////////////////////////////////////////

    public User(String userName, String email, String senha, String firebaseId) {
        this.userName = userName;
        this.email = email;
        this.senha = senha;
        this.firebaseId = firebaseId;
        this.createdAt = System.currentTimeMillis();  // Define o timestamp de criação automaticamente
    }

    public User() {
    }

    // Métodos de Get/Set /////////////////////////////////////////////////////////////

    public void updateUser(UserUpdate updatedUserInformation) {
        this.email = updatedUserInformation.getEmail();
        this.userName = updatedUserInformation.getUserName();
        this.descricaoUsuario = updatedUserInformation.getDescricaoUsuario();
        this.cpf = updatedUserInformation.getCpf();
        this.nome = updatedUserInformation.getNome();
        this.nascimento = updatedUserInformation.getNascimento();
        this.senha = updatedUserInformation.getSenha();
        this.urlFoto = updatedUserInformation.getUrlFoto();
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getDescricaoUsuario() {
        return descricaoUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public String getUrlFoto() {
        return urlFoto;
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

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public void setUrlFoto(String urlFoto){
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", descricaoUsuario='" + descricaoUsuario + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", senha='" + senha + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", deletedAt=" + deletedAt +
                ", createdAt=" + createdAt +
                ", firebaseId='" + firebaseId + '\'' +
                '}';
    }
}
