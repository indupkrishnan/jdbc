package databasedemo;




//TODO Auto-generated method stub
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLSyntaxErrorException;

public class commit {

public static void main(String[] args)throws Exception {
//TODO Auto-generated method stub
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
String url="jdbc:mysql://localhost:3306/dbdemo";
String username="root";
String password="pranamam@NSS15";
try{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection(url,username,password);


con.setAutoCommit(false);


String s1="insert into emp values('122','induu');";
String s2="insert into emp values('123','neethuuu');";
String s3="insert into emp values('121','anu');";
long starttime=System.currentTimeMillis();
Statement st=con.createStatement();
st.addBatch(s1);
st.addBatch(s2);
st.addBatch(s3);
st.executeBatch();
long endtime=System.currentTimeMillis();
System.out.println("addedbatch time");
System.out.println(endtime-starttime);
con.commit();
System.out.println("successful...connection committed....");
}
catch(SQLException e){
	e.printStackTrace();
	System.out.println("some exception occured........");
}
try{

	if(con!=null)
		con.rollback();
}catch(SQLException e){
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
