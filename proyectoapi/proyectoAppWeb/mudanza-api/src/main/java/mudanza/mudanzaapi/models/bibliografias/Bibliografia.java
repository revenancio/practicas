package mudanza.mudanzaapi.models.bibliografias;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bibliografia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fuente;
    private URL direccion;

    public Bibliografia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public URL getDireccion() {
        return direccion;
    }

    public void setDireccion(URL direccion) {
        this.direccion = direccion;
    }
    

    
    
}
