package com.hma.katabook.domain;

public class BookPacket {
    public String bookReference;
    public int quantity;

    public BookPacket(String bookReference, int quantity)
    {
        this.bookReference = bookReference;
        this.quantity = quantity;
    }
}
