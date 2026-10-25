package com.example.unifind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String name = UserStore.getName(this);
        String email = UserStore.getEmail(this);

        TextView tvAvatar = findViewById(R.id.tvAvatar);
        TextView tvName = findViewById(R.id.tvProfileName);
        TextView tvEmail = findViewById(R.id.tvProfileEmail);
        TextView tvInfoName = findViewById(R.id.tvInfoName);
        TextView tvInfoEmail = findViewById(R.id.tvInfoEmail);
        Button btnLogout = findViewById(R.id.btnLogout);

        tvAvatar.setText(name.isEmpty() ? "U" : name.substring(0, 1).toUpperCase());
        tvName.setText(name);
        tvEmail.setText(email);
        tvInfoName.setText(name);
        tvInfoEmail.setText(email);

        btnLogout.setOnClickListener(v -> {
            Toast.makeText(this, R.string.logged_out, Toast.LENGTH_SHORT).show();
            // Open Login and clear every other screen from the back stack
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}