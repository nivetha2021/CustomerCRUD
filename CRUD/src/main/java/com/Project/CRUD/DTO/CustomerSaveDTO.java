package com.Project.CRUD.DTO;


public class CustomerSaveDTO {

    private String customerName;
    private String customerAddress;
    private long mobile;
    public CustomerSaveDTO(){

    }

//    public CustomerSaveDTO(String customerName, String customerAddress, int mobile) {
//        this.customerName = customerName;
//        this.customerAddress = customerAddress;
//        this.mobile = mobile;
//    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "CustomerSaveDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
