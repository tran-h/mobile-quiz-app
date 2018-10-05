package com.example.android.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initialize all the answer fields.
    private RadioButton q1a2, q2a3, q3a1, q5a1, q6a1, q7a3, q8a2, q9a4;
    private CheckBox q4a1, q4a2, q4a3, q4a4;
    private EditText q10Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign resource references to variables.
        q1a2 = (RadioButton) findViewById(R.id.rb_q1a2_tetris);
        q2a3 = (RadioButton) findViewById(R.id.rb_q2a3_pong);
        q3a1 = (RadioButton) findViewById(R.id.rb_q3a1_carpenter);
        q4a1 = (CheckBox) findViewById(R.id.cb_q4a1_mario);
        q4a2 = (CheckBox) findViewById(R.id.cb_q4a2_bowser);
        q4a3 = (CheckBox) findViewById(R.id.cb_q4a3_toad);
        q4a4 = (CheckBox) findViewById(R.id.cb_q4a4_luigi);
        q5a1 = (RadioButton) findViewById(R.id.rb_q5a1_pizza);
        q6a1 = (RadioButton) findViewById(R.id.rb_q6a1_mortalkombat);
        q7a3 = (RadioButton) findViewById(R.id.rb_q7a3_mew);
        q8a2 = (RadioButton) findViewById(R.id.rb_q8a2_link);
        q9a4 = (RadioButton) findViewById(R.id.rb_q9a4_sonic);
        q10Answer = (EditText) findViewById(R.id.question10_text_field);
    }

    //Calculates test score based on number of correct answers.
    public String getTestScore() {

        // Keeps track of number of correct answers.
        int correctAnswers = 0;

        // Toast message displayed when the user submits their answers.
        String toastMsg;

        //Checks if correct answers are selected.
        if (q1a2.isChecked())
            correctAnswers++;
        if (q2a3.isChecked())
            correctAnswers++;
        if (q3a1.isChecked())
            correctAnswers++;
        if (q4a1.isChecked() && q4a4.isChecked() && !q4a2.isChecked() && !q4a3.isChecked())
            correctAnswers++;
        if (q5a1.isChecked())
            correctAnswers++;
        if (q6a1.isChecked())
            correctAnswers++;
        if (q7a3.isChecked())
            correctAnswers++;
        if (q8a2.isChecked())
            correctAnswers++;
        if (q9a4.isChecked())
            correctAnswers++;
        if (q10Answer.getText().toString().equals("35"))
            correctAnswers++;

        // Tell the user whether or not they passed.
        if (correctAnswers < 5)
            toastMsg = getString(R.string.failedTestMsg) + " " + correctAnswers + "/10.";
        else
            toastMsg = getString(R.string.passedTestMsg) + " " + correctAnswers + "/10!";

        return toastMsg;
    }

    // Displays a toast informing the user of their test score.
    public void submitAnswers(View view) {
        Toast.makeText(getApplicationContext(), getTestScore(), Toast.LENGTH_SHORT).show();
    }

    // Highlights the correct answers in green.
    public void showCorrectAnswers(View view) {
        q1a2.setTextColor(Color.GREEN);
        q2a3.setTextColor(Color.GREEN);
        q3a1.setTextColor(Color.GREEN);
        q4a1.setTextColor(Color.GREEN);
        q4a4.setTextColor(Color.GREEN);
        q5a1.setTextColor(Color.GREEN);
        q6a1.setTextColor(Color.GREEN);
        q7a3.setTextColor(Color.GREEN);
        q8a2.setTextColor(Color.GREEN);
        q9a4.setTextColor(Color.GREEN);
        q10Answer.setText("35");
        q10Answer.setTextColor(Color.GREEN);
    }
}
