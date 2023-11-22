package cl.ipvg.nutrilabel_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button btIrI, btCr, btGe;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent ingreIntent, recIntent, etiIntent;

        btIrI = findViewById(R.id.button2);
        btCr = findViewById(R.id.button);
        btGe = findViewById(R.id.button4);

        ingreIntent = new Intent(this, MainIngrediente2.class);
        recIntent = new Intent(this, MainReceta3.class);
        etiIntent = new Intent(this, MainEtiqueta4.class);

        btIrI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ingreIntent);
            }
        });

        btCr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recIntent);
            }
        });

        btGe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(etiIntent);
            }
        });


    }


}