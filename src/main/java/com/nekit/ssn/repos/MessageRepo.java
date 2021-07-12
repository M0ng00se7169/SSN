package com.nekit.ssn.repos;

import com.nekit.ssn.domains.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
