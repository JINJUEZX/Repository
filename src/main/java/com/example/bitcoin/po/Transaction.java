package com.example.bitcoin.po;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private String txid;

    private String txhash;

    private String blockhash;

    private Long size;

    private Integer weight;

    private Date time;

    private Double totalInput;

    private Double totalOutput;

    private Double fees;

    private Double amount;

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getTotalInput() {
        return totalInput;
    }

    public void setTotalInput(Double totalInput) {
        this.totalInput = totalInput;
    }

    public Double getTotalOutput() {
        return totalOutput;
    }

    public void setTotalOutput(Double totalOutput) {
        this.totalOutput = totalOutput;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transaction(String txid, String txhash, String blockhash, Long size, Integer weight, Date time, Double totalInput, Double totalOutput, Double fees, Double amount) {
        this.txid = txid;
        this.txhash = txhash;
        this.blockhash = blockhash;
        this.size = size;
        this.weight = weight;
        this.time = time;
        this.totalInput = totalInput;
        this.totalOutput = totalOutput;
        this.fees = fees;
        this.amount = amount;
    }

    public Transaction() {
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txid='" + txid + '\'' +
                ", txhash='" + txhash + '\'' +
                ", blockhash='" + blockhash + '\'' +
                ", size=" + size +
                ", weight=" + weight +
                ", time=" + time +
                ", totalInput=" + totalInput +
                ", totalOutput=" + totalOutput +
                ", fees=" + fees +
                ", amount=" + amount +
                '}';
    }
}