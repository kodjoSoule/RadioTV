package com.kodjo.radioettv;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnRadio ;
    private  Button btnTv ;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.texthome);
        textView.setSelected(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true ;
    }
    public void goRadio(View view){
        btnRadio = findViewById(R.id.radio);
        startActivity(new Intent(this, Radio.class));
    }
    public void goTv(View view){
        btnRadio = findViewById(R.id.tv);
        startActivity(new Intent(this, TV.class));
    }
    public void goQuitter(View view){
    }
}