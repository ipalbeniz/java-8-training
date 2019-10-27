package training;

import com.fasterxml.jackson.databind.ObjectMapper;
import training.model.Movie;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MovieMother {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Map<String, Movie> MOVIES_BY_JSON_FILE = new HashMap<>();

    static Movie starWars() {
        return MOVIES_BY_JSON_FILE.computeIfAbsent("movies/star_wars.json", MovieMother::parseJson);
    }

    static Movie pulpFiction() {
        return MOVIES_BY_JSON_FILE.computeIfAbsent("movies/pulp_fiction.json", MovieMother::parseJson);
    }

    static Movie theGodfather() {
        return MOVIES_BY_JSON_FILE.computeIfAbsent("movies/the_godfather.json", MovieMother::parseJson);
    }

    static Movie closeEncountersOfTheThirdKind() {
        return MOVIES_BY_JSON_FILE.computeIfAbsent("movies/close_encounters_of_the_third_kind.json", MovieMother::parseJson);
    }

    static Movie etTheExtraTerrestrial() {
        return MOVIES_BY_JSON_FILE.computeIfAbsent("movies/et_the_extra_terrestrial.json", MovieMother::parseJson);
    }

    private static Movie parseJson(String movieJsonFile){
        try {
            return OBJECT_MAPPER.readValue(getMovieStream(movieJsonFile), Movie.class);
        } catch (IOException e) {
            return null;
        }
    }

    private static InputStream getMovieStream(String movieJsonFile) {
        return MovieMother.class.getClassLoader().getResourceAsStream(movieJsonFile);
    }
}
