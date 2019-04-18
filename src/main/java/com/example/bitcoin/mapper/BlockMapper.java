package com.example.bitcoin.mapper;

import com.example.bitcoin.dto.BlockDetailDTO;
import com.example.bitcoin.dto.BlockListDTO;
import com.example.bitcoin.po.Block;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<BlockListDTO> getRecentBlocksById(Integer getRecentBlocksById);

    List<BlockListDTO> getRecentBlocksByNameType(String name, String type);

    BlockDetailDTO getBlockDetailByHash(String blockhash);

    BlockDetailDTO getBlockDetailByHeight(Integer blockheight);
}