package com.example.calc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StackAdapter extends RecyclerView.Adapter<StackAdapter.MyViewHolder> {

    private ArrayList<HistoricModel> historico;
    private Context context;


    public StackAdapter(Context context, ArrayList<HistoricModel> historico) {
        this.historico = historico;
        this.context = context;
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
        holder.input.setText(String.valueOf(fieldHistorico.getInput()));
        holder.result.setText(String.valueOf(fieldHistorico.getResult()));
    }

    @Override
    public int getItemCount() {
        if (historico != null) {
            return historico.size();
        } else return 0;
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
