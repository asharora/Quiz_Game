//package com.example.hospitalmanagement;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.hospitalmanagement.Patient;
//import com.example.hospitalmanagement.R;
//
//import java.util.ArrayList;
//
//public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
//
//    public static ArrayList<Patient> people;
//
//
//
//    public PersonAdapter( ArrayList<com.example.hospitalmanagement.Patient> people) {
//
//        this.people = people;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder
//    {
//
//        ImageView image;
//        TextView client,ph,userid,gen;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            image=itemView.findViewById(com.example.hospitalmanagement.R.id.image);
//            client=itemView.findViewById(com.example.hospitalmanagement.R.id.client);
//            ph=itemView.findViewById(com.example.hospitalmanagement.R.id.ph);
//            gen=itemView.findViewById(R.id.gen);
//            userid=itemView.findViewById(R.id.Userid);
//
//        }
//    }
//
//    @NonNull
//    @Override
//    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_patient_layout,null);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        holder.client.setText(people.get(position).getName().toString().trim());
//        holder.ph.setText(people.get(position).getPhone().toString().trim());
//        holder.itemView.setTag(people.get(position));
//        holder.gen.setText(people.get(position).getGender().toString().trim());
//        holder.userid.setText(people.get(position).getUserIdno().toString().trim());
//        holder.image.setImageResource(R.drawable.user12);
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return people.size();
//    }
//}
