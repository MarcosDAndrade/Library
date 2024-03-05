package br.project.Library.Repository;

import br.project.Library.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Book, Long> {
}
