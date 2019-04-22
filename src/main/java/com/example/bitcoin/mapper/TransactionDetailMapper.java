package com.example.bitcoin.mapper;

import com.example.bitcoin.dto.AddressInfo;
import com.example.bitcoin.po.TransactionDetail;
import com.example.bitcoin.po.TransactionDetailKey;

import java.util.List;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(TransactionDetailKey key);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(TransactionDetailKey key);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    List<TransactionDetail> selectByAddress(String address);

    void truncate();

    AddressInfo getAddressInfo(String address);

}