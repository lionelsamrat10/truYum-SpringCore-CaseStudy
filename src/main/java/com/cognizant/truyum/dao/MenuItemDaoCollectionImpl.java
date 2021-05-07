package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

//@Resource(name = "MenuItemDaoImpl")
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerMenuItemList = new ArrayList<MenuItem>();

		for (int i = 0; i < menuItemList.size(); i++) {
			MenuItem menuItem = menuItemList.get(i);
			if ((menuItem.getDateOfLaunch().equals(new Date()) || menuItem.getDateOfLaunch().before(new Date()))
					&& menuItem.isActive()) {
				customerMenuItemList.add(menuItem);
			}
		}

		return customerMenuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).equals(menuItem)) {
				menuItemList.set(i, menuItem);
				break;
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		return menuItem;
	}

}
