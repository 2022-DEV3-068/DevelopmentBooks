package com.hma.katabook.controllers;

import com.hma.katabook.domain.BookPacket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookPriceController {

    @PostMapping("/packet-price")
    public double getPacketPrice(@RequestBody List<BookPacket> bookList) {
        List<String> flatBooksList = new ArrayList<>();
        flatBooksList = flatBooksList(bookList);
        System.out.println("WORKING ON -------------------" + flatBooksList);

        List<List<String>> groupedBooks = new ArrayList<>();
        groupedBooks = groupedBooks(flatBooksList);
        System.out.println("Grouped Books -------------------" + groupedBooks);


        double basketPrice =  priceCalculation(groupedBooks);
        System.out.println("Basket Price -------------------" + basketPrice);

        return basketPrice;
    }

    private double priceCalculation(List<List<String>> packet) {
        var wrapper = new Object(){ double packPrice = 0; };
        if(!packet.isEmpty()) {
            packet.forEach(pack -> {
                double packPrice = packPrice(pack.size());
                wrapper.packPrice += packPrice;
            });
        }

        return wrapper.packPrice;
    }

    private float packPrice(int packSize) {
        int percent = (packSize == 5) ? 25 : (packSize == 4 ? 20 : (((packSize == 3) ? 10 : ((packSize == 2) ? 5 : 0))));
        return  (50 * packSize) - (((50 * packSize) / 100) *  percent) ;
    }

    private List<String> flatBooksList(List<BookPacket> bookList) {
        List<String> books = new ArrayList<>();
        if(!bookList.isEmpty()){
            bookList.forEach(bl -> {
                for(var i = 0; i < bl.quantity; i++) {
                    books.add(bl.bookReference);
                }
            });
        }
        return books;
    }

    // NOTE: Refact: reccressive function will be a better solution (something went wrong for me)
    // NOTE: satisfiying sonar is needed!!
    private List<List<String>> groupedBooks(List<String> bookList) {
        List<List<String>> bookGroup = new ArrayList<>();
        do {
            List<String> group = new ArrayList<>();
            group = extractGroup(bookList);
            bookGroup.add(group);
            removeElement(bookList, group);
        } while (!bookList.isEmpty());

        return bookGroup;
    }

    private List<String> extractGroup(List<String> bookList) {
        List<String> refs = new ArrayList<>();
        if(!bookList.isEmpty()) {
            bookList.forEach(bl -> {
                if(refs.isEmpty() || refs.indexOf(bl) == -1) {
                    refs.add(bl);
                }
            });
        }
        return refs;
    }

    private List<String> removeElement(List<String> bookList, List<String> itemsToRemove) {
        if(!itemsToRemove.isEmpty()) {
            itemsToRemove.forEach(bl -> {
                if(!bookList.isEmpty() &&  bookList.indexOf(bl) != -1) {
                    bookList.remove(bl);
                }
            });
        }

        return bookList;
    }
}
