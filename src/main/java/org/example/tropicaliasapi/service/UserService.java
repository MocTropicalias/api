package org.example.tropicaliasapi.service;

import org.example.tropicaliasapi.domain.UserCreate;
import org.example.tropicaliasapi.domain.UserUpdate;
import org.example.tropicaliasapi.model.User;
import org.example.tropicaliasapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        newUser.setCreatedAt(new Timestamp(System.currentTimeMillis()).getTime());
        return userRepository.save(newUser);
    }


    //Read//////////////////////////////////////////////////////////////////////////////////


    public List<User> getAll() {
        return userRepository.findAll();
    }


    public User getByID(int id) {
        return userRepository.findById(id).orElse(null);
    }


    //Update//////////////////////////////////////////////////////////////////////////////////


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

        user.setDeletedAt(new Timestamp(System.currentTimeMillis()).getTime());
        return userRepository.save(user);
    }

}
