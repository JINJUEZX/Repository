package com.example.bitcoin.dto;

public class BlockListDTO {
    private Integer height;
    private Long time;
    private Integer txSize;
    private Long sizeOnDisk;
    private String blockhash;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getTxSize() {
        return txSize;
    }

    public void setTxSize(Integer txSize) {
        this.txSize = txSize;
    }

    public Long getSizeOnDisk() {
        return sizeOnDisk;
    }

    public void setSizeOnDisk(Long sizeOnDisk) {
        this.sizeOnDisk = sizeOnDisk;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public BlockListDTO(Integer height, Long time, Integer txSize, Long sizeOnDisk, String blockhash) {
        this.height = height;
        this.time = time;
        this.txSize = txSize;
        this.sizeOnDisk = sizeOnDisk;
        this.blockhash = blockhash;
    }

    public BlockListDTO() {
    }

    @Override
    public String toString() {
        return "BlockListDTO{" +
                "height=" + height +
                ", time=" + time +
                ", txSize=" + txSize +
                ", sizeOnDisk=" + sizeOnDisk +
                ", blockhash='" + blockhash + '\'' +
                '}';
    }
}
