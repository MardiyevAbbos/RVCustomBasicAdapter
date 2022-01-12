package com.example.rvcustombasicadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvcustombasicadapter.R;
import com.example.rvcustombasicadapter.model.Member;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Member> members;

    public CustomAdapter(Context context, ArrayList<Member> members){
        this.context = context;
        this.members = members;
        // uyftfuyyugy
    }


    @Override
    public int getItemCount() {
        return members.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_layout,parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewHolder){
            TextView firstN = ((CustomViewHolder)holder).firstName;
            TextView lastN = ((CustomViewHolder)holder).lastName;

            firstN.setText(member.getFirstName());
            lastN.setText(member.getLastName());
        }
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView firstName;
        public TextView lastName;

        CustomViewHolder(View v){
            super(v);
            this.view = v;
            firstName = view.findViewById(R.id.first_name);
            lastName = view.findViewById(R.id.last_name);
        }

    }


}
