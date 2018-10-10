package com.faifly.faiflytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private static final int WORDS_GROUP_SIZE = 4;

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
                convertInput();
            }
        });
    }

    private void convertInput() {
        StringBuilder builder = new StringBuilder();
        String[] words = textInputView.getText().toString().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            builder.append(words[i]);

            boolean isLastWordInGroup = (i + 1) % WORDS_GROUP_SIZE == 0;
            boolean isNotLastWord = i < words.length - 1;

            if (isLastWordInGroup && isNotLastWord) {
                builder.append(System.lineSeparator());
            } else if (isNotLastWord) {
                builder.append(' ');
            }
        }

        textOutputView.setText(builder);
    }
}
