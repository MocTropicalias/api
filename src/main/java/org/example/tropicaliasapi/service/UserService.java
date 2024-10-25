package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.domain.UserCreate;
import org.example.tropicaliasapi.domain.UserReturn;
import org.example.tropicaliasapi.domain.UserUpdate;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.repository.FollowRepository;
import org.example.tropicaliasapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    FollowRepository followRepository;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, FollowRepository followRepository) {
        this.userRepository = userRepository;
        this.followRepository = followRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    //Create//////////////////////////////////////////////////////////////////////////////////

    public User createUser(UserCreate user) {
        // Criptografa a senha antes de salvar
        String encryptedPassword = passwordEncoder.encode(user.getPassword());

        User newUser = new User(
                user.getUsername(),
                user.getEmail(),
                encryptedPassword,  // Usa a senha criptografada
                user.getFirebaseId()
        );
        return userRepository.save(newUser);
    }


    //Read//////////////////////////////////////////////////////////////////////////////////


    public List<User> getAll() {
        return userRepository.findAll();
    }


    public User getByID(Long id) {
        User user = userRepository.findById(id).orElse(null);
        user.setQtSeguidores(followRepository.countFollowsByIdSeguido(id));
        return user;
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
                followRepository.countFollowsByIdSeguido(id),
                followRepository.countFollowsByIdSeguidor(id));

        return userReturn;
    }

    public UserReturn getByFirebaseId(String firebaseId){

        Optional<User> user = userRepository.findUserByFirebaseId(firebaseId);

        if(user.isEmpty()){
            return null;
        }

        UserReturn userReturn = new UserReturn(
                user.get().getId(),
                user.get().getUsername(),
                user.get().getDescricaoUsuario(),
                user.get().getNome(),
                user.get().getUrlFoto(),
                user.get().getFirebaseId(),
                followRepository.countFollowsByIdSeguido(user.get().getId()),
                followRepository.countFollowsByIdSeguidor(user.get().getId()));

        return userReturn;
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
        user.setQtSeguidores(
                followRepository.countFollowsByIdSeguido(
                        Long.parseLong(String.valueOf(id)
                        )
                ));
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
