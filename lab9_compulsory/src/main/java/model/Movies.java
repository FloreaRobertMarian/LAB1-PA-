package model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.findById",
                query = "SELECT movie FROM Movies movie WHERE movie.id=:id")
})
public class Movies {
    private String id;
    private String title;
    private Time releaseDate;
    private Byte duration;
    private Long score;

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 256)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "RELEASE_DATE", nullable = true)
    public Time getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Time releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "DURATION", nullable = true, precision = 0)
    public Byte getDuration() {
        return duration;
    }

    public void setDuration(Byte duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "SCORE", nullable = true, precision = 2)
    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movies movies = (Movies) o;

        if (id != null ? !id.equals(movies.id) : movies.id != null) return false;
        if (title != null ? !title.equals(movies.title) : movies.title != null) return false;
        if (releaseDate != null ? !releaseDate.equals(movies.releaseDate) : movies.releaseDate != null) return false;
        if (duration != null ? !duration.equals(movies.duration) : movies.duration != null) return false;
        if (score != null ? !score.equals(movies.score) : movies.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
