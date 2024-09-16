package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.Evento;
import org.example.tropicaliasapi.service.EstadoService;
import org.example.tropicaliasapi.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Evento")
@RestController
@RequestMapping("/evento")
public class EventoController {
    EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos os eventos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eventos retornadas com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Evento.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(eventoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar evento pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class))
            ),
            @ApiResponse(responseCode = "404", description = "Evento não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        Evento evento = eventoService.getById(id);
        if (evento == null) {
            return new ResponseEntity<>("O evento não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
}
