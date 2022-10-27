package com.hma.katabook.domain;

public class BookPacket {
    private String bookReference;
    private int quantity;

    public BookPacket(String bookReference, int quantity)
    {
        this.bookReference = bookReference;
        this.quantity = quantity;
    }
}
