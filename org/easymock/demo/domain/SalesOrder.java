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
public interface SalesOrder
{
	public String getOrderNumber();
	
	public String getRegion();
	
	public double getTotalPrice();
	
	public void setOrderNumber(String orderNumber);
	
	public void setRegion(String region);
	
	public void setTotalPrice(double totalPrice);
	
	public void loadDataFromDB(ResultSet resultSet) throws SQLException;
	
	public String getPriceLevel();
	
	public String toString();

}
