package semwinf.database;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import semwinf.model.Tree;
import semwinf.model.TreeVM;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "tree", path = "tree")
@PropertySource("classpath:application.properties")
@Repository("tree")
public interface TreeRepository extends MongoRepository<Tree, String> {

    Optional<Tree> findById(@Param("treeid") String treeid);

    List<Tree> findAll();
    List<Tree> findAllByisFinishedTrue();

    @Override
    <S extends Tree> S insert(S s);
}
