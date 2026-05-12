package br.edu.unipam.biblioteca.repositories;

import br.edu.unipam.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Os métodos de busca customizados da Etapa 2 serão colocados aqui depois!
}