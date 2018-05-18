package java180518;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java180518.Member;

public class MemberDAO {
	
	public void insert(Member mem) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.데이터배이스와 연결 Connection 객체 얻기
			con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 준비하기
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mem.getName());
			psmt.setInt(2, mem.getAge());
			psmt.setString(3, mem.getTel());
			psmt.setString(4, mem.getMemnum());
			
			//4.실행하기
			int num=psmt.executeUpdate();
			System.out.println(num);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을수없습니다");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL실행중 문제가 발생");
			e.printStackTrace();
		} finally {
			//5.연결끊기
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Member selectOne(String memnum) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs=null;
		Member m=null;
			

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2.데이터배이스와 연결 Connection 객체 얻기
			con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 준비하기
			String sql = "SELECT * FROM MEMBER WHERE MEMNUM=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, memnum);
			
			
			//4.실행하기
			rs=psmt.executeQuery();
			
			
			//5.ResultSet 객체에서 데이터 꺼내오기
			rs.next();
			String name=rs.getString(1);
			int age=rs.getInt(2);
			String tel=rs.getString(3);
			String memnum2=rs.getString(4);
				
			m=new Member(name, age, tel, memnum2);
				
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을수없습니다");
				e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL실행중 문제가 발생");
			e.printStackTrace();
		} finally {
			//5.연결끊기
			try {
				if(rs !=null)rs.close();
				if(psmt !=null)psmt.close();
				if(con !=null)con.close();
				} catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}

	public Member MemberUpdate(String name, int age, String tel,String memnum) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.데이터배이스와 연결 Connection 객체 얻기
			con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 준비하기
			String sql = "UPDATE MEMBER SET NAME=?,AGE=?,TEL=? WHERE MEMNUM=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, age);
			psmt.setString(3, tel);
			psmt.setString(4, memnum);
			
			//4.실행하기
			int num=psmt.executeUpdate();
			System.out.println(num);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을수없습니다");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL실행중 문제가 발생");
			e.printStackTrace();
		} finally {
			//5.연결끊기
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public Member MemberDelete(String memnum) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.데이터배이스와 연결 Connection 객체 얻기
			con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 준비하기
			String sql = "DELETE FROM MEMBER WHERE MEMNUM=?"; 
			psmt = con.prepareStatement(sql);
			psmt.setString(1,memnum);
			
			//4.실행하기
			int num=psmt.executeUpdate();
			System.out.println(num);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을수없습니다");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL실행중 문제가 발생");
			e.printStackTrace();
		} finally {
			//5.연결끊기
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
}
}
