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
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.service.BarracaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Barraca")
@RestController
@RequestMapping("/barraca")
public class BarracaController {
    BarracaService barracaService;

    public BarracaController(BarracaService barracaService) {
        this.barracaService = barracaService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos as barracas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Barracas retornadas com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Barraca.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(barracaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar barraca pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Barraca retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Barraca.class))
            ),
            @ApiResponse(responseCode = "404", description = "Barraca não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        Barraca barraca = barracaService.getById(id);
        if (barraca == null) {
            return new ResponseEntity<>("A barraca não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barraca, HttpStatus.OK);
    }
}
