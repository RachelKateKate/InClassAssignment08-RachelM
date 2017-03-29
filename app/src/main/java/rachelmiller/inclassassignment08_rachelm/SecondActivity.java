package rachelmiller.inclassassignment08_rachelm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference planetRef = database.getReference("planet");

    private EditText planet;
    private EditText distance;
    private CheckBox hasWater;
    private Button firebaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        planet = (EditText) findViewById(R.id.planetName);
        distance = (EditText) findViewById(R.id.distance);
        hasWater = (CheckBox) findViewById(R.id.hasWater);
        firebaseButton = (Button) findViewById(R.id.addToFirebaseButton);
    }

    public void addToFirebase(View view) {
        String planetName = planet.getText().toString();
        int miles = Integer.parseInt(distance.getText().toString());
        boolean hydrated = ((CheckBox) findViewById(R.id.hasWater)).isChecked();
        planetRef.push().setValue(new Planet(planetName, miles, hydrated));
        Intent mrIntent = new Intent(this, MainActivity.class);
        startActivity(mrIntent);
    }
}
