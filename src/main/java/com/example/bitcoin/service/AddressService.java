package com.example.bitcoin.service;

import com.example.bitcoin.dto.AddressInfo;
import com.example.bitcoin.dto.TransactionInBlockDTO;
import com.example.bitcoin.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    public AddressInfo getAddressInfo(String address) {
        return addressMapper.getAddressInfo(address);
    }

    public List<TransactionInBlockDTO> getAddressTransactions(String address, Integer pageNum) {
        return addressMapper.getAddressTransactions(address,pageNum);
    }
}
