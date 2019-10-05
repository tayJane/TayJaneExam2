package com.tay.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    EditText events, comm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("CONFIRMATION");
        FileInputStream reader = null;
        String str = "";
        try {
            reader = openFileInput("data.txt");
            int token;
            while ((token = reader.read()) != -1) {
                str = str + (char) token;
            }
            try {
                String[] x = str.split("_");
                try {
                    ((TextView) (findViewById(R.id.editText2))).setText(x[0]);
                    ((TextView) (findViewById(R.id.editText3))).setText(x[1]);
                } catch (Exception e) {
                    Log.d("error", "event not found...");
                }
                reader.close();
            } catch (FileNotFoundException e) {
                Log.d("error", "file not found...");
            } catch (IOException e) {
                Log.d("error", "IO error...");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void previous(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void send(View v){
        setTitle("SUMMARY");
        Toast.makeText(this, "Registration Sent...", Toast.LENGTH_LONG).show();
    }

}
