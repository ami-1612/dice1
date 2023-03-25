package com.rwn.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Locale;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button roll_btn;
    ImageView dice1, dice2;
    TextView total;
    LinearLayout layout;
    TextToSpeech textToSpeech;

    int[] img1 = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};
    int i1 = 0;

    int[] img2 = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};
    int i2 = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Binding();
        setImg1(i1);
        setImg2(i2);


        roll_btn.setOnClickListener(view -> {
            Random random = new Random();
            int a = random.nextInt(img1.length);

            Random random1 = new Random();
            int b = random1.nextInt(img2.length);

            dice1.setImageResource(img1[a]);
            dice2.setImageResource(img2[b]);

            Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            v.vibrate(200);

            int x = Integer.parseInt(String.valueOf(a));
            int y = Integer.parseInt(String.valueOf(b));
            int tot = (x + 1) + (y + 1);
            total.setText("Your toss is " + tot);

//            textToSpeech.speak(total.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
//        });
//
//        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int i) {
//
//                if (i != TextToSpeech.ERROR) {
//                    textToSpeech.setLanguage(Locale.UK);
//                }
//            }
        });

    }

    public void setImg1(int i) {

        Glide.with(MainActivity.this).load(img1[i]).placeholder(R.drawable.ic_launcher_background).into(dice1);
    }

    public void setImg2(int i) {

        Glide.with(MainActivity.this).load(img2[i]).placeholder(R.drawable.ic_launcher_background).into(dice2);
    }

    public void Binding() {

        roll_btn = findViewById(R.id.roll_btn);
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        total = findViewById(R.id.total);
        layout = findViewById(R.id.layout);
    }


}