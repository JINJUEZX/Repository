package com.example.bitcoin.service;


import com.example.bitcoin.po.Block;

import java.util.List;

public interface BlockService {
    List<Block> selectRecent();
}
