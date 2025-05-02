package com.biblioteca.biblioteca2.controller;
//importar clase libro
import com.biblioteca.biblioteca2.model.Libro;
import com.biblioteca.biblioteca2.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//2. importar listas y option
import java.util.List;
import java.util.Optional;

@RestController //Clase de tippppooo controlador rest.....
@RequestMapping("/libros") //para indicarle la ruta base de mi proyecto

public class LibroController {
    @Autowired // inyecta un servicio
    private LibroService libroService;

    //agregar todos los Endpoints de mi API

    @GetMapping("/total")// deifne ruta específica para la ruta que crearé, en este caso total, me dará el total de los libros
    public int totalLibros(){
        return libroService.obtenerTotalLibros();
    }
    @GetMapping("/buscar/isbn/{isbn}")
    public Optional<Libro> buscarPorIsbn(@PathVariable String isbn){
        return libroService.buscarLibroPorIsbn(isbn);
    }
    @GetMapping("/buscar/anio/{anio}")
    public Long contarPorAnio(@PathVariable int anio){
        return libroService.contarLibrosPorAnio(anio);
    }
    @GetMapping("/buscar/autor/{autor}")
    public List<Libro> buscarPorAutor(@PathVariable String autor){
        return libroService.buscarLibrosPorAutor(autor);
    }
    @GetMapping("/buscar/antiguo")
    public Optional<Libro> libroMasAntiguo(){
        return libroService.buscarLibroMasAntiguo();
    }
    @GetMapping("/buscar/nuevo")
    public Optional<Libro> libroMasNuevo(){
        return libroService.buscarLibroMasNuevo();
    }
    @GetMapping("/listar/ordenado")
    public List<Libro> listarOrdenadosPorAnio(){
        return libroService.listarLibrosOrdenadosPorAnio();
    }
}
