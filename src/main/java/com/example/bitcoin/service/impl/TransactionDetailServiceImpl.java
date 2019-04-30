package com.example.bitcoin.service.impl;

import com.example.bitcoin.dto.TxDetailInTxInfo;
import com.example.bitcoin.mapper.TransactionDetailMapper;
import com.example.bitcoin.po.Block;
import com.example.bitcoin.po.Transaction;
import com.example.bitcoin.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @Override
    public List<Block> getBlockHash(Integer blockheight) {
        return transactionDetailMapper.getBlockHash(blockheight);
    }

    @Override
    public List<Transaction> getTransactions(String blockhash) {
        return transactionDetailMapper.getTransactions(blockhash);
    }

    @Override
    public List<TxDetailInTxInfo> getTxDetailInTxInfos(String txid) {
        return transactionDetailMapper.getTxDetailInTxInfos(txid);
    }


}
