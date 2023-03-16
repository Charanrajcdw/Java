package dto;

import java.io.Serializable;
import java.util.Objects;

public class ItemDTO implements Serializable, Comparable<ItemDTO> {
	private Integer itemNo;
	private int itemPrice;
	private String itemDescription, itemUnit;

	public ItemDTO() {
	}

	public ItemDTO(Integer itemNo, int itemPrice, String itemDescription, String itemUnit) {
		this.itemNo = itemNo;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.itemUnit = itemUnit;
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	@Override
	public int compareTo(ItemDTO o) {
		return itemNo.compareTo(o.itemNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemDescription, itemNo, itemPrice, itemUnit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDTO other = (ItemDTO) obj;
		return Objects.equals(itemDescription, other.itemDescription) && Objects.equals(itemNo, other.itemNo)
				&& itemPrice == other.itemPrice && Objects.equals(itemUnit, other.itemUnit);
	}

	@Override
	public String toString() {
		return "itemDTO [itemNo=" + itemNo + ", itemPrice=" + itemPrice + ", itemDescription=" + itemDescription
				+ ", itemUnit=" + itemUnit + "]";
	}
}
