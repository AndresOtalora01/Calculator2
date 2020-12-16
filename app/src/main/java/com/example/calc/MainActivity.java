package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity { // implements View.onClickListener
    //    private RecyclerView recyclerView;
//    private StackAdapter adapter;
//    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<HistoricModel> historic;
//    private Button btnSuma, btnResta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

//    @Override
//    public void onClick(View v) {
//
//    }

    public void init() {
        //recyclerView.setHasFixedSize(true);

        historic = new ArrayList<HistoricModel>();
        historic.add(new HistoricModel(1, 2));
        historic.add(new HistoricModel(4, 2));
        historic.add(new HistoricModel(3, 1));
        historic.add(new HistoricModel(1, 1));
        historic.add(new HistoricModel(-2, 2));
//        historic.add(new HistoricModel(1, 2));
//        historic.add(new HistoricModel(4, 2));
//        historic.add(new HistoricModel(-3, 1));
//        historic.add(new HistoricModel(3, 1));
//        historic.add(new HistoricModel(1, 1));
//        historic.add(new HistoricModel(-2, 2));
//        historic.add(new HistoricModel(1, 2));
//        historic.add(new HistoricModel(4, 2));
//        historic.add(new HistoricModel(-3, 1));

//
//        adapter = new StackAdapter(this, historic);
//        recyclerView = findViewById(R.id.rvPila);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

        StackAdapter listAdapter = new StackAdapter(this, historic);
        RecyclerView recyclerView = findViewById(R.id.rvPila);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);


//        btnSuma = (Button) findViewById(R.id.btnPlus);
//        btnResta = (Button) findViewById(R.id.btnMinus);
//
//        btnSuma.setOnClickListener(this);
//        btnResta.setOnClickListener(this);
        //clase anónima para utilizar el método on click sin necesidad de crear una nueva clase.
//        btnSuma.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void plusMethod(View view) {
        EditText et = (EditText) findViewById(R.id.editTextInput);
        TextView et2 = (TextView) findViewById(R.id.tvScore);
        String valueInput = et.getText().toString();
        String valueResult = et2.getText().toString();
        int result, input = Integer.parseInt(valueInput);

        if (!valueResult.isEmpty()) {
            result = Integer.parseInt(valueResult);
            int Score = input + result;

            et2.setText(Integer.toString(Score));
        } else {
            result = 0;
            et2.setText(String.valueOf(input));
        }

        historic.add(new HistoricModel(input, result));
    }

    public void minusMethod(View view) {
        EditText et = (EditText) findViewById(R.id.editTextInput);
        TextView et2 = (TextView) findViewById(R.id.tvScore);
        String valueInput = et.getText().toString();
        String stackInput;
        String valueResult = et2.getText().toString();
        int result, input = Integer.parseInt(valueInput);

        if (!valueResult.isEmpty()) {
            result = Integer.parseInt(valueResult);
            int Score = input - result;
            et2.setText(Integer.toString(Score));
        } else {
            result = input;
            et2.setText(Integer.toString(result));
        }

        stackInput = "- " + input;
        historic.add(new HistoricModel(input, result));

    }
}