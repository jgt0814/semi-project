package com.kh.menu.model.vo;

public class Menu {
//	
//	MENU_NO	NUMBER
//	MENU_NAME	VARCHAR2(90 BYTE)
//	MENU_PRICE	NUMBER
//	MENU_CATEGORY	VARCHAR2(90 BYTE)
//	STORE_NO	NUMBER

    private int menuNo;
    private String menuName;
    private int menuPrice;
    private String menuCategory;
    private int storeNo;

    public Menu() {
    }

	public Menu(int menuNo, String menuName, int menuPrice, String menuCategory, int storeNo) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCategory = menuCategory;
		this.storeNo = storeNo;
	}
	
	public Menu(int menuNo, String menuName, int menuPrice) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuCategory="
				+ menuCategory + ", storeNo=" + storeNo + "]";
	}

}
