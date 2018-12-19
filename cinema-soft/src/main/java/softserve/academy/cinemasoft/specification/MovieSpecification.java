package softserve.academy.cinemasoft.specification;

import org.springframework.data.jpa.domain.Specification;
import softserve.academy.cinemasoft.model.Movie;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

public class MovieSpecification {


    //    public static Specification<Movie> directorNameContains(String query){
//
//       // return ((root, criteriaQuery, criteriaBuilder) -> getContainsPredicate(criteriaBuilder,root.get("director"),query));
//    }
    public static Specification<Movie> directorNameContains(String name) {
        String searchPhrase = "%"+name+"%";
        return (root, query, cb) -> cb.like(root.get("director"), searchPhrase);

    }
}
