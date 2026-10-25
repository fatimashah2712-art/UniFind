package com.example.unifind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        setupCard(R.id.cardLostFound, getString(R.string.module_lost_found));
        setupCard(R.id.cardCampusMap, getString(R.string.module_campus_map));
        setupCard(R.id.cardDepartments, getString(R.string.module_departments));
        setupCard(R.id.cardFaculty, getString(R.string.module_faculty));
        setupCard(R.id.cardNotices, getString(R.string.module_notices));

        // Profile card opens the Profile screen (explicit Intent)
        MaterialCardView cardProfile = findViewById(R.id.cardProfile);
        cardProfile.setOnClickListener(v ->
                startActivity(new Intent(this, ProfileActivity.class)));
    }

    // Other modules are placeholders for now
    private void setupCard(int cardId, String moduleName) {
        MaterialCardView card = findViewById(cardId);
        card.setOnClickListener(v ->
                Toast.makeText(this, getString(R.string.coming_soon, moduleName),
                        Toast.LENGTH_SHORT).show());
    }
}