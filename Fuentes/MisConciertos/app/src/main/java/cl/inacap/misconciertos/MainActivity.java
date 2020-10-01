package cl.inacap.misconciertos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.misconciertos.dto.Concierto;


public class MainActivity extends AppCompatActivity {

    private EditText artistaTxt;
    private EditText entradaTxt;
    private Button agregarBtn;
    private ListView conciertosLv;
    private List<Concierto> conciertos = new ArrayList<>();
    private ArrayAdapter<Concierto> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.artistaTxt = findViewById(R.id.artistaTxt);
        this.entradaTxt = findViewById(R.id.entradaTxt);
        this.conciertosLv = findViewById(R.id.conciertosLv);
        this.agregarBtn = findViewById(R.id.agregarBtn);
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, conciertos);
        this.conciertosLv.setAdapter(adapter);
        this.agregarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> errores = new ArrayList<>();
                String artistaStr = artistaTxt.getText().toString().trim();
                String entradaStr = entradaTxt.getText().toString().trim();
                int entrada =0;

                try {
                    entrada = Integer.parseInt(entradaStr);
                    if (entrada < 0){
                        throw new NumberFormatException();
                    }
                }catch (NumberFormatException ex){
                    errores.add("El valor tiene que ser mayor que 0");
                }

                //Concierto
                if (errores.isEmpty()){
                    Concierto c = new Concierto();
                    c.setArtista(artistaStr);
                    c.setValorEntrada(entrada);
                    conciertos.add(c);
                    adapter.notifyDataSetChanged();
                }else {
                    mostrarErrores(errores);
                }



            }
        });
    }

    private void mostrarErrores(List<String> errores) {
        String mensaje = "";
        for (String e: errores){
            mensaje+= "-" + e + "\n";
        }
        AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(MainActivity.this);
        AlertBuilder.setTitle("Error al Ingresar").setMessage(mensaje)
                .setPositiveButton("Aceptar", null).create().show();

    }
}