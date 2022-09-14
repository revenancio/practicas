package mudanza.mudanzaapi.models.preguntas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PreguntasRepository extends CrudRepository<Preguntas, Long>{}