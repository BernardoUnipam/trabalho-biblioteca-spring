// ETAPA 2

// Será usado parâmetros na URL (@RequestParam) para decidir qual busca fazer. Se o usuário não passar nenhum parâmetro de busca, listamos todos os livros.

package br.edu.unipam.biblioteca.controllers;

import br.edu.unipam.biblioteca.models.Livro;
import br.edu.unipam.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    // Salvar um novo Livro
    @PostMapping
    public Livro salvarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    // Listar todos e realizar as buscas
    @GetMapping
    public List<Livro> listarEBuscar(
            @RequestParam(required = false) String tituloExato,
            @RequestParam(required = false) String tituloParte,
            @RequestParam(required = false) Long categoriaId) {

        if (tituloExato != null) {
            return livroRepository.findByTitulo(tituloExato);
        }
        
        if (tituloParte != null) {
            return livroRepository.findByTituloContainingIgnoreCase(tituloParte);
        }
        
        if (categoriaId != null) {
            return livroRepository.findByCategoriaId(categoriaId);
        }

        // Se não passou nenhum parâmetro, lista todos
        return livroRepository.findAll();
    }
}