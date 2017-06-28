/*
 * Created on 2007-8-8
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.easymock.demo.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface DBUtility
{
	public abstract Connection getConnection();
	
	public abstract void closeDBResource(Connection conn);
	
	public abstract void closeDBResource(Statement stmt);
	
	public abstract void closeDBResource(ResultSet rs);
}
