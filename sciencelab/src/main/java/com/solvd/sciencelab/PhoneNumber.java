package com.solvd.sciencelab;

public class PhoneNumber {
    private int phoneNumber;
    private Laboratory laboratory;

    public PhoneNumber() {
    }

    public PhoneNumber(int phoneNumber, Laboratory laboratory) {
        this.phoneNumber = phoneNumber;
        this.laboratory = laboratory;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber=" + phoneNumber +
                ", laboratory=" + laboratory +
                '}';
    }
}
