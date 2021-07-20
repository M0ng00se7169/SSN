package com.nekit.ssn.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.nekit.ssn.domains.Message;
import com.nekit.ssn.domains.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonView(Views.FullMessage.class)
public class MessagePageDTO {
    private List<Message> messages;
    private int currentPage;
    private int totalPages;
}
