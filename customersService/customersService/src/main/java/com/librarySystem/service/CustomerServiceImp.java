package com.librarySystem.service;

import com.librarySystem.domain.Customer;
import com.librarySystem.Integrations.Sender;
import com.librarySystem.DAO.CustomerRepo;
import com.librarySystem.service.dto.CustomerAdapter;
import com.librarySystem.service.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    Sender sender;
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public void add(CustomerDto customerDto) {

        Customer customer= CustomerAdapter.getCustomerFromCustomerDto(customerDto);
        customerRepo.save(customer);
    }

    @Override
    public void deleteById(long customerNumber) {
      customerRepo.deleteById(customerNumber);
    }

    @Override
    public void updateById(long customerNumber, CustomerDto customerDto) {

        Customer customer=customerRepo.findById(customerNumber).orElse(null);
            customer.setCustomerNumber(customerDto.getCustomerNumber());
            customer.setName(customerDto.getName());
            customer.setAddress(customerDto.getAddress());
            customer.setContact(customerDto.getContact());
            customerRepo.save(customer);

            sender.send(customerDto);
        System.out.println("Sent.. "+customerDto+" to Integrations ");


        }


    @Override
    public CustomerDto getCustomerById(long customerNumber) {

        Customer optionalCustomer=customerRepo.findById(customerNumber).get();
        if (optionalCustomer == null){
            System.out.println("Customer not found!");
        }

        return CustomerAdapter.getCustomerDtoFromCustomer(optionalCustomer);
    }

    @Override
    public Collection<CustomerDto> getCustomers() {
        List<Customer>customers=customerRepo.findAll();
        return CustomerAdapter.getCustomerDtoListFromCustomerList(customers);
    }
}
