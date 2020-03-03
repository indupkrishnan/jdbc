package databasedemo;



// TODO Auto-generated method stub
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.SQLSyntaxErrorException;

public class metadata {

public static void main(String[] args)throws Exception {
// TODO Auto-generated method stub
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
String url="jdbc:mysql://localhost:3306/dbdemo";
String username="root";
String password="pranamam@NSS15";
try{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection(url,username,password);
//Statement st=con.createStatement();

String query="select * from emp where emp_id=? and emp_name=?";
ps=con.prepareStatement(query);
ps.setString(2, "subin");
ps.setInt(1, 3);
rs=ps.executeQuery();
if(rs.next()){
System.out.println(rs.getInt(1)+" "+rs.getString(2));
//System.out.println(rs.getInt("emp_id")+" "+rs.getString("emp_name"));
}
else{
	System.out.println("unsuccessful");
}


ResultSetMetaData rsmd= (ResultSetMetaData) rs.getMetaData();
System.out.println(rsmd.getColumnCount());
System.out.println(rsmd.getColumnName(1));
System.out.println(rsmd.getColumnTypeName(1));
}
catch(SQLException e){
	e.printStackTrace();
}


finally{
	try{
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close();
		
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}

}

}
