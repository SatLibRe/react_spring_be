package com.example.codeengine.expense.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.codeengine.expense.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

