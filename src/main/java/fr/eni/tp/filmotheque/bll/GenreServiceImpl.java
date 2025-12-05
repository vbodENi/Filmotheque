package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.dal.GenreRepository;
import fr.eni.tp.filmotheque.dal.GenreRepositoryImpl;
import fr.eni.tp.filmotheque.exception.GenreNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService
{

    GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAllGenres() {
        List<Genre> genres = genreRepository.findAllGenres();
        return genres;
    }

    @Override
    public Genre findGenreById(long id)
    {
        Genre genre;
        genre = genreRepository.findGenreById(id);
        return genre;
    }

    @Override
    public Genre saveGenre(Genre genre)
    {
        genreRepository.saveGenre(genre);
        return genre;
    }
}
