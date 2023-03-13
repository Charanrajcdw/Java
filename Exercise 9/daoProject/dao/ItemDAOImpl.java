package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import db.DBUtility;
import dto.ItemDTO;

public class ItemDAOImpl extends ItemDAO implements Cloneable {
	private static ItemDAOImpl itemdao;

	private ItemDAOImpl() {
	}

	public static ItemDAOImpl getItemDAOImpl() {
		if (itemdao == null) {
			itemdao = new ItemDAOImpl();
			return itemdao;
		} else {
			return itemdao.createClone();
		}
	}

	private ItemDAOImpl createClone() {
		if (itemdao != null) {
			try {
				return (ItemDAOImpl) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemDTO findByItemNo(int itemNo) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from item_master where itemNo=?");
			ps.setInt(1, itemNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ItemDTO itemdto = new ItemDTO();
				itemdto.setItemNo(itemNo);
				itemdto.setItemDescription(rs.getString("itemDescription"));
				itemdto.setItemPrice(rs.getInt("itemPrice"));
				itemdto.setItemUnit(rs.getString("itemUnit"));
				return itemdto;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Collection<ItemDTO> findAll() {
		try {
			Connection conn = DBUtility.getConnection();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from item_master");
			List<ItemDTO> items = new ArrayList<ItemDTO>();
			while (rs.next()) {
				ItemDTO itemdto = new ItemDTO();
				itemdto.setItemNo(rs.getInt("itemNo"));
				itemdto.setItemDescription(rs.getString("itemDescription"));
				itemdto.setItemPrice(rs.getInt("itemPrice"));
				itemdto.setItemUnit(rs.getString("itemUnit"));
				items.add(itemdto);
			}
			return items;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateItem(ItemDTO itemdto) {
		try {
			Connection conn = DBUtility.getConnection();
			int itemNo = itemdto.getItemNo();
			PreparedStatement ps = conn.prepareStatement("select * from item_master where itemNo=?");
			ps.setInt(1, itemNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ps = conn.prepareStatement(
						"update item_master set itemDescription=?,itemPrice=?,itemUnit=? where itemNo=?");
				ps.setString(1, itemdto.getItemDescription());
				ps.setInt(2, itemdto.getItemPrice());
				ps.setString(3, itemdto.getItemUnit());
				ps.setInt(4, itemdto.getItemNo());
				int n = ps.executeUpdate();
				DBUtility.closeConnection(null);
				return n;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteItemByItemNo(int itemNo) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from item_master where itemNo=?");
			ps.setInt(1, itemNo);
			int n = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}
}
