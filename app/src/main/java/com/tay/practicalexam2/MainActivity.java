package com.tay.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    EditText comm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cb5 = findViewById(R.id.checkBox5);
        cb6 = findViewById(R.id.checkBox6);
        cb7 = findViewById(R.id.checkBox7);
        cb8 = findViewById(R.id.checkBox8);
        comm = findViewById(R.id.editText);
    }

    public void save(View v){
        String data1 = cb1.getText().toString();
        String data2 = cb2.getText().toString();
        String data3 = cb3.getText().toString();
        String data4 = cb4.getText().toString();
        String data5 = cb5.getText().toString();
        String data6 = cb6.getText().toString();
        String data7 = cb7.getText().toString();
        String data8 = cb8.getText().toString();
        String com = comm.getText().toString();
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data.txt", MODE_PRIVATE);
            if (cb1.isChecked()){
                writer.write((data1 + "\n").getBytes());
            }
            if (cb2.isChecked()){
                writer.write((data2 + "\n").getBytes());
            }
            if (cb3.isChecked()){
                writer.write((data3 + "\n").getBytes());
            }
            if (cb4.isChecked()){
                writer.write((data4 + "\n").getBytes());
            }
            if (cb5.isChecked()){
                writer.write((data5 + "\n").getBytes());
            }
            if (cb6.isChecked()){
                writer.write((data6 + "\n").getBytes());
            }
            if (cb7.isChecked()){
                writer.write((data7 + "\n").getBytes());
            }
            if (cb8.isChecked()){
                writer.write((data8 + "\n").getBytes());
            }
            writer.write(("_" + (com + "\n")).getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "file not found...");
        } catch (IOException e) {
            Log.d("error", "IO error...");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "file not found...");
            }
        }
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }

    public void next(View v){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

}
