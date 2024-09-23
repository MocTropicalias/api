package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.StatusVenda;
import org.example.tropicaliasapi.model.Ticket;
import org.example.tropicaliasapi.service.StatusVendaService;
import org.example.tropicaliasapi.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Ticket")
@RestController
@RequestMapping("/ticket")
public class TicketController {
    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos os tickets dos usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tickets retornadas com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ticket.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(ticketService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar os tickets pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tickets retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class))
            ),
            @ApiResponse(responseCode = "404", description = "Tickets não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        Ticket ticket = ticketService.getById(id);
        if (ticket == null) {
            return new ResponseEntity<>("O ticket não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
