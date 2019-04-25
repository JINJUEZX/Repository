package com.example.bitcoin.service.impl;

import com.example.bitcoin.mapper.BlockMapper;
import com.example.bitcoin.po.Block;
import com.example.bitcoin.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    @Override
    public List<Block> selectRecent() {
        List<Block> blocks = blockMapper.selectRecent();
        return blocks;
    }
}
