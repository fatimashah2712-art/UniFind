package com.example.unifind;


import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout tilName, tilEmail, tilPassword, tilConfirm;
    private TextInputEditText etName, etEmail, etPassword, etConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tilName = findViewById(R.id.tilName);
        tilEmail = findViewById(R.id.tilRegEmail);
        tilPassword = findViewById(R.id.tilRegPassword);
        tilConfirm = findViewById(R.id.tilConfirmPassword);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etRegEmail);
        etPassword = findViewById(R.id.etRegPassword);
        etConfirm = findViewById(R.id.etConfirmPassword);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvLogin = findViewById(R.id.tvGoLogin);

        btnRegister.setOnClickListener(v -> {
            if (validateInputs()) {
                UserStore.saveUser(this,
                        etName.getText().toString().trim(),
                        etEmail.getText().toString().trim(),
                        etPassword.getText().toString());
                Toast.makeText(this, R.string.register_success, Toast.LENGTH_LONG).show();
                finish(); // back to Login
            }
        });

        tvLogin.setOnClickListener(v -> finish());
    }

    private boolean validateInputs() {
        String name = etName.getText() == null ? "" : etName.getText().toString().trim();
        String email = etEmail.getText() == null ? "" : etEmail.getText().toString().trim();
        String password = etPassword.getText() == null ? "" : etPassword.getText().toString();
        String confirm = etConfirm.getText() == null ? "" : etConfirm.getText().toString();
        boolean valid = true;

        if (TextUtils.isEmpty(name)) {
            tilName.setError(getString(R.string.error_name_required));
            valid = false;
        } else {
            tilName.setError(null);
        }

        if (TextUtils.isEmpty(email)) {
            tilEmail.setError(getString(R.string.error_email_required));
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError(getString(R.string.error_email_invalid));
            valid = false;
        } else {
            tilEmail.setError(null);
        }

        if (password.length() < 6) {
            tilPassword.setError(getString(R.string.error_password_short));
            valid = false;
        } else {
            tilPassword.setError(null);
        }

        if (!confirm.equals(password)) {
            tilConfirm.setError(getString(R.string.error_password_mismatch));
            valid = false;
        } else {
            tilConfirm.setError(null);
        }
        return valid;
    }
}