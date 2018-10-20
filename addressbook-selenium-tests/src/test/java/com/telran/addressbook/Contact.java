package com.telran.addressbook;

public class Contact {
    private  String nameFirstName;
    private  String nameLastName;
    private  String nameAddress;
    private  String nameTelephone;
    private  String nameEmail;

    public Contact setNameFirstName(String nameFirstName) {
        this.nameFirstName = nameFirstName;
        return this;
    }

    public Contact setNameLastName(String nameLastName) {
        this.nameLastName = nameLastName;
        return this;
    }

    public Contact setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
        return this;
    }

    public Contact setNameTelephone(String nameTelephone) {
        this.nameTelephone = nameTelephone;
        return  this;
    }

    public Contact setNameEmail(String nameEmail) {
        this.nameEmail = nameEmail;
        return  this;
    }

    public String getNameFirstName() {
        return nameFirstName;
    }

    public String getNameLastName() {
        return nameLastName;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public String getNameTelephone() {
        return nameTelephone;
    }

    public String getNameEmail() {
        return nameEmail;
    }
}
