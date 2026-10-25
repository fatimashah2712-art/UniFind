package com.example.unifind;


import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ResetPasswordActivity extends AppCompatActivity {

    private TextInputLayout tilNew, tilConfirm;
    private TextInputEditText etNew, etConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        String email = getIntent().getStringExtra("email");

        tilNew = findViewById(R.id.tilNewPassword);
        tilConfirm = findViewById(R.id.tilResetConfirm);
        etNew = findViewById(R.id.etNewPassword);
        etConfirm = findViewById(R.id.etResetConfirm);
        Button btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(v -> {
            if (validateInputs()) {
                if (email != null && UserStore.emailExists(this, email)) {
                    UserStore.setPassword(this, etNew.getText().toString());
                }
                Toast.makeText(this, R.string.reset_success, Toast.LENGTH_LONG).show();
                finish(); // back to Login
            }
        });
    }

    private boolean validateInputs() {
        String password = etNew.getText() == null ? "" : etNew.getText().toString();
        String confirm = etConfirm.getText() == null ? "" : etConfirm.getText().toString();
        boolean valid = true;

        if (password.length() < 6) {
            tilNew.setError(getString(R.string.error_password_short));
            valid = false;
        } else {
            tilNew.setError(null);
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