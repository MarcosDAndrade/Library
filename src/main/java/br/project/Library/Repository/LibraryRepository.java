package br.project.Library.Repository;

import br.project.Library.Entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Books, Long> {
}
