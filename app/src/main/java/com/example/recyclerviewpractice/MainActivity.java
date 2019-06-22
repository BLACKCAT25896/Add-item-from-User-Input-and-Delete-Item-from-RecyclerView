package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Student> studentList;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private EditText name, mobile, email;
    private Button save;
    private String aName, aMobile, aEmail;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("User Input and save data in RecyclerView");



        init();
        initRecyclerView();

        getStudentsData();
        deleteData();

    }

    private void deleteData() {

    }

    private void initRecyclerView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);
    }

    private void getStudentsData() {

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aName = name.getText().toString();
                aMobile = mobile.getText().toString();
                aEmail = email.getText().toString();
                Student student = new Student(aName,aMobile,aEmail);

                studentList.add(student);



            }
        });







        studentAdapter.notifyDataSetChanged();




    }

    private void init() {
        studentList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        studentAdapter = new StudentAdapter(studentList, this);
        name = findViewById(R.id.nameET);
        mobile = findViewById(R.id.phoneET);
        email = findViewById(R.id.emailET);
        save = findViewById(R.id.saveBtn);

    }
}
