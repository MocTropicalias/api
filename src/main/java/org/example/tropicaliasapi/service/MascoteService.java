package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.Mascote;
import org.example.tropicaliasapi.repository.EstadoRepository;
import org.example.tropicaliasapi.repository.MascoteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MascoteService {
    MascoteRepository mascoteRepository;

    CorService corService;

    public MascoteService(MascoteRepository mascoteRepository, CorService corService) {
        this.corService = corService;
        this.mascoteRepository = mascoteRepository;
    }

    public List<Mascote> getAll(){
        return mascoteRepository.findAll();
    }

    public Mascote getById(Long id){
        return mascoteRepository.findById(id).orElse(null);
    }

    public Mascote getByUserId(Long id){return mascoteRepository.getMascoteByUsuarioId(id).orElse(null);}

    public Mascote save(Mascote mascote){
        return mascoteRepository.save(mascote);
    }

    public Mascote criarMascoteCadastro(Long userId){
        Mascote mascote = new Mascote("Araci", userId, corService.getById(0L));
        return save(mascote);
    }

    public Mascote atualizarMascote(Mascote mascote){
        if(mascote.getId() == null){
            return null;
        }

        return save(mascote);
    }
}
