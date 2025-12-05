package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.exception.GenreNotFound;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GenreRepositoryImpl implements GenreRepository
{
    private JdbcTemplate jdbcTemplate;

    //injection d'un jdbcTemplate
    public GenreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class GenreRowMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Genre  genre = new Genre();
            genre.setId(rs.getInt("id"));
            genre.setTitre(rs.getString("libelle"));
            return genre;
        }
    }

    @Override
    public List<Genre> findAllGenres() {
        String sql = "select id,libelle from genres";

        List<Genre> genres = jdbcTemplate.query(sql, new GenreRowMapper());
        return genres;
    }

    @Override
    public Genre findGenreById(long id)
    {
        String sql = "select id,libelle from genres where id = ?";
        Genre genre;

        try {
            genre = jdbcTemplate.queryForObject(sql, new GenreRowMapper(), id);

        }catch(EmptyResultDataAccessException e){
            throw new GenreNotFound();
        }
        return genre;
    }

    @Override
    public Genre saveGenre(Genre genre)
    {
        String sql = "insert into genres (id,libelle) values (?, ?)";

        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, genre.getId());
                ps.setString(2, genre.getTitre());
            } };
        jdbcTemplate.update(sql, pss );

        return genre;
    }
}
