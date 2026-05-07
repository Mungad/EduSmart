package com.example.edusmart;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TestDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionsTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = QuestionAnswersActivity.question.length; // Access the length of the questions array
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_details);

        // Initialize UI components
        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionsTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        // Set the total number of questions
        totalQuestionsTextView.setText("Total questions : " + totalQuestion);

        // Load the first question
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        // Reset all button colors
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        if (view.getId() == R.id.submit_btn) {
            // Check if the selected answer is correct
            if (selectedAnswer.equals(QuestionAnswersActivity.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            // Move to the next question
            currentQuestionIndex++;
            loadNewQuestion();
        } else { // If a choice button was clicked
            Button clickedButton = (Button) view;
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    // Load a new question and display it
    void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        // Set the question and the choices for the current question
        questionsTextView.setText(QuestionAnswersActivity.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswersActivity.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswersActivity.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswersActivity.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswersActivity.choices[currentQuestionIndex][3]);
    }

    // Handle the end of the quiz
    void finishQuiz() {
        String passStatus = score > totalQuestion * 0.60 ? "Passed" : "Failed";
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    // Restart the quiz
    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
}
