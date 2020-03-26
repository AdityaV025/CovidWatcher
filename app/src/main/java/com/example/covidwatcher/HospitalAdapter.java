package com.example.covidwatcher;

import android.content.Intent;
import android.net.Uri;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Aditya Verma on 26-03-2020
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>{
    private List<People> hospitalNameList;
    Context context;

    HospitalAdapter(List<People> hospitalNameList, Context context) {
        this.hospitalNameList = hospitalNameList;
        this.context = context;
    }

    @Override
    public HospitalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View hospitalNameView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_cardview, parent, false);
        return new HospitalViewHolder(hospitalNameView);
    }

    @Override
    public void onBindViewHolder(HospitalViewHolder holder, final int position) {
        holder.hospitalName.setText(hospitalNameList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = hospitalNameList.get(position).getName();

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + name);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return hospitalNameList.size();
    }

    static class HospitalViewHolder extends RecyclerView.ViewHolder {
        TextView hospitalName;
        HospitalViewHolder(View view) {
            super(view);
            hospitalName = view.findViewById(R.id.hospitalName);
        }
    }
}
