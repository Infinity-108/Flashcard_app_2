package com.example.flashcard_app_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent,100);
            }
        });

        TextView Question = findViewById(R.id.question_textview);
        TextView Answer = findViewById(R.id.answer_textview);



        Question.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Question.setVisibility(View.INVISIBLE);
                Answer.setVisibility(View.VISIBLE);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView Question = findViewById(R.id.question_textview);
        TextView Answer = findViewById(R.id.answer_textview);

        if (requestCode == 100 && data != null) { //needs to match so they know which activity to call?
            String the_question = data.getExtras().getString("the_question"); // 'string1' needs to match key used in Intent
            String the_answer = data.getExtras().getString("the_answer");

            Question.setText(the_question);
            Answer.setText(the_answer);
        }



    }

}