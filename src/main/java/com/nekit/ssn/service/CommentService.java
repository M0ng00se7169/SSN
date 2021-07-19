package com.nekit.ssn.service;

import com.nekit.ssn.domains.Comment;
import com.nekit.ssn.domains.User;
import com.nekit.ssn.domains.Views;
import com.nekit.ssn.dto.EventType;
import com.nekit.ssn.dto.ObjectType;
import com.nekit.ssn.repos.CommentRepo;
import com.nekit.ssn.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}
