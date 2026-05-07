package com.example.edusmart;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HelpSupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_help_support);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] faqQuestions = {
                "Q: How to use the app?",
                "Q: How can I contact support?",
                "Q: What features are available in the app?",
                "Q: How do I reset my password?",
                "Q: Is the app available offline?",
                "Q: How do I update my profile information?",
                "Q: Can I access course materials after the course ends?",
                "Q: How do I track my progress in the app?",
                "Q: How do I logout of the app?",
                "Q: How do I delete my account?",
                "Q: What should I do if I encounter a bug?",
                "Q: Is my data secure in the app?",
                "Q: How do I change my notification preferences?"
        };

        // Array of FAQ answers
        String[] faqAnswers = {
                "A: You can start by signing up and accessing the dashboard to view your courses and materials.",
                "A: You can contact support by visiting the 'Help & Support' section or sending an email.",
                "A: The app allows you to access course materials, track your progress, and contact support.",
                "A: To reset your password, click 'Forgot Password' on the login screen and follow the instructions.",
                "A: Currently, the app requires an internet connection to function fully, but some content may be available offline.",
                "A: Go to 'Profile Settings' under your account menu to update your name, email, password, and other information.",
                "A: Yes, you can still access course materials even after the course ends, as long as your account is active.",
                "A: You can track your progress on the dashboard, where your completed lessons and assignments are displayed.",
                "A: To logout, simply go to 'Settings' and tap the 'Logout' button.",
                "A: To delete your account, go to 'Account Settings' and select 'Delete Account'. Please note, this is permanent.",
                "A: If you encounter a bug, please report it through the 'Help & Support' section, including details of the issue.",
                "A: Your data is secure. We use encryption and follow best practices to protect your privacy and personal information.",
                "A: You can change your notification preferences under 'Settings' > 'Notifications'. You can enable/disable different alerts."
        };

        // Assign TextViews to display the FAQ questions and answers
        TextView faqQuestion1 = findViewById(R.id.faqQuestion1);
        TextView faqAnswer1 = findViewById(R.id.faqAnswer1);

        TextView faqQuestion2 = findViewById(R.id.faqQuestion2);
        TextView faqAnswer2 = findViewById(R.id.faqAnswer2);

        TextView faqQuestion3 = findViewById(R.id.faqQuestion3);
        TextView faqAnswer3 = findViewById(R.id.faqAnswer3);

        TextView faqQuestion4 = findViewById(R.id.faqQuestion4);
        TextView faqAnswer4 = findViewById(R.id.faqAnswer4);

        TextView faqQuestion5 = findViewById(R.id.faqQuestion5);
        TextView faqAnswer5 = findViewById(R.id.faqAnswer5);

        TextView faqQuestion6 = findViewById(R.id.faqQuestion6);
        TextView faqAnswer6 = findViewById(R.id.faqAnswer6);

        TextView faqQuestion7 = findViewById(R.id.faqQuestion7);
        TextView faqAnswer7 = findViewById(R.id.faqAnswer7);

        TextView faqQuestion8 = findViewById(R.id.faqQuestion8);
        TextView faqAnswer8 = findViewById(R.id.faqAnswer8);

        TextView faqQuestion9 = findViewById(R.id.faqQuestion9);
        TextView faqAnswer9 = findViewById(R.id.faqAnswer9);

        TextView faqQuestion10 = findViewById(R.id.faqQuestion10);
        TextView faqAnswer10 = findViewById(R.id.faqAnswer10);

        TextView faqQuestion11 = findViewById(R.id.faqQuestion11);
        TextView faqAnswer11 = findViewById(R.id.faqAnswer11);

        TextView faqQuestion12 = findViewById(R.id.faqQuestion12);
        TextView faqAnswer12 = findViewById(R.id.faqAnswer12);

        TextView faqQuestion13 = findViewById(R.id.faqQuestion13);
        TextView faqAnswer13 = findViewById(R.id.faqAnswer13);

        // You can add more TextViews for additional FAQ entries

        // Set the questions and answers dynamically
        faqQuestion1.setText(faqQuestions[0]);
        faqAnswer1.setText(faqAnswers[0]);

        faqQuestion2.setText(faqQuestions[1]);
        faqAnswer2.setText(faqAnswers[1]);

        faqQuestion3.setText(faqQuestions[2]);
        faqAnswer3.setText(faqAnswers[2]);

        faqQuestion4.setText(faqQuestions[3]);
        faqAnswer4.setText(faqAnswers[3]);

        faqQuestion5.setText(faqQuestions[4]);
        faqAnswer5.setText(faqAnswers[4]);

        faqQuestion6.setText(faqQuestions[5]);
        faqAnswer6.setText(faqAnswers[5]);

        faqQuestion7.setText(faqQuestions[6]);
        faqAnswer7.setText(faqAnswers[6]);

        faqQuestion8.setText(faqQuestions[7]);
        faqAnswer8.setText(faqAnswers[7]);

        faqQuestion9.setText(faqQuestions[8]);
        faqAnswer9.setText(faqAnswers[8]);

        faqQuestion10.setText(faqQuestions[9]);
        faqAnswer10.setText(faqAnswers[9]);

        faqQuestion11.setText(faqQuestions[10]);
        faqAnswer11.setText(faqAnswers[10]);

        faqQuestion12.setText(faqQuestions[11]);
        faqAnswer12.setText(faqAnswers[11]);

        faqQuestion13.setText(faqQuestions[12]);
        faqAnswer13.setText(faqAnswers[12]);
    }
}