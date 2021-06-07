package cl.inacap.misconciertos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cl.inacap.misconciertos.dto.Concierto;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText artistaTxt;
    private EditText entradaTxt;
    private Button agregarBtn;
    private Spinner spinnerSp;
    private Button fechaBtn;
    private ListView conciertosLv;
    private int dia,mes,ano;
    private Spinner calificacionSp;
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
        this.spinnerSp = (Spinner) findViewById(R.id.spinnerSp);
        this.calificacionSp = findViewById(R.id.calificacionSp);
        this.fechaBtn = findViewById(R.id.fechaBtn); //(Button)
        fechaBtn.setOnClickListener(this);
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, conciertos);
        this.conciertosLv.setAdapter(adapter);
        //SPINNER
        ArrayAdapter<CharSequence> adapterUno= ArrayAdapter.createFromResource(this, R.array.generos, android.R.layout.simple_spinner_item);
        spinnerSp.setAdapter(adapterUno);
        ArrayAdapter<CharSequence> adapterDos= ArrayAdapter.createFromResource(this, R.array.calificaciones, android.R.layout.simple_spinner_item);
        calificacionSp.setAdapter(adapterDos);

        this.agregarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> errores = new ArrayList<>();
                String artistaStr = artistaTxt.getText().toString().trim();
                String entradaStr = entradaTxt.getText().toString().trim();
                String fechaStr = fechaBtn.getText().toString().trim();

                //Validacion Artista
                if (artistaStr.isEmpty()){
                    errores.add("Debe ingresar un Artista");
                }

                //Validacion Valor Entrada
                int entrada = 0;

                try {
                    entrada = Integer.parseInt(entradaStr);
                    if (entrada < 0){
                        throw new NumberFormatException();
                    }
                }catch (NumberFormatException ex){
                    errores.add("El valor tiene que ser mayor que 0");
                }

                //Validacion Fecha
                if (fechaStr.isEmpty()){
                    errores.add("Debe ingresar una fecha");
                }


                // --- CONCIERTO ---
                if (errores.isEmpty()){
                    Concierto c = new Concierto();
                    c.setArtista(artistaStr);
                    c.setValorEntrada(entrada);
                    c.setFechaEvento(fechaStr);
                    c.setCalificacion(calificacionSp.getSelectedItemPosition());
                    c.setGenero(spinnerSp.getSelectedItemPosition()+1);
                    conciertos.add(c);
                    Toast.makeText(MainActivity.this, "Concierto Exitoso", Toast.LENGTH_SHORT).show();
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
            mensaje+= "* " + e + "\n";
        }
        AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(MainActivity.this);
        AlertBuilder.setTitle("Error al Ingresar").setMessage(mensaje)
                .setPositiveButton("Aceptar", null).create().show();
    }



    //Calendario
    @Override
    public void onClick(View v) {
        if (v == fechaBtn){
            final Calendar cal = Calendar.getInstance();
            dia = cal.get(Calendar.DAY_OF_MONTH);
            mes = cal.get(Calendar.MONTH);
            ano = cal.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fechaBtn.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }
    }
}