package semwinf.database;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import semwinf.model.Result;
import semwinf.model.Step;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import semwinf.model.StepVM;

@RepositoryRestResource(collectionResourceRel = "results", path = "results")
@PropertySource("classpath:application.properties")
@Repository("results")
public interface ResultRepository extends MongoRepository<Result, String> {

        List<Result> findAllBytreeid(@Param("treeid") String treeid);

        @Override
        <S extends Result> S insert(S s);
}
