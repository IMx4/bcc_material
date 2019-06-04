package com.bcc.mm.dto;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ProductDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private String description;
    private String length;
    private String width;
    private String thick;
    private int qty;
    private String category;
    private String date;
    private boolean stockControl;
    private int stockControlMin;


    
   
    
    public ProductDTO(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        description = "";
        length = "";
        width = "";
        thick = "";
        qty = 0;
        category = "";
        date = dateFormat.format(new java.sql.Date(System.currentTimeMillis()));
        stockControl = false;
        stockControlMin = 0;

    }

    public ProductDTO(int id, String description, String length, String width, String thick, int qty, String category, String date, boolean stockControl, int stockControlMin){

            this.id = id;
            this.description = description;
            this.length = length;
            this.width = width;
            this.thick = thick;
            this.qty = qty;
            this.category = category;
            this.date = date;
            this.stockControl = stockControl;
            this.stockControlMin = stockControlMin;


    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
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
