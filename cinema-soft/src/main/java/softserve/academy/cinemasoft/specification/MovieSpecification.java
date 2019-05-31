package softserve.academy.cinemasoft.specification;

import org.springframework.data.jpa.domain.Specification;
import softserve.academy.cinemasoft.model.Movie;

public class MovieSpecification {

    public static Specification<Movie> directorNameContains(String name) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("director")), getSearchPhrase(name));
    }

    public static Specification<Movie> movieRatingGreaterThanOrEqualTo(Double value) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("rating"), value));
    }

    private static String getSearchPhrase(String phrase) {
        return "%" + phrase.toLowerCase() + "%";
    }
}
