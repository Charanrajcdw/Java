package dao;

import java.util.Collection;
import dto.ItemDTO;

abstract public class ItemDAO {
	public abstract ItemDTO findByItemNo(int itemNo);
	public abstract Collection<ItemDTO> findAll();
	public abstract int updateItem(ItemDTO itemdto);
	public abstract int deleteItemByItemNo(int itemNo);
}
