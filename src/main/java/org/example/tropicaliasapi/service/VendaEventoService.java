package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.VendaAnuncio;
import org.example.tropicaliasapi.model.VendaEvento;
import org.example.tropicaliasapi.repository.VendaAnuncioRepository;
import org.example.tropicaliasapi.repository.VendaEventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaEventoService {
    VendaEventoRepository vendaEventoRepository;

    public VendaEventoService(VendaEventoRepository vendaEventoRepository) {
        this.vendaEventoRepository = vendaEventoRepository;
    }

    public List<VendaEvento> getAll(){
        return vendaEventoRepository.findAll();
    }

    public VendaEvento getById(Long id){
        return vendaEventoRepository.findById(id).orElse(null);
    }
}
