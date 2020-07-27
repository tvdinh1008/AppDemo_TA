package com.example.appdemo_ta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;

public class TranslateVNActivity extends AppCompatActivity {

    EditText ed_sentence;
    TextView txt_result;
    Button btn_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_v_n);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Translate Vietnamese");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txt_result=findViewById(R.id.txt_result);
        ed_sentence=findViewById(R.id.ed_sentence);
        btn_trans=findViewById(R.id.btn_translate);

        //translate
        // Create an English-German translator:
        FirebaseTranslatorOptions options =
                new FirebaseTranslatorOptions.Builder()
                        .setSourceLanguage(FirebaseTranslateLanguage.VI)
                        .setTargetLanguage(FirebaseTranslateLanguage.EN)
                        .build();
        final FirebaseTranslator vietnameseEnglishTranslator =
                FirebaseNaturalLanguage.getInstance().getTranslator(options);
        //translation model download the device
        FirebaseModelDownloadConditions conditions = new FirebaseModelDownloadConditions.Builder()
                .requireWifi()
                .build();
        vietnameseEnglishTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void v) {
                                // Model downloaded successfully. Okay to start translating.
                                // (Set a flag, unhide the translation UI, etc.)
                                // Toast.makeText(getApplicationContext()," Model downloaded successfully",Toast.LENGTH_LONG).show();
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Model couldn’t be downloaded or other internal error.
                                // ...
                                Toast.makeText(getApplicationContext()," Model couldn’t be downloaded",Toast.LENGTH_LONG).show();
                            }
                        });
        btn_trans=findViewById(R.id.btn_translate);
        btn_trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=ed_sentence.getText().toString();
                if(text.length()>0)
                {
                    vietnameseEnglishTranslator.translate(text)
                            .addOnSuccessListener(
                                    new OnSuccessListener<String>() {
                                        @Override
                                        public void onSuccess(@NonNull String translatedText) {
                                            // Translation successful.
                                            txt_result.setText(translatedText);
                                        }
                                    })
                            .addOnFailureListener(
                                    new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Error.
                                            // ...
                                            Toast.makeText(getApplicationContext(),"Translation error",Toast.LENGTH_LONG).show();
                                        }
                                    });
                }
            }
        });

    }
}
