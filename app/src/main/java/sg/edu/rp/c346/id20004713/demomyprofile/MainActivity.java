package sg.edu.rp.c346.id20004713.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGpa = findViewById(R.id.etGpa);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGpa.getText().toString());

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //create a share preference editor by calling edit()
        SharedPreferences.Editor preEdit = prefs.edit();
        //set a key-value pair in the editor
        preEdit.putString("name", strName);
        preEdit.putFloat("gpa", gpa);
        //call the commit() to save the changed made to the sharedPrefrance
        preEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE); //obtain shared preference instance
        String strName = prefs.getString("name", "");  //Retrieve the data from shared preference
        float gpa = prefs.getFloat("gpa", 0);
        etGpa.setText("" + gpa);
        etName.setText(strName);
    }
}