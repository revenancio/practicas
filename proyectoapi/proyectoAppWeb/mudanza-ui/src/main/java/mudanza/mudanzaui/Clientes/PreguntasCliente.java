package mudanza.mudanzaui.Clientes;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import mudanza.mudanzaui.entidad.preguntas.Preguntas;

public class PreguntasCliente {
    private final RestTemplate restTemplate = new RestTemplate();
    //listado
    public List<Preguntas> getList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List<Preguntas>> responseEntity = restTemplate.exchange(Global.URL_Preguntas,
                HttpMethod.GET, requestEntity,
                new ParameterizedTypeReference<List<Preguntas>>() {
                });

        List<Preguntas> preguntas = responseEntity.getBody();
        return preguntas;
    }
    //obtener id
    public Preguntas getPreguntasByID(long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        
        ResponseEntity<Preguntas> responseEntity =
        restTemplate.exchange(Global.URL_Preguntas.concat("/{id}"), HttpMethod.GET
        , requestEntity, Preguntas.class, id);
        Preguntas preguntas = responseEntity.getBody();
        return preguntas;
    }
    //agregar
    public Preguntas add(Preguntas preguntas){
        int status = HttpStatus.OK.value();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_GRAPHQL);
        HttpEntity<Preguntas> requestEntity = new HttpEntity<>(preguntas,headers);
        Preguntas nuevapregunta= null;
        try {
            nuevapregunta = restTemplate.postForEntity(Global.URL_Preguntas,
            requestEntity, Preguntas.class).getBody();
    } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
        if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode()) || 
            HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
                status = httpClientOrServerExc.getRawStatusCode();
            }
        }
        return nuevapregunta;
    }

    //actualizar
    public Integer update(long id, Preguntas preguntas) {
        int status = HttpStatus.OK.value();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Preguntas> requestEntity =  new HttpEntity<>(preguntas,headers);
        try {
            restTemplate.put(Global.URL_Preguntas.concat("/{id}"),requestEntity,id);            
        } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode()) || 
                HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
                    status = httpClientOrServerExc.getRawStatusCode();
                }
        }
        return status;
    }

}
