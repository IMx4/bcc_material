package com.bcc.mm.dto;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
//@Table(name="inventory")
public class ProductDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String category;
	private String date;
    private String description;
    private String length;
    private int qty;   
    private String thick;
    private String width;
    private boolean stockControl;
    private int stockControlMin;
    
   
    
    public ProductDTO(){
    	
    }

    ProductDTO(String desc, String l, String w, String t, int qty, String cat){

        description = desc;
        length = l;
        width = w;
        thick = t;
        this.qty = qty;
        category = cat;
    }

    ProductDTO(int id, String desc, String l, String w, String t, int qty, String date, String cat){

        this.id = id;
        description = desc;
        length = l;
        width = w;
        thick = t;
        this.qty = qty;
        this.date = date;
        category = cat;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
    	
        return date;
    }
    
    public void setDate() {
        
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	this.date = dateFormat.format(date);
    	
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
    		
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getThick() {
        return thick;
    }

    public void setThick(String thick) {
    	
        this.thick = thick;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

	public boolean isStockControl() {
		return stockControl;
	}

	public void setStockControl(boolean stockControl) {
		this.stockControl = stockControl;
	}

	public int getStockControlMin() {
		return stockControlMin;
	}

	public void setStockControlMin(int stockControlMin) {
		this.stockControlMin = stockControlMin;
	}

}
