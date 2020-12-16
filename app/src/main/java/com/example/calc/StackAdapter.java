package com.example.calc;

import  android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StackAdapter extends RecyclerView.Adapter<StackAdapter.MyViewHolder> {

    private ArrayList<HistoricModel> historico = new ArrayList<>();;
    private Context context;


    public StackAdapter(Context context) {
        this.context = context;
    }

    public void updateList(ArrayList<HistoricModel> array){
        historico.clear();
        historico.addAll(array);
        notifyDataSetChanged();
    }

    @Override
    public StackAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.stack_row, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(StackAdapter.MyViewHolder holder, int position) {
        HistoricModel fieldHistorico = historico.get(position);
        holder.input.setText((fieldHistorico.getInput()>0 ? "+" : "")+fieldHistorico.getInput());
        holder.result.setText(String.valueOf(fieldHistorico.getResult()));
    }

    @Override
    public int getItemCount() {
        return historico.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView input, result;

        public MyViewHolder(View v) {
            super(v);
            input = v.findViewById(R.id.tvInput);
            result = v.findViewById(R.id.tvResultado);
        }
    }

}
