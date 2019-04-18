package com.example.bitcoin.mapper;

import com.example.bitcoin.dto.TransactionInfoDTO;
import com.example.bitcoin.dto.TransactionListDTO;
import com.example.bitcoin.po.Transaction;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(String txid);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    List<TransactionListDTO> getRecentTransactionsById(Integer blockchainId);

    List<TransactionListDTO> getRecentTransactionsByNameType(String name, String type);

    TransactionInfoDTO getTransactionInfoByTxid(String txid);

    TransactionInfoDTO getTransactionInfoByTxhash(String txhash);
}