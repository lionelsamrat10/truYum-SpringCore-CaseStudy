package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	private MenuItemDao menuItemDao;

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemDao.getMenuItemListAdmin();
	}

	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();
	}

	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
	}

	public MenuItem getMenuItem(long menuItemId) {
		return menuItemDao.getMenuItem(menuItemId);
	}
}
