package com.ghanshyam.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateActivity extends AppCompatActivity {


    EditText title2, author2, pages2;
    Button updateButton;
    String id, title, author, pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title2 = findViewById(R.id.title_input2);
        author2 = findViewById(R.id.author_input2);
        pages2 = findViewById(R.id.pages_input2);
        updateButton = findViewById(R.id.update_button);
        getIntentData();
        updateButton.setOnClickListener(view -> {
            MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(updateActivity.this);
            myDatabaseHelper.updateData(id, title, author, pages);
        });


    }

    void getIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("author") && getIntent().hasExtra("pages")) {
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");

            title2.setText(title);
            author2.setText(author);
            pages2.setText(pages);

        } else {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }
}