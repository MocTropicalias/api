package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.Evento;
import org.example.tropicaliasapi.repository.EstadoRepository;
import org.example.tropicaliasapi.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> getAll(){
        return eventoRepository.findAll();
    }

    public Evento getById(Long id){
        return eventoRepository.findById(id).orElse(null);
    }
}
