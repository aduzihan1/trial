package com.dzh.trial.trial.tryJPA.repository;

import com.dzh.trial.trial.tryJPA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>, JpaRepository<User, String> {

}
