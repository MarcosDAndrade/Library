package br.project.Library.Controller;

import br.project.Library.Entities.Books;
import br.project.Library.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class LibraryRestController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/")
    List<Books> list(){
        return libraryService.list();
    }

    @PostMapping("/")
    ResponseEntity<List<Books>> create(@RequestBody Books books){
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.create(books));
    }

    @PutMapping("{id}")
    List<Books> update(@PathVariable Long id, @RequestBody Books books){
        return libraryService.update(id, books);
    }

    @DeleteMapping("{id}")
    List<Books> delete(@PathVariable Long id){
        return libraryService.delete(id);
    }



}