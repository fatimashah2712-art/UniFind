
package com.example.unifind;

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
        setupCard(R.id.cardProfile, getString(R.string.module_profile));
    }

    // Later, replace the Toast with an Intent, e.g.
    // startActivity(new Intent(this, ProfileActivity.class));
    private void setupCard(int cardId, String moduleName) {
        MaterialCardView card = findViewById(cardId);
        card.setOnClickListener(v ->
                Toast.makeText(this, getString(R.string.coming_soon, moduleName),
                        Toast.LENGTH_SHORT).show());
    }
}
