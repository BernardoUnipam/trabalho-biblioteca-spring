// ETAPA 2

// Responsável por salvar novas categorias

package br.edu.unipam.biblioteca.controllers;

import br.edu.unipam.biblioteca.models.Categoria;
import br.edu.unipam.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public Categoria salvarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}