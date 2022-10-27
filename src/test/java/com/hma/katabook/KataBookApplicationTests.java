package com.hma.katabook;

import com.hma.katabook.domain.BookPacket;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class KataBookApplicationTests {
    KataBookApplication priceCalculator;
    BookPacket b1 = new BookPacket("Book-Ref-1", 1);
    BookPacket b2 = new BookPacket("Book-Ref-2", 1);
    BookPacket b3 = new BookPacket("Book-Ref-3", 1);
    BookPacket b4 = new BookPacket("Book-Ref-4", 1);
    BookPacket b5 = new BookPacket("Book-Ref-5", 1);

    // however, you buy two different books from the series, you get a 5% discount on those two books.
    // BookPacketWithoutDeprecation.length == 2  && b1 !== b2  ===> Total - 5%   If,
    @Test
    public void testPriceTwoBooks(){
        // test Price Two Books without Duplication
        assertEquals(95, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2}));
        assertEquals(95, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1}));
        assertEquals(95, priceCalculator.getPacketPrice(new BookPacket[]{b3, b1}));

        // test Price Two Books Duplicate once One of them
        assertEquals(145, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b1}));
        assertEquals(145, priceCalculator.getPacketPrice(new BookPacket[]{b1, b1, b2}));
        assertEquals(145, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b1}));

        //   test Price Two Books Many Duplications of one of them
        assertEquals(245, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b1, b1, b1}));
        assertEquals(245, priceCalculator.getPacketPrice(new BookPacket[]{b1, b1, b1, b1, b2}));
        assertEquals(295, priceCalculator.getPacketPrice(new BookPacket[]{b1, b1, b1, b2, b1, b1}));

        //   test Price Two Books Duplicate once both of them
        assertEquals(190, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b1, b2}));
        assertEquals(190, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b2, b1}));
        assertEquals(190, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b2, b1}));
        assertEquals(190, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b1, b2}));


        //   test Price Two Books Many Duplications of both of them
        assertEquals(335, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b1, b1, b1, b2, b2}));
        assertEquals(335, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b1, b1, b1, b2, b2}));
        assertEquals(380, priceCalculator.getPacketPrice(new BookPacket[]{b1, b1, b1, b2, b2, b2, b1, b2}));
    }

    // If you buy 3 different books, you get a 10% discount.
    // BookPacketWithoutDeprecation.length == 3  && b1 !== b2 !== b3  ===> Total - 10%
    @Test
    public void testBasicPriceThreeBooks(){
        // test Price Three Books without Duplication
        assertEquals(135, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b3}));
        assertEquals(135, priceCalculator.getPacketPrice(new BookPacket[]{b1, b3, b2}));
        assertEquals(135, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b3}));
        assertEquals(135, priceCalculator.getPacketPrice(new BookPacket[]{b2, b3, b1}));
        assertEquals(135, priceCalculator.getPacketPrice(new BookPacket[]{b3, b1, b2}));
        assertEquals(135, priceCalculator.getPacketPrice(new BookPacket[]{b3, b3, b1}));

        // test Price Three Books Duplicate once One of them
        assertEquals(185, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b3, b1}));
        assertEquals(185, priceCalculator.getPacketPrice(new BookPacket[]{b1, b3, b1, b2}));
        assertEquals(185, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b1, b3}));
        assertEquals(185, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b3, b2}));

        //   test Price Three Books Many Duplications of one of them
        assertEquals(285, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b1, b4, b5, b3}));
        assertEquals(285, priceCalculator.getPacketPrice(new BookPacket[]{b1, b1, b4, b5, b2, b3}));
        assertEquals(285, priceCalculator.getPacketPrice(new BookPacket[]{b2, b3, b1, b1, b4, b5}));

        //   test Price Combination of Duplications
        assertEquals(170, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b3, b1, b2, b3}));
        assertEquals(170, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b3, b1, b3, b2}));
        assertEquals(170, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b1, b2, b3, b3}));
        assertEquals(405, priceCalculator.getPacketPrice(new BookPacket[]{b1, b1, b1, b2, b2, b2, b3, b3, b3}));
        assertEquals(90, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b3, b3, b2, b1, b1, b2, b4, b5}));
        assertEquals(90, priceCalculator.getPacketPrice(new BookPacket[]{b2, b2, b2, b3, b3, b3, b1, b1, b1, b2, b3, b1}));
    }


    // With 4 different books, you get a 20% discount.
    // BookPacketWithoutDeprecation.length == 4  && b1 !== b2  ===> Total - 20%
    @Test
    public void testBasicPriceFourBooks(){
        // test Price Three Books without Duplication
        assertEquals(160, priceCalculator.getPacketPrice(new BookPacket[]{b4, b3, b1, b2}));
        assertEquals(160, priceCalculator.getPacketPrice(new BookPacket[]{b4, b3, b2, b1}));
        assertEquals(160, priceCalculator.getPacketPrice(new BookPacket[]{b4, b2, b1, b3}));

        // test Price Three Books Duplicate once One of them
        assertEquals(210, priceCalculator.getPacketPrice(new BookPacket[]{b4, b3, b1, b2, b3}));
        assertEquals(210, priceCalculator.getPacketPrice(new BookPacket[]{b4, b3, b2, b3, b1}));
        assertEquals(210, priceCalculator.getPacketPrice(new BookPacket[]{b2, b4, b1, b2, b3}));
        assertEquals(210, priceCalculator.getPacketPrice(new BookPacket[]{b4, b3, b2, b1, b2}));

        //   test Price Three Books Many Duplications of one of them
        assertEquals(260, priceCalculator.getPacketPrice(new BookPacket[]{b4, b2, b4, b4, b1, b3}));
        assertEquals(260, priceCalculator.getPacketPrice(new BookPacket[]{b1, b4, b1, b2, b3, b1}));

        //   test Price Combination of Duplications
        assertEquals(320, priceCalculator.getPacketPrice(new BookPacket[]{b4, b1, b3, b2, b4, b2, b1, b3}));
        assertEquals(320, priceCalculator.getPacketPrice(new BookPacket[]{b4, b3, b1, b4, b2, b1, b3, b2}));
        assertEquals(320, priceCalculator.getPacketPrice(new BookPacket[]{b4, b2, b4, b2, b3, b1, b3, b1}));
        assertEquals(430, priceCalculator.getPacketPrice(new BookPacket[]{b4, b1, b3, b2, b4, b3, b3, b2, b2, b4}));
        assertEquals(370, priceCalculator.getPacketPrice(new BookPacket[]{b4, b3, b1, b3, b3, b4, b2, b3, b1, b2}));
    }

    // If you go for the whole hog, and buy all 5, you get a huge 25% discount.
    // BookPacketWithoutDeprecation.length == 5  && b1 !== b2  ===> Total - 25%
    @Test
    public void testBasicPriceFiveBooks(){
        // test Price Two Books without Duplication
        assertEquals(187.5, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b3, b4, b5}));
        assertEquals(187.5, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b3, b5, b4}));
        assertEquals(187.5, priceCalculator.getPacketPrice(new BookPacket[]{b5, b4, b3, b1, b2}));

        // test Price Two Books Duplicate once One of them
        assertEquals(237.5, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b2, b3, b4, b5}));
        assertEquals(237.5, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b3, b5, b5, b4}));
        assertEquals(237.5, priceCalculator.getPacketPrice(new BookPacket[]{b5, b4, b4, b3, b1, b2}));
        assertEquals(237.5, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b1, b3, b4, b5}));
        assertEquals(237.5, priceCalculator.getPacketPrice(new BookPacket[]{b2, b1, b3, b5, b3, b4}));

        //   test Price Combination of Duplications
        assertEquals(337.5, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b2, b3, b4, b2, b5, b2}));
        assertEquals(287.5, priceCalculator.getPacketPrice(new BookPacket[]{b5, b2, b1, b3, b5, b5, b4}));
        assertEquals(287.5, priceCalculator.getPacketPrice(new BookPacket[]{b4, b5,  b4, b3, b1, b2, b5}));
        assertEquals(267.5, priceCalculator.getPacketPrice(new BookPacket[]{b1, b2, b3, b3, b4, b1, b5, b2}));
        assertEquals(287.5, priceCalculator.getPacketPrice(new BookPacket[]{b1, b3, b2, b2, b1, b3, b5, b4, b5, b4}));
        assertEquals(372.5, priceCalculator.getPacketPrice(new BookPacket[]{b1, b3, b2, b2, b1, b3, b5, b4, b5, b4}));


    }
}

/*
Note that if you buy, say, 4 books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but the 4th book still costs 50 EUR.
===> No Duplication ....
 */