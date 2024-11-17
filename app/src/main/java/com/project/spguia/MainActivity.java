package com.project.spguia;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etEmail;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etEmail=findViewById(R.id.etEmail);
        btnIngresar=findViewById(R.id.btnIngresar);

        SharedPreferences sp=getSharedPreferences("datos", Context.MODE_PRIVATE);
        etEmail.setText(sp.getString("email",""));
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared=getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=shared.edit();
                editor.putString("email", etEmail.getText().toString());
                editor.commit();
                finish();
            }
        });
    }
}