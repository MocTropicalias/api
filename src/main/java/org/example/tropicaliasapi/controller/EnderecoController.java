package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.Endereco;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Endereço")
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos os endereços")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereços retornado com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Endereco.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(enderecoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id")
    @Operation(summary = "Procurar endereço pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço retornado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Endereco.class))
            ),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        Endereco endereco = enderecoService.getById(id);
        if (endereco == null) {
            return new ResponseEntity<>("O endereço não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }
}
