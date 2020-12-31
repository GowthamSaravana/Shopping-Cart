package com.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Item;

public class Order {

   private LocalDate dateCreated;

    private int[] quantity;
    
    private int[] itemno;
    
    
    




	public int[] getQuantity() {
		return quantity;
	}


	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}


	public int[] getItemno() {
		return itemno;
	}


	public void setItemno(int[] itemno) {
		this.itemno = itemno;
	}


	private List<OrderProduct> orderProducts = new ArrayList<>();

   
   

    
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }


	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	

	

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}


	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
    

}
