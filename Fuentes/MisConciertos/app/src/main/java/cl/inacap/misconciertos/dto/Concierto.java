package cl.inacap.misconciertos.dto;

public class Concierto {
    private String artista;
    private String fechaEvento;
    private String genero;
    private int valorEntrada;
    private String calificacion;

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
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

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString(){
        return "Fecha: "+ fechaEvento +"\n"+ "Artista: " + artista +"\n"+ "Valor Entrada: "
                +  valorEntrada +"\n"+ "Calificacion: "+ calificacion;
    }
}
