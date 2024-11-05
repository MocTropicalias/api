package org.example.tropicaliasapi.service;

import jakarta.transaction.Transactional;
import org.apache.juli.logging.Log;
import org.example.tropicaliasapi.domain.UserReturn;
import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.Follow;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.repository.EstadoRepository;
import org.example.tropicaliasapi.repository.FollowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    // Service
    @Transactional
    public int followed(Long idSeguidor, Long idSeguido){
        UserReturn seguido = userService.getByID(idSeguido);
        UserReturn seguidor = userService.getByID(idSeguidor);

        if (seguido == null) {
            return -1;
        } else if (seguidor == null) {
            return -2;
        } else if (followRepository.getFollowByIdSeguidorAndIdSeguido(idSeguidor, idSeguido).isPresent()) {
            followRepository.deleteByIdSeguidorAndIdSeguido(idSeguidor, idSeguido);
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

        if(followRepository.getFollowByIdSeguidorAndIdSeguido(idSeguidor, idSeguido).isPresent()) {
            return ResponseEntity.ok(Map.of("following", true));
        } else {
            return ResponseEntity.ok(Map.of("following", false));
        }
    }

    public ResponseEntity<?> getAllFollowing(Long idSeguidor) {
        UserReturn usuario = userService.getByID(idSeguidor);
        if (usuario == null) {
            return new ResponseEntity<>("Usuário não encontrado!", HttpStatus.NOT_FOUND);
        }

        List<Follow> follows = followRepository.getFollowsByIdSeguidor(idSeguidor);

        if (follows.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
        }

        List<Long> ids = follows.stream().map(Follow::getIdSeguido).toList();

        return new ResponseEntity<>(ids, HttpStatus.OK);

    }

}
