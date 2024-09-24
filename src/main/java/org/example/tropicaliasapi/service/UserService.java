package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.domain.UserCreate;
import org.example.tropicaliasapi.domain.UserUpdate;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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


    public User getByID(int id) {
        return userRepository.findById(id).orElse(null);
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
