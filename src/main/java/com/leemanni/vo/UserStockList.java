package com.leemanni.vo;

import java.util.ArrayList;

public class UserStockList {
	private ArrayList<UserStockVO> stockList = new ArrayList<UserStockVO>();
	private int totalAsset;
	private int p_totalAsset;
	private float totalRatio;
	
	public UserStockList() {}
	
	
	
	public UserStockList(ArrayList<UserStockVO> stockList) {
		this.stockList = stockList;
		calculate(stockList);
	}



	public void setStockList(ArrayList<UserStockVO> stockList) {
		this.stockList = stockList;
	}
	
	public int getTotalAsset() {
		return totalAsset;
	}

	public void setTotalAsset(int totalAsset) {
		this.totalAsset = totalAsset;
	}

	public float getTotalRatio() {
		return totalRatio;
	}

	public void setTotalRatio(float totalRatio) {
		this.totalRatio = totalRatio;
	}
	
	
	private void calculate(ArrayList<UserStockVO> stockList) {
		for (UserStockVO vo : stockList) {
			totalAsset += vo.getTotalPrice();
			p_totalAsset += vo.getP_totalPrice();
			
		}
		totalRatio = (float)(totalAsset- p_totalAsset) / p_totalAsset;
	}



	@Override
	public String toString() {
		return "UserStockList [stockList=" + stockList + ", totalAsset=" + totalAsset + ", p_totalAsset=" + p_totalAsset
				+ ", totalRatio=" + totalRatio + "]";
	}
	
	
}
