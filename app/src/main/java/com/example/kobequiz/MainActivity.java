package com.example.kobequiz;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView kobeQ1,kobeQ2,kobeQ3,kobeQ4;
    Button radio1Q1,radio1Q2,radio1Q3,radio1Q4;
    RadioGroup radioGroup1,radioGroup2;
    RadioButton radio3Q1,radio3Q2,radio3Q3,radio3Q4;
    RadioButton radioChoice1,radioChoice2;
    CheckBox checkBox2Q1,checkBox2Q2,checkBox2Q3,checkBox2Q4;
    TextInputEditText freeText;
    Button submitButton;
    private Question question = new Question();
    private int correctAnswers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup1 = findViewById(R.id.radio_group_1);
        radioGroup2 = findViewById(R.id.radio_group_2);
        freeText = findViewById(R.id.free_text);
        submitButton = findViewById(R.id.submit_button);
//set the text for each question. I know there is an easier way using a loop
        kobeQ1 = findViewById(R.id.kobe_question);
        kobeQ1.setText(question.getQuestion(0));
        kobeQ2 = findViewById(R.id.kobe_question2);
        kobeQ2.setText(question.getQuestion(1));
        kobeQ3 = findViewById(R.id.kobe_question3);
        kobeQ3.setText(question.getQuestion(2));
        kobeQ4 = findViewById(R.id.kobe_question4);
        kobeQ4.setText((question.getQuestion(3)));
//set the choices for the first question
        radio1Q1 = findViewById(R.id.radio_q_1_o_1);
        radio1Q1.setText(question.getchoice1(0));
        radio1Q2 = findViewById(R.id.radio_q_1_o_2);
        radio1Q2.setText(question.getchoice2(0));
        radio1Q3 = findViewById(R.id.radio_q_1_o_3);
        radio1Q3.setText(question.getchoice3(0));
        radio1Q4 = findViewById(R.id.radio_q_1_o_4);
        radio1Q4.setText(question.getchoice4(0));
//set the choices for the second question
        checkBox2Q1 = findViewById(R.id.checkBox_q_2_o_1);
        checkBox2Q1.setText(question.getchoice1(1));
        checkBox2Q2 = findViewById(R.id.checkBox_q_2_o_2);
        checkBox2Q2.setText(question.getchoice2(1));
        checkBox2Q3 = findViewById(R.id.checkBox_q_2_o_3);
        checkBox2Q3.setText(question.getchoice3(1));
        checkBox2Q4 = findViewById(R.id.checkBox_q_2_o_4);
        checkBox2Q4.setText(question.getchoice4(1));
//set the choices for the third question
        radio3Q1 = findViewById(R.id.radio_q_3_o_1);
        radio3Q1.setText(question.getchoice1(2));
        radio3Q2 = findViewById(R.id.radio_q_3_o_2);
        radio3Q2.setText(question.getchoice2(2));
        radio3Q3 = findViewById(R.id.radio_q_3_o_3);
        radio3Q3.setText(question.getchoice3(2));
        radio3Q4 = findViewById(R.id.radio_q_3_o_4);
        radio3Q4.setText(question.getchoice4(2));

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                int selectedId = radioGroup1.getCheckedRadioButtonId();
                int selectedId2 = radioGroup2.getCheckedRadioButtonId();
//                grab the associated radio view
                radioChoice1 = findViewById(selectedId);
                radioChoice2 = findViewById(selectedId2);
                String content = freeText.getText().toString();
//                compare input to answers RadioGroup1
                if(radioChoice1 == null ) {
                    Toast.makeText(MainActivity.this, "You forgot to answer Question 1" , Toast.LENGTH_SHORT).show();
                } else if(radioChoice1.getText() == question.getCorrectAnswer(0)) {
                    correctAnswers++;
                }
//                compare input to answers CheckBoxes
                if(!checkBox2Q1.isChecked() && !checkBox2Q2.isChecked() && !checkBox2Q3.isChecked() && !checkBox2Q4.isChecked()){
                    Toast.makeText(MainActivity.this, "You forgot to answer Question 2" , Toast.LENGTH_SHORT).show();
                } else if(!checkBox2Q1.isChecked() && !checkBox2Q2.isChecked() && checkBox2Q3.isChecked() && checkBox2Q4.isChecked()) {
                    correctAnswers++;
                }
//                compare input to answers RadioGroup2
                if(radioChoice2 == null ){
                    Toast.makeText(MainActivity.this, "You forgot to answer Question 3" , Toast.LENGTH_SHORT).show();
                } else if(radioChoice2.getText() == question.getCorrectAnswer(2)) {
                    correctAnswers++;
                }
//                compare free text response to CorrectAnswer
                if (Arrays.asList(question.correctAnswer).contains(content)) {
                    correctAnswers++;
                } else {
                    Toast.makeText(MainActivity.this, "Put some respect on his name and Capitalize B and M", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this, "You got " + correctAnswers + " out of 4" , Toast.LENGTH_SHORT).show();
                GameOver();
            }
        });
    }
    private void GameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
            .setMessage("Game Over You got " + correctAnswers + " Correct")
            .setCancelable(false)
            .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            })
            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
        alertDialogBuilder.show();
    }
}