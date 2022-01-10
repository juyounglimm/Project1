package project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.IOException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JToolBar;
//관리페이지
public class Manageprogram extends JFrame{
	JPanel panel_addinfo;
	List list;
	JPanel panel_changeinfo;
	JPanel paneltMTitle;
	JPanel paneltMScreen;
	
	Manageprogram(){
				
		setResizable(false);
		setTitle("학생관리프로그램");
		setSize(700,700);
		setResizable(false);
		setBounds(100, 100, 725, 527);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container ct= getContentPane();
		ct.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMTitle = new JPanel();
		ct.add(panelMTitle, BorderLayout.NORTH);
		
		JLabel labelMTitle = new JLabel("학생관리 프로그램");
		labelMTitle.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 43));
		panelMTitle.add(labelMTitle);
		panelMTitle.setBackground(Color.decode("#FBE1BD"));
		
		JPanel panelMScreen = new JPanel();
		ct.add(panelMScreen, BorderLayout.CENTER);
		panelMScreen.setLayout(null);
		panelMScreen.setBackground(Color.decode("#F7E6C2"));
		
		//툴바내용
		JToolBar toolBar=new JToolBar("toolbar menu");
		JComboBox<String> comboBoxfind = new JComboBox<String>();
		JButton btnclear=new JButton("clear");
		btnclear.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		
		
		JButton btnteacher=new JButton("Teacher");
		btnteacher.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		
		JLabel toollabelsearch=new JLabel("search");
		toollabelsearch.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 20));
		
		JTextField txtfind=new JTextField();
		txtfind.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		
		comboBoxfind.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		
		
		JButton toolFind=new JButton();
		toolFind.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		toolFind.setIcon(new ImageIcon("image\\find.jpg"));
		
		btnclear.setBackground(Color.decode("#FBE1BD"));
		btnteacher.setBackground(Color.decode("#FBE1BD"));
	
		txtfind.setBackground(Color.decode("#FBE1BD"));
		comboBoxfind.setBackground(Color.decode("#FBE1BD"));
		toolFind.setBackground(Color.decode("#FBE1BD"));
		
		toolBar.setMargin(new Insets(1,1,1,1));
		toolBar.setFloatable(false);
		toolBar.add(btnclear);
		toolBar.addSeparator();
		toolBar.add(btnteacher);
		toolBar.addSeparator();
		toolBar.add(toollabelsearch);
		toolBar.addSeparator();
		toolBar.add(comboBoxfind);
		toolBar.addSeparator();
		toolBar.add(txtfind);
		toolBar.addSeparator();
		toolBar.add(toolFind);
		
	

		toolBar.setBounds(0, 377, 707, 33);
		toolBar.setBackground(Color.decode("#F7E6C2"));
		comboBoxfind.addItem("학생이름");
		comboBoxfind.addItem("학생전화번호");
		comboBoxfind.addItem("출신학교");
		comboBoxfind.addItem("학생주소");
		comboBoxfind.addItem("반");
		
		
		
		list = new List();
		list.setBounds(25, 64, 652, 235);
		list.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15));
		
		
		panelMScreen.add(list);
		
	
			
		

		panelMScreen.add(toolBar);
		
		//teacher버튼 클릭
		String btnteacherpw="abcd";
		btnteacher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String passwd=JOptionPane.showInputDialog("비밀번호를 입력하세요");
					
				try{
					if(passwd.equals(btnteacherpw)) {
					new Teacherinfo();
					}
					else JOptionPane.showMessageDialog(null, "비밀번호 오류 접근불가");
				}catch(NullPointerException ne) {
					
				}
			}
		});
		//clear버튼 누르면 검색텍스트, 리스트 리셋
		btnclear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				txtfind.setText("");
				
			}
		});
		
		JButton btnSearch = new JButton();
		btnSearch.setBounds(43, 319, 105, 46);
		btnSearch.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		panelMScreen.add(btnSearch);
		btnSearch.setIcon(new ImageIcon("image\\search.jpg"));
		//조회하기 버튼 누르면 전체조회
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				displayAll();
			}
		});
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(205, 319, 105, 46);
		btnAdd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		panelMScreen.add(btnAdd);
		btnAdd.setIcon(new ImageIcon("image\\add.jpg"));
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Addstuinfo();
				displayAll();
			}
		});
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(365, 319, 105, 46);
		btnDelete.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		btnDelete.setIcon(new ImageIcon("image\\delete.jpg"));
		panelMScreen.add(btnDelete);
		
		//삭제하기 버튼누르면 누른 내용이 삭제
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			try {	//선택된항목없을때 예외처리
				String str=list.getSelectedItem();
				StringTokenizer st=new StringTokenizer(str);
				int studentID= Integer.parseInt(st.nextToken());
				StuDAO dao= new StuDAO();
				dao.delete(studentID);
				displayAll();
			}catch(NullPointerException ne) {
				JOptionPane.showMessageDialog(null, "삭제할 학생이 선택되지않았습니다.");
			}
			}
		});
		
		
				
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(535, 319, 105, 46);
		btnUpdate.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		btnUpdate.setIcon(new ImageIcon("image\\update.jpg"));
		panelMScreen.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			try {	
				String str=list.getSelectedItem();
				
				StringTokenizer st=new StringTokenizer(str);
				
				int studentIDch=Integer.parseInt(st.nextToken());
				String stunamech=st.nextToken();
				String stunumberch=st.nextToken();
				String stuschoolch=st.nextToken();
				String stuaddrch=st.nextToken();
				String stuclassch=st.nextToken();
				String korscorech=st.nextToken();
				String mathscorech=st.nextToken();
				String engscorech=st.nextToken();
				String historyscorech=st.nextToken();
				
				ChangeStuinfo chinfo=new ChangeStuinfo();
				chinfo.change(studentIDch,stunamech,stunumberch,stuschoolch,stuaddrch,stuclassch,korscorech,mathscorech,engscorech,historyscorech);
			}catch(NullPointerException ne) {
				JOptionPane.showMessageDialog(null, "수정될 학생이 선택되지않았습니다."); 
			}
			}
		});//수정버튼누르면 화면나오게
		

		
		//툴바검색버튼
		toolFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				list.removeAll(); 
				int index=comboBoxfind.getSelectedIndex();
				System.out.println(index);
				String column="";//column값 초기화
				//column값 인덱스번호로 읽어오기
				switch(index) {
				case 0: column="studentname"; break;
				case 1: column="studentnumber"; break;
				case 2: column="studentSchool"; break;
				case 3: column="studentaddr"; break;
				case 4: column="studentclass"; break;	
				}
				System.out.println(column);		//column값 잘읽어왔나 확인	
				
				System.out.println(txtfind.getText());
				String item=txtfind.getText(); //텍스트에 입력한 검색할내용 읽어오기
				StuDAO dao= new StuDAO();
				list.add("학생번호"+"            "+"학생이름"+"                             "+"학생전화번호"+"                              "+"학교이름"+"                          "+"학생주소"+"                "+"반"+"                "+"국어점수"+"                "+"수학점수"+"                "+"영어점수"+"                "+"한국사점수"+"                "+"평균");
				ArrayList<StuDTO> AllData=dao.search(column,item);
				for(StuDTO dto : AllData) {
					int studentID=dto.getStudentID();
					String studentname=dto.getStudentname();
					String studentnumber=dto.getStudentnumber();
					String studentschool=dto.getStudentschool();
					String studentaddr=dto.getStudentaddr();
					String studentclass=dto.getStudentclass();
					int korscore=dto.getKorscore();
					int mathscore=dto.getMathscore();
					int engscore=dto.getEngscore();
					int historyscore=dto.getHistoryscore();
					double avgg=dto.getAvgg();
					
					
					list.add(studentID+"                                  "+studentname+"                             "+studentnumber+"                           "+studentschool+"                       "+studentaddr+"                 "+studentclass+"                      "+korscore+"                     "+mathscore+"                             "+engscore+"                              "+historyscore+"                           "+avgg);//화면에 있는 리스트에 붙이기
				} 
				
			
			}
		});
		
		
		ct.add(panelMScreen);
		setVisible(true);
		
	}
	
	//조회
		private void displayAll() {
			list.removeAll(); 
			StuDAO dao=new StuDAO();
			
			list.add("학생번호"+"            "+"학생이름"+"                             "+"학생전화번호"+"                              "+"학교이름"+"                          "+"학생주소"+"                "+"반"+"          "+"국어성적"+"       "+"수학성적"+"        "+"영어성적"+"        "+"한국사성적"+"         "+"평균"+"         "+"교사이름");
			ArrayList<StuDTO> allData=dao.select();
			for(StuDTO dto : allData) {
				int studentID=dto.getStudentID();
				String studentname=dto.getStudentname();
				String studentnumber=dto.getStudentnumber();
				String studentschool=dto.getStudentschool();
				String studentaddr=dto.getStudentaddr();
				String studentclass=dto.getStudentclass();
				int korscore=dto.getKorscore();
				int mathscore=dto.getMathscore();
				int engscore=dto.getEngscore();
				int historyscore=dto.getHistoryscore();
				double avgg=dto.getAvgg();
				int teacherID=dto.getTeacherID();
				String teachername=dto.getTeachername();
				String teachernumber=dto.getTeachernumber();
				String teachersubject=dto.getTeachersubject();
				String teacherclass=dto.getTeacherclass();
				
				
				
				list.add(studentID+"                        "+studentname+"                             "+studentnumber+"                              "+studentschool+"                       "+studentaddr+"                         "+studentclass+"                 "+korscore+"                 "+mathscore+"                  "+engscore+"                "+historyscore+"                  "+avgg+"               "+teachername);//화면에 있는 리스트에 붙이기
			 
			}
		
	}
		
		
		

		
		 
		

	public static void main(String[] args) {
		new Manageprogram();
		
		
	}

}
