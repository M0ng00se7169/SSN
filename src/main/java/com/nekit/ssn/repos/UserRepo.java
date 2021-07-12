package com.nekit.ssn.repos;

import com.nekit.ssn.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
