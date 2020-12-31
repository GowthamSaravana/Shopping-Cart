package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ItemDAO;
import com.model.Item;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDAO dao;
	
	@Override
	public Item findById(int id) {
		return dao.findByItemno(id);
	}

	@Override
	public void saveItem(Item item) {
		dao.saveItem(item);
		
	}

	@Override
	public void updateItem(Item item) {
		dao.update(item);
		
	}

	@Override
	public List<Item> findAllItems() {
		return dao.findAllItems();
	}

	@Override
	public Item findItembyCategory(String category) {
		return null;
	}

	@Override
	public void deleteItem(Integer id) {
		dao.deleteItem(id);
		
	}

}
