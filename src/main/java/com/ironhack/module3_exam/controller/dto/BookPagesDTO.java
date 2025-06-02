package com.ironhack.module3_exam.controller.dto;

import jakarta.validation.constraints.Min;

public class BookPagesDTO {
    @Min(value = 0, message = "The book cannot have less than one page")
    private Integer pages;

    public BookPagesDTO() {
    }

    public BookPagesDTO(Integer pages) {
        this.pages = pages;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
