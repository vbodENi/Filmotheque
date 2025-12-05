package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> findAllGenres();
    Genre findGenreById(long id);
    Genre saveGenre(Genre genre);
    long updateGenre(Genre genre);
}
