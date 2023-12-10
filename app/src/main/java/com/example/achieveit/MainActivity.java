package com.example.achieveit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Get references for the EditTexts
    private EditText etUsernameEmail;
    private EditText etPassword;

    // Get references for the Buttons;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditTexts
        etUsernameEmail = findViewById(R.id.etUsernameEmail);
        etPassword = findViewById(R.id.etPassword);

        // Initialize Buttons
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        setButtonMargins(30,0);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Set default margins when released or canceled
                        setButtonMargins(24, 10);
                        break;
                }
                return false;
            }
        });
    }

    private void setButtonMargins(int marginTop, int marginRight) {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) btnLogin.getLayoutParams();

        // Convert the margins in the parameters from dp to px
        float density = getResources().getDisplayMetrics().density;
        int marginTopInPx = Math.round(marginTop * density);
        int marginRightPx = Math.round(marginRight * density);

        params.setMargins(0, marginTopInPx, marginRightPx, 0);

        btnLogin.setLayoutParams(params);
    }
}