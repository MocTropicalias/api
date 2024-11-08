package org.example.tropicaliasapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class UserReturn {
    @NotNull
    @Schema(description = "ID do usuário, gerado automaticamente", example = "1")
    private Long id;

    @Schema(description = "Nome do usuário", example = "usuario1")
    private String username;

    @Schema(description = "Biografia do usuário", example = "Lorem ipsum dolor sit amet")
    private String descricaoUsuario;

    @Schema(description = "Nome de exibição do usuário", example = "Lagostin Branco")
    private String nome;

    @Schema(description = "URL da foto do usuário", example = "https://url.com/foto.jpg")
    private String urlFoto;

    @Schema(description = "ID gerado pelo Firebase para o usuário", example = "tKBGsn4xIRMWWzyT2Okim6YuoZ23")
    private String firebaseId;

    @Schema(description = "Quantidade de Seguidores do usuário")
    private int qtSeguidores;

    @Schema(description = "Quantidade de usuários seguidos")
    private int qtSeguidos;

    @Schema(description = "Tipo de acesso do usuário")
    private String userRole;

    public UserReturn(Long id, String username, String descricaoUsuario, String nome, String urlFoto, String firebaseId, int qtSeguidores, int qtSeguidos, String userRole) {
        this.id = id;
        this.username = username;
        this.descricaoUsuario = descricaoUsuario;
        this.nome = nome;
        this.urlFoto = urlFoto;
        this.firebaseId = firebaseId;
        this.qtSeguidores = qtSeguidores;
        this.qtSeguidos = qtSeguidos;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescricaoUsuario() {
        return descricaoUsuario;
    }

    public void setDescricaoUsuario(String descricaoUsuario) {
        this.descricaoUsuario = descricaoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public int getQtSeguidores() {
        return qtSeguidores;
    }

    public void setQtSeguidores(int qtSeguidores) {
        this.qtSeguidores = qtSeguidores;
    }

    public int getQtSeguidos() {
        return qtSeguidos;
    }

    public void setQtSeguidos(int qtSeguidos) {
        this.qtSeguidos = qtSeguidos;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserReturn{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", descricaoUsuario='").append(descricaoUsuario).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", urlFoto='").append(urlFoto).append('\'');
        sb.append(", firebaseId='").append(firebaseId).append('\'');
        sb.append(", qtSeguidores=").append(qtSeguidores);
        sb.append(", qtSeguidos=").append(qtSeguidos);
        sb.append(", userRole='").append(userRole).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
