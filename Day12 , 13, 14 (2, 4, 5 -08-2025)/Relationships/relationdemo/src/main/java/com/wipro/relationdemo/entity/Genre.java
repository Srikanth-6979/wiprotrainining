package com.wipro.relationdemo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity 
@Data
@Table(name = "genres")
public class Genre {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    int id;

    @Column(name = "genre_description")
    String description;

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    Set<Movie> movies;

}
