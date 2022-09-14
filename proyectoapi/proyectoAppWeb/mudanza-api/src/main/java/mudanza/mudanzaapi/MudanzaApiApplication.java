package mudanza.mudanzaapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mudanza.mudanzaapi.models.bibliografias.Bibliografia;
import mudanza.mudanzaapi.models.preguntas.Preguntas;
import mudanza.mudanzaapi.services.bibliografiaServices.BibliografiaServices;
import mudanza.mudanzaapi.services.preguntasServices.PreguntasServices;

@SpringBootApplication
public class MudanzaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MudanzaApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (PreguntasServices preguntasServices){
		return args ->{
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Preguntas>> typeReference= new TypeReference<List<Preguntas>>() {};
			String file = "/static/Preguntas.json";
			InputStream inputStream = new ClassPathResource(file).getInputStream();
			try {
				List<Preguntas> preguntas = mapper.readValue(inputStream, typeReference);
				preguntasServices.save(preguntas);
				System.out.println("se grabo");
			} catch (IOException e) {
				System.out.println("");
			}
		};
	}

	@Bean
	CommandLineRunner runner2 (BibliografiaServices bibliografiaServices){
		return args ->{
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Bibliografia>> typeReference= new TypeReference<List<Bibliografia>>() {};
			String file = "/static/Bibliografias.json";
			InputStream inputStream = new ClassPathResource(file).getInputStream();
			try {
				List<Bibliografia> bibliografias = mapper.readValue(inputStream, typeReference);
				bibliografiaServices.save(bibliografias);
				System.out.println("se grabo");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		};
	}


}
