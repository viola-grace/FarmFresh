package com.cognizant.farmfresh.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class MenuItem {
	@NotEmpty(message = "Name may not be empty")
	@Length(min = 2, max = 65,message="Name must be of length min 2 and max 65")
	private String farmerName;
	private long id;
	@NotEmpty(message = "Fill item")
	@Length(min = 2, max = 65,message = "Name may not be blank")
	private String itemName;
	@NotNull(message = "Fill price")
	@Min(value=1,message="Price must be greater than 1")
	private float price;
	@NotNull(message = "Stock may not be empty")
	@Min(value=(long) 0.5,message="Stock must be greater than 1")
	private float stock;
	@NotNull(message = "Quantity may not be empty")
	private float quantity;
	@NotEmpty(message = "Fill location")
	@Length(min = 2, max = 65,message="Name must be of length min 2 and max 65")
	private String location;
	@NotEmpty(message = "Category may not be empty")
	private String Category;
	
	
	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}
	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public MenuItem() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuItem [farmerName=" + farmerName + ", id=" + id + ", itemName=" + itemName + ", price=" + price
				+ ", stock=" + stock + ", quantity=" + quantity + ", location=" + location + ", Category=" + Category
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Category == null) ? 0 : Category.hashCode());
		result = prime * result + ((farmerName == null) ? 0 : farmerName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + Float.floatToIntBits(quantity);
		result = prime * result + Float.floatToIntBits(stock);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (Category == null) {
			if (other.Category != null)
				return false;
		} else if (!Category.equals(other.Category))
			return false;
		if (farmerName == null) {
			if (other.farmerName != null)
				return false;
		} else if (!farmerName.equals(other.farmerName))
			return false;
		if (id != other.id)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (Float.floatToIntBits(quantity) != Float.floatToIntBits(other.quantity))
			return false;
		if (Float.floatToIntBits(stock) != Float.floatToIntBits(other.stock))
			return false;
		return true;
	}

}