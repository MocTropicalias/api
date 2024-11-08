package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.domain.UserCreate;
import org.example.tropicaliasapi.domain.UserReturn;
import org.example.tropicaliasapi.domain.UserUpdate;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.example.tropicaliasapi.utils.Utils.getErros;

@Tag(name = "Usuário")
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    HashMap<String, String> userNotFound = new HashMap<>() {{
        put("details", "Usuário não encontrado");
    }};

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //Create//////////////////////////////////////////////////////////////////////////////////

    @PostMapping
    @Operation(summary = "Criar usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> createUser(@Validated @RequestBody UserCreate user, BindingResult result) {
        Map<String, String> erros = getErros(result);
        if (!erros.isEmpty()) {
            return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }


    //Read//////////////////////////////////////////////////////////////////////////////////

    //All//
    @GetMapping
    @Operation(summary = "Procurar todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários retornado com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    //ByID//
    @GetMapping("/{id}")
    @Operation(summary = "Procurar usuário por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        UserReturn user = userService.getByID(id);
        if (user == null) {
            return new ResponseEntity<>(userNotFound, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //ByFirebaseID//
    @GetMapping("/firebase/{id}")
    @Operation(summary = "Procurar usuário por id do firebase")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") String firebaseId) {
        UserReturn user = userService.getByFirebaseId(firebaseId);
        if (user == null) {
            return new ResponseEntity<>(userNotFound, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/authorization/{email}/{senha}")
    @Operation(summary = "Verificar se o usuário é admin pelo email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário autorizado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(responseCode = "401", description = "Informações inválidas", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não autorizado", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> isUserAuthorized(@PathVariable("email") String email, @PathVariable("senha") String senha) {
        return userService.isUserAuthorized(email, senha);
    }
    //Update//////////////////////////////////////////////////////////////////////////////////

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários retornado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserUpdate.class))
            ),
            @ApiResponse(responseCode = "400", description = "Informações inválidas", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @Validated @RequestBody UserUpdate user, BindingResult result) {
        Map<String, String> erros = getErros(result);
        if (!erros.isEmpty()) {
            return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
        }
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser == null) {
            return new ResponseEntity<>(userNotFound, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PutMapping("/photo/{id}/{photo}")
    @Operation( summary = "Adicionar foto para o usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários retornado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserUpdate.class))
            ),
            @ApiResponse(responseCode = "400", description = "Informações inválidas", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @PathVariable("photo") String url,BindingResult result) {
        Map<String, String> erros = getErros(result);
        if (!erros.isEmpty()) {
            return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
        }
        User user = userService.updatePhoto(id, url);
        if (user == null) {
            return new ResponseEntity<>(userNotFound, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Delete//////////////////////////////////////////////////////////////////////////////////


    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário excluído com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserUpdate.class))
            ),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id,
                                        @Parameter(description = "True: excluir o registro do banco, False: apenas adicionar um timestamp de exclusão")
                                        @RequestParam(required = false, defaultValue = "false") boolean trueDelete) {
        if (trueDelete) {
            User deletedUser = userService.deleteUserTrue(id);
            if (deletedUser == null) {
                return new ResponseEntity<>(userNotFound, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(deletedUser, HttpStatus.OK);
        }

        User deletedUser = userService.deleteUser(id);
        if (deletedUser == null) {
            return new ResponseEntity<>(userNotFound, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);

    }


}
