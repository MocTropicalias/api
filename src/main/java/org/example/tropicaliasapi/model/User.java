package org.example.tropicaliasapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.example.tropicaliasapi.domain.UserUpdate;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "tb_usuario")
@Schema(description = "Informações do usuário")
public class User {

    // Atributos /////////////////////////////////////////////////////////////

    @Id
    @Column(name = "pk_int_id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do usuário, gerado automaticamente", example = "1")
    private Long id;

    @Column(name = "var_email", nullable = false, unique = true)
    @Schema(description = "Email do usuário", example = "example@example.com")
    private String email;

    @Column(name = "var_user_name", nullable = false, unique = true)
    @Schema(description = "Nome do usuário", example = "usuario1")
    private String username;

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

    @Column(name = "var_foto")
    @Schema(description = "URL da foto do usuário", example = "https://url.com/foto.jpg")
    private String urlFoto;

    @Column(name = "deletedat")
    @Schema(description = "Timestamp da deleção do usuário", example = "1622567890")
    private Date deletedAt;

    @Column(name = "createdat", nullable = false)
    @Schema(description = "Timestamp da criação do usuário", example = "1612567890")
    private Date createdAt;

    @Column(name = "var_id_firebase", nullable = false, unique = true)
    @Schema(description = "ID gerado pelo Firebase para o usuário", example = "tKBGsn4xIRMWWzyT2Okim6YuoZ23")
    private String firebaseId;

    @Column(name = "var_role")
    @Schema(description = "Permissão do usuário", example = "ADMIN")
    private String userRole;

    // Construtores /////////////////////////////////////////////////////////////

    public User(String username, String email, String senha, String firebaseId) {
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.firebaseId = firebaseId;
        this.createdAt = Date.valueOf(LocalDate.now());  // Define o timestamp de criação automaticamente
    }

    public User(Long id, String email, String username, String descricaoUsuario, String cpf, String nome, Date nascimento, String senha, String urlFoto, Date deletedAt, Date createdAt, String firebaseId) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.descricaoUsuario = descricaoUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.senha = senha;
        this.urlFoto = urlFoto;
        this.deletedAt = deletedAt;
        this.createdAt = createdAt;
        this.firebaseId = firebaseId;
    }

    public User() {
    }

    // Métodos de Get/Set /////////////////////////////////////////////////////////////

    public void updateUser(UserUpdate updatedUserInformation) {
        if (updatedUserInformation.getEmail() != null) {
            this.email = updatedUserInformation.getEmail();
        }
        if (updatedUserInformation.getUsername() != null) {
            this.username = updatedUserInformation.getUsername();
        }
        if (updatedUserInformation.getDescricaoUsuario() != null) {
            this.descricaoUsuario = updatedUserInformation.getDescricaoUsuario();
        }
        if (updatedUserInformation.getNome() != null) {
            this.nome = updatedUserInformation.getNome();
        }
        if (updatedUserInformation.getSenha() != null) {
            this.senha = updatedUserInformation.getSenha();
        }
        if (updatedUserInformation.getUrlFoto() != null) {
            this.urlFoto = updatedUserInformation.getUrlFoto();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){this.id = id;}

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + username + '\'' +
                ", descricaoUsuario='" + descricaoUsuario + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", senha='" + senha + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", deletedAt=" + deletedAt +
                ", createdAt=" + createdAt +
                ", firebaseId='" + firebaseId + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
