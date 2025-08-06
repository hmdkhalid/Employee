package com.example.employee.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "employees")
@Getter
@Setter
@NoArgsConstructor

public class Employee {
    @Id
    private String id;
    private String nom;
    private Double prix;
    private LocalDate date;
    private Integer nombreVillas;

    public Employee(String nom, Double prix, LocalDate date, Integer nombreVillas) {
        this.nom = nom;
        this.prix = prix;
        this.date = date;
        this.nombreVillas = nombreVillas;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Double getPrix() { return prix; }
    public void setPrix(Double prix) { this.prix = prix; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Integer getNombreVillas() { return nombreVillas; }
    public void setNombreVillas(Integer nombreVillas) { this.nombreVillas = nombreVillas; }
}