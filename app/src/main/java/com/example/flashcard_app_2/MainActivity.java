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

        TextView Question = findViewById(R.id.question_textview);
        TextView Answer = findViewById(R.id.answer_textview); //comment out later
        TextView answer1 = findViewById(R.id.answer1_textview);
        TextView answer2 = findViewById(R.id.answer2_textview);
        TextView answer3 = findViewById(R.id.answer3_textview);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);

                MainActivity.this.startActivityForResult(intent,100);
            }
        });

        //When this button is clicked, the user will be able to edit previous input.
        findViewById(R.id.edit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                intent.putExtra("Original_question",Question.getText().toString());
                //intent.putExtra("Original_answer",Answer.getText().toString()); //delete after!!
                intent.putExtra("Original_answer1",answer1.getText().toString());
                intent.putExtra("Original_answer2",answer2.getText().toString());
                intent.putExtra("Original_answer3",answer3.getText().toString());
                MainActivity.this.startActivityForResult(intent,100);
            }
        });




        //DELETE LATER or comment out
//        Question.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Question.setVisibility(View.INVISIBLE);
//                Answer.setVisibility(View.VISIBLE);
//            }
//        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView Question = findViewById(R.id.question_textview);
        //TextView Answer = findViewById(R.id.answer_textview);
        TextView answer1 = findViewById(R.id.answer1_textview);
        TextView answer2 = findViewById(R.id.answer2_textview);
        TextView answer3 = findViewById(R.id.answer3_textview);


        if (requestCode == 100 && data != null) { //needs to match so they know which activity to call?
            String the_question = data.getExtras().getString("the_question"); // 'string1' needs to match key used in Intent
            //String the_answer = data.getExtras().getString("the_answer");
            String the_answer1 = data.getExtras().getString("the_answer1");
            String the_answer2 = data.getExtras().getString("the_answer2");
            String the_answer3 = data.getExtras().getString("the_answer3");

            Question.setText(the_question);
            //Answer.setText(the_answer);
            answer1.setText(the_answer1);
            answer2.setText(the_answer2);
            answer3.setText(the_answer3);
        }



    }

}