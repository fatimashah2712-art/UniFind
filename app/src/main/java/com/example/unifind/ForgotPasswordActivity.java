package com.example.unifind;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ForgotPasswordActivity extends AppCompatActivity {

    private TextInputLayout tilEmail;
    private TextInputEditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        tilEmail = findViewById(R.id.tilForgotEmail);
        etEmail = findViewById(R.id.etForgotEmail);
        Button btnSend = findViewById(R.id.btnSendLink);
        TextView tvBack = findViewById(R.id.tvBackToLogin);

        btnSend.setOnClickListener(v -> {
            String email = etEmail.getText() == null ? "" : etEmail.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                tilEmail.setError(getString(R.string.error_email_required));
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tilEmail.setError(getString(R.string.error_email_invalid));
            } else if (!UserStore.emailExists(this, email)) {
                tilEmail.setError(getString(R.string.error_email_not_found));
            } else {
                tilEmail.setError(null);
                // Simulated recovery: pretend the link was sent, then open Reset screen
                Toast.makeText(this, R.string.reset_link_sent, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ResetPasswordActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });

        tvBack.setOnClickListener(v -> finish());
    }
}