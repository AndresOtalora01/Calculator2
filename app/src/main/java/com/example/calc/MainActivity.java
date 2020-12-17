package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<HistoricModel> historic = new ArrayList<>();
    ;
    private EditText etInput;
    private TextView etScore;
    private int actualScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = findViewById(R.id.editTextInput);
        etScore = findViewById(R.id.tvScore);
        recyclerView = findViewById(R.id.rvPila);
        initList();

    }

    private StackAdapter listAdapter;

    private void initList() {

        listAdapter = new StackAdapter(this);
        recyclerView.setAdapter(listAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void plusMethod(View view) {
        updateScore(HistoricModel.OperandType.TYPE_SUM);
    }

    public void minusMethod(View view) {
        updateScore(HistoricModel.OperandType.TYPE_SUB);
    }

    public void multMethod(View view) {
        updateScore(HistoricModel.OperandType.TYPE_MUL);
    }

    public void divMethod(View view) {
        updateScore(HistoricModel.OperandType.TYPE_DIV);
    }

//    private void updateScor(Boolean isPositive) {
//        String valueInput = etInput.getText().toString();
//
//        if (TextUtils.isEmpty(valueInput)) return;
//
//        int input = Integer.parseInt(valueInput);
//
//        if (!isPositive) {
//            input = -input;
//        }
//
//        actualScore += input;
//
//        etScore.setText(String.valueOf(actualScore));
//
//        historic.add(0, new HistoricModel(input, actualScore));
//        listAdapter.updateList(historic);
//    }

    private void updateScore(HistoricModel.OperandType operandType) {
        String valueInput = etInput.getText().toString();

        if (TextUtils.isEmpty(valueInput)) return;

        int input = Integer.parseInt(valueInput);

        switch (operandType) {
            case TYPE_SUM:
                actualScore += input;
                break;
            case TYPE_SUB:
                actualScore -= input;
                break;
            case TYPE_MUL:
                actualScore *= input;
                break;
            case TYPE_DIV:
                if (input != 0) {
                 actualScore /= input;
                } else return;
                break;

        }
        etScore.setText(String.valueOf(actualScore));
        historic.add(0, new HistoricModel(input, actualScore, operandType));
        listAdapter.updateList(historic);
    }


}