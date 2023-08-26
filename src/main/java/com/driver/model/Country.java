package com.driver.model;// Note: Do not write @Enumerated annotation above CountryName in this model.

import javax.persistence.*;

@Entity
@Table
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;

    private String code;
    private CountryName countryName;


    @OneToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private ServiceProvider serviceProvider;


    public Country() {
    }

    public Country(String code, CountryName countryName) {
        this.code = code;
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CountryName getCountryName() {
        return countryName;
    }

    public void setCountryName(CountryName countryName) {
        this.countryName = countryName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
