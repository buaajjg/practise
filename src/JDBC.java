import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBC jd= new JDBC();
		Connection conn=jd.getConnection();
	//git test for merge	
		//git test
		//
		//hualallala  9898
		System.out.println(conn);
		String sql="select * from student";
		try {
			Statement stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			ResultSetMetaData meta=rs.getMetaData();
			int count= meta.getColumnCount();
			for(int i=1;i<=count;i++){
				System.out.print(meta.getColumnName(i)+'\t');
				System.out.print(meta.getColumnLabel(i)+'\t');
				System.out.print(meta.getColumnTypeName(i)+'\t');
				System.out.print(meta.getTableName(i)+'\t');
				System.out.println();
			}
			System.out.println();
			//System.out.println("FetchSize:" + rs.getFetchSize());
			while(rs.next()){
				int id=rs.getInt(1);
				String name= rs.getString(2);
				int gender=rs.getInt(3);
				int hometown=rs.getInt(4);
				int stucla=rs.getInt(5);
				System.out.println(id+ "     " + name+'\t' + gender + '\t'+ hometown+ '\t' +stucla );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		jd.closeConnection(conn);
		}


	}
	public Connection getConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//com.microsoft.sqlserver.jdbc.SQLServerDriver    com.mysql.jdbc.Driver
			return DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=testbase", 
					"sa", "123456");
			//jdbc:sqlserver://localhost:1433; DatabaseName=UniversityDB   "jdbc:mysql://localhost:3306/test_db"
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void closeConnection(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
