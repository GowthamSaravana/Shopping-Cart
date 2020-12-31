package com.dao;

import java.util.List;

import com.model.Customer;
import com.model.Item;

public interface ItemDAO {

	Item findByItemno(int item_no);
	 
    void saveItem(Item item);
     
    List<Item> findAllItems();
    
    void deleteItem(Integer id);
    
    void update(Item c);
}
