package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.StatusVenda;
import org.example.tropicaliasapi.model.VendaAnuncio;
import org.example.tropicaliasapi.repository.StatusVendaRepository;
import org.example.tropicaliasapi.repository.VendaAnuncioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaAnuncioService {
    VendaAnuncioRepository vendaAnuncioRepository;

    public VendaAnuncioService(VendaAnuncioRepository vendaAnuncioRepository) {
        this.vendaAnuncioRepository = vendaAnuncioRepository;
    }

    public List<VendaAnuncio> getAll(){
        return vendaAnuncioRepository.findAll();
    }

    public VendaAnuncio getById(Long id){
        return vendaAnuncioRepository.findById(id).orElse(null);
    }
}
