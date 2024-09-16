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

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAll(){
        return ticketRepository.findAll();
    }

    public Ticket getById(Long id){
        return ticketRepository.findById(id).orElse(null);
    }
}
