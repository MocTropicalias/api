package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.Ticket;
import org.example.tropicaliasapi.model.VendaAnuncio;
import org.example.tropicaliasapi.service.TicketService;
import org.example.tropicaliasapi.service.VendaAnuncioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "VendaAnuncio")
@RestController
@RequestMapping("/anuncio")
public class VendaAnuncioController {
    VendaAnuncioService vendaAnuncioService;

    public VendaAnuncioController(VendaAnuncioService vendaAnuncioService) {
        this.vendaAnuncioService = vendaAnuncioService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos os anúncios dos produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anúncios retornadas com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VendaAnuncio.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(vendaAnuncioService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar os anúncios pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tickets retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = VendaAnuncio.class))
            ),
            @ApiResponse(responseCode = "404", description = "Tickets não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        VendaAnuncio vendaAnuncio = vendaAnuncioService.getById(id);
        if (vendaAnuncio == null) {
            return new ResponseEntity<>("O anúncio não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vendaAnuncio, HttpStatus.OK);
    }
}
