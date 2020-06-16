package com.microservice_user.repositories;

import com.microservice_user.data.objects.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserDO, Integer> {
    UserDO findByNameAndPassword(String name, String password);
}
