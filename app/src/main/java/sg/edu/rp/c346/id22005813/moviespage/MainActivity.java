package sg.edu.rp.c346.id22005813.moviespage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etTitle, etGenre, etYear;
    Spinner spinnerRating;
    Button btnInsert, btnShowList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etMovie);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spinnerRating = findViewById(R.id.spinRating);
        btnInsert = findViewById(R.id.btnUpdate);
        btnShowList = findViewById(R.id.btnDelete);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String selectedRating = spinnerRating.getSelectedItem().toString();


                DBHelper db = new DBHelper(MainActivity.this);

                if(etTitle.getText().toString().trim().length() != 0 && etGenre.getText().toString().trim().length() != 0 && etYear.getText().toString().trim().length() != 0){
                    db.insertMovie(etTitle.getText().toString(), etGenre.getText().toString(), Integer.parseInt(etYear.getText().toString()), selectedRating);
                    Toast.makeText(MainActivity.this,"Insert Successful",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this,"Error empty fields",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MovieList.class);
                startActivity(intent);
            }
        });


    }
}