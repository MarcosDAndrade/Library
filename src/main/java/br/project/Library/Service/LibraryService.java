package br.project.Library.Service;

import br.project.Library.Entities.Books;
import br.project.Library.Repository.LibraryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService (LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }



    public List<Books> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        return libraryRepository.findAll(sort);
    }

    public List<Books> create(Books books){
        libraryRepository.save(books);
        return  list();
    }


    public List<Books> update(Long id, Books books){
            Books existingBooks = libraryRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + id));

            existingBooks.setTitle(books.getTitle());
            existingBooks.setAuthor(books.getAuthor());
            existingBooks.setGender(books.getGender());
            existingBooks.setPublicationYear(books.getPublicationYear());

            libraryRepository.save(existingBooks);

            return list();
    }

    public List<Books> delete(Long id){
        libraryRepository.deleteById(id);
        return list();
    }

}
