package com.example.edusmart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class LecturerDetailsActivity extends AppCompatActivity {
    private String[][] lecturer_details1 =
            {
                    {"Lecturer Name : Ethan Cooper" , "Location : Lilian Beam" , "Floor No : 2", "Room No : 2", "Mobile No : 0760 890 456" },
                    {"Lecturer Name : Sophia Bennett" , "Location : Lilian Beam" , "Floor No : 1", "Room No : 1", "Mobile No : 0758 789 234" },
                    {"Lecturer Name : Liam Mitchell" , "Location : Lilian Beam" , "Floor No : 4", "Room No : 3", "Mobile No : 0746 678 123" },
                    {"Lecturer Name : Ava Brooks" , "Location : Lilian Beam" , "Floor No : 1", "Room No : 4", "Mobile No : 0731 567 890" },
                    {"Lecturer Name : Noah Sullivan" , "Location : Lilian Beam" , "Floor No : 2", "Room No : 5", "Mobile No : 0729 456 789" }
            };
    private String[][] lecturer_details2 =
            {
                    {"Lecturer Name : Emma Carter" , "Location : School of Science and Technology " , "Floor No : 2", "Room No : 1", "Mobile No : 0717 345 678" },
                    {"Lecturer Name : Lucas Evans" , "Location : School of Science and Technology" , "Floor No : 2", "Room No : 2", "Mobile No : 0767 234 567" },
                    {"Lecturer Name : Mia Anderson" , "Location : School of Science and Technology" , "Floor No : 1", "Room No : 3", "Mobile No : 0756 123 456" },
                    {"Lecturer Name : Mason Hughes" , "Location : School of Science and Technology" , "Floor No : 4", "Room No : 4", "Mobile No : 0742 901 234" },
                    {"Lecturer Name : Isabella Reed" , "Location : School of Science and Technology" , "Floor No : 3", "Room No : 5", "Mobile No : 0738 890 345" }
            };
    private String[][] lecturer_details3 =
            {
                    {"Lecturer Name : Oliver Hayes" , "Location : School of Humanities and Social Science" , "Floor No : 2", "Room No : 1", "Mobile No : 0726 789 234" },
                    {"Lecturer Name : Charlotte Turner" , "Location : School of Humanities and Social Science" , "Floor No : 1", "Room No : 2", "Mobile No : 0716 678 123" },
                    {"Lecturer Name : Benjamin Morris" , "Location : School of Humanities and Social Science" , "Floor No : 3", "Room No : 3", "Mobile No : 0765 567 890" },
                    {"Lecturer Name : Amelia Foster" , "Location : School of Humanities and Social Science" , "Floor No : 2", "Room No : 4", "Mobile No : 0752 456 789" },
                    {"Lecturer Name : Elijah Coleman" , "Location : School of Humanities and Social Science" , "Floor No : 4", "Room No : 5", "Mobile No : 0741 345 678" }
            };
    private String[][] lecturer_details4 =
            {
                    {"Lecturer Name : Harper Scott" , "Location : New School of Humanities and Social Science" , "Floor No : 1", "Room No : 2", "Mobile No : 0739 234 567" },
                    {"Lecturer Name : James Parker" , "Location : New School of Humanities and Social Science" , "Floor No : 2", "Room No : 1", "Mobile No : 0725 678 345" },
                    {"Lecturer Name : Grace Murphy" , "Location : New School of Humanities and Social Science" , "Floor No : 2", "Room No : 4", "Mobile No : 0714 789 012" },
                    {"Lecturer Name : Alexander Peterson" , "Location : New School of Humanities and Social Science" , "Floor No : 2", "Room No : ", "Mobile No : 0768 123 456" },
                    {"Lecturer Name : Lily Jenkins" , "Location : New School of Humanities and Social Science" , "Floor No : 1", "Room No : 7", "Mobile No : 0754 234 567" }
            };
    private String[][] lecturer_details5 =
            {
                    {"Lecturer Name : Jackson Wright" , "Location : School of Business" , "Floor No : 2", "Room No : 1", "Mobile No : 0743 678 912" },
                    {"Lecturer Name : Chloe Hamilton" , "Location : School of Business" , "Floor No : 1", "Room No : 2", "Mobile No : 0730 456 789" },
                    {"Lecturer Name : Daniel Rivera" , "Location : School of Business" , "Floor No : 1", "Room No : 3", "Mobile No : 0728 345 678" },
                    {"Lecturer Name : Natalie Phillips" , "Location : School of Business" , "Floor No : 1", "Room No : 4", "Mobile No : 0713 876 543" },
                    {"Lecturer Name : Henry Morgan" , "Location : School of Business" , "Floor No : 3", "Room No : 5", "Mobile No : 0762 456 789" }
            };
    private String[][] lecturer_details6 =
            {
                    {"Lecturer Name : Zoe Patterson" , "Location : Freida Brown Building" , "Floor No :3 ", "Room No : 1", "Mobile No : 0751 987 654" },
                    {"Lecturer Name : William Ward" , "Location : Freida Brown Building" , "Floor No : 3", "Room No : 2", "Mobile No : 0745 678 901" },
                    {"Lecturer Name : Ella Collins" , "Location : Freida Brown Building" , "Floor No : 1", "Room No : 3", "Mobile No : 0734 567 890" },
                    {"Lecturer Name : Samuel Barnes" , "Location : Freida Brown Building" , "Floor No : 2", "Room No : 4", "Mobile No : 0721 234 567" },
                    {"Lecturer Name : Victoria Ross" , "Location : Freida Brown Building" , "Floor No : 2", "Room No : 5", "Mobile No : 0712 345 678" }
            };
    TextView tv;
    String[][] lecturer_details = {};
    HashMap<String,String> item;
    ArrayList list = new ArrayList();
    SimpleAdapter sa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lecturer_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv = findViewById(R.id.textViewLDTitle);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        assert title != null;
        if(title.compareTo("IT")==0)
            lecturer_details = lecturer_details1;
        else
        if(title.compareTo("Pharmacy")==0)
            lecturer_details = lecturer_details2;
        else
        if(title.compareTo("International Relations")==0)
            lecturer_details = lecturer_details3;
        else
        if(title.compareTo("Journalism")==0)
            lecturer_details = lecturer_details4;
        else
        if(title.compareTo("Psychology")==0)
            lecturer_details = lecturer_details5;
        else
            lecturer_details = lecturer_details6;

        for (String[] lecturerDetail : lecturer_details) {
            item = new HashMap<String, String>();
            item.put("line1", lecturerDetail[0]);
            item.put("line2", lecturerDetail[1]);
            item.put("line3", lecturerDetail[2]);
            item.put("line4", lecturerDetail[3]);
            item.put("line5", lecturerDetail[4]);
            list.add(item);
        }
        //binds the data to the list view
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,}
                );
        ListView lst = findViewById(R.id.listViewLD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LecturerDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1" , title);
                it.putExtra("text2" , lecturer_details[i][0]);
                it.putExtra("text3" , lecturer_details[i][1]);
                it.putExtra("text4" , lecturer_details[i][2]);
                it.putExtra("text5" , lecturer_details[i][3]);
                it.putExtra("text6" , lecturer_details[i][4]);
                startActivity(it);
            }
        });

        }
    }
