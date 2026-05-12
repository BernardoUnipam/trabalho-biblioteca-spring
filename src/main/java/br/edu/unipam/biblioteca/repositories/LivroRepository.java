package br.edu.unipam.biblioteca.repositories;

import br.edu.unipam.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // ETAPA 2
    // Pelo menos 3 métodos de busca por nome

    // 1. Busca por título exato
    List<Livro> findByTitulo(String titulo);

    // 2. Busca por parte do título (ignorando maiúsculas/minúsculas)
    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    // 3. Busca de livros por uma categoria específica (será usado o ID da categoria)
    List<Livro> findByCategoriaId(Long categoriaId);
}