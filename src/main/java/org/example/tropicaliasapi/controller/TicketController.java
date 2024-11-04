package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.Ticket;
import org.example.tropicaliasapi.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Ticket")
@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos os tickets dos usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tickets retornados com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ticket.class)))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar o ticket pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket retornado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class))),
            @ApiResponse(responseCode = "404", description = "Ticket não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Ticket ticket = ticketService.getById(id);
        if (ticket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ticket não foi encontrado");
        }
        return ResponseEntity.ok(ticket);
    }

    @PostMapping
    @Operation(summary = "Criar um ticket de um usuário (Cadastrar um usuário em um evento)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket retornado com sucesso"),
            @ApiResponse(responseCode = "201", description = "Ticket criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class))),
            @ApiResponse(responseCode = "404", description = "Usuário ou evento não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> createTicket(@RequestParam Long idUser, @RequestParam Long idEvent) {
        return ticketService.cadastrarUserEvento(idUser, idEvent);
    }

    @PatchMapping("/addTickets")
    @Operation(summary = "Adicionar tickets ao saldo de um cliente em um evento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tickets adicionados ao saldo do cliente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class))),
            @ApiResponse(responseCode = "404", description = "Ticket não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> addTickets(@RequestParam Long id, @RequestParam int tickets) {
        return ticketService.addTickets(id, tickets);
    }

    @GetMapping("/uset/{userId}")
    @Operation(summary = "Procurar todos os tickets de um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tickets retornados com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ticket.class)))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByUserId(@PathVariable("userId") Long id) {
        return ResponseEntity.ok(ticketService.getTicketsByUserId(id));
    }
}
