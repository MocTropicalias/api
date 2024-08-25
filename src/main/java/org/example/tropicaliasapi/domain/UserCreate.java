package org.example.tropicaliasapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserCreate {


    //Attributes//////////////////////////////////////////////////////////////

    @NotNull
    @Schema(description = "Nome do usuário", example = "usuario1")
    private final String username;

    @NotNull
    @Schema(description = "Senha", example = "HLsdasdBDibadhAsaIUidabspaADdiub")
    private final String password;

    @NotNull
    @Email
    @Schema(description = "Email", example = "example@example.com")
    private final String email;

    //Constructors//////////////////////////////////////////////////////////////

    public UserCreate(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //Get/Sets//////////////////////////////////////////////////////////////

    public @NotNull String getUsername() {
        return username;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public @NotNull @Email String getEmail() {
        return email;
    }

}

