package com.cassitech.bookapi;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/lib")
public class BookController {

    @GetMapping("/books")
    public List<Livro> getAllBooks() {
        return Arrays.asList(
                new Livro(1L, "O homem mais rico da babilonia", "Fala de um homem rico", "Maluco beleza", 458),
                new Livro(2L, "Clean code", "Codigo limpo", "Um doido ai", 649)
        );
    }

    @GetMapping("/book/{id}")
    public Livro getBookById(@PathVariable Long id) {
        List<Livro> dataBase = Arrays.asList(
                new Livro(1L, "O homem mais rico da babilonia", "Fala de um homem rico", "Maluco beleza", 458),
                new Livro(2L, "Clean code", "Codigo limpo", "Um doido ai", 649)
        );
        return dataBase.stream().filter(livro -> Objects.equals(livro.getId(), id)).findFirst().orElse(null);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBookById(@PathVariable Long id) {
        List<Livro> dataBase = Arrays.asList(
                new Livro(1L, "O homem mais rico da babilonia", "Fala de um homem rico", "Maluco beleza", 458),
                new Livro(2L, "Clean code", "Codigo limpo", "Um doido ai", 649)
        );
        final Livro object = dataBase.stream().filter(livro -> Objects.equals(livro.getId(), id)).findFirst().orElse(null);
        if (object != null) {
            dataBase.remove(object);
            return "Book não encontrado";
        }
        return "Book removido";
    }


}
