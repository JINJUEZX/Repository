package com.example.bitcoin.controller;

import com.example.bitcoin.dto.TransactionInfoDTO;
import com.example.bitcoin.dto.TxDetailInTxInfo;
import com.example.bitcoin.po.Block;
import com.example.bitcoin.po.Transaction;
import com.example.bitcoin.service.TransactionDetailService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/transactionDetail")
public class TransactionDetailController {

    @Autowired
    private TransactionDetailService transactionDetailService;

    @GetMapping("/getTransactionDetail")
    public List<TransactionInfoDTO> getTransactionDetail(Integer blockheight){

        List<Block> blocks = transactionDetailService.getBlockHash(blockheight);

        String blockhash = blocks.get(0).getBlockhash();

        List<Transaction> transactions = transactionDetailService.getTransactions(blockhash);


        List<TransactionInfoDTO> transactionInfoDTOS =transactions.stream().map(block->{
            TransactionInfoDTO t = new TransactionInfoDTO();

            t.setTxid(block.getTxid());
            t.setTxhash(block.getTxhash());
            t.setSize(block.getSize());
            t.setWeight(block.getWeight());
            t.setTime(block.getTime());
            t.setTotalInput(block.getTotalInput());
            t.setTotalOutput(block.getTotalOutput());
            t.setFees(block.getFees());
            List<TxDetailInTxInfo> txDetailInTxInfos=transactionDetailService.getTxDetailInTxInfos(block.getTxid());

            t.setTxDetails(txDetailInTxInfos);
            return t;
        }).collect(Collectors.toList());

        return transactionInfoDTOS;
    }

}
