package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.Follow;
import org.example.tropicaliasapi.repository.EstadoRepository;
import org.example.tropicaliasapi.repository.FollowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    FollowRepository followRepository;
    UserService userService;

    public FollowService(FollowRepository followRepository, UserService userService) {
        this.followRepository = followRepository;
        this.userService = userService;
    }

    public List<Follow> getAll(){
        return followRepository.findAll();
    }

    public Follow getById(Long id){
        return followRepository.findById(id).orElse(null);
    }

    public int countFollowers(Long id) {

        if (userService.getByID(id.intValue()) == null) {
            return -1;
        }

        return followRepository.countFollowsByIdSeguido(id);
    }
}
