package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Evento;
import org.example.tropicaliasapi.model.Ticket;
import org.example.tropicaliasapi.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserService userService;
    private final EventoService eventoService;

    public TicketService(TicketRepository ticketRepository, UserService userService, EventoService eventoService) {
        this.ticketRepository = ticketRepository;
        this.userService = userService;
        this.eventoService = eventoService;
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket getById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?> cadastrarUserEvento(Long userId, Long eventoId) {
        // Verifica se o usuário existe
        if (userService.getUserByID(userId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        // Verifica se o evento existe
        Evento evento = eventoService.getById(eventoId);
        if (evento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado");
        }

        // Cria um novo ticket
        Ticket ticket = new Ticket(0, userId, evento); // Passa a instância de Evento
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketRepository.save(ticket));
    }

    public ResponseEntity<?> addTickets(Long id, int quantity) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);

        if (ticket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ticket não foi encontrado");
        }

        if (quantity < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quantidade inválida");
        }

        // Atualiza a quantidade de tickets
        ticket.setQuantidade(ticket.getQuantidade() + quantity);
        return ResponseEntity.ok(ticketRepository.save(ticket));
    }
}
