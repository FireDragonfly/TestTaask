package com.faifly.faiflytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private EditText textInputView;
    private MultiAutoCompleteTextView textOutputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputView = findViewById(R.id.textInput);
        textOutputView = findViewById(R.id.textOutput);
        Button splitButtonView = findViewById(R.id.splitButton);

        splitButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                split();
            }
        });
    }

    private void split() {
        StringBuilder builder = new StringBuilder();
        String[] words = textInputView.getText().toString().split("\\s+");

        if (words.length == 0) {
            textOutputView.setText("");
            return;
        }

        for (int i = 0; i < words.length; i++) {
            builder.append(words[i]);

            if (((i + 1) % 4 == 0) && (i < words.length - 1)) {
                builder.append(System.lineSeparator());
            } else if (i < words.length - 1) {
                builder.append(' ');
            }
        }

        textOutputView.setText(builder);
    }
}
