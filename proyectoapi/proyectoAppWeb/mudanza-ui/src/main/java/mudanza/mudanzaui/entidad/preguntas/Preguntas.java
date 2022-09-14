package mudanza.mudanzaui.entidad.preguntas;

public class Preguntas {
    private Long id;
    private String pregunta;
    private String respuesta;
    
    public Preguntas() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    

}
