package com.example.bitcoin.service.impl;

import com.example.bitcoin.mapper.TransactionMapper;
import com.example.bitcoin.po.Transaction;
import com.example.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<Transaction> getTransactions() {

        List<Transaction> transactions = transactionMapper.getTransactions();

        return transactions;
    }
}
