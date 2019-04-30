package com.example.bitcoin.mapper;

import com.example.bitcoin.dto.BlockDetailDTO;
import com.example.bitcoin.dto.TransactionInBlockDTO;
import com.example.bitcoin.po.Block;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int truncate();

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    List<Block> selectRecent();

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<Block> selectRecent2();

    List<Block> getBlockDetailByHeight(Integer blockheight);

    List<TransactionInBlockDTO> getTransactionsByBlockHash(String blockhash);

}