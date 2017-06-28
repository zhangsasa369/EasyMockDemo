/*
 * Created on 2007-8-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.easymock.demo.testcase;

import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.demo.matcher.SQLEquals.sqlEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.easymock.demo.domain.DBUtility;
import org.easymock.demo.domain.SalesOrder;
import org.easymock.demo.domain.SalesOrderImpl;

/**
 * @author
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class SalesOrderTestCase extends TestCase {
	
	public void testSalesOrder() {

		IMocksControl control = EasyMock.createControl();
		
		DBUtility mockDBUtility = control.createMock(DBUtility.class);
		Connection mockConnection = control.createMock(Connection.class);
		Statement mockStatement = control.createMock(Statement.class);
		ResultSet mockResultSet = control.createMock(ResultSet.class);

		try {
			mockDBUtility.getConnection();
			EasyMock.expectLastCall().andStubReturn(mockConnection);

			mockConnection.createStatement();
			expectLastCall().andStubReturn(mockStatement);

			mockStatement.executeQuery(sqlEquals("SELECT * FROM sales_order_table"));
			expectLastCall().andStubReturn(mockResultSet);

			mockResultSet.next();
			expectLastCall().andReturn(true).times(3);
			expectLastCall().andReturn(false).times(1);

			mockResultSet.getString(1);
			expectLastCall().andReturn("DEMO_ORDER_001").times(1);
			expectLastCall().andReturn("DEMO_ORDER_002").times(1);
			expectLastCall().andReturn("DEMO_ORDER_003").times(1);

			mockResultSet.getString(2);
			expectLastCall().andReturn("Asia Pacific").times(1);
			expectLastCall().andReturn("Europe").times(1);
			expectLastCall().andReturn("America").times(1);

			mockResultSet.getDouble(3);
			expectLastCall().andReturn(350.0).times(1);
			expectLastCall().andReturn(1350.0).times(1);
			expectLastCall().andReturn(5350.0).times(1);

			control.replay();
			
			Connection conn = mockDBUtility.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from sales_order_table");

			int i = 0;
			String[] priceLevels = { "Level_A", "Level_C", "Level_E" };
			while (rs.next()) {
				SalesOrder order = new SalesOrderImpl();
				order.loadDataFromDB(rs);
				assertEquals(order.getPriceLevel(), priceLevels[i]);
				i++;
			}
			
			control.verify();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
