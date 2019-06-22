package com.example.recyclerviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

  private ArrayList<Student> studentList;
  private Context context;

    public StudentAdapter(ArrayList<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_layout,parent,false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Student currentStudent =  studentList.get(position);

        final int currentP = position;
        final Student studentData = studentList.get(position);


        holder.nameTV.setText("Name : " + currentStudent.getName());
        holder.mobileNumberTV.setText("Cell : " +currentStudent.getMobileNumber());
        holder.emailTV.setText("Email : " + currentStudent.getEmail());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"Delete Button clicked " + position,Toast.LENGTH_LONG).show();
                
                
                
                removeItem(studentData);


            }

            private void removeItem(Student studentData) {
                int cPosition = studentList.indexOf(studentData);
                studentList.remove(cPosition);
                notifyItemRemoved(cPosition);
            }
        });




    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTV, mobileNumberTV, emailTV;
        private Button delete;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameTV);
            mobileNumberTV = itemView.findViewById(R.id.mobileTV);
            emailTV = itemView.findViewById(R.id.emailTV);
            delete = itemView.findViewById(R.id.deleteBtn);







        }
    }
}
