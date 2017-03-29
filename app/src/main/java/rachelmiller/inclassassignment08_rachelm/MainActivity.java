package rachelmiller.inclassassignment08_rachelm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference planetRef = database.getReference("planet");
    private TextView displayText;
    private ArrayList<Planet> planetList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = (TextView) findViewById(R.id.textDisplay);

        planetRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                planetList.add(dataSnapshot.getValue(Planet.class));
                displayPlanets();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Planet.class) + " has changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Planet.class) + " is removed", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void displayPlanets() {
        String text = " ";
        for (Planet user : planetList)
            text += user + "\n";
        displayText.setText(text);
    }

    public void makeNewPlanet(View view) {
        Intent msIntent = new Intent(this, SecondActivity.class);
        startActivity(msIntent);
    }
}
