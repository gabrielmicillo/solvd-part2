package com.solvd.sciencelab;

public class PhoneNumber {
    private int phoneNumberId;
    private int phoneNumber;
    private Laboratory laboratory;

    public PhoneNumber() {
    }

    public PhoneNumber(int phoneNumberId, int phoneNumber, Laboratory laboratory) {
        this.phoneNumberId = phoneNumberId;
        this.phoneNumber = phoneNumber;
        this.laboratory = laboratory;
    }

    public int getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(int phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
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
                "phoneNumberId=" + phoneNumberId +
                ", phoneNumber=" + phoneNumber +
                ", laboratory=" + laboratory +
                '}';
    }
}
