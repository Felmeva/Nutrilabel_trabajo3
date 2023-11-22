package cl.ipvg.nutrilabel_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import cl.ipvg.nutrilabel_v1.clases.ingrediente;

public class MainEtiqueta4 extends AppCompatActivity {

    private Button btGenerar;
    private ImageButton btVolver;
    private Spinner verS;
    private ListView listEt;





    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_etiqueta2);
         btGenerar = findViewById(R.id.button5);
         btVolver = findViewById(R.id.imageButton3);
         verS = findViewById(R.id.spinner5);
         listEt = findViewById(R.id.listView1);
         Intent intVolver;
         intVolver = new Intent(this, MainActivity.class);

         inicializarFireBase();


         btGenerar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

         btVolver.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(intVolver);
             }
         });












    }

    private void listarEt(){
        databaseReference.child("etiqueta").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}