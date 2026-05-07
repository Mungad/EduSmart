package com.example.edusmart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;
    FirebaseAuth mAuth;
/*
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
            mAuth= FirebaseAuth.getInstance();

            edUsername =findViewById(R.id.editTextAppFullName);
            edPassword = findViewById(R.id.editTextAppFloorNo);
            edEmail = findViewById(R.id.editTextAppLocation);
            edConfirm = findViewById(R.id.editTextAppContactNumber);
            btn = findViewById(R.id.buttonBookAppointment);
            tv = findViewById(R.id.textViewNewToEduSmart);

        tv.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this,LoginActivity.class)));

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       String username = edUsername.getText().toString();
                                       String email = edEmail.getText().toString();
                                       String password = edPassword.getText().toString();
                                       String confirm = edConfirm.getText().toString();
                                       if (username.isEmpty() || password.isEmpty() || email.isEmpty() || confirm.isEmpty()) {
                                           Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                                       } else {
                                           if (password.compareTo(confirm) == 0) {
                                               if (isValid(password)) {
                                                   mAuth.createUserWithEmailAndPassword(email, password)
                                                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                               @Override
                                                               public void onComplete(@NonNull Task<AuthResult> task) {
                                                                   if (task.isSuccessful()) {
                                                                       Toast.makeText(RegisterActivity.this, "Account created.",
                                                                               Toast.LENGTH_SHORT).show();
                                                                       Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                                                       startActivity(intent);
                                                                       finish();
                                                                   } else {
                                                                       String errorMsg = task.getException() != null ? task.getException().getMessage() : "Authentication failed.";
                                                                       Toast.makeText(RegisterActivity.this, "Error: " + errorMsg, Toast.LENGTH_SHORT).show();
                                                                   }
                                                               }
                                                           });
                                               } else {
                                                   Toast.makeText(getApplicationContext(), "Password must contain 8 characters having a letter, digit and character", Toast.LENGTH_SHORT).show();
                                               }
                                           } else {
                                               Toast.makeText(getApplicationContext(), "Passwords did not match", Toast.LENGTH_SHORT).show();
                                           }
                                       }
                                   }
                               });
    }
    public static boolean isValid(String password) {
        int hasLetter = 0, hasDigit = 0, hasSpecialChar = 0;

        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        } else {
            // Iterate through each character in the password
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);

                // Check for a letter
                if (Character.isLetter(c)) {
                    hasLetter = 1;
                }
                // Check for a digit
                if (Character.isDigit(c)) {
                    hasDigit = 1;
                }
                // Check for a special character
                if ((c >= 33 && c <= 46) || c == 64) { // ASCII range for common special chars
                    hasSpecialChar = 1;
                }
            }

            // If all conditions are met, return true
            if (hasLetter == 1 && hasDigit == 1 && hasSpecialChar == 1) {
                return true;
            }
        }
        // If any condition is not met, return false
        return false;
    }

}