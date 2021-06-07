package cl.inacap.misconciertos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.misconciertos.dto.Concierto;

public class ConciertosDAO {

    private static List<Concierto> conciertos = new ArrayList<Concierto>();

    public void add(Concierto concierto){
        conciertos.add(concierto);
    }
    public List<Concierto> getAll(){
        return conciertos;
    }


}
