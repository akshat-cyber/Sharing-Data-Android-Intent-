package com.example.sharingdatatoanotherapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText name;
private Button share_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextTextPersonName);
        share_button = findViewById(R.id.button);
        String Name = name.getText().toString();
       share_button.setOnClickListener(v -> {
           if(Name != null){ shareTheDataUsingAndroidShareSheet();
           }else { Toast.makeText(getApplicationContext(), "Null Name", Toast.LENGTH_LONG).show(); }
       });
    }
    private void shareTheDataUsingAndroidShareSheet() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, name.getText().toString());
        intent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(intent, null);
        startActivity(shareIntent);
    }
}