package com.example.edusmart;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Button;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1, ed2,ed3,ed4,ed5;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_appointment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv = findViewById(R.id.textViewAppTitle);
        ed1 = findViewById(R.id.editTextAppFullName);
        ed2 = findViewById(R.id.editTextAppLocation);
        ed3 = findViewById(R.id.editTextAppFloorNo);
        ed4 = findViewById(R.id.editTextAppRoomNo);
        ed5 = findViewById(R.id.editTextAppContactNumber);
        dateButton = findViewById(R.id.buttonAppDate);
        timeButton = findViewById(R.id.buttonAppTime);
        btnBook = findViewById(R.id.buttonBookAppointment);


        //not editable, just display from previous activities
        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);
        ed5.setKeyListener(null);

        //fetch the data
        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String location = it.getStringExtra("text3");
        String floor = it.getStringExtra("text4");
        String room = it.getStringExtra("text5");
        String contact = it.getStringExtra("text6");

        //display to the edittext
        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(location);
        ed3.setText(floor);
        ed4.setText(room);
        ed5.setText(contact);

        initialDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gather input
                String appointmentTitle = tv.getText().toString();
                String fullname = ed1.getText().toString();
                String location = ed2.getText().toString();
                String floor = ed3.getText().toString();
                String room = ed4.getText().toString();
                String contact = ed5.getText().toString();
                String date = dateButton.getText().toString();
                String time = timeButton.getText().toString();

                // Check if fields are filled
                if (date.equals("Select Date") || time.equals("Select Time")) {
                    Toast.makeText(BookAppointmentActivity.this, "Please select date and time", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create a map or object for appointment details
                Map<String, String> appointmentDetails = new HashMap<>();
                appointmentDetails.put("title", appointmentTitle);
                appointmentDetails.put("fullname", fullname);
                appointmentDetails.put("location", location);
                appointmentDetails.put("floor", floor);
                appointmentDetails.put("room", room);
                appointmentDetails.put("contact", contact);
                appointmentDetails.put("date", date);
                appointmentDetails.put("time", time);

                // Save to Firebase Realtime Database
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("appointments");
                String appointmentId = databaseReference.push().getKey(); // Generate unique ID

                assert appointmentId != null;
                databaseReference.child(appointmentId).setValue(appointmentDetails)
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(BookAppointmentActivity.this, "Appointment booked successfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(BookAppointmentActivity.this, LecturerDetailsActivity.class)); // Move to next activity
                        })
                        .addOnFailureListener(e -> Toast.makeText(BookAppointmentActivity.this, "Failed to book appointment: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        });
    }
        private void initialDatePicker() {
            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    i1 = i1 + 1;
                    dateButton.setText(i2 + "/" + i1 + "/" + i);
                }
            };
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            int style = AlertDialog.THEME_HOLO_DARK;
            datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
            datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+386400000);
        }
        private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i+":"+i1);
            }
        };
            Calendar cal = Calendar.getInstance();
            int hrs = cal.get(Calendar.HOUR);
            int mins = cal.get(Calendar.MINUTE);

            int style = AlertDialog.THEME_HOLO_DARK;
            timePickerDialog = new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);

        }
}