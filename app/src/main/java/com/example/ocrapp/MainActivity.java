package com.example.ocrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Button imgBtn, speechBtn;
    InputImage inputImage;
    TextRecognizer recognizer;
    TextToSpeech textToSpeech;
    public Bitmap textImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
        imgBtn = findViewById(R.id.choose_img);
        speechBtn = findViewById(R.id.speech);
        textView = findViewById(R.id.text);
        imageView =findViewById(R.id.imageView);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });
        speechBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(textView.getText().toString() , TextToSpeech.QUEUE_FLUSH ,null);
            }
        });


    }
    private void openGallery() {
    }
}