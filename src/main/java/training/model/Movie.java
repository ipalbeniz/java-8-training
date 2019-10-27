package training.model;

import java.util.List;
import java.util.StringJoiner;

public class Movie {

    private int id;
    private String name;
    private int year;
    private String director;
    private List<String> characters;

    @Override
    public boolean equals(final Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null || this.getClass() != otherObject.getClass()) return false;

        final Movie movie = (Movie) otherObject;

        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Movie.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("year=" + year)
                .add("director='" + director + "'")
                .add("characters=" + characters)
                .toString();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(final String director) {
        this.director = director;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(final List<String> characters) {
        this.characters = characters;
    }
}