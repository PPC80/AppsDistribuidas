public class Pregunta {
    private String respuesta;
    private int puntaje;

    public Pregunta(String respuesta, int puntaje) {
        this.respuesta = respuesta;
        this.puntaje = puntaje;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
