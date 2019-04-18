package com.example.bitcoin.service;

import com.example.bitcoin.dto.TransactionInfoDTO;
import com.example.bitcoin.dto.TransactionListDTO;
import com.example.bitcoin.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionMapper transactionMapper;


    public List<TransactionListDTO> getRecentTransactionsById(Integer blockchainId) {
        return transactionMapper.getRecentTransactionsById(blockchainId);
    }

    public List<TransactionListDTO> getRecentTransactionsByNameType(String name, String type) {
        return transactionMapper.getRecentTransactionsByNameType(name,type);
    }

    public TransactionInfoDTO getTransactionInfoByTxid(String txid) {
        return transactionMapper.getTransactionInfoByTxid(txid);
    }

    public TransactionInfoDTO getTransactionInfoByTxhash(String txhash) {
        return transactionMapper.getTransactionInfoByTxhash(txhash);
    }
}
