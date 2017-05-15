package com.example.priyanjul.vision;

/**
 * Created by Priyanjul on 16-05-2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

/**
 * Created by Janit on 5/15/2017.
 */

public class EditActivity extends AppCompatActivity {

    private Button button;
    private String coord;
    private DatabaseReference mDatabase;
    public String name="";
    public String label1, label2, label3, label4, label5;
    public EditText e1, e2, e3, e4, e5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userform);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);

        coord=getIntent().getExtras().getString("coord");
        mDatabase = FirebaseDatabase.getInstance().getReference();




        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                label1 = e1.getText().toString();
                e1.setText("");
                label2 = e2.getText().toString();
                e2.setText("");
                label3 = e3.getText().toString();
                e3.setText("");
                label4 = e4.getText().toString();
                e4.setText("");
                label5 = e5.getText().toString();
                e5.setText("");

                name = name + label1 + " " + label2 + " " + label3 + " " + label4 + " " + label5;

                HashMap<String, String> dataMap= new HashMap<String, String >();
                dataMap.put("Co-ordinates",coord);
                dataMap.put("Labels",name);

                mDatabase.push().setValue(dataMap);
                name="";
                Toast.makeText(getApplicationContext(), "Labels & Co-ordinates have been successfully uploaded !", Toast.LENGTH_SHORT).show();


            }
        });


    }
}

