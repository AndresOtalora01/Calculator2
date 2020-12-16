package com.example.calc;

public class HistoricModel {
    private int input;
    private int result;

    public HistoricModel(int input, int result) {
        this.input = input;
        this.result = result;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
