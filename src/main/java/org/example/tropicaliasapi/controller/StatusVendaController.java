package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.StatusVenda;
import org.example.tropicaliasapi.service.EstadoService;
import org.example.tropicaliasapi.service.StatusVendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Estado")
@RestController
@RequestMapping("/estado")
public class StatusVendaController {
    StatusVendaService statusVendaService;

    public StatusVendaController(StatusVendaService statusVendaService) {
        this.statusVendaService = statusVendaService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos os status das vendas realizadas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status retornadas com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StatusVenda.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(statusVendaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar o status de uma venda pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusVenda.class))
            ),
            @ApiResponse(responseCode = "404", description = "Status não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        StatusVenda statusVenda = statusVendaService.getById(id);
        if (statusVenda == null) {
            return new ResponseEntity<>("O status da venda não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(statusVenda, HttpStatus.OK);
    }
}
