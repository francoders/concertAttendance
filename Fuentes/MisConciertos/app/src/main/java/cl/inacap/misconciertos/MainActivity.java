package cl.inacap.misconciertos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText artistaTxt;
    private Button agregarBtn;
    private ListView conciertosLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.artistaTxt = findViewById(R.id.artistaTxt);
        this.agregarBtn = findViewById(R.id.agregarBtn);
        this.conciertosLv = findViewById(R.id.conciertosLv);
        this.agregarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Agregado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}