package proyectofinal.example.org.ramirezj_fundamentos;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.StringTokenizer;
import java.util.Vector;

public class Numeros extends Activity implements View.OnClickListener {

    Button boton1;
    Button boton2;
    Button boton3;
    Vector<String> miVector;
    ImageView imagen;
    private ImageView imgView;
    Vector<String> palabras1;
    Vector<String> palabras2;
    Vector<String> palabras3;
    String foto;
    int caso;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.numeros);


        boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(this);

        boton2 = (Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(this);

        boton3 = (Button) findViewById(R.id.boton3);
        boton3.setOnClickListener(this);

        imagen=(ImageView) findViewById(R.id.imageView);
        PalabrasSQLite pal = new PalabrasSQLite(this);
        pal.guardarPalabras();

        miVector = new Vector<String>();
        miVector = pal.listaPalabras(10,2);
        int opc1=(int)numeroaleatiro();
        int opc2=-1;
        int opc3=-1;
        do{
            opc2= (int)numeroaleatiro();
        }
        while (opc2==-1 || opc2==opc1);

        do{opc3= (int)numeroaleatiro();}
        while (opc3==-1  || opc3==opc1 || opc3==opc2);



        palabras1= DevolverPalabras(miVector.get(opc1));
        palabras2= DevolverPalabras(miVector.get(opc2));
        palabras3= DevolverPalabras(miVector.get(opc3));
        foto =palabras1.get(0);
        ponerImagen();

        int x1=(int)numeroaleatiro3();
        int x2,x3;
        do{
            x2=(int)numeroaleatiro3();
        }while (x1==x2);
        do{
            x3=(int)numeroaleatiro3();
        }while (x1==x3 || x2==x3);

        caso=0;
        if(x1==1 && x2==2 && x3==3){
            boton1.setText(palabras1.get(2));
            boton2.setText(palabras2.get(2));
            boton3.setText(palabras3.get(2));
            caso=1;}
        if(x1==1 && x2==3 && x3==2){
            boton1.setText(palabras1.get(2));
            boton2.setText(palabras3.get(2));
            boton3.setText(palabras2.get(2));
            caso=2;}
        if(x1==2 && x2==1 && x3==3){
            boton1.setText(palabras2.get(2));
            boton2.setText(palabras1.get(2));
            boton3.setText(palabras3.get(2));
            caso=3;}
        if(x1==2 && x2==3 && x3==1){
            boton1.setText(palabras2.get(2));
            boton2.setText(palabras3.get(2));
            boton3.setText(palabras1.get(2));
            caso=4;}
        if(x1==3 && x2==1 && x3==2){
            boton1.setText(palabras3.get(2));
            boton2.setText(palabras1.get(2));
            boton3.setText(palabras2.get(2));
            caso=5;}
        if(x1==3 && x2==2 && x3==1){
            boton1.setText(palabras3.get(2));
            boton2.setText(palabras2.get(2));
            boton3.setText(palabras1.get(2));
            caso=6;}


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.boton1) {
            if(caso==1 || caso ==2){
                boton1.setBackgroundColor(Color.GREEN);

                reiniciarActivity(this);
            }
            else{ boton1.setBackgroundColor(Color.RED);}


        }
        if (v.getId() == R.id.boton2) {
            if(caso==3 || caso ==5){
                boton2.setBackgroundColor(Color.GREEN);
                reiniciarActivity(this);
            }
            else{boton2.setBackgroundColor(Color.RED);}
        }


        if (v.getId() == R.id.boton3) {

            if(caso==4 || caso ==6){
                boton3.setBackgroundColor(Color.GREEN);

                reiniciarActivity(this);
            }
            else{boton3.setBackgroundColor(Color.RED);}

        }
    }

    public Vector<String> DevolverPalabras(String frase) {
        Vector<String> vector=new Vector();
        StringTokenizer tokens = new StringTokenizer(frase);
        while(tokens.hasMoreTokens()){
            vector.add(tokens.nextToken());
        }
        return vector;
    }
    public void ponerImagen(){
        if (foto.equals("12")){
            imagen.setImageResource(R.drawable.uno);
        }
        else if(foto.equals("13")){
            imagen.setImageResource(R.drawable.dos);
        }
        else if(foto.equals("14")){
            imagen.setImageResource(R.drawable.tres);
        }
        else if(foto.equals("15")){
            imagen.setImageResource(R.drawable.cuatro);
        }
        else if(foto.equals("16")){
            imagen.setImageResource(R.drawable.cinco);
        }
        else if(foto.equals("17")){
            imagen.setImageResource(R.drawable.seis);
        }
        else if(foto.equals("18")){
            imagen.setImageResource(R.drawable.siete);
        }
        else if(foto.equals("19")){
            imagen.setImageResource(R.drawable.ocho);
        }
        else if(foto.equals("20")){
            imagen.setImageResource(R.drawable.nueve);
        }
        else if(foto.equals("21")){
            imagen.setImageResource(R.drawable.diez);
        }

    }
    double numeroaleatiro(){
        double numAleatorio=Math.random()*10+0;
        return numAleatorio;
    }
    double numeroaleatiro3(){
        double numAleatorio=Math.random()*3+1;
        return numAleatorio;
    }
    public static void reiniciarActivity(Activity actividad){
        Intent intent=new Intent();
        intent.setClass(actividad, actividad.getClass());
        //llamamos a la actividad
        actividad.startActivity(intent);
        //finalizamos la actividad actual
        actividad.finish();
    }
}


