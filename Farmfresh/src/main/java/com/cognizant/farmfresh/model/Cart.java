package com.cognizant.farmfresh.model;

public class Cart {
	 private int userId;
	 private int farmerId;
	 private int menuitemId;
	 private float total;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public int getMenuitemId() {
		return menuitemId;
	}
	public void setMenuitemId(int menuitemId) {
		this.menuitemId = menuitemId;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + farmerId;
		result = prime * result + menuitemId;
		result = prime * result + Float.floatToIntBits(total);
		result = prime * result + userId;
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
		Cart other = (Cart) obj;
		if (farmerId != other.farmerId)
			return false;
		if (menuitemId != other.menuitemId)
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", farmerId=" + farmerId + ", menuitemId=" + menuitemId + ", total=" + total
				+ "]";
	}
	
	 
}