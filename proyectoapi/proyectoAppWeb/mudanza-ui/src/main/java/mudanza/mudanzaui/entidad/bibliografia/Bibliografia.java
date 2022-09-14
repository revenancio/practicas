package mudanza.mudanzaui.entidad.bibliografia;

import java.net.URL;

public class Bibliografia {
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
