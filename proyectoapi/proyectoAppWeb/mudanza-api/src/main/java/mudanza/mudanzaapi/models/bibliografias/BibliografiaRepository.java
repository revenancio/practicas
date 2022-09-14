package mudanza.mudanzaapi.models.bibliografias;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BibliografiaRepository extends CrudRepository<Bibliografia,Long>{}
