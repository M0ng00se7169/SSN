package com.nekit.ssn.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class MetaDTO {
    private String title;
    private String description;
    private String cover;

    public MetaDTO(String title, String description, String cover) {
        this.title = title;
        this.description = description;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaDTO metaDTO = (MetaDTO) o;
        return title.equals(metaDTO.title) && description.equals(metaDTO.description) && cover.equals(metaDTO.cover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, cover);
    }
}
