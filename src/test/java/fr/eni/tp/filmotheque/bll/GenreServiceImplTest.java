package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.exception.GenreNotFound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GenreServiceImplTest {
    @Autowired
    GenreService genreService;

    @Test
    @DisplayName("test findAllGenres cas plusieurs genres existent") //Optionnel
    public void testFindAllGenreCasPlusieursGenres() {
        //AAA
        //Arrange : Préparation du test

        //Act : Appel de la méthode à tester
        List<Genre> genres = genreService.findAllGenres();

        //Assert : Vérification du résultat du Act
        assertNotNull(genres);
        assertEquals(6, genres.size());
    }

    @Test
    @DisplayName("test findGenreById cas l'id existe")
    public void testFindGenreCasIdExiste() {
        //AAA
        //Arrange : Préparation du test
        int id = 2;

        //Act : Appel de la méthode à tester
        Genre genre = genreService.findGenreById(id);

        //Assert : Vérification du résultat du Act
        assertNotNull(genre);
        assertEquals(id,genre.getId());
        assertEquals("Science-fiction", genre.getTitre());

    }

    @Test
    @DisplayName("test findGenreById cas l'id n'existe pas")
    public void testFindGenreCasIdNExistePas() {
        //AAA
        //Arrange : Préparation du test
        int id = 999;
        //Act : Appel de la méthode à tester
        //Act ET Assert
        assertThrows(GenreNotFound.class, ()->genreService.findGenreById(id));
    }
}
