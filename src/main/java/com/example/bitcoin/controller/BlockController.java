package com.example.bitcoin.controller;

import com.example.bitcoin.api.BitcoinApi;
import com.example.bitcoin.api.BitcoinJsonRpcClient;
import com.example.bitcoin.dto.BlockDetailDTO;
import com.example.bitcoin.dto.BlockListDTO;
import com.example.bitcoin.dto.TransactionInBlockDTO;
import com.example.bitcoin.mapper.BlockMapper;
import com.example.bitcoin.po.Block;
import com.example.bitcoin.po.Transaction;
import com.example.bitcoin.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/block")
@CrossOrigin
public class BlockController {

    @Autowired
    private BitcoinApi bitcoinApi;

    @Autowired
    private BitcoinJsonRpcClient bitcoinJsonRpcClient;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BlockService blockService;

    @Value("${blockchain.recentCount}")
    private Integer recentCount;

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks() throws Throwable {

//        String bestBlockhash = bitcoinJsonRpcClient.getBestBlockhash();
//        String tempBlockhash = bestBlockhash;
//
//        List<BlockListDTO> blockListDTOS = new LinkedList<>();
//
//        for (int i = 0; i < 5; i++) {
//            JSONObject block = bitcoinApi.getNoTxBlock(tempBlockhash);
//            BlockListDTO blockListDTO = new BlockListDTO();
//            blockListDTO.setHeight(block.getInteger("height"));
//            Long time = block.getLong("time");
//            Date date = new Date(time * 1000);
//            blockListDTO.setTime(date);
//            blockListDTO.setTxSize(block.getJSONArray("tx").size());
//            blockListDTO.setSizeOnDisk(block.getLong("size"));
//            blockListDTOS.add(blockListDTO);
//            tempBlockhash = block.getString("previousblockhash");
//        }

//        JSONObject chainInfo = bitcoinApi.getChainInfo();
//        Integer height = chainInfo.getInteger("blocks");
//        height -= 5;
//        String blockHashByHeight = bitcoinJsonRpcClient.getBlockHashByHeight(height);
//        JSONArray blockHeaders = bitcoinApi.getBlockHeaders(5, blockHashByHeight);
//
//        LinkedList<BlockListDTO> blockListDTOS = new LinkedList<>();
//        for (int i = 4; i > -1; i--) {
//            JSONObject block = blockHeaders.getJSONObject(i);
//            BlockListDTO blockListDTO = new BlockListDTO();
//            blockListDTO.setHeight(block.getInteger("height"));
//            Long time = block.getLong("time");
//            Date date = new Date(time * 1000);
//            blockListDTO.setTime(date);
//            //todo add size on disk
//            blockListDTO.setTxSize(block.getInteger("nTx"));
//            blockListDTOS.add(blockListDTO);
//        }

//        List<Block> blocks = blockMapper.selectRecent();
        List<Block> blocks = blockService.selectRecent();

        List<BlockListDTO> blockListDTOS = blocks.stream().map(block -> {
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime().getTime());
            blockListDTO.setTxSize(block.getTxSize());
            blockListDTO.setSizeOnDisk(block.getSizeOnDisk());
            return blockListDTO;
        }).collect(Collectors.toList());

        return blockListDTOS;


//        bitcoinApi.getBlockHeaders(recentCount,bestBlockhash)
    }


    @GetMapping("/getRecentBlocks2")
    public List<BlockListDTO> getRecentBlocks2() throws Throwable {

        List<Block> blocks = blockService.selectRecent2();

        List<BlockListDTO> blockListDTOS2 = blocks.stream().map(block -> {
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime().getTime());
            blockListDTO.setTxSize(block.getTxSize());
            blockListDTO.setSizeOnDisk(block.getSizeOnDisk());
            blockListDTO.setBlockhash(block.getBlockhash());
            return blockListDTO;
        }).collect(Collectors.toList());

        return blockListDTOS2;
    }


    @GetMapping("/getRecentBlocksByNameType")
    public List<BlockListDTO> getRecentBlocksByNameType(@RequestParam String name,
                                                        @RequestParam String type){
        return null;
    }

    @GetMapping("/getBlockDetailByHash")
    public BlockDetailDTO getBlockDetailByHash(@RequestParam String blockhash){
        return null;
    }

    @GetMapping("/getBlockDetailByHeight")
    public List<BlockDetailDTO> getBlockDetailByHeight(@RequestParam Integer blockheight){

        List<Block> blocks = blockService.getBlockDetailByHeight(blockheight);

        String blockhash = blocks.get(0).getBlockhash();

        List<TransactionInBlockDTO> transactions = blockService.getTransactionsByBlockHash(blockhash);

        List<BlockDetailDTO> blockDetailDTOList = blocks.stream().map(block->{
            BlockDetailDTO blockDetailDTO = new BlockDetailDTO();

            blockDetailDTO.setBlockhash(block.getBlockhash());
            blockDetailDTO.setDifficulty(block.getDifficulty());
            blockDetailDTO.setMerkleRoot(block.getMerkleRoot());
            blockDetailDTO.setHeight(block.getHeight());
            blockDetailDTO.setNextBlockhash(block.getNextBlockhash());
            blockDetailDTO.setOutputTotal(block.getOutputTotal());
            blockDetailDTO.setPrevBlockhash(block.getPrevBlockhash());
            blockDetailDTO.setSizeOnDisk(block.getSizeOnDisk());
            blockDetailDTO.setTime(block.getTime());
            blockDetailDTO.setTransactionFees(block.getTransactionFees());
            blockDetailDTO.setTxSize(block.getTxSize());

            blockDetailDTO.setTransactions(transactions);
            return blockDetailDTO;
        }).collect(Collectors.toList());

        return blockDetailDTOList;

    }



}
