package cl.ipvg.nutrilabel_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cl.ipvg.nutrilabel_v1.clases.ingrediente;
import cl.ipvg.nutrilabel_v1.clases.receta;

public class MainReceta3 extends AppCompatActivity {

    private Button btCrear;
    private ImageButton btVolver;
    private EditText gr1R, gr2R, gr3R, nomR;
    private String txt1, txt2, txt3;
    private float gr1, gr2, gr3;
    private Spinner ingS1, ingS2, ingS3;

    private List<receta> ListRe = new ArrayList<receta>();
    private List<String> ListReceta = new ArrayList();
    ArrayAdapter<String> recetaArrayAdapter;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btCrear = findViewById(R.id.button6);
        btVolver = findViewById(R.id.imageButton2);
        gr1R = findViewById(R.id.editTextText10);
        gr2R = findViewById(R.id.editTextText11);
        gr3R = findViewById(R.id.editTextText12);
        nomR = findViewById(R.id.editTextText8);
        ingS1 = findViewById(R.id.spinner);
        ingS2 = findViewById(R.id.spinner2);
        ingS3 = findViewById(R.id.spinner3);
        Intent intVolver;
        intVolver = new Intent(this, MainActivity.class);

        //txt1 = gr1R.getText().toString();
        //gr1 = Float.parseFloat(txt1);
        //txt2 = gr2R.getText().toString();
        //gr2 = Float.parseFloat(txt2);
        //txt3 = gr3R.getText().toString();
        //gr3 = Float.parseFloat(txt3);

        inicializarFireBase();
        listarR();


        btCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receta rec1 = new receta();

                rec1.setIdReceta(UUID.randomUUID().toString());
                rec1.setNombreR(nomR.getText().toString());
                rec1.setGrR(gr1);

            }
        });

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intVolver);
            }
        });




    }

    private void listarR(){
        databaseReference.child("ingrediente").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListRe.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    receta rec =objs.getValue(receta.class);
                    ListRe.add(rec);
                    ListReceta.add("" + rec.getIdReceta() + " " + rec.getNombreR() + " " + rec.getGrR());
                    recetaArrayAdapter = new ArrayAdapter<String>(MainReceta3.this, android.R.layout.simple_expandable_list_item_1,ListReceta);
                    ingS1.setAdapter(recetaArrayAdapter);
                    ingS2.setAdapter(recetaArrayAdapter);
                    ingS3.setAdapter(recetaArrayAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();

    }



}