package com.example.edusmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_books);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CardView it = findViewById(R.id.cardCTIT);
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(BooksActivity.this,BooksDetailsActivity.class);
                it.putExtra("title", "IT");
                startActivity(it);
            }
        });

        CardView pharmacy = findViewById(R.id.cardCTPharmacy);
        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(BooksActivity.this,BooksDetailsActivity.class);
                it.putExtra("title", "Pharmacy");
                startActivity(it);
            }
        });

        CardView international_relations = findViewById(R.id.cardCTInternationalRelations);
        international_relations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(BooksActivity.this,BooksDetailsActivity.class);
                it.putExtra("title", "International Relations");
                startActivity(it);
            }
        });
        CardView journalism = findViewById(R.id.cardCTJournalism);
        journalism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(BooksActivity.this,BooksDetailsActivity.class);
                it.putExtra("title", "International relations");
                startActivity(it);
            }
        });

        CardView psychology = findViewById(R.id.cardCTPsychology);
        psychology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(BooksActivity.this,BooksDetailsActivity.class);
                it.putExtra("title", "Psychology");
                startActivity(it);
            }
        });

        CardView engineering = findViewById(R.id.cardCTEngineering);
        engineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(BooksActivity.this,BooksDetailsActivity.class);
                it.putExtra("title", "Engineering");
                startActivity(it);
            }
        });
    }
}