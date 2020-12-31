package com.service;

import java.util.List;

import com.model.Item;

public interface ItemService {

	Item findById(int id);
    
    void saveItem(Item item);
     
    void updateItem(Item item);
    
    void deleteItem(Integer id);
     
    //void deleteEmployeeBySsn(String ssn);
 
    List<Item> findAllItems(); 
     
     Item  findItembyCategory(String category);
 
    //boolean isEmployeeSsnUnique(Integer id, String ssn);
}
