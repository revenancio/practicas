package mudanza.mudanzaui.Clientes;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import mudanza.mudanzaui.entidad.bibliografia.Bibliografia;


public class BibliografiasCliente {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Bibliografia> getList(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        
        ResponseEntity<List<Bibliografia>> responseEntity =
        restTemplate.exchange(Global.URL_Bibliografia,
        HttpMethod.GET, requestEntity,
        new ParameterizedTypeReference<List<Bibliografia>> () {});

        List<Bibliografia> Bibliografia = responseEntity.getBody();
        return Bibliografia;
    }

    public Bibliografia getBibliografiaByID(long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        
        ResponseEntity<Bibliografia> responseEntity =
        restTemplate.exchange(Global.URL_Bibliografia.concat("/{id}"), HttpMethod.GET
        , requestEntity, Bibliografia.class, id);
        Bibliografia Bibliografia = responseEntity.getBody();
        return Bibliografia;
    }

}
