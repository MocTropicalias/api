package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Cor;
import org.example.tropicaliasapi.repository.CorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorService {
    CorRepository corRepository;

    public CorService(CorRepository corRepository) {
        this.corRepository = corRepository;
    }

    public List<Cor> getAll(){
        return corRepository.findAll();
    }

    public Cor getById(Long id){
        return corRepository.findById(id).orElse(null);
    }
}
