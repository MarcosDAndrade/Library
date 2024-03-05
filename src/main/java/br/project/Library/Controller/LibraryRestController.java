package br.project.Library.Controller;

import br.project.Library.Entities.Book;
import br.project.Library.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryRestController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/list")
    List<Book> list(){
        return libraryService.list();
    }

    @PostMapping("/add")
    ResponseEntity<List<Book>> create(@RequestBody Book books){
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.create(books));
    }

    @PutMapping("/edit/{id}")
    List<Book> update(@PathVariable Long id, @RequestBody Book books){
        return libraryService.update(id, books);
    }

    @DeleteMapping("/delete/{id}")
    List<Book> delete(@PathVariable Long id){
        return libraryService.delete(id);
    }

}