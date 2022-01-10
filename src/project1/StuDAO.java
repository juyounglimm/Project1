package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StuDAO {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/project"; 
	String userid="root";
	String passwd="1234";
	Connection conn=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	JPanel panel_addinfo;

	StuDAO(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//드라이버로딩
	}
	
	//회원정보 보기
		public ArrayList<StuDTO> select(){
			ArrayList<StuDTO> list=new ArrayList<StuDTO>();
			
			Connection conn=null;
			Statement stmt=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				conn=DriverManager.getConnection(url, userid, passwd);
				String query="select s.studentID,s.studentname,s.studentnumber,s.studentSchool,s.studentaddr,s.studentclass,r.korscore,r.mathscore,r.engscore,r.historyscore,r.avgg,t.teachername from student s  left outer join report1 r on s.studentname=r.studentname and s.studentID=r.studentID left outer join teacher t on s.studentclass=t.teacherclass";
				pstmt=conn.prepareStatement(query);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					StuDTO dto=new StuDTO();
					dto.setStudentID(rs.getInt("studentID"));
					dto.setStudentname(rs.getString("studentname"));
					dto.setStudentnumber(rs.getString("studentnumber"));
					dto.setStudentschool(rs.getString("studentSchool"));
					dto.setStudentaddr(rs.getString("studentaddr"));
					dto.setStudentclass(rs.getString("studentclass"));
					dto.setKorscore(rs.getInt("korscore"));
					dto.setMathscore(rs.getInt("mathscore"));
					dto.setEngscore(rs.getInt("engscore"));
					dto.setHistoryscore(rs.getInt("historyscore"));
					dto.setAvgg(rs.getDouble("avgg"));
					dto.setTeachername(rs.getString("teachername"));
					
					list.add(dto);
				
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try { 
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
		String studentnumber;
		int cnt=0;
		boolean result=true;
		public boolean checknum(String stunum) {
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			
			try {
				conn=DriverManager.getConnection(url, userid, passwd);
				String query="select * from student where studentnumber=?";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, stunum);
				rs=pstmt.executeQuery();
			
				while(rs.next()) {
				
					cnt++;
			
					}
				if(stunum.length()!=11) {
					JOptionPane.showMessageDialog(null, "전화번호형식이 잘못되었습니다.");
					result=false;
				}
				
				else if(cnt==1) {
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
		
	
		
		//삭제 학생번호로 삭제내용정함
		public void delete(int studentID) {
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn=DriverManager.getConnection(url, userid, passwd);
				String query="delete from student where studentID=?";
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1,studentID);
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
		
		//학생정보삽입
		public void insertstu(String studentname, String studentnumber, String studentSchool, String studentaddr, String stuclass) {
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn=DriverManager.getConnection(url, userid, passwd);
				String query="insert into student(studentname,studentnumber,studentSchool,studentaddr,studentclass) values(?,?,?,?,?)";
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, studentname);
				pstmt.setString(2, studentnumber);
				pstmt.setString(3, studentSchool);
				pstmt.setString(4, studentaddr);
				pstmt.setString(5, stuclass);
				
				int n=pstmt.executeUpdate();
				if(n==1) System.out.println("insert success");
			
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
		
		//점수테이블 삽입
		public void insertscore(String studentname,String korscore,String mathscore,String engscore, String historyscore,String avgg) {
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn=DriverManager.getConnection(url, userid, passwd);
				String query="insert into report1(studentname,korscore,mathscore,engscore,historyscore,avgg) values(?,?,?,?,?,?)";
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, studentname);
				pstmt.setInt(2, Integer.parseInt(korscore));
				pstmt.setInt(3, Integer.parseInt(mathscore));
				pstmt.setInt(4, Integer.parseInt(engscore));
				pstmt.setInt(5, Integer.parseInt(historyscore));
				pstmt.setDouble(6,Double.parseDouble(avgg));
				
				
				int n=pstmt.executeUpdate();
				if(n==1) {JOptionPane.showMessageDialog(null, "입력완료");
				System.out.println("insert success"); 
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}//end
		
		//수정
		public void updatechangestu(int studentID,String studentname, String studentnumber, String studentSchool, String studentaddr,
				String studentclass) {
				
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn=DriverManager.getConnection(url, userid, passwd);
				String query="update student set studentnumber=?,studentSchool=?,studentaddr=?,studentclass=? where studentID=?";
				pstmt=conn.prepareStatement(query);
				
				pstmt.setString(1, studentnumber);
				pstmt.setString(2, studentSchool);
				pstmt.setString(3, studentaddr);
				pstmt.setString(4,studentclass);
				
				pstmt.setInt(5, studentID);
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
		
		//점수부분수정
		public void updatescore(String korscore, String engscore, String mathscore, String historyscore, String avgg, int studentID) {
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn=DriverManager.getConnection(url, userid, passwd);
				String query="update report1 set korscore=?,engscore=?,mathscore=?,historyscore=?, avgg=? where studentID=? ";
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, Integer.parseInt(korscore));
				pstmt.setInt(2, Integer.parseInt(engscore));
				pstmt.setInt(3, Integer.parseInt(mathscore));
				pstmt.setInt(4, Integer.parseInt(historyscore));
				pstmt.setDouble(5,Double.parseDouble(avgg));
				pstmt.setInt(6,studentID);
				
				int n=pstmt.executeUpdate();
				if(n==1) System.out.println("updatechange success");
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//콤보밗
		public ArrayList<StuDTO> search(String column, String item){
			ArrayList<StuDTO> list=new ArrayList<StuDTO>();//객체생성
			
			Connection conn=null;
			Statement stmt=null;
			PreparedStatement pstmt=null;
			
			ResultSet rs=null;
			
			try {
				conn=DriverManager.getConnection(url, userid, passwd);
				switch(column) {
				case "studentname": String query="select  s.studentID,s.studentname,s.studentnumber,s.studentSchool,s.studentaddr,s.studentclass,r.korscore,r.mathscore,r.engscore,r.historyscore,r.avgg from student s  left outer join report1 r on s.studentID=r.studentID WHERE s.studentname=?"; pstmt=conn.prepareStatement(query); break;
				case "studentnumber": query="select s.studentID,s.studentname,s.studentnumber,s.studentSchool,s.studentaddr,s.studentclass,r.korscore,r.mathscore,r.engscore,r.historyscore,r.avgg from student s  left outer join report1 r on s.studentID=r.studentID WHERE s.studentnumber=?";pstmt=conn.prepareStatement(query); break;
				case "studentSchool": query="select s.studentID,s.studentname,s.studentnumber,s.studentSchool,s.studentaddr,s.studentclass,r.korscore,r.mathscore,r.engscore,r.historyscore,r.avgg from student s  left outer join report1 r on s.studentID=r.studentID WHERE s.studentSchool=?";pstmt=conn.prepareStatement(query); break;
				case "studentaddr": query="select  s.studentID,s.studentname,s.studentnumber,s.studentSchool,s.studentaddr,s.studentclass,r.korscore,r.mathscore,r.engscore,r.historyscore,r.avgg from student s  left outer join report1 r on s.studentID=r.studentID WHERE s.studentaddr=?";pstmt=conn.prepareStatement(query); break;
				case "studentclass": query="select  s.studentID,s.studentname,s.studentnumber,s.studentSchool,s.studentaddr,s.studentclass,r.korscore,r.mathscore,r.engscore,r.historyscore,r.avgg from student s  left outer join report1 r on s.studentID=r.studentID WHERE s.studentclass=?";pstmt=conn.prepareStatement(query); break;
				}
				stmt=conn.createStatement();
			
				pstmt.setString(1, item);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					StuDTO dto=new StuDTO();//객체생성
					dto.setStudentID(rs.getInt("studentID"));
					dto.setStudentname(rs.getString("studentname"));
					dto.setStudentnumber(rs.getString("studentnumber"));
					dto.setStudentschool(rs.getString("studentSchool"));
					dto.setStudentaddr(rs.getString("studentaddr"));
					dto.setStudentclass(rs.getString("studentclass"));
					//
					dto.setKorscore(rs.getInt("korscore"));
					dto.setMathscore(rs.getInt("mathscore"));
					dto.setEngscore(rs.getInt("engscore"));
					dto.setHistoryscore(rs.getInt("historyscore"));
					dto.setAvgg(rs.getDouble("avgg"));
					
					list.add(dto);
				
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try { 
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
			return list;
		}//select의 끝

		

		

		
		


	}
