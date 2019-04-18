package com.example.bitcoin.service;

import com.example.bitcoin.dto.BlockDetailDTO;
import com.example.bitcoin.dto.BlockListDTO;
import com.example.bitcoin.mapper.BlockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {

    @Autowired
    private BlockMapper blockMapper;


    public List<BlockListDTO> getRecentBlocksById(Integer getRecentBlocksById) {
        return blockMapper.getRecentBlocksById(getRecentBlocksById);
    }

    public List<BlockListDTO> getRecentBlocksByNameType(String name, String type) {
        return blockMapper.getRecentBlocksByNameType(name,type);
    }

    public BlockDetailDTO getBlockDetailByHash(String blockhash) {
        return blockMapper.getBlockDetailByHash(blockhash);
    }

    public BlockDetailDTO getBlockDetailByHeight(Integer blockheight) {
        return blockMapper.getBlockDetailByHeight(blockheight);
    }
}
