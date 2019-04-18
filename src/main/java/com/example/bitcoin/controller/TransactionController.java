package com.example.bitcoin.controller;

import com.example.bitcoin.dto.TransactionInfoDTO;
import com.example.bitcoin.dto.TransactionListDTO;
import com.example.bitcoin.mapper.TransactionMapper;
import com.example.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getRecentTransactionsById")
    public List<TransactionListDTO> getRecentTransactionsById(@RequestParam Integer blockchainId){
        return transactionService.getRecentTransactionsById(blockchainId);
    }

    @GetMapping("/getRecentTransactionsByNameType")
    public List<TransactionListDTO> getRecentTransactionsByNameType(@RequestParam String name,
                                                                    @RequestParam String type){
        return transactionService.getRecentTransactionsByNameType(name,type);
    }

    @GetMapping("/getTransactionInfoByTxid")
    public TransactionInfoDTO getTransactionInfoByTxid(@RequestParam String txid){
        return transactionService.getTransactionInfoByTxid(txid);
    }

    @GetMapping("/getTransactionInfoByTxhash")
    public TransactionInfoDTO getTransactionInfoByTxhash(@RequestParam String txhash){
        return transactionService.getTransactionInfoByTxhash(txhash);
    }

}