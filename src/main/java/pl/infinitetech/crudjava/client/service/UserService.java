package pl.infinitetech.crudjava.client.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pl.infinitetech.crudjava.client.dto.UserRequest;
import pl.infinitetech.crudjava.client.dto.UserResponse;
import pl.infinitetech.crudjava.client.model.UserEntity;
import pl.infinitetech.crudjava.client.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<UserEntity> getUserList(){
        return (List<UserEntity>) userRepository.findAll();
    }

    public UserResponse getById(Long id){
        return modelMapper.map(userRepository.findById(id),UserResponse.class);
    }

    public UserEntity addUser(UserRequest userRequest){
        UserEntity userEntity = this.modelMapper.map(userRequest, UserEntity.class);
        return userRepository.save(userEntity);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public UserEntity update(UserRequest userRequest, Long id){
        Optional<UserEntity> userEntity = userRepository.findById(id);
        userEntity.get().setFirstName(userRequest.getFirstName());
        userEntity.get().setLastName(userRequest.getLastName());
        userEntity.get().setEmail(userRequest.getEmail());
        userEntity.get().setPhoneNumber(userRequest.getPhoneNumber());
        return userRepository.save(userEntity.get());
    }


}
