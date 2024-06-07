package com.example.r6companion;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class OperatorDetailActivity extends AppCompatActivity {
    private TextView name;
    private TextView role;
    private TextView unit;
    private ImageView image;
    private TextView description;
    private RecyclerView weaponsRecyclerView;
    private WeaponAdapter weaponAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator_detail);

        name = findViewById(R.id.operator_name);
        role = findViewById(R.id.operator_role);
        unit = findViewById(R.id.operator_unit);
        image = findViewById(R.id.operator_image);
        description = findViewById(R.id.operator_description);
        weaponsRecyclerView = findViewById(R.id.weapons_recycler_view);

        Operator operator = getIntent().getParcelableExtra("operator");

        if (operator != null) {
            name.setText(operator.getName());
            role.setText(operator.getRole());
            unit.setText(operator.getUnit());
            description.setText(operator.getDescription());

            Glide.with(this)
                    .load(operator.getImageUrl())
                    .into(image);

            weaponAdapter = new WeaponAdapter(operator.weapons);
            weaponsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            weaponsRecyclerView.setAdapter(weaponAdapter);
        }
    }
}