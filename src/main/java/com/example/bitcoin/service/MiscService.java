package com.example.bitcoin.service;

import com.example.bitcoin.dto.ImportStateDTO;
import org.springframework.stereotype.Service;

@Service
public interface MiscService {
    void importFromHeight(Integer blockHeight, Boolean isClean);

    void importFromHash(String blockHash, Boolean isClean) throws Throwable;

    ImportStateDTO getImportState();

    Object search(String keyword);
}
