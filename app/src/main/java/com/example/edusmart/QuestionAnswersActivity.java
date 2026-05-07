package com.example.edusmart;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class QuestionAnswersActivity extends AppCompatActivity {

    public static String[] question = {
            "Which of the following is not an operating system?",
            "What is the primary function of RAM in a computer?",
            "Which protocol is primarily used to browse the internet?",
            "What does SQL stand for in the context of databases?"
    };

    public static String[][] choices = {
            {"Windows", "Linux", "Python", "macOS"},
            {"To store data permanently", "To execute commands and store temporary data",
                    "To protect the computer from viruses", "To display graphics"},
            {"FTP", "HTTP", "SMTP", "SNMP"},
            {"Structured Query Language", "Simple Query Logic",
                    "System Query List", "Standard Query Link"}
    };

    public static String[] correctAnswers = {
            "Python",
            "To execute commands and store temporary data",
            "HTTP",
            "Structured Query Language"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question_answers);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }
}