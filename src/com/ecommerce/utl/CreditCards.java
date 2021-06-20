package com.ecommerce.utl;

import com.ecommerce.model.Card;

public class CreditCards {
    private static Card[] cards = { new Card("Muhammet", "4024007119943461", 123, "10/02/2025"),
            new Card("Sefa", "5582670190821749", 584, "01/03/2024"),
            new Card("Elif", "6011388571185175", 823, "12/09/2027"),
            new Card("Ýrem", "378108353254738", 902, "26/04/2033"), };

    public static Card getKartByNumber(String kn) {
        if (kn == null)
            return null;

        for (Card k : cards) {
            if (kn.equals(k.getNumber()))
                return k;
        }

        return null;
    }
}

