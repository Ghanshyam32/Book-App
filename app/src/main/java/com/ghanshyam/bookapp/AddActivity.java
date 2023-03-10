package com.ghanshyam.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText title, author, pages;
    Button addBtn;

//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title = findViewById(R.id.title_input);
        author = findViewById(R.id.author_input);
        pages = findViewById(R.id.pages_input);
        addBtn = findViewById(R.id.save_button);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(AddActivity.this);
                myDatabaseHelper.addBook(title.getText().toString().trim(),
                        author.getText().toString().trim(),
                        Integer.parseInt(pages.getText().toString().trim()));
            }
        });


    }
}