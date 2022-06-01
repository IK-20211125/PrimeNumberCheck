package com.example.primenumbercheck;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    long value;
    boolean tf = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        Button button = findViewById(R.id.button);

        Context context = getApplicationContext();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    value = Long.parseLong(String.valueOf(editText.getText()));
                    for (int i = 2; i < value; i++) {
                        if (value % i == 0) {
                            tf = false;
                            break;
                        }
                    }
                    if (tf) {
                        Toast.makeText(context, "素数です", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "素数ではありません", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(context, "数字を入力してください", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}