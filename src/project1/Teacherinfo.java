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

public class Teacherinfo extends JFrame {
	List list;
	JPanel panel_changetinfo;
	JTextField txtfind=new JTextField();
	Teacherinfo(){
		
		setTitle("교사관리프로그램");
		setSize(700,700);
		setResizable(false);
		setBounds(100, 100, 725, 527);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container ct= getContentPane();
		ct.setLayout(new BorderLayout(0, 0));
		
		JPanel paneltMTitle = new JPanel();
		ct.add(paneltMTitle, BorderLayout.NORTH);
		
		JLabel labelMTitle = new JLabel("교사 정보관리");
		labelMTitle.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 43));
		paneltMTitle.add(labelMTitle);
		paneltMTitle.setBackground(Color.decode("#FBE1BD"));
		
		JPanel paneltMScreen = new JPanel();
		ct.add(paneltMScreen, BorderLayout.CENTER);
		paneltMScreen.setLayout(null);
		paneltMScreen.setBackground(Color.decode("#F7E6C2"));
		
	
		
		JComboBox<String> comboBoxfind = new JComboBox<String>();
		JButton btnclear=new JButton("clear");
		btnclear.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		
		JLabel toollabelsearch=new JLabel("search");
		toollabelsearch.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
	
		txtfind.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		comboBoxfind.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		
		JToolBar toolBar=new JToolBar("toolbar menu");
		toolBar.setFloatable(false);//툴바고정
		JButton tooltFind=new JButton();
		tooltFind.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		tooltFind.setIcon(new ImageIcon("image\\find.jpg"));
		btnclear.setBackground(Color.decode("#F7E6C2"));
		//btnteacher.setBackground(Color.decode("#F7E6C2"));
		toollabelsearch.setBackground(Color.decode("#F7E6C2"));
		txtfind.setBackground(Color.decode("#F7E6C2"));
		comboBoxfind.setBackground(Color.decode("#F7E6C2"));
		tooltFind.setBackground(Color.decode("#F7E6C2"));
		toolBar.setMargin(new Insets(1,1,1,1));
	
		toolBar.add(btnclear);
		
		toolBar.add(toollabelsearch);
		
		toolBar.add(comboBoxfind);
		toolBar.add(txtfind);
		toolBar.add(tooltFind);
		ct.add(toolBar);
		paneltMScreen.add(toolBar);
		//toolBar.setBounds(0, 0, 707, 35);
		toolBar.setBounds(0, 377, 707, 33);
		
		comboBoxfind.addItem("이름");
		comboBoxfind.addItem("전화번호");
		comboBoxfind.addItem("과목");
		comboBoxfind.addItem("반");
		
		
		
		list = new List();
		list.setBounds(25, 64, 652, 235);
		paneltMScreen.add(list);
		
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
		paneltMScreen.add(btnSearch);
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
		paneltMScreen.add(btnAdd);
		btnAdd.setIcon(new ImageIcon("image\\add.jpg"));
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddteacherInfo();
				displayAll();
			}
		});
		
		JButton btnDelete = new JButton("삭제");
		//btnDelete.setBounds(383, 336, 105, 46);
		btnDelete.setBounds(365, 319, 105, 46);
		btnDelete.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		btnDelete.setIcon(new ImageIcon("image\\delete.jpg"));
		paneltMScreen.add(btnDelete);
		
		//삭제하기 버튼누르면 누른 내용이 삭제
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			try{ 
				String str=list.getSelectedItem();
			
				StringTokenizer st=new StringTokenizer(str);
				int teacherID= Integer.parseInt(st.nextToken());
				
				TeacherDAO dao= new TeacherDAO();
				dao.delete(teacherID);
				displayAll();
			}catch(NullPointerException ne) {
				JOptionPane.showMessageDialog(null, "삭제할 교사가 선택되지않았습니다.");
			}
			}
		});
		
		
				
		JButton btnUpdate = new JButton("수정");
		//btnUpdate.setBounds(544, 336, 105, 46);
		btnUpdate.setBounds(535, 319, 105, 46);
		btnUpdate.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		btnUpdate.setIcon(new ImageIcon("image\\update.jpg"));
		paneltMScreen.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			try {	
				String str=list.getSelectedItem();
				System.out.println(str);//값이 잘 들어갔는지 확인용 코드
				StringTokenizer st=new StringTokenizer(str);
				st.nextToken();
				String tnamech=st.nextToken();
				String tnumberch=st.nextToken();
				String tsubjectch=st.nextToken();
				String tclassch=st.nextToken();
				
				
				Changeteacherinfo chtinfo=new Changeteacherinfo();
				chtinfo.change(tnamech,tnumberch,tsubjectch,tclassch);
			}catch(NullPointerException ne) {
				JOptionPane.showMessageDialog(null, "수정될 교사가 선택되지않았습니다.");
			}
			}
		});//수정버튼누르면 화면나오게
		
	
		
		tooltFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				list.removeAll(); 
				int index=comboBoxfind.getSelectedIndex();
				System.out.println(index);
				String column="";//column값 초기화
				
				switch(index) { //column값 인덱스값으로 검색해서 넣기
				case 0: column="teachername"; break;
				case 1: column="teachernumber"; break;
				case 2: column="teachersubject"; break;
				case 3: column="teacherclass"; break;
				
				}
				System.out.println(column);			
				
				System.out.println(txtfind.getText());
				String item=txtfind.getText();
				TeacherDAO dao= new TeacherDAO(); 
				list.add("번호"+"                                         "+"이름"+"                                              "+"번호"+"                                   "+"과목"+"                                        "+"담당반");
				ArrayList<TeacherDTO> AllData=dao.search(column,item); 
				for(TeacherDTO dto : AllData) {
					int teacherID=dto.getTeacherID();
					String teachername=dto.getTeachername();
					String teachernumber=dto.getTeachernumber();
					String teachersubject=dto.getTeachersubject();
					String teacherclass=dto.getTeacherclass();
					
					list.add(teacherID+"                                              "+teachername+"                               "+teachernumber+"                            "+teachersubject+"                                               "+teacherclass);
				}
				
			
			}
		});
		
		
		ct.add(paneltMScreen);
		setVisible(true);
		
	}
	
	//조회
		private void displayAll() {
			list.removeAll(); 
			TeacherDAO dao=new TeacherDAO();
			  
			list.add("번호"+"                                         "+"이름"+"                                              "+"전화번호"+"                                   "+"과목"+"                                        "+"담당반");
			ArrayList<TeacherDTO> allData=dao.select();
			for(TeacherDTO tdto : allData) {
				
				int teacherID=tdto.getTeacherID();
				String teachername=tdto.getTeachername();
				String teachernumber=tdto.getTeachernumber();
				String teachersubject=tdto.getTeachersubject();
				String teacherclass=tdto.getTeacherclass();
				
				
				
				list.add(teacherID+"                                              "+teachername+"                               "+teachernumber+"                            "+teachersubject+"                                               "+teacherclass);
			} 
		
	}
		
	
	public static void main(String[] args) {
		new Teacherinfo();
	}

}
