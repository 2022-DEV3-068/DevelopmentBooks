package com.hma.katabook;

import com.hma.katabook.controllers.BookPriceController;
import com.hma.katabook.domain.BookPacket;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class KataBookApplicationTests {
    BookPriceController bookPriceController;
    // however, you buy two different books from the series, you get a 5% discount on those two books.
    // BookPacketWithoutDeprecation.length == 2  && b1 !== b2  ===> Total - 5%   If,
    //TOBE DONE: tests errors
    @Test
    public void testPriceTwoBooks(){
        assertTrue(true);
        // test Price Two Books without Duplication
        assertEquals(95, bookPriceController.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-1", 1), new BookPacket("Book-Ref-2", 1)))));
//        assertEquals(95, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-2", 1), new BookPacket("Book-Ref-1", 1)))));

        // test Price Two Books with Duplications
//        assertEquals(145, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-1", 2), new BookPacket("Book-Ref-2", 1)))));
//        assertEquals(245, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-2", 1), new BookPacket("Book-Ref-1", 4)))));
//        assertEquals(335, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-1", 4), new BookPacket("Book-Ref-2", 5))));
    }

    // If you buy 3 different books, you get a 10% discount.
    // BookPacketWithoutDeprecation.length == 3  && b1 !== b2 !== b3  ===> Total - 10%
//    @Test
//    public void testBasicPriceThreeBooks(){
//        // test Price Three Books without Duplication
//        assertEquals(135, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-1", 1), new BookPacket("Book-Ref-2", 1), new BookPacket("Book-Ref-3", 1)))));
//        assertEquals(135, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-1", 2), new BookPacket("Book-Ref-2", 2), new BookPacket("Book-Ref-3", 2)))));
//        assertEquals(135, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-1", 2), new BookPacket("Book-Ref-2", 1), new BookPacket("Book-Ref-3", 1)))));
//
//
//        // test Price Two Books with Duplications
//        assertEquals(185, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-1", 2), new BookPacket("Book-Ref-2", 2), new BookPacket("Book-Ref-3", 1)))));
//        assertEquals(185, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-1", 2), new BookPacket("Book-Ref-2", 2), new BookPacket("Book-Ref-3", 3)))));
//        assertEquals(185, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(new BookPacket("Book-Ref-1", 3), new BookPacket("Book-Ref-2", 2), new BookPacket("Book-Ref-3", 2)))));
//    }
//

    // With 4 different books, you get a 20% discount.
    // BookPacketWithoutDeprecation.length == 4  && b1 !== b2  ===> Total - 20%
//    @Test
//    public void testBasicPriceFourBooks(){
//        // test Price Three Books without Duplication
//        assertEquals(160, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b3, b1, b2))));
//        assertEquals(160, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b3, b2, b1))));
//        assertEquals(160, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b2, b1, b3))));
//
//        // test Price Three Books Duplicate once One of them
//        assertEquals(210, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b3, b1, b2, b3))));
//        assertEquals(210, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b3, b2, b3, b1))));
//        assertEquals(210, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b2, b4, b1, b2, b3))));
//        assertEquals(210, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b3, b2, b1, b2))));
//
//        //   test Price Three Books Many Duplications of one of them
//        assertEquals(260, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b2, b4, b4, b1, b3))));
//        assertEquals(260, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b1, b4, b1, b2, b3, b1))));
//
//        //   test Price Combination of Duplications
//        assertEquals(320, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b1, b3, b2, b4, b2, b1, b3))));
//        assertEquals(320, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b3, b1, b4, b2, b1, b3, b2))));
//        assertEquals(320, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b2, b4, b2, b3, b1, b3, b1))));
//        assertEquals(430, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b1, b3, b2, b4, b3, b3, b2, b2, b4))));
//        assertEquals(370, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b3, b1, b3, b3, b4, b2, b3, b1, b2))));
//    }

    // If you go for the whole hog, and buy all 5, you get a huge 25% discount.
    // BookPacketWithoutDeprecation.length == 5  && b1 !== b2  ===> Total - 25%
//    @Test
//    public void testBasicPriceFiveBooks(){
//        // test Price Two Books without Duplication
//        assertEquals(187.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b1, b2, b3, b4, b5))));
//        assertEquals(187.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b2, b1, b3, b5, b4))));
//        assertEquals(187.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b5, b4, b3, b1, b2))));
//
//        // test Price Two Books Duplicate once One of them
//        assertEquals(237.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b1, b2, b2, b3, b4, b5))));
//        assertEquals(237.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b2, b1, b3, b5, b5, b4))));
//        assertEquals(237.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b5, b4, b4, b3, b1, b2))));
//        assertEquals(237.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b1, b2, b1, b3, b4, b5))));
//        assertEquals(237.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b2, b1, b3, b5, b3, b4))));
//
//        //   test Price Combination of Duplications
//        assertEquals(337.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b1, b2, b3, b4, b2))));
//        assertEquals(287.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b5, b2, b1, b3, b5, b5, b4))));
//        assertEquals(287.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b4, b5,  b4, b3, b1, b2, b5))));
//        assertEquals(267.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b1, b2, b3, b3, b4, b1, b5, b2))));
//        assertEquals(287.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b1, b3, b2, b2, b1, b3, b5, b4, b5, b4))));
//        assertEquals(372.5, priceCalculator.getPacketPrice(new ArrayList<BookPacket>(Arrays.asList(b1, b3, b2, b2, b1, b3, b5, b4, b5, b4))));
//
//
//    }
}

/*
Note that if you buy, say, 4 books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but the 4th book still costs 50 EUR.
===> No Duplication ....
 */