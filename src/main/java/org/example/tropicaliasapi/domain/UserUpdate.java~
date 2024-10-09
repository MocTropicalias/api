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
    private final String userName;

    @Column(name = "var_descricao_usuario")
    @Schema(description = "Biografia do usuário", example = "Lorem ipsum dolor sit amet")
    private final String descricaoUsuario;

    @Column(name = "var_cpf")
    @Schema(description = "CPF", example = "12345678901")
    private final String cpf;

    @Column(name = "var_nome")
    @Schema(description = "Nome de exebição", example = "Lagostin Branco")
    private final String nome;

    @Column(name = "dt_nascimento")
    @Schema(description = "Data de Nascimento", example = "12/12/2022")
    private final Date nascimento;

    @Column(name = "var_senha")
    @Schema(description = "Senha", example = "HLsdasdBDibadhAsaIUidabspaADdiub")
    private final String senha;

    @Column(name = "text_foto")
    @Schema(description = "URL da foto do usuário", example = "https://url.com")
    private final String urlFoto;

    //Constructors//////////////////////////////////////////////////////////////

    public UserUpdate(String email, String userName, String descricaoUsuario, String cpf, String nome, Date nascimento, String senha, String urlFoto) {
        this.email = email;
        this.userName = userName;
        this.descricaoUsuario = descricaoUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.senha = senha;
        this.urlFoto = urlFoto;
    }

    //Get/Sets//////////////////////////////////////////////////////////////

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

}
