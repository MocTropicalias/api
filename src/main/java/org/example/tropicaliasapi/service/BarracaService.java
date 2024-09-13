package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Barraca;
import org.example.tropicaliasapi.model.Cor;
import org.example.tropicaliasapi.repository.BarracaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarracaService {
    BarracaRepository barracaRepository;

    public BarracaService(BarracaRepository barracaRepository) {
        this.barracaRepository = barracaRepository;
    }

    public List<Barraca> getAll(){
        return barracaRepository.findAll();
    }

    public Barraca getById(Long id){
        return barracaRepository.findById(id).orElse(null);
    }
}
