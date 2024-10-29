package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.StatusVenda;
import org.example.tropicaliasapi.model.Ticket;
import org.example.tropicaliasapi.repository.StatusVendaRepository;
import org.example.tropicaliasapi.repository.TicketRepository;
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
}
