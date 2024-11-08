package org.example.tropicaliasapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

import java.sql.Date;

public class UserUpdate {

    //Attributes//////////////////////////////////////////////////////////////

    @Column(name = "var_email")
    @Schema(description = "Email", example = "example@example.com")
    private final String email;

    @Column(name = "var_user_name")
    @Schema(description = "Nome do usuário", example = "usuario1")
    private final String username;

    @Column(name = "var_descricao_usuario")
    @Schema(description = "Biografia do usuário", example = "Lorem ipsum dolor sit amet")
    private final String descricaoUsuario;

    @Column(name = "var_nome")
    @Schema(description = "Nome de exebição", example = "Lagostin Branco")
    private final String nome;

    @Column(name = "var_senha")
    @Schema(description = "Senha", example = "HLsdasdBDibadhAsaIUidabspaADdiub")
    private final String senha;

    @Column(name = "text_foto")
    @Schema(description = "URL da foto do usuário", example = "https://uploads.jovemnerd.com.br/wp-content/uploads/2023/03/vitrine_shrek_e_mais_animacoes_dreamworks_deixarao_netflix_nerdbunker__2z154j.jpg?ims=1210x544/filters:quality(75)")
    private final String urlFoto;

    //Constructors//////////////////////////////////////////////////////////////

    public UserUpdate(String email, String userName, String descricaoUsuario, String nome, String senha, String urlFoto) {
        this.email = email;
        this.username = userName;
        this.descricaoUsuario = descricaoUsuario;
        this.nome = nome;
        this.senha = senha;
        this.urlFoto = urlFoto;
    }

    //Get/Sets//////////////////////////////////////////////////////////////

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getDescricaoUsuario() {
        return descricaoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

}
