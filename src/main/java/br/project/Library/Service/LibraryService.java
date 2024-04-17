package br.project.Library.Service;

import br.project.Library.Entities.Book;
import br.project.Library.Exception.EmptySpaceException;
import br.project.Library.Exception.NotNullException;
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

    public List<Book> create(Book book){
        libraryRepository.save(book);
        return  list();
    }


    public List<Book> update(Long id, Book book){
            Book existingBooks = libraryRepository.findById(id).orElseThrow(EmptySpaceException::new);

            existingBooks.setTitle(book.getTitle());
            existingBooks.setAuthor(book.getAuthor());
            existingBooks.setGender(book.getGender());
            existingBooks.setPublicationYear(book.getPublicationYear());
            existingBooks.setQuantity(existingBooks.getQuantity());

            libraryRepository.save(existingBooks);

            return libraryRepository.findAll();
    }

    public List<Book> delete(Long id){
        libraryRepository.deleteById(id);
        return list();
    }

}
