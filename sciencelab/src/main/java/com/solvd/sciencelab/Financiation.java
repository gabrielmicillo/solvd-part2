package com.solvd.sciencelab;

public class Financiation {
    private int financiationId;
    private String finOrigin;

    public Financiation() {
    }

    public Financiation(int financiationId, String finOrigin) {
        this.financiationId = financiationId;
        this.finOrigin = finOrigin;
    }

    public int getFinanciationId() {
        return financiationId;
    }

    public void setFinanciationId(int financiationId) {
        this.financiationId = financiationId;
    }

    public String getFinOrigin() {
        return finOrigin;
    }

    public void setFinOrigin(String finOrigin) {
        this.finOrigin = finOrigin;
    }

    @Override
    public String toString() {
        return "Financiation{" +
                "financiationId=" + financiationId +
                ", finOrigin='" + finOrigin + '\'' +
                '}';
    }
}
