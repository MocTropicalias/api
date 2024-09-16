package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.Barraca;
import org.example.tropicaliasapi.model.Cor;
import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.service.BarracaService;
import org.example.tropicaliasapi.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Estado")
@RestController
@RequestMapping("/estado")
public class EstadoController {
    EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos os estados do Brasil")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estados retornadas com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Estado.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(estadoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar evento pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estado retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estado.class))
            ),
            @ApiResponse(responseCode = "404", description = "Estado não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        Estado estado = estadoService.getById(id);
        if (estado == null) {
            return new ResponseEntity<>("O estado não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estado, HttpStatus.OK);
    }
}
