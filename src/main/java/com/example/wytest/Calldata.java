package com.example.wytest;

import com.example.wytest.Address;

import java.math.BigInteger;

public class Calldata {

    private Address from;
    private Address to;
    private BigInteger tokenId;
    private String data;

    public Calldata() {
    }

    public Calldata(Address from, Address to, BigInteger tokenId, String data) {
        this.from = from;
        this.to = to;
        this.tokenId = tokenId;
        this.data = data;
    }

    public Address getFrom() {
        return from;
    }

    public void setFrom(Address from) {
        this.from = from;
    }

    public Address getTo() {
        return to;
    }

    public void setTo(Address to) {
        this.to = to;
    }

    public BigInteger getTokenId() {
        return tokenId;
    }

    public void setTokenId(BigInteger tokenId) {
        this.tokenId = tokenId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
