package com.solvd.sciencelab;

public class Financiation {
    private String finOrigin;

    public Financiation() {
    }

    public Financiation(String finOrigin) {
        this.finOrigin = finOrigin;
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
                "finOrigin='" + finOrigin + '\'' +
                '}';
    }
}
