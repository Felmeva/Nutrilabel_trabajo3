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

public class MainIngrediente2 extends AppCompatActivity {

    private Button btAgregar;
    private ImageButton btVolver;
    private EditText nomI, enerI, proteI, grasI, hdcI, sodI;

    private String textE, textP, textG, textHdc, textS;

    private float enerIt, proIt, grasIt, hdcIt, sodIt;

    private List<ingrediente> ListIng = new ArrayList<ingrediente>();
    private List<String> ListIngrediente = new ArrayList();
    ArrayAdapter<String> ingredienteArrayAdapter;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ingrediente2);

        btAgregar = findViewById(R.id.button3);
        btVolver = findViewById(R.id.imageButton);
        nomI = findViewById(R.id.editTextText);
        enerI = findViewById(R.id.editTextText2);
        proteI = findViewById(R.id.editTextText3);
        grasI = findViewById(R.id.editTextText4);
        hdcI = findViewById(R.id.editTextText5);
        sodI = findViewById(R.id.editTextText6);


        inicializarFireBase();
        listarI();

        Intent intVolver;
        intVolver = new Intent(this, MainActivity.class);


        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textE = enerI.getText().toString();
                enerIt = Float.parseFloat(textE);
                textP = proteI.getText().toString();
                proIt = Float.parseFloat(textP);
                textG = grasI.getText().toString();
                grasIt = Float.parseFloat(textG);
                textHdc = hdcI.getText().toString();
                hdcIt = Float.parseFloat(textHdc);
                textS = sodI.getText().toString();
                sodIt = Float.parseFloat(textS);
                ingrediente ing1 = new ingrediente();
                ing1.setIdIng(UUID.randomUUID().toString());
                ing1.setNombreI(nomI.getText().toString());
                ing1.setEnergiaI(enerIt);
                ing1.setProteinasI(proIt);
                ing1.setGrasasI(grasIt);
                ing1.setHdcI(hdcIt);
                ing1.setSodioI(sodIt);
                databaseReference.child("ingrediente").child(ing1.getIdIng()).setValue(ing1);
            }
        });

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intVolver);
            }
        });



    }

    private void listarI(){
        databaseReference.child("ingrediente").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListIng.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    ingrediente ing =objs.getValue(ingrediente.class);
                    ListIng.add(ing);
                    ListIngrediente.add("" + ing.getIdIng() + " " + ing.getNombreI() + " " + ing.getEnergiaI() + " " + ing.getProteinasI() + " " + ing.getGrasasI() + " " + ing.getHdcI() + " " + ing.getSodioI());
                    ingredienteArrayAdapter = new ArrayAdapter<String>(MainIngrediente2.this, android.R.layout.simple_expandable_list_item_1,ListIngrediente);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();

    }


}