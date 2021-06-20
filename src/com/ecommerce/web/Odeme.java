package com.ecommerce.web;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ecommerce.utl.CreditCards;
import com.ecommerce.model.Card;

@Path("/odeme")
public class Odeme {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)

    public Response odemeyiKontrolEt(Card kart) {
        Card arananKart = CreditCards.getKartByNumber(kart.getNumber());
        List<String> mesaj = new ArrayList<String>();
        if (arananKart != null) {
            if (arananKart.getOwner().equals(kart.getOwner()) && arananKart.getCvc() == kart.getCvc()
                    && arananKart.getSkt().equals(kart.getSkt())) {
                mesaj.add("Ödeme Baþarýlý.");
                GenericEntity<List<String>> entity = new GenericEntity<List<String>>(mesaj) {
                };
                return Response.status(200).entity(entity).build();
            }
        }

        mesaj.add("Ödeme Baþarýsýz...");
        GenericEntity<List<String>> entity = new GenericEntity<List<String>>(mesaj) {};
        return Response.status(401).entity(entity).build();
    }
}
