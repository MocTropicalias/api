package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.Mascote;
import org.example.tropicaliasapi.repository.EstadoRepository;
import org.example.tropicaliasapi.repository.MascoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascoteService {
    MascoteRepository mascoteRepository;

    public MascoteService(MascoteRepository mascoteRepository) {
        this.mascoteRepository = mascoteRepository;
    }

    public List<Mascote> getAll(){
        return mascoteRepository.findAll();
    }

    public Mascote getById(Long id){
        return mascoteRepository.findById(id).orElse(null);
    }

    public Mascote getByUserId(Long id){return mascoteRepository.getMascoteByUsuarioId(id).orElse(null);}
}
