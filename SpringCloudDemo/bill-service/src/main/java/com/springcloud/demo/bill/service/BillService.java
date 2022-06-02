package com.springcloud.demo.bill.service;

import com.springcloud.demo.bill.dto.BillDTO;
import com.springcloud.demo.bill.entity.Bill;
import com.springcloud.demo.bill.exceptions.BillNotFoundException;
import com.springcloud.demo.bill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {


    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void createBill(Bill bill) {
        billRepository.save(bill);
    }

    public Bill getBillById(Long id){

        return billRepository.findById(id).orElseThrow(() -> new BillNotFoundException("Required bill with id: " + id+ "not found"));

    }

    










}
