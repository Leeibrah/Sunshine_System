package org.fleet.classes;

import java.sql.*;
import java.util.*;

import org.fleet.classes.SystemUtilities.StatusFlag;



public class Database 
{
	private Connection conn=null;
	private Statement statement=null;
	private ResultSet rs=null;
	private static String mysqlUserName=null;
	private static String mysqlPassword=null;
	private static org.fleet.classes.SystemUtilities.StatusFlag flag = StatusFlag.RESET;
	/*******************************************************************
	 * StatusFlag==RESET, default value to indicate it has been reset
	 * StatusFlag==FAILED, command failed to execute successfully
	 * StatusFlag==SUCCESSFUL, command executed successfully
	 * 
	 * The StatusFlag is reset when either
	 * 			1)Its value is read
	 * 			2)Another SQL Command is executed.
	 *******************************************************************/
	
	/**
	 * executes an SQL command and returns a result set 
	 * @return
	 * Returns a result set containing a reference to records from the database
	 * through which the record can be iterated
	 * Returns a null value if the SQL command was an Update Command e.g INSERT,DELETE or UPDATE
	 */
	public  ResultSet ExecuteCommand(String sqlCommand){
		
		try 
		{
			Database.flag=StatusFlag.RESET;			
			sqlCommand=sqlCommand.trim();
			//evaluate the type of command being parsed 
			String commandType=new StringTokenizer(sqlCommand).nextToken().toUpperCase();
			
			Class.forName("com.mysql.jdbc.Driver");
			String str="jdbc:mysql://localhost:3306/sunshine";
			conn=DriverManager.getConnection(str,"root","sqlyella");
			statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//determine if the sequel command is an update command that alters data or a one that gets/reads data
			if(commandType.equals("INSERT") || commandType.equals("UPDATE") || commandType.equals("DELETE"))
			{
				//The sequel command is an update statement,i.e,makes changes to the database
				statement.executeUpdate(sqlCommand);
				flag=StatusFlag.SUCCESS; //success
			}
			else if(commandType.equals("SELECT"))
			{
				rs=statement.executeQuery(sqlCommand);
				flag=StatusFlag.SUCCESS; //success
				return rs;
			}
			else{
				System.err.println("Allowed sql commands are INSERT,DELETE,UPDATE and SELECT only");
				flag=StatusFlag.FAILED; //failure
				throw new Exception("Invalid sql command");
			}
			return rs;
		} 
		catch (Exception ex) {
			flag=StatusFlag.FAILED;
			ex.printStackTrace();
		}
		return rs;	
		
	}
	
	public static void setPassword_and_UserName(String password,String username){
		/*
		 * sets the password and user name to MySql DBMS
		 */
		Database.mysqlPassword=password;
		Database.mysqlUserName=username;
	}
	
	/*
	 * METHOD SUMMARY AND RETURN
	 * 		Returns a flag to indicate whether an sql command executed successfully or not
	 * 		Once the method is called the flag is reset.
	 */
	public static StatusFlag getStatusFlag(){
		if(flag==StatusFlag.FAILED)
		{
			flag=StatusFlag.RESET;
			return StatusFlag.FAILED;
		}
		else if(flag==StatusFlag.SUCCESS)
		{
			flag=StatusFlag.RESET;//reset
			return StatusFlag.SUCCESS;
		}
		else			
			return flag=StatusFlag.RESET;
	}
	
	public  void CloseConnection(){ 

		try{
			//attempt to close the connection to release JDBC resources and perform garbage collection clean up
			if(conn!=null)
			{
				conn.close();
				conn=null;
			}
			if(rs != null)
			{
				rs.close();
				rs=null;
			}
			statement=null;
		 }
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}