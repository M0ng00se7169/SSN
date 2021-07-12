package com.nekit.ssn.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.nekit.ssn.domains.Message;
import com.nekit.ssn.domains.Views;
import com.nekit.ssn.repos.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageRepo messages;

    @Autowired
    public MessageController(MessageRepo messages) {
        this.messages = messages;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messages.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationDate(LocalDateTime.now());
        return messages.save(message);
    }

    @PutMapping("{id}")
    public Message update(
            @PathVariable("id") Message messageFromDB,
            @RequestBody Message message
    ) {
        BeanUtils.copyProperties(message, messageFromDB, "id");
        return messages.save(messageFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messages.delete(message);
    }
}
