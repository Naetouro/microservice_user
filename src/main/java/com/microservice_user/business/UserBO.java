package com.microservice_user.business;

import com.microservice_user.custom.exceptions.ResourceNotFoundException;
import com.microservice_user.data.objects.UserDO;
import com.microservice_user.data.transfer.objects.UserDTO;
import com.microservice_user.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBO {

    @Autowired
    private IUserRepository repo;

    public UserDTO findByNameAndPassword(final UserDTO user) throws ResourceNotFoundException {
        final UserDO newUser = repo.findByNameAndPassword(user.getName(), user.getPassword());

        if (newUser == null) {
            throw new ResourceNotFoundException("User not found");
        }

        final UserDTO dto = new UserDTO();
        dto.setId(newUser.getId());
        dto.setName(newUser.getName());
        dto.setPassword(newUser.getPassword());

        return dto;
    }

    public void save(UserDTO userDTO) {
        try {
            UserDO user = new UserDO();
            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());
            repo.save(user);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
