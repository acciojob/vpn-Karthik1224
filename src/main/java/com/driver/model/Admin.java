package com.driver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    List<ServiceProvider> serviceProviderList;

    public Admin() {
    }

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }
}
