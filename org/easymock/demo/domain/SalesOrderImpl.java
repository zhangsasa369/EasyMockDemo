/*
 * Created on 2007-8-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.easymock.demo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SalesOrderImpl implements SalesOrder
{
	
	private String orderNumber;
	private String region;
	private double totalPrice;
	

	/* (non-Javadoc)
	 * @see xmleasymock.demo.test.SalesOrder#getSalesOrderNumber()
	 */
	public String getOrderNumber()
	{
		return orderNumber;
	}

	/* (non-Javadoc)
	 * @see xmleasymock.demo.test.SalesOrder#getSalesRepID()
	 */
	public String getRegion()
	{
		return region;
	}

	/* (non-Javadoc)
	 * @see xmleasymock.demo.test.SalesOrder#getTotalPrice()
	 */
	public double getTotalPrice()
	{
		return totalPrice;
	}

	/* (non-Javadoc)
	 * @see xmleasymock.demo.test.SalesOrder#setSalesOrderNumber(java.lang.String)
	 */
	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	/* (non-Javadoc)
	 * @see xmleasymock.demo.test.SalesOrder#setSalesRepID(java.lang.String)
	 */
	public void setRegion(String region)
	{
		this.region = region;
	}

	/* (non-Javadoc)
	 * @see xmleasymock.demo.test.SalesOrder#setTotalPrice(double)
	 */
	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	/* (non-Javadoc)
	 * @see xmleasymock.demo.test.SalesOrder#loadDataFromDB(java.sql.ResultSet)
	 */
	public void loadDataFromDB(ResultSet resultSet) throws SQLException
	{
		orderNumber = resultSet.getString(1);
		region = resultSet.getString(2);
		totalPrice = resultSet.getDouble(3);
	}
	/* (non-Javadoc)
	 * @see xmleasymock.demo.test.SalesOrder#getPriceLevel()
	 */
	public String getPriceLevel()
	{
		double totalPrice = this.getTotalPrice();
		double totalPoints = 0.0;
		
		if ("Africa".equalsIgnoreCase(this.getRegion()))
			totalPoints = totalPrice;
		else if ("Asia Pacific".equalsIgnoreCase(this.getRegion()))
			totalPoints = totalPrice * 0.9;
		else if ("Europe".equalsIgnoreCase(this.getRegion()))
			totalPoints = totalPrice * 0.85;
		else if ("America".equalsIgnoreCase(this.getRegion()))
			totalPoints = totalPrice * 0.8;
		else
			totalPoints = totalPrice * 0.75;
		
		if (totalPoints < 500)
			return "Level_A";
		else if (totalPoints < 1000)
			return "Level_B";
		else if (totalPoints < 2000)
			return "Level_C";
		else if (totalPoints < 4000)
			return "Level_D";
		else
			return "Level_E";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("orderNumber = "+orderNumber+"\n");
		sb.append("region = "+region+"\n");
		sb.append("totalPrice = "+totalPrice+"\n");
		sb.append("priceLevel = "+this.getPriceLevel()+"\n");
		return sb.toString();
	}
}
