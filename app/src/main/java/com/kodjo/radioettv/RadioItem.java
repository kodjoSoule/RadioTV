package com.kodjo.radioettv;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import static android.os.Build.ID;

public class RadioItem extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView textView ;
    ImageView imageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_item);

        textView = findViewById(R.id.textView);
        //Modifier le  bouton Actionbar
        ActionBar actionBar = getSupportActionBar();
        Intent intent = getIntent() ;
        String nomRadio = intent.getStringExtra("nom");
        textView.setText(nomRadio);

        actionBar.setTitle(nomRadio.toUpperCase());
        //Image resource
        imageView = findViewById(R.id.imageView);
        //imageView.setImageResource(R.drawable.kledu);
        int id0 = getResources().getIdentifier(ID,"kledu", "com.kodjo") ;
        Drawable d = getResources().getDrawable(id0);
        imageView.setImageDrawable(d);
        //
        //Url streams
        String url3 = "https://rfimonde64k.ice.infomaniak.ch/rfimonde-64.mp3";
        //mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url3);
            mediaPlayer.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void lancerRadio(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }else {
            mediaPlayer.start();
        }
    }
}