package com.example.flashcard_app_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);


        EditText question_edit = findViewById(R.id.question_edittext);
        EditText answer1_edit = findViewById(R.id.answer1_edittext);
        EditText answer2_edit = findViewById(R.id.answer2_edittext);
        EditText answer3_edit = findViewById(R.id.answer3_edittext);


        //this accounts for receiving data from the Main Activity
        String Original_question = getIntent().getStringExtra("Original_question");
        String Original_answer1 = getIntent().getStringExtra("Original_answer1");
        String Original_answer2 = getIntent().getStringExtra("Original_answer2");
        String Original_answer3 = getIntent().getStringExtra("Original_answer3");


        //answer 1 is the correct answer
        question_edit.setText(Original_question);
        answer1_edit.setText(Original_answer1);
        answer2_edit.setText(Original_answer2);
        answer3_edit.setText(Original_answer3);


        findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //for an empty question and answer box
                Toast toast = Toast.makeText(getApplicationContext(), "Must Enter Both Question and three Answer!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 500);


                Intent data  = new Intent();
                data.putExtra("the_question",question_edit.getText().toString());
                data.putExtra("the_answer1",answer1_edit.getText().toString());
                data.putExtra("the_answer2",answer2_edit.getText().toString());
                data.putExtra("the_answer3",answer3_edit.getText().toString());

                setResult(RESULT_OK, data);

                if(!question_edit.getText().toString().isEmpty() &&
                        !answer1_edit.getText().toString().isEmpty() &&
                        !answer2_edit.getText().toString().isEmpty() &&
                        !answer3_edit.getText().toString().isEmpty()) {
                    finish();
                }

                else{
                    toast.show();
                }
            }
        });

    }


}