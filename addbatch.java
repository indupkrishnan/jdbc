package databasedemo;



//TODO Auto-generated method stub
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLSyntaxErrorException;

public class addbatch {

public static void main(String[] args)throws Exception {
//TODO Auto-generated method stub
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
String url="jdbc:mysql://localhost:3306/dbdemo";
String username="root";
String password="pranamam@NSS15";

Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection(url,username,password);
String s1="insert into emp values('9','induu');";
String s2="insert into emp values('10','neethuuu');";
String s3="insert into emp values('11','anu');";
long starttime=System.currentTimeMillis();
Statement st=con.createStatement();
st.addBatch(s1);
st.addBatch(s2);
st.addBatch(s3);
st.executeBatch();
long endtime=System.currentTimeMillis();
System.out.println("addedbatch time");
System.out.println(endtime-starttime);
st.close();
con.close();
}
}