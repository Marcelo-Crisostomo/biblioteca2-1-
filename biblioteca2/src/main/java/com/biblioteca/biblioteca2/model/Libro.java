package com.biblioteca.biblioteca2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data// Creo el acceso a los datos de clase get y set
@NoArgsConstructor// Crear un constructor vacío
@AllArgsConstructor// Crear un constructor que recibe argumentossssss
public class Libro {
    //Atributos Libro
    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int anioPublicacion;
    private String autor;
}
