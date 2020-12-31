package com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity(name = "item")
@Table(name = "item")
public class Item implements Serializable{

	private Integer itemno;
	private String itemdesc;
	private String unit;
	private Integer price;
	private String category;
	 private byte[] image;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_NO")
	public Integer getItemno() {
		return itemno;
	}
	public void setItemno(Integer itemno) {
		this.itemno = itemno;
	}
	@Column(name = "ITEM_DESC")
	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	@Column(name = "UNIT")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "PRICE", nullable = false)
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Column(name = "CATEGORY")
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Item [itemno=" + itemno + ", itemdesc=" + itemdesc + ", unit=" + unit + ", price=" + price
				+ ", category=" + category + "]";
	}
	 @Lob
	 @Column(name="IMAGE", nullable=false, columnDefinition="LONGBLOB")
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}
