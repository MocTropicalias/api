package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.StatusVenda;
import org.example.tropicaliasapi.model.Ticket;
import org.example.tropicaliasapi.repository.StatusVendaRepository;
import org.example.tropicaliasapi.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    TicketRepository ticketRepository;

    UserService userService;
    EventoService eventoService;

    public TicketService(TicketRepository ticketRepository, UserService userService, EventoService eventoService) {
        this.ticketRepository = ticketRepository;
        this.userService = userService;
        this.eventoService = eventoService;
    }

    public List<Ticket> getAll(){
        return ticketRepository.findAll();
    }

    public Ticket getById(Long id){
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket cadastrarUserEvento(Long userId, Long eventoId){


        if (userService.getUserByID(userId) == null) {
            return null;
        }

        if (eventoService.getById(eventoId) == null) {
            return null;
        }

        Ticket ticket = new Ticket(0, userId, eventoId);
        return ticketRepository.save(ticket);
    }

    public ResponseEntity<?> addTickets(Long id, int quantity){
        Ticket ticket = ticketRepository.findById(id).orElse(null);

        if (ticket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ticket não foi encontrado");
        }

        if(quantity < 1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quantidade inválida");
        }

        ticket.setQuantidade(ticket.getQuantidade() + quantity);
        return ResponseEntity.ok(ticketRepository.save(ticket));
    }

}
