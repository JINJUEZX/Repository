package com.example.bitcoin.mapper;

import com.example.bitcoin.dto.AddressInfo;
import com.example.bitcoin.dto.TransactionInBlockDTO;

import java.util.List;

public interface AddressMapper {

    AddressInfo getAddressInfo(String address);

    List<TransactionInBlockDTO> getAddressTransactions(String address, Integer pageNum);

}
