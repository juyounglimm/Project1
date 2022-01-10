package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TeacherDAO {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/project"; 
	String userid="root";
	String passwd="1234";
	Connection conn=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	TeacherDAO(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//드라이버로딩
	}
	
	public ArrayList<TeacherDTO> select(){
		ArrayList<TeacherDTO> list=new ArrayList<TeacherDTO>();//객체생성
		
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(url, userid, passwd);
			String query="select * from teacher";
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TeacherDTO tdto=new TeacherDTO();//객체생성
				tdto.setTeacherID(rs.getInt("teacherID"));
				tdto.setTeachername(rs.getString("teachername"));
				tdto.setTeachernumber(rs.getString("teachernumber"));
				tdto.setTeachersubject(rs.getString("teachersubject"));
				tdto.setTeacherclass(rs.getString("teacherclass"));
				list.add(tdto);
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { //데이터베이스 자원은 반드시 닫아주어야한다.
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return list;
	}//select의 끝

		
	//중복체크
			String teachernumber;
			int cnt=0;
			boolean result=true;
			public boolean checknum(String teachernum) {
				Connection conn=null;
				PreparedStatement pstmt=null;
				
				try {
					conn=DriverManager.getConnection(url, userid, passwd);
					String query="select * from teacher where teachernumber=?";
					pstmt=conn.prepareStatement(query);
					pstmt.setString(1, teachernum);
					rs=pstmt.executeQuery();
					
					while(rs.next()) {
					
						cnt++; //같은번호 있으면 cnt값 추가
				
						}
					if(cnt==1) {
					JOptionPane.showMessageDialog(null, "중복된 전화번호입니다.");
					
					result=false;
					}
					
			
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					try {
						pstmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
				}
				return result;
			}
			
	
	
	//delete
	public void delete(int teacherID) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(url, userid, passwd);
			String query="delete from teacher where teacherID=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, teacherID);
			int n=pstmt.executeUpdate();
			if(n==1) System.out.println("삭제완료");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
	}//delete 끝
	
	public void insert(String teachername, String teachernumber, String teachersubject, String teacherclass) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(url, userid, passwd);
			String query="insert into teacher(teachername,teachernumber,teachersubject,teacherclass) values(?,?,?,?)";
			
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, teachername);
			pstmt.setString(2, teachernumber);
			pstmt.setString(3, teachersubject);
			pstmt.setString(4, teacherclass);
			
			
			
			int n=pstmt.executeUpdate();
			if(n==1) { System.out.println("insert success");JOptionPane.showMessageDialog(null, "입력완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//insert끝
	
	//수정
	public void updatechanget(String teachername, String teachernumber, String teachersubject, String teacherclass) {
			
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(url, userid, passwd);
			String query="update teacher set teachernumber=?,teachersubject=?,teacherclass=? where teachername=?";
			pstmt=conn.prepareStatement(query);
			
			
			pstmt.setString(1, teachernumber);
			pstmt.setString(2, teachersubject);
			pstmt.setString(3,teacherclass);
			pstmt.setString(4, teachername);
		
		
			int n=pstmt.executeUpdate();
			if(n==1) System.out.println("updatechange success");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}//update끝 수정
	
	public ArrayList<TeacherDTO> search(String column, String item){
		ArrayList<TeacherDTO> list=new ArrayList<TeacherDTO>();//객체생성
		
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(url, userid, passwd);
			switch(column) {
			case "teachername": String query="select * from teacher where teachername=?"; pstmt=conn.prepareStatement(query); break;
			case "teachernumber": query="select * from teacher where teachernumber=?";pstmt=conn.prepareStatement(query); break;
			case "teachersubject": query="select * from teacher where teachersubject=?";pstmt=conn.prepareStatement(query); break;
			case "teacherclass": query="select * from teacher where teacherclass=?";pstmt=conn.prepareStatement(query); break;
			}
			stmt=conn.createStatement();
			pstmt.setString(1, item);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				TeacherDTO dto=new TeacherDTO();//객체생성
				dto.setTeacherID(rs.getInt("teacherID"));
				dto.setTeachername(rs.getString("teachername"));
				dto.setTeachernumber(rs.getString("teachernumber"));
				dto.setTeachersubject(rs.getString("teachersubject"));
				dto.setTeacherclass(rs.getString("teacherclass"));
				list.add(dto);
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { //데이터베이스 자원은 반드시 닫아주어야한다.
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return list;
	}//select의 끝
	
}
