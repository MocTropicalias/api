package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.StatusVenda;
import org.example.tropicaliasapi.repository.EstadoRepository;
import org.example.tropicaliasapi.repository.StatusVendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusVendaService {
    StatusVendaRepository statusVendaRepository;

    public StatusVendaService(StatusVendaRepository statusVendaRepository) {
        this.statusVendaRepository = statusVendaRepository;
    }

    public List<StatusVenda> getAll(){
        return statusVendaRepository.findAll();
    }

    public StatusVenda getById(Long id){
        return statusVendaRepository.findById(id).orElse(null);
    }
}
