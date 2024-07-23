package com.example.demo.user;

import com.example.demo.user.exceptions.EmailAlreadyInUseEx;
import com.example.demo.user.exceptions.UserNotFoundByIdEx;
import com.example.demo.user.api.request.CreateUserRequest;
import com.example.demo.user.api.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id){
        return userRepository.findUserById(id).orElseThrow(()-> new UserNotFoundByIdEx(id));
    }

    public void createUser(CreateUserRequest request){
        if(userRepository.existsByEmail(request.email())){
            throw new EmailAlreadyInUseEx(request.email());
        }

        userRepository.save(new User(
                request.firstname(),
                request.lastname(),
                request.email(),
                request.password()
        ));
    }

    public void updateUser(UpdateUserRequest request, Long id){
        User userById = getUserById(id);
        userById.setFirstname(request.firstname());
        userById.setLastname(request.lastname());
        userRepository.save(userById);
    }

    public void deleteUser(Long id){
        User userById = getUserById(id);
        userRepository.delete(userById);
    }
}
