package com.ecommerce.dao;

import com.ecommerce.model.Item;

/** A catalog that lists the items available in inventory. */
public class ItemCatalog {
	// This would come from a database in real life.
	// We use a static table for ease of testing and deployment.
	// See JDBC chapters for info on using databases in
	// servlets and JSP pages.
	private static Item[] items =
	  { new Item
		("lillian001", "Lillian Topuklu S�et",
		"https://cdn.dsmcdn.com//ty49/product/media/images/20210108/20/48916889/69028305/1/1_org.jpg",
	     "Renk: K�rm�z� Detay: Topuklu Malzeme: S�et Topuk Boyu: 9 cm. Taban Materyali: Neolit Jurdan "+
	      "Taban �� Taban: Pad'li �� Taban. Kal�p: Standart Ayak �l��lerine G�re Tam Kal�p.",
	   	39.95),
	   new Item
	   ("bag001", "C�zdan Aksesuarl� Ask�l� �anta",
	    "https://cdn.dsmcdn.com//ty69/product/media/images/20210213/6/62087578/89653491/1/1_org.jpg",
		"Cepli , zincir detayl� saten kol �antas� Y�kseklik: 18 cm Geni�lik: 28 cm Derinlik: 6 cm" +
		  "</UL>",
		12.99),
	  new Item
	  ("bejhat001", "Kad�n Bej �apka",
	   "https://cdn.dsmcdn.com//ty77/product/media/images/20210301/14/67650209/65234877/1/1_org_zoom.jpeg",
	   	 "Bucket �apka",
	  6.95),
	 new Item
	 ("flowdress001", "G���s B�zg� �i�ek Desen Elbise Pembe",
	  "https://cdn.dsmcdn.com//ty128/product/media/images/20210610/2/98137059/185683964/0/0_org.jpg",
	  	"�r�n �zellikleri: G���s B�zg� �i�ek Desen Elbise Pembe Model �l��leri: Boy: 1.62 , Kilo: 49 , "
	  	+ "G���s: 89 , Bel: 60 , Kal�a: 88. Modelin �zerindeki S/36 beden.",
	 59.95),
	new Item
	("blackcrop001", "Siyah Crop �rme Bluz",
	 "https://cdn.dsmcdn.com//ty54/product/media/images/20210114/15/53236421/118507474/1/1_org.jpg",
	 "Modelin �l��leri: Boy: 1.77, G���s: 85 Bel: 61, Kal�a: 90",
	 39.95),
	new Item
	 ("blackcigarette001", "Siyah Beli Kuplu Cigarette Pantolon",
	  "https://cdn.dsmcdn.com//ty82/product/media/images/20210310/10/70395927/65579961/4/4_org.jpg",
	  	"Modelin �l��leri: Boy: 1.75, G���s: 87, Bel: 60, Kal�a: 89",
	 69.95),
	 new Item
	 ("blueskirt001", "Kad�n Mavi Kat F�rf�rl� Flora Etek ",
	  "https://cdn.dsmcdn.com//ty36/product/media/images/20210316/15/72125280/151422590/1/1_org.jpg",
	  	"F�rf�rl�, katl�, ince kuma�l� etek.",
	 20.95),
	 new Item
	 ("lilashirt001", "Kad�n Koyu Lila Oversize Uzun Basic G�mlek",
	  "https://cdn.dsmcdn.com//ty118/product/media/images/20210524/18/91227723/177566952/1/1_org.jpg",
	  	"%70 Pamuk %30 Polyester\r\n" + 
	  	"Oversize, Uzun, Kenarlar� Oval Kesim, Rahat Kal�p G�mlek.",
	 49.95)
	};
	
	public static Item getItem(String itemID) {
		Item item;
		if (itemID == null) {
			return(null);
		}
		for(int i=0; i<items.length; i++) {
			item = items[i];
			if (itemID.equals(item.getItemID())) {
				return(item);
			}
		}
	return(null);
	}
}
