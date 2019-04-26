package com.example.bitcoin.service;

import com.example.bitcoin.po.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactions();

}
