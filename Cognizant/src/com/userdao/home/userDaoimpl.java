package com.userdao.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






public class userDaoimpl implements UserDao {
	
	Connection con = null;
	PreparedStatement pst = null;
	int rs = 0;
	

	@Override
	public  void viewuser() {
		
	
		con = JDBCconnection.getConnection();
		String query = "select * from course";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				int a=rs.getInt(1);
				String s=rs.getString(2);
				System.out.println(a+"       "+s);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
		/*public static void main(String [] args)
		{
			UserDao p = new userDaoimpl();
            p.viewuser();
		
		}*/
		
	}
	
	
	
	



