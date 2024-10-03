package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.domain.UserCreate;
import org.example.tropicaliasapi.domain.UserReturn;
import org.example.tropicaliasapi.domain.UserUpdate;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    FollowService followService;

    public UserService(UserRepository userRepository, FollowService followService) {
        this.userRepository = userRepository;
        this.followService = followService;
    }


    //Create//////////////////////////////////////////////////////////////////////////////////

    public User createUser(UserCreate user) {
        User newUser = new User(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getFirebaseId()
        );
        return userRepository.save(newUser);
    }


    //Read//////////////////////////////////////////////////////////////////////////////////


    public List<User> getAll() {
        return userRepository.findAll();
    }


    public User getByID(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserReturn getUserByID(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            return null;
        }

        UserReturn userReturn = new UserReturn(
                id,
                user.get().getUsername(),
                user.get().getDescricaoUsuario(),
                user.get().getNome(),
                user.get().getUrlFoto(),
                user.get().getFirebaseId(),
                followService.countFollowers(id),
                followService.countFollowed(id));

        return userReturn;
    }

    public User getByFirebaseId(String firebaseId){
        return userRepository.findUserByFirebaseId(firebaseId).orElse(null);
    }

    //Update//////////////////////////////////////////////////////////////////////////////////

    public User updatePhoto(int id, String url){
        User user = userRepository.findById(id).orElse(null);

        if(user == null){
            return null;
        }

        user.setUrlFoto(url);
        return userRepository.save(user);
    }

    public User updateUser(int id, UserUpdate updatedUserInformation) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.updateUser(updatedUserInformation);
        return userRepository.save(user);
    }


    //Delete//////////////////////////////////////////////////////////////////////////////////

    public User deleteUserTrue(int id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        userRepository.delete(user);
        return user;
    }

    public User deleteUser(int id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setDeletedAt(Date.valueOf(LocalDate.now()));
        return userRepository.save(user);
    }

}
