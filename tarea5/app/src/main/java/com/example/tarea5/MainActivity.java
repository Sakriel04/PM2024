package com.example.tarea5;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //variables y objetos
    MediaPlayer mediaPlayer;
    Button btnPlay,btnPause,btnResume,btnStop;
    RadioButton radio1,radio2,radio3,radio4,radio5,radio6,radio7,radio8,radio9;
    int posicion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //botones
        btnPlay=(Button) findViewById(R.id.btnPlay);
        btnPause=(Button) findViewById(R.id.btnPause);
        btnResume=(Button) findViewById(R.id.btnResume);
        btnStop=(Button) findViewById(R.id.btnStop);

        //radio botones
        radio1=(RadioButton) findViewById(R.id.radio1);
        radio2=(RadioButton) findViewById(R.id.radio2);
        radio3=(RadioButton) findViewById(R.id.radio3);
        radio4=(RadioButton) findViewById(R.id.radio4);
        radio5=(RadioButton) findViewById(R.id.radio5);
        radio6=(RadioButton) findViewById(R.id.radio6);
        radio7=(RadioButton) findViewById(R.id.radio7);
        radio8=(RadioButton) findViewById(R.id.radio8);
        radio9=(RadioButton) findViewById(R.id.radio9);
    }

    //metodos
    public void destruir(){
        if (mediaPlayer!=null) {
            mediaPlayer.release();
        }
    }

    public void reproducir(View view){
        //liberar el reproductor
        destruir();
        //reproduccion
        if (radio1.isChecked()) {
            mediaPlayer=MediaPlayer.create(this,R.raw.pista01);
        }
        if (radio2.isChecked()) {
            mediaPlayer=MediaPlayer.create(this,R.raw.pista02);
        }
        if (radio3.isChecked()) {
            mediaPlayer=MediaPlayer.create(this,R.raw.pista03);
        }
        if (radio4.isChecked()) {
            mediaPlayer=MediaPlayer.create(this,R.raw.pista04);
        }
        if (radio5.isChecked()) {
            mediaPlayer=MediaPlayer.create(this,R.raw.pista05);
        }
        if (radio6.isChecked()) {
            mediaPlayer=new MediaPlayer();
            try {
                mediaPlayer.setDataSource("https://techtransfer.com.py/music/pista06.mp3");
                mediaPlayer.prepare();
            } catch (IOException e) {
            }
        }
        if (radio7.isChecked()) {
            mediaPlayer=new MediaPlayer();
            try {
                mediaPlayer.setDataSource("https://techtransfer.com.py/music/pista07.mp3");
                mediaPlayer.prepare();
            } catch (IOException e) {
            }
        }
        if (radio8.isChecked()) {
            mediaPlayer=MediaPlayer.create(this,R.raw.pista08);
        }
        if (radio9.isChecked()) {
            mediaPlayer=new MediaPlayer();
            try {
                mediaPlayer.setDataSource("https://filebin.net/9vmgedqjqfdnrzyc/pista09.mp3");
                mediaPlayer.prepare();
            } catch (IOException e) {
            }
        }

        //play
        mediaPlayer.start();
    }

    public void pausar(View view) {
        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            posicion=mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
    }

    public void continuar(View view){
        if(mediaPlayer!=null && mediaPlayer.isPlaying()==false){
            mediaPlayer.seekTo(posicion);
            mediaPlayer.start();
        }
    }

    public void detener(View view){
        if (mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            posicion=0;
        }
    }
}