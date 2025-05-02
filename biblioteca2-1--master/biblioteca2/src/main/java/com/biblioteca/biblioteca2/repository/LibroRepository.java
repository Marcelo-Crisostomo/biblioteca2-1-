package com.biblioteca.biblioteca2.repository;
//1
import com.biblioteca.biblioteca2.model.Libro;
import org.springframework.stereotype.Repository;

//2Importaciones varias
import java.util.ArrayList;
import java.util.Comparator; // Sirve para comparar datos
import java.util.List;// Listas
import java.util.Optional;// Para manejar varios tipos de respuestas y en caso de que sea null evitar un error
import java.util.stream.Collectors;

//3
@Repository
public class LibroRepository {
    //4 Generar un lista vacía
    private List<Libro> listaLibros = new ArrayList<>();

    //5 Constructor que agregue 10 libros a mi lista

    public LibroRepository(){
        listaLibros.add(new Libro(1, "8723872387", "Fuego y Sangre", "Editorial Planeta", 2008, "Marcelo Crisóstomo"));
        listaLibros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez")); listaLibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard")); listaLibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling")); listaLibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling")); listaLibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling")); listaLibros.add(new Libro(7, "9780321127426", "Effective Java", "Addison-Wesley", 2008, "Joshua Bloch")); listaLibros.add(new Libro(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin")); listaLibros.add(new Libro(9, "9780201633610", "Design Patterns", "Addison-Wesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides")); listaLibros.add(new Libro(10, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));

    }

    //7- Metodo para obtener la cantidad de libros
    public int totalLibros(){
        return listaLibros.size();//10
    }

    //8-  Buscar un libro por su isbn
    public Optional<Libro> buscarPorIsbn(String isbn){
        return listaLibros.stream().filter(libro-> libro.getIsbn().equals(isbn)).findFirst();
    }

    //9 - Cuantos libros se publicaron en un año
    public long contarPorAnio(int anio){
        return listaLibros.stream().filter(libro->libro.getAnioPublicacion()==anio).count();//1
    }

    //10- Buscar todos los libros buscar un autor
    public List<Libro> buscarPorAutor(String autor){
        return listaLibros.stream().filter(libro -> libro.getAutor().equalsIgnoreCase(autor)).collect(Collectors.toList());
    }

    //11- Encontrar libro más antiguo
    public Optional<Libro> libroMasAntiguo(){
        return listaLibros.stream().min(Comparator.comparingInt(Libro::getAnioPublicacion));
    }


    //12-Encontrar el libro mas actual
    public Optional<Libro> libroMasNuevo(){
        return listaLibros.stream().max(Comparator.comparingInt(Libro::getAnioPublicacion));
    }

    //13- Devuelve la lista completa ordenada por año de manera ascendente

    public List<Libro> listarOrdenadosPorAnio(){
        return listaLibros.stream().sorted(Comparator.comparingInt(Libro::getAnioPublicacion))
                .collect(Collectors.toList());
    }


}
