package com.example.edusmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class EducationArticlesActivity extends AppCompatActivity {
    private String[][] education_details =
            {
                {"Education Department" , "" , "" , "" , "Click more details"},
                {"Education,language and people" , "" , "" , "" , "Click more details"},
                {"Poverty" , "" , "" , "" , "Click more details"},
                {"American journal" , "" , "" , "" , "Click more details"},
                {"Home-schooling" , "" , "" , "" , "Click more details"}
            };
    private int[] images =
            {
                    R.drawable.article_1,
                    R.drawable.article_2,
                    R.drawable.article_3,
                    R.drawable.article_4,
                    R.drawable.article_5
            };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education_articles);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lst = findViewById(R.id.listviewEA);
        list = new ArrayList();
        for(int i=0; i<education_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", education_details[i][0]);
            item.put("line2", education_details[i][1]);
            item.put("line3", education_details[i][2]);
            item.put("line4", education_details[i][3]);
            item.put("line5", education_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,}
        );

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(EducationArticlesActivity.this,EducationArticlesDetailsActivity.class);
                it.putExtra("text1" , education_details[i][0]);
                it.putExtra("text2" , images[i]);
                startActivity(it);
            }
        });

    }
}