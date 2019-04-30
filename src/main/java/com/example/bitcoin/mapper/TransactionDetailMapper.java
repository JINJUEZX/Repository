package com.example.bitcoin.mapper;

import com.example.bitcoin.dto.TxDetailInTxInfo;
import com.example.bitcoin.po.Block;
import com.example.bitcoin.po.Transaction;
import com.example.bitcoin.po.TransactionDetail;
import com.example.bitcoin.po.TransactionDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(TransactionDetailKey key);

    int truncate();

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(TransactionDetailKey key);

    List<TransactionDetail> selectByAddress(@Param("address") String address);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    List<Block> getBlockHash(Integer blockheight);

    List<Transaction> getTransactions(String blockhash);

    List<TxDetailInTxInfo> getTxDetailInTxInfos(String txid);

}