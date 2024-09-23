package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.VendaAnuncio;
import org.example.tropicaliasapi.model.VendaEvento;
import org.example.tropicaliasapi.service.VendaAnuncioService;
import org.example.tropicaliasapi.service.VendaEventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "VendaAnuncio")
@RestController
@RequestMapping("/vendaevento")
public class VendaEventoController {
    VendaEventoService vendaEventoService;

    public VendaEventoController(VendaEventoService vendaEventoService) {
        this.vendaEventoService = vendaEventoService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos as vendas realizadas dentro do evento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vendas retornadas com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VendaEvento.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(vendaEventoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar as vendas pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venda retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = VendaEvento.class))
            ),
            @ApiResponse(responseCode = "404", description = "Venda não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        VendaEvento vendaEvento = vendaEventoService.getById(id);
        if (vendaEvento == null) {
            return new ResponseEntity<>("A venda não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vendaEvento, HttpStatus.OK);
    }
}
