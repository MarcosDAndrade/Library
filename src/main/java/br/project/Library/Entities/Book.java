package br.project.Library.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Cannot be null")

    private String title;
    @NotBlank(message = "Cannot be null")

    private String author;
    @NotBlank(message = "Cannot be null")

    private String gender;

    private Integer publicationYear;
    private Integer quantity;

    public Book(Long id, String title, String author, String gender, Integer publicationYear, Integer quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.gender = gender;
        this.publicationYear = publicationYear;
        this.quantity = quantity;
    }

    public Book(){

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
}