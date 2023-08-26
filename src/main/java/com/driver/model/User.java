package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private String password;
    private  String originalIP;

    private String maskedIP;

    private Boolean connected;

    @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
    List<ServiceProvider> serviceProviderList = new ArrayList<>();


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Connection>connectionList = new ArrayList<>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Country country;

    public User() {
    }

    public User(String userName, String password, String originalIP, String maskedIP, Boolean connected) {
        this.userName = userName;
        this.password = password;
        this.originalIP = originalIP;
        this.maskedIP = maskedIP;
        this.connected = connected;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOriginalIP(String originalIP) {
        this.originalIP = originalIP;
    }

    public void setMaskedIP(String maskedIP) {
        this.maskedIP = maskedIP;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getOriginalIP() {
        return originalIP;
    }

    public String getMaskedIP() {
        return maskedIP;
    }

    public Boolean getConnected() {
        return connected;
    }
}
