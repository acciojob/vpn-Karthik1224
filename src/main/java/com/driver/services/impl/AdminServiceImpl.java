package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {

            Admin obj = new Admin(username,password);
            return adminRepository1.save(obj);
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) {
        Optional<Admin>optionalAdmin = adminRepository1.findById(adminId);
        Admin obj = optionalAdmin.get();
        ServiceProvider serviceProvider = new ServiceProvider(providerName);
        serviceProvider.setAdmin(obj);
        List<ServiceProvider> list = obj.getServiceProviderList();
        list.add(serviceProvider);
        return adminRepository1.save(obj);

    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{

          Optional<ServiceProvider>serviceProvider = serviceProviderRepository1.findById(serviceProviderId);
          if(serviceProvider.isEmpty()) throw new Exception("Invalid serviceProviderId");

          ServiceProvider obj = serviceProvider.get();

    }
}
