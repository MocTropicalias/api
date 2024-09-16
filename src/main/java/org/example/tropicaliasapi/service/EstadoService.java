package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Barraca;
import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.repository.BarracaRepository;
import org.example.tropicaliasapi.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {
    EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> getAll(){
        return estadoRepository.findAll();
    }

    public Estado getById(Long id){
        return estadoRepository.findById(id).orElse(null);
    }
}
