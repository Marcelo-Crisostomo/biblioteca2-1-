package com.biblioteca.biblioteca2.service;
//1. import modelo libro

import com.biblioteca.biblioteca2.model.Libro;
import com.biblioteca.biblioteca2.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//2. importar listas y optional
import java.util.List; // para trabajar con listas
import java.util.Optional; // para manejar respuestas con datos o sin datos

@Service

public class LibroService {

    @Autowired
    private LibroRepository libroRepository; //3. inyectando el repositorio para poder consumirlo dentro de esta clase

    //4. Llamar a los metodos del repositorio
    public int obtenerTotalLibros(){
        return libroRepository.totalLibros();
    }
    // 5. buscar por isbn
    public Optional<Libro> buscarLibroPorIsbn(String isbn){
        return libroRepository.buscarPorIsbn(isbn);
    }
    //6. buscar el que cuenta los libros por anios
    public long contarLibrosPorAnio(int anio) {
        return libroRepository.contarPorAnio(anio);
    }
    //7.buscar por autor
    public List<Libro> buscarLibrosPorAutor(String autor){
        return libroRepository.buscarPorAutor(autor);
    }
    //8.buscar libro mas antiguo
    public Optional<Libro> buscarLibroMasAntiguo(){
        return libroRepository.libroMasAntiguo();
    }
    //9.buscar libro mas nuevo
    public Optional<Libro> buscarLibroMasNuevo(){
        return libroRepository.libroMasNuevo();
    }
    //10. listar o mostrar todos por orden en annio en asc
    public List<Libro> listarLibrosOrdenadosPorAnio(){
        return libroRepository.listarOrdenadosPorAnio();
    }

}
