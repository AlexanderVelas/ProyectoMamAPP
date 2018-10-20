package proyectofinal.example.org.ramirezj_fundamentos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bAcercaDe;
    private Button bColores;
    private Button bNumeros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAcercaDe = (Button) findViewById(R.id.button02);
        bColores = (Button) findViewById(R.id.button01);
        bNumeros = (Button) findViewById(R.id.button03);

        bAcercaDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarAcercaDe(null);
            }
        });
        bColores.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarColores(null);
            }
        });
        bNumeros.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarNumeros(null);
            }
        });
    }
    public void lanzarAcercaDe(View view) {
        Intent i = new Intent(this, Acercade.class);
        startActivity(i);
    }
    public void lanzarColores(View view) {
        Intent i = new Intent(this, Colores.class);
        startActivity(i);
    }
    public void lanzarNumeros(View view) {
        Intent i = new Intent(this, Numeros.class);
        startActivity(i);
    }
}
