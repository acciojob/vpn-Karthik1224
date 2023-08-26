package com.driver.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ServiceProvider {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    private String serviceName;

    @ManyToOne
    @JoinColumn
    private Admin admin;


    @ManyToMany
    @JoinColumn
    List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    List<Connection>connectionList = new ArrayList<>();

    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    List<Country>countryList = new ArrayList<>();

    public ServiceProvider() {
    }

    public ServiceProvider(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
