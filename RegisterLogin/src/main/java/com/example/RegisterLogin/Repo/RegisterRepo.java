package com.example.RegisterLogin.Repo;

import com.example.RegisterLogin.Entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer> {

    Optional<Register> findByRegisterEmailAndPassword(String registerEmail, String password);

    Register findByRegisterEmail(String email);

}
