package com.example.bitcoin.service;

import com.example.bitcoin.dto.TxDetailInTxInfo;
import com.example.bitcoin.po.Block;
import com.example.bitcoin.po.Transaction;

import java.util.List;

public interface TransactionDetailService {

    List<Block> getBlockHash(Integer blockheight);

    List<Transaction> getTransactions(String blockhash);

    List<TxDetailInTxInfo> getTxDetailInTxInfos(String txid);

}
