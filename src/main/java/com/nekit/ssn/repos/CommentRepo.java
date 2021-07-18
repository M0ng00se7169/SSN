package com.nekit.ssn.repos;

import com.nekit.ssn.domains.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
