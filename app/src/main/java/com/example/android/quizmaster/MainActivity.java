package com.example.android.quizmaster;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    String correctAnswer1 = "luigi";
    String correctAnswer4 = "plumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gradeQuiz(View view) {
        EditText question1Answer = (EditText) findViewById(R.id.question1_answer);
        String question1 = question1Answer.getText().toString();

        RadioButton question2Answer = (RadioButton) findViewById(R.id.question2_answer_4);
        boolean question2 = question2Answer.isChecked();

        CheckBox box3 = (CheckBox) findViewById(R.id.question3_answer_xbox);
        boolean question3xbox = box3.isChecked();

        CheckBox box4 = (CheckBox) findViewById(R.id.question3_answer_playstation);
        boolean question3playstation = box4.isChecked();

        EditText question4Answer = (EditText) findViewById(R.id.question4_answer);
        String question4 = question4Answer.getText().toString();

        // calculate score
        score = getFinalScore(question1, question2, question3xbox, question3playstation, question4);

        // toast display score
        Context context = getApplicationContext();
        if (score == 100) {
            int duration = Toast.LENGTH_LONG;
            CharSequence text = "Your Final Score: " + score + " out of 100. You got a perfect score!";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            int duration = Toast.LENGTH_LONG;
            CharSequence text = "Your Final Score: " + score + " out of 100.";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


        // resets score after submit
        score = 0;

    }

    private int getFinalScore(String question1, boolean question2, boolean question3xbox, boolean question3playstation, String question4) {
        if (question1.equals(correctAnswer1)) {
            score = score + 25;
        }

        if (question2 == true) {
            score = score + 25;
        }

        if (question3xbox == true && question3playstation == true) {
            score = score + 25;
        }

        if (question4.equals(correctAnswer4)) {
            score = score + 25;
        }

        return score;
    }
}
