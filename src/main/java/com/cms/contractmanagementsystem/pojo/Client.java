package com.cms.contractmanagementsystem.pojo;

public class Client {

    private Integer id;
    private String name;
    private String address;
    private String fax;
    private String tel;
    private String postcode;
    private String bankname;
    private String bankaccount;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Client() {
    }

    public Client(Integer id, String name, String address, String fax, String tel, String postcode, String bankname, String bankaccount, Integer del) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fax = fax;
        this.tel = tel;
        this.postcode = postcode;
        this.bankname = bankname;
        this.bankaccount = bankaccount;
        this.del = del;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", fax='" + fax + '\'' +
                ", tel='" + tel + '\'' +
                ", postcode='" + postcode + '\'' +
                ", bankname='" + bankname + '\'' +
                ", bankaccount='" + bankaccount + '\'' +
                ", del=" + del +
                '}';
    }
}
