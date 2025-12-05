package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.exception.GenreNotFound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GenreRepositoryImplTest
{
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("test findAllPizzas cas plusieurs pizzas existent") //Optionnel
    public void testFindAllPizzasCasPlusieursPizzas() {
        //AAA
        //Arrange : Préparation du test

        //Act : Appel de la méthode à tester
        List<Genre> genres = genreRepository.findAllGenres();

        //Assert : Vérification du résultat du Act
        assertNotNull(genres);
        assertEquals(5, genres.size());
    }

    @Test
    @DisplayName("test findGenreById cas l'id existe")
    public void testFindGenreCasIdExiste() {
        //AAA
        //Arrange : Préparation du test
        int id = 2;

        //Act : Appel de la méthode à tester
        Genre genre = genreRepository.findGenreById(id);

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
        /*
        try{
            pizzaRepository.findPizzaById(id);
            fail();
        }catch(PizzaNotFound ex){
            //success
        }*/
        //Act ET Assert
        assertThrows(GenreNotFound.class, ()->genreRepository.findGenreById(id));

    }

    @Test
    @DisplayName("test ajout genre cas droit")
    public void testAjoutGenreCasDroit() {
        //AAA
        //Arrange : Préparation du test
        Genre genre = new Genre(6, "Historique");

        //Act : Appel de la méthode à tester
        Genre newGenre = genreRepository.saveGenre(genre);

        //Assert : Vérification du résultat du Act
        assertNotNull(genre);
        Genre genre1 = genreRepository.findGenreById(genre.getId());
        assertEquals(genre, genre1);

    }
}
