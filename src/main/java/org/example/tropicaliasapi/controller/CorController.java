package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.Cor;
import org.example.tropicaliasapi.model.Endereco;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.service.CorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cor")
@RestController
@RequestMapping("/cor")
public class CorController {
    CorService corService;

    public CorController(CorService corService) {
        this.corService = corService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos as cores personalizáveis para a Araci")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paletas de cores retornado com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Cor.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(corService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id")
    @Operation(summary = "Procurar paleta de cores pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cor retornado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(responseCode = "404", description = "Paleta de cores não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        Cor cor = corService.getById(id);
        if (cor == null) {
            return new ResponseEntity<>("A paleta de cores não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cor, HttpStatus.OK);
    }
}