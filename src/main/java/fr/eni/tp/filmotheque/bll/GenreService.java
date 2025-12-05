package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAllGenres();
    Genre findGenreById(long id);
    Genre saveGenre(Genre genre);
}
