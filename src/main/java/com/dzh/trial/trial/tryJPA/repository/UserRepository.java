package com.dzh.trial.trial.tryJPA.repository;

import com.dzh.trial.trial.tryJPA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String>, JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    List<User> findByUname(String uname);

}
