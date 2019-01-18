package com.example.ousama.medical;

/**
 * Created by ousama on 1/19/2017.
 */

public class Doctor {
    private String phone;
    private String name;
    private String email;
    private String address;
    private String specialist;
    private String region;

    public Doctor(String phone, String name, String email, String address, String specialist, String region) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.address = address;
        this.specialist = specialist;
        this.region = region;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Dr. " + name + "\n" +
                "  Phone: " + phone + "\n" +
                "  Email: " + email + "\n" +
                "  Address: " + address;
    }
}
