package mudanza.mudanzaapi.services.bibliografiaServices;

import java.util.List;

import org.springframework.stereotype.Service;

import mudanza.mudanzaapi.models.bibliografias.BibliografiaRepository;
import mudanza.mudanzaapi.models.bibliografias.Bibliografia;

@Service
public class BibliografiaServices {
    private final BibliografiaRepository bibliografiaRepository;
    public BibliografiaServices(BibliografiaRepository bibliografiaRepository){
        this.bibliografiaRepository = bibliografiaRepository;
    }

    public Iterable<Bibliografia> save(List<Bibliografia> bibliografias){
        return bibliografiaRepository.saveAll(bibliografias);
    }
}