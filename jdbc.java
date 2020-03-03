package databasedemo;

		// TODO Auto-generated method stub
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLSyntaxErrorException;

public class testjdbc {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/dbdemo";
		String username="root";
		String password="pranamam@NSS15";
	
		//String sql3="select * from emp;";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection(url,username,password);
Statement st=con.createStatement();


String sql1="create table emp(emp_id smallint not null primary key,emp_name varchar(30));";
String sql2="insert into emp values('1','indu');";
String sql4="insert into emp values('2','neethu');";
String sql5="insert into emp values('3','subin');";
String sql6="delete from emp where emp_id=1;";

String query="select * from emp where emp_id=? and emp_name=?";
PreparedStatement ps=con.prepareStatement(query);
ps.setString(2, "npk");
ps.setInt(1, 2);
ResultSet rs=ps.executeQuery();
if(rs.next()){
	System.out.println("success");
	//System.out.println(rs.getInt("emp_id")+" "+rs.getString("emp_name"));
}

//ResultSet rs=st.executeQuery("select * from emp;");
//while(rs.next()){
	//System.out.println(rs.getInt(1)+" "+rs.getString(2));
	//System.out.println(rs.getInt("emp_id")+" "+rs.getString("emp_name"));
//}
/*int res=st.executeUpdate(sql4);
System.out.println("rows inserted");

if(res>=1){
	System.out.println("success");
}
else{
	System.out.println("sorry..not inserted");
}
*/
//st.executeUpdate(sql1);
//System.out.println("TABLE CREATED");
//st.executeUpdate(sql2);
//st.executeUpdate(sql4);
//st.executeUpdate(sql5);
//System.out.println("vaues inserted");
//st.executeUpdate(sql6);
//System.out.println("row1 deleted");
//st.executeUpdate(sql3);
//System.out.println("displayed the table");




st.close();
con.close();
	}

}
