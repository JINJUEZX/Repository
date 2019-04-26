package com.example.bitcoin.controller;

import com.example.bitcoin.dto.TransactionInfoDTO;
import com.example.bitcoin.dto.TransactionListDTO;
import com.example.bitcoin.po.Transaction;
import com.example.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getRecentTransactionsById")
    public List<TransactionListDTO> getRecentTransactionsById(@RequestParam Integer blockchainId){
        return null;
    }

    @GetMapping("/getRecentTransactionsByNameType")
    public List<TransactionListDTO> getRecentTransactionsByNameType(@RequestParam String name,
                                                                    @RequestParam String type){
        return null;
    }

    @GetMapping("/getTransactionInfoByTxid")
    public TransactionInfoDTO getTransactionInfoByTxid(@RequestParam String txid){
        return null;
    }

    @GetMapping("/getTransactionInfoByTxhash")
    public TransactionInfoDTO getTransactionInfoByTxhash(@RequestParam String txhash){
        return null;
    }

    @GetMapping("/getTransactions")
    public List<TransactionListDTO> getTransactions(){

        List<Transaction> transactions = transactionService.getTransactions();

        List<TransactionListDTO> transactionListDTOS = transactions.stream().map(transaction->{
            TransactionListDTO transactionListDTO = new TransactionListDTO();
            transactionListDTO.setTxid(transaction.getTxid());
            transactionListDTO.setTxhash(transaction.getTxhash());
            transactionListDTO.setTime(transaction.getTime());
            transactionListDTO.setAmount(transaction.getAmount());
            return transactionListDTO;
        }).collect(Collectors.toList());

        return transactionListDTOS;
    }

}
