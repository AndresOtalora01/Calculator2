package com.example.calc;

public class HistoricModel {
    private int input;
    private int result;
    private OperandType operandType;

    public enum OperandType {
        TYPE_SUM, TYPE_SUB, TYPE_MUL, TYPE_DIV
    }
    public HistoricModel(int input, int result, OperandType operandType) {
        this.input = input;
        this.result = result;
        this.operandType = operandType;
    }

    public OperandType getOperandType() {
        return operandType;
    }

    public void setOperandType(OperandType operandType) {
        this.operandType = operandType;
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
