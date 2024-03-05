package br.project.Library.Service;

import br.project.Library.Entities.Book;
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



    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return libraryRepository.findAll(sort);
    }

    public List<Book> create(Book books){
        libraryRepository.save(books);
        return  list();
    }


    public List<Book> update(Long id, Book books){
            Book existingBooks = libraryRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + id));

            existingBooks.setTitle(books.getTitle());
            existingBooks.setAuthor(books.getAuthor());
            existingBooks.setGender(books.getGender());
            existingBooks.setPublicationYear(books.getPublicationYear());

            libraryRepository.save(existingBooks);

            return libraryRepository.findAll();
    }

    public List<Book> delete(Long id){
        libraryRepository.deleteById(id);
        return list();
    }

}
