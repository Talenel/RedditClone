package groupA;

/**
 * Created by student on 6/20/17.
 */

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditRepository extends CrudRepository<Reddit, Integer> {


    public List<Reddit> findAllByOrderByRedDateDesc();
    public List<Reddit> findAllByRedAuthorOrderByRedDateDesc(String redAuthor);

}