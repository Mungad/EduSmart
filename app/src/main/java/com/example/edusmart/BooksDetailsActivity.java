package com.example.edusmart;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooksDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_books_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve the title from the Intent
        String courseTitle = getIntent().getStringExtra("title");

        // Get reference to your ListView (or RecyclerView)
        ListView listView = findViewById(R.id.listView);

        // Prepare different course materials
        List<String> courseMaterials = new ArrayList<>();
        switch (courseTitle) {
            case "IT":
                courseMaterials = Arrays.asList(
                        "Introduction to Programming",
                        "Data Structures and Algorithms",
                        "Operating Systems",
                        "Database Management Systems"
                );
                break;

            case "Pharmacy":
                courseMaterials = Arrays.asList(
                        "Pharmacology Basics",
                        "Pharmaceutical Chemistry",
                        "Clinical Pharmacy",
                        "Drug Formulation"
                );
                break;

            case "International Relations":
                courseMaterials = Arrays.asList(
                        "World Politics",
                        "Foreign Policy Analysis",
                        "Global Governance",
                        "International Organizations"
                );
                break;

            case "Journalism":
                courseMaterials = Arrays.asList(
                        "Introduction to Journalism",
                        "Media Ethics",
                        "Investigative Reporting",
                        "Digital Media"
                );
                break;

            case "Psychology":
                courseMaterials = Arrays.asList(
                        "Introduction to Psychology",
                        "Cognitive Psychology",
                        "Behavioral Therapy",
                        "Abnormal Psychology"
                );
                break;

            case "Engineering":
                courseMaterials = Arrays.asList(
                        "Engineering Mathematics",
                        "Mechanics of Materials",
                        "Thermodynamics",
                        "Control Systems"
                );
                break;
        }

        // Set up the ListView with the course materials
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                courseMaterials
        );
        listView.setAdapter(adapter);

        TextView courseTitleTextView = findViewById(R.id.courseTitle);
        courseTitleTextView.setText(courseTitle);

    }
}
