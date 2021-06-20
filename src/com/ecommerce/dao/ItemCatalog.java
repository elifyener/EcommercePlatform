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
		("lillian001", "Lillian Topuklu Süet",
		"https://cdn.dsmcdn.com//ty49/product/media/images/20210108/20/48916889/69028305/1/1_org.jpg",
	     "Renk: Kýrmýzý Detay: Topuklu Malzeme: Süet Topuk Boyu: 9 cm. Taban Materyali: Neolit Jurdan "+
	      "Taban Ýç Taban: Pad'li Ýç Taban. Kalýp: Standart Ayak Ölçülerine Göre Tam Kalýp.",
	   	39.95),
	   new Item
	   ("bag001", "Cüzdan Aksesuarlý Askýlý Çanta",
	    "https://cdn.dsmcdn.com//ty69/product/media/images/20210213/6/62087578/89653491/1/1_org.jpg",
		"Cepli , zincir detaylý saten kol çantasý Yükseklik: 18 cm Geniþlik: 28 cm Derinlik: 6 cm" +
		  "</UL>",
		12.99),
	  new Item
	  ("bejhat001", "Kadýn Bej Þapka",
	   "https://cdn.dsmcdn.com//ty77/product/media/images/20210301/14/67650209/65234877/1/1_org_zoom.jpeg",
	   	 "Bucket Þapka",
	  6.95),
	 new Item
	 ("flowdress001", "Göðüs Büzgü Çiçek Desen Elbise Pembe",
	  "https://cdn.dsmcdn.com//ty128/product/media/images/20210610/2/98137059/185683964/0/0_org.jpg",
	  	"Ürün Özellikleri: Göðüs Büzgü Çiçek Desen Elbise Pembe Model Ölçüleri: Boy: 1.62 , Kilo: 49 , "
	  	+ "Göðüs: 89 , Bel: 60 , Kalça: 88. Modelin üzerindeki S/36 beden.",
	 59.95),
	new Item
	("blackcrop001", "Siyah Crop Örme Bluz",
	 "https://cdn.dsmcdn.com//ty54/product/media/images/20210114/15/53236421/118507474/1/1_org.jpg",
	 "Modelin Ölçüleri: Boy: 1.77, Göðüs: 85 Bel: 61, Kalça: 90",
	 39.95),
	new Item
	 ("blackcigarette001", "Siyah Beli Kuplu Cigarette Pantolon",
	  "https://cdn.dsmcdn.com//ty82/product/media/images/20210310/10/70395927/65579961/4/4_org.jpg",
	  	"Modelin Ölçüleri: Boy: 1.75, Göðüs: 87, Bel: 60, Kalça: 89",
	 69.95),
	 new Item
	 ("blueskirt001", "Kadýn Mavi Kat Fýrfýrlý Flora Etek ",
	  "https://cdn.dsmcdn.com//ty36/product/media/images/20210316/15/72125280/151422590/1/1_org.jpg",
	  	"Fýrfýrlý, katlý, ince kumaþlý etek.",
	 20.95),
	 new Item
	 ("lilashirt001", "Kadýn Koyu Lila Oversize Uzun Basic Gömlek",
	  "https://cdn.dsmcdn.com//ty118/product/media/images/20210524/18/91227723/177566952/1/1_org.jpg",
	  	"%70 Pamuk %30 Polyester\r\n" + 
	  	"Oversize, Uzun, Kenarlarý Oval Kesim, Rahat Kalýp Gömlek.",
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
