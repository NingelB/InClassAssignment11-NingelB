package com.example.cmltdstudent.inclassassignment11_ningelb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

public class NewMonument extends AppCompatActivity {

    private EditText monumentName;
    private EditText monumentBuilt;
    private CheckBox monumentVisited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_monument);

        monumentName = (EditText) findViewById(R.id.enter_name);
        monumentBuilt= (EditText) findViewById(R.id.enter_year_built);
        monumentVisited = (CheckBox) findViewById(R.id.check_if_visited);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_or_delete_monument, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                Toast.makeText(this, "Monument saved", Toast.LENGTH_SHORT).show();

                String nameAdd = monumentName.getText().toString();
                String idAdd = UUID.randomUUID().toString();
                int yearAdd = Integer.parseInt(monumentBuilt.getText().toString());
                boolean visitedAdd = monumentVisited.isChecked();

                Monument monument = new Monument(idAdd, nameAdd, yearAdd, visitedAdd);

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(KEYS.MONUMENT, monument);
                setResult(RESULT_OK, intent);
                finish();


                return true;

            case R.id.menu_delete:
                Toast.makeText(this, "Monument deleted", Toast.LENGTH_SHORT).show();


                monumentName.setText("");
                monumentBuilt.setText("");
                monumentVisited.setChecked(false);


                Intent remove = new Intent(this, MainActivity.class);
                startActivity(remove);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}