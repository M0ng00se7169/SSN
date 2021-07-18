package com.nekit.ssn.service;

import com.nekit.ssn.domains.Comment;
import com.nekit.ssn.domains.User;
import com.nekit.ssn.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        commentRepo.save(comment);

        return comment;
    }
}
