package mudanza.mudanzaapi.services.preguntasServices;

import java.util.List;

import org.springframework.stereotype.Service;

import mudanza.mudanzaapi.models.preguntas.Preguntas;
import mudanza.mudanzaapi.models.preguntas.PreguntasRepository;

@Service
public class PreguntasServices {
    private final PreguntasRepository preguntasRepository;
    public PreguntasServices(PreguntasRepository preguntasRepository){
        this.preguntasRepository= preguntasRepository;
    }
    public Iterable<Preguntas> save(List<Preguntas> preguntas){
        return preguntasRepository.saveAll(preguntas);
    }
}
