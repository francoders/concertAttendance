package cl.inacap.misconciertos.dto;

public class Concierto {
    private String artista;
    private int fechaEvento;
    private String genero;
    private int valorEntrada;
    private int calificacion;

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(int fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(int valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString(){
        return artista + " " + valorEntrada;
    }
}
