package com.cassitech.bookapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("")
public class BookController {

    @Value("ENV_TEST")
    public String env;

    @GetMapping("/lib/books")
    public List<Livro> getAllBooks() {
        return Arrays.asList(
                new Livro(1L, "O homem mais rico da babilonia", "Fala de um homem rico", "Maluco beleza", 458),
                new Livro(2L, "Clean code", "Codigo limpo", "Um doido ai", 649)
        );
    }

    @GetMapping("/lib/book/{id}")
    public Livro getBookById(@PathVariable Long id) {
        List<Livro> dataBase = Arrays.asList(
                new Livro(1L, "O homem mais rico da babilonia", "Fala de um homem rico", "Maluco beleza", 458),
                new Livro(2L, "Clean code", "Codigo limpo", "Um doido ai", 649)
        );
        return dataBase.stream().filter(livro -> Objects.equals(livro.getId(), id)).findFirst().orElse(null);
    }

    @DeleteMapping("/lib/book/{id}")
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

    @GetMapping("/health")
    public String health() {
        return "O serviço esta de online " + env;
    }


}
