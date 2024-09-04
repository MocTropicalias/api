package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Endereco;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }

    public Endereco getById(Long id){
        return enderecoRepository.findById(id).orElse(null);
    }
}
