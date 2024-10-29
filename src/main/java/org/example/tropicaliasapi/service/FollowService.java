package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.domain.UserReturn;
import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.Follow;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.repository.EstadoRepository;
import org.example.tropicaliasapi.repository.FollowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        if (userService.getByID(id) == null) {
            return -1;
        }

        return followRepository.countFollowsByIdSeguido(id);
    }

    public int countFollowed(Long id){
        if (userService.getByID(id) == null){
            return -1;
        }

        return followRepository.countFollowsByIdSeguidor(id);
    }

    public int followed(Long idSeguido, Long idSeguidor){
        UserReturn seguido = userService.getByID(idSeguido);
        UserReturn seguidor = userService.getByID(idSeguidor);

        if (seguido == null){
            return -1;
        }
        else if (seguidor == null) {
            return -2;
        }
        else if (followRepository.getFollowByIdSeguidoAndIdSeguidor(idSeguidor, idSeguido).isPresent()) {
            followRepository.deleteFollowByIdSeguidoAndIdSeguidor(idSeguido, idSeguidor);
            return 1;
        }

        followRepository.save(new Follow(idSeguidor, idSeguido));
        return 0;
    }

    public ResponseEntity<?> isFollowing(Long idSeguido, Long idSeguidor) {
        UserReturn seguido = userService.getByID(idSeguido);
        UserReturn seguidor = userService.getByID(idSeguidor);

        if (seguido == null){
            return new ResponseEntity<>("Usuário seguido não encontrado!", HttpStatus.NOT_FOUND);
        }
        else if (seguidor == null) {
            return new ResponseEntity<>("Usuário seguidor não encontrado!", HttpStatus.NOT_FOUND);
        }

        if(followRepository.getFollowByIdSeguidoAndIdSeguidor(idSeguido, idSeguidor).isPresent()) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

}
