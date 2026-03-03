package com.example.milestone_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.DividerItemDecoration;

public class SubjectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        //Set up subject list
        List<String> subjects = new ArrayList<>();
        subjects.add("📚 Mathematics");
        subjects.add("📚 Science");
        subjects.add("📚 English");
        subjects.add("📚 Filipino");
        subjects.add("📚 History");
        subjects.add("📚 Computer Science");
        subjects.add("📚 Arts");
        subjects.add("📚 Music");
        subjects.add("📚 Physics");
        subjects.add("📚 P.E");

        //Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewSubjects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);
        SubjectAdapter adapter = new SubjectAdapter(subjects);
        recyclerView.setAdapter(adapter);

        //Back button
        Button btnBack = findViewById(R.id.btnBackToDashboard);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubjectsActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}