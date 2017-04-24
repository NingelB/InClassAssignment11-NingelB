package com.example.cmltdstudent.inclassassignment11_ningelb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MonumentAdapter monumentAdapter;

    private DatabaseReference monumentReference = FirebaseDatabase.getInstance().getReference("monument");
    private ArrayList<Monument> monument = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        monumentAdapter = new MonumentAdapter(monumentReference); // Stop listening if the activity is destroyed
        recyclerView.setAdapter(monumentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.add_monument, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent intent = new Intent(this, NewMonument.class);
                startActivityForResult(intent, 1);

                Toast.makeText(this, "Adding Item", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Monument monument = (Monument) data.getSerializableExtra(KEYS.MONUMENT);
            monumentReference.child(monument.id).setValue(monument);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        monumentAdapter.cleanup();
    }

//    public void addMonument(View view) {
//        String id = UUID.randomUUID().toString();
//        Monument m = new Monument(id, "Taj Mahal", 1632, true);
////        monument.add(m);
//        monumentReference.child(id).setValue(m);
////    peopleReference.push().setValue(p);
//    }


//    public void removePerson(View view) {
//        if (monument.size() == 0) return;
//        Monument m = monument.remove(0);
//        monumentReference.child(m.id).removeValue();
//    }

}
