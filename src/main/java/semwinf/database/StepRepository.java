package semwinf.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import semwinf.model.Step;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import semwinf.model.StepVM;

@RepositoryRestResource(collectionResourceRel = "steps", path = "steps")
@PropertySource("classpath:application.properties")
@Repository("steps")
public interface StepRepository extends MongoRepository<Step, String> {

    List<Step> findByQuestion(@Param("question") String question);

    List<Step> findAllBytreeid(@Param("treeid") String treeid);

    Optional<Step> findById(@Param("Id") String stepid);

    @Override
    <S extends Step> S insert(S s);
}
