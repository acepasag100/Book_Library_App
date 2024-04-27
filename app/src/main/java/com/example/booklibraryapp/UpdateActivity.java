package com.example.booklibraryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateActivity extends AppCompatActivity {

    private EditText etUpdateID, etUpdateTitle, etUpdateAuthor, etUpdatePageNum;
    private Button btnUpdate;

    private String id, title, author, pages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUpdateID = findViewById(R.id.etUpdateID);
        etUpdateTitle = findViewById(R.id.etUpdateTitle);
        etUpdateAuthor = findViewById(R.id.etUpdateAuthor);
        etUpdatePageNum = findViewById(R.id.etUpdatePageNum);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getIntentContent(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("title") &&
                getIntent().hasExtra("author") &&
                getIntent().hasExtra("pages")){

            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");

            etUpdateID.setText(id);
            etUpdateTitle.setText(title);
            etUpdateAuthor.setText(author);
            etUpdatePageNum.setText(pages);
        }
        else{
            Toast.makeText(UpdateActivity.this, "No Data Avialable", Toast.LENGTH_LONG).show();
        }
    }
}