package com.nekit.ssn.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.nekit.ssn.domains.Views;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@JsonView(Views.Id.class)
public class WsEventDTO {
    private ObjectType objectType;
    private EventType eventType;

    @JsonRawValue
    private String body;

    public WsEventDTO(ObjectType objectType, EventType eventType, String body) {
        this.objectType = objectType;
        this.eventType = eventType;
        this.body = body;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WsEventDTO that = (WsEventDTO) o;
        return objectType == that.objectType && eventType == that.eventType && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectType, eventType, body);
    }
}
