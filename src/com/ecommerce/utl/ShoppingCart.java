package com.ecommerce.utl;
import java.util.*;
import com.ecommerce.model.ItemOrder;
import com.ecommerce.dao.ItemCatalog;

public class ShoppingCart {
	private ArrayList itemsOrdered;
	/** Builds an empty shopping cart. */

	public ShoppingCart() {
		itemsOrdered = new ArrayList();
	}
	public List getItemsOrdered() {
		return(itemsOrdered);
	}
	public synchronized void addItem(String itemID) {
		ItemOrder order;
		for(int i=0; i<itemsOrdered.size(); i++) {
			order = (ItemOrder)itemsOrdered.get(i);
			if (order.getItemID().equals(itemID)) {
				order.incrementNumItems();
			return;
			}
		}
		
		ItemOrder newOrder = new ItemOrder(ItemCatalog.getItem(itemID));
		itemsOrdered.add(newOrder);
	}
	public synchronized void setNumOrdered(String itemID,
	int numOrdered) {
		ItemOrder order;
		for(int i=0; i<itemsOrdered.size(); i++) {
			order = (ItemOrder)itemsOrdered.get(i);
			if (order.getItemID().equals(itemID)) {
				if (numOrdered <= 0) {
					itemsOrdered.remove(i);
				} else {
					order.setNumItems(numOrdered);
				}
				return;
			}
		}
		ItemOrder newOrder =
		new ItemOrder(ItemCatalog.getItem(itemID));
		itemsOrdered.add(newOrder);
	}

}