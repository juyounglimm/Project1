package project1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Addstuinfo extends JFrame{
	
	Addstuinfo(){
		setTitle("학생정보추가프로그램");
		setBounds(100, 100, 550, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container ct= getContentPane();
		ct.setLayout(null);
	
		JPanel panel_addinfo = new JPanel();
		panel_addinfo .setBounds(0, 0, 549, 567);
		ct.add(panel_addinfo);
		panel_addinfo.setLayout(null);
		panel_addinfo.setBackground(Color.decode("#F7E6C2"));
		
		JLabel label_titleadd= new JLabel("학생정보입력");
		label_titleadd.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 36));
		label_titleadd.setBounds(181, 1, 200, 76);
		panel_addinfo.add(label_titleadd);
		
		JLabel label_nameadd = new JLabel("이름");
		label_nameadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_nameadd.setBounds(87, 80, 48, 39);
		panel_addinfo.add(label_nameadd);
		
		JLabel label_phoneadd= new JLabel("연락처");
		label_phoneadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_phoneadd.setBounds(87, 131, 66, 39);
		panel_addinfo.add(label_phoneadd);
		
		JLabel label_school = new JLabel("학교명");
		label_school.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_school.setBounds(87, 175, 66, 39);
		panel_addinfo.add(label_school);
		
		JLabel label_addr = new JLabel("주소");
		label_addr.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_addr.setBounds(87, 226, 66, 39);
		panel_addinfo.add(label_addr);
		
		
		JTextField txtnameadd = new JTextField();
		txtnameadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtnameadd.setBounds(205, 89, 146, 30);
		panel_addinfo.add(txtnameadd);
		txtnameadd.setColumns(10);
		
		JTextField txtphoneadd = new JTextField();
		txtphoneadd .setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtphoneadd .setColumns(10);
		txtphoneadd.setText("-제외");
		txtphoneadd .setBounds(205, 135, 146, 30);
		panel_addinfo.add(txtphoneadd);
		
		
		
		JTextField txtschooladd= new JTextField();
		txtschooladd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtschooladd.setColumns(10);
		txtschooladd.setBounds(205, 179, 146, 30);
		panel_addinfo.add(txtschooladd);
		
		JTextField txtAddradd= new JTextField();
		txtAddradd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtAddradd.setColumns(10);
		txtAddradd.setBounds(205, 230, 146, 30);
		panel_addinfo.add(txtAddradd);
		
		
		JLabel label_scoreadd = new JLabel("점수");
		label_scoreadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_scoreadd.setBounds(87, 319, 48, 39);
		panel_addinfo.add(label_scoreadd);
		
		JLabel label_koradd = new JLabel("국어");
		label_koradd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_koradd.setBounds(168, 316, 66, 39);
		panel_addinfo.add(label_koradd);
		
		JLabel label_mathadd = new JLabel("수학");
		label_mathadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_mathadd.setBounds(168, 367, 66, 39);
		panel_addinfo.add(label_mathadd);
		
		JLabel label_engadd= new JLabel("영어");
		label_engadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_engadd.setBounds(168, 414, 66, 39);
		panel_addinfo.add(label_engadd);
		
		JLabel label_historyadd= new JLabel("한국사");
		label_historyadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_historyadd.setBounds(168, 456, 66, 39);
		panel_addinfo.add(label_historyadd);
				
		JTextField txtkoradd = new JTextField();
		txtkoradd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtkoradd.setColumns(10);
		txtkoradd.setBounds(235, 323, 146, 30);
		panel_addinfo.add(txtkoradd);
		
		JTextField txtmathadd = new JTextField();
		txtmathadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtmathadd.setColumns(10);
		txtmathadd.setBounds(235, 367, 146, 30);
		panel_addinfo.add(txtmathadd);
		
		JTextField txtengadd = new JTextField();
		txtengadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtengadd.setColumns(10);
		txtengadd.setBounds(235, 418, 146, 30);
		panel_addinfo.add(txtengadd);
		
		JTextField txthistoryadd = new JTextField();
		txthistoryadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txthistoryadd.setColumns(10);
		txthistoryadd.setBounds(235, 460, 146, 30);
		panel_addinfo.add(txthistoryadd);
		
		JButton btnaddsave = new JButton("입력완료");
		btnaddsave.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		btnaddsave.setBounds(194, 516, 113, 39);
		panel_addinfo.add(btnaddsave);
		
		
		
		//입력완료누르면 테이블 내용에 insert되는것 구현 1.student 2. score
		btnaddsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//번호는 자동생성이므로 뺀다.
			try {	String studentname=txtnameadd.getText();
				String studentnumber=txtphoneadd.getText();
				String studentSchool=txtschooladd.getText();
				String studentaddr=txtAddradd.getText();
				String korscore=txtkoradd.getText();
				String mathscore=txtmathadd.getText();
				String engscore=txtengadd.getText();
				String historyscore=txthistoryadd.getText();
				String avgg=String.valueOf((Integer.parseInt(korscore)+Integer.parseInt(engscore)+Integer.parseInt(mathscore)+Integer.parseInt(historyscore))/4);
				String stuclass="";
				
				//점수대로 반 나누기
				if(((Integer.parseInt(korscore)+Integer.parseInt(engscore)+Integer.parseInt(mathscore)+Integer.parseInt(historyscore))/4)>=90.0) stuclass="A";
				else if(((Integer.parseInt(korscore)+Integer.parseInt(engscore)+Integer.parseInt(mathscore)+Integer.parseInt(historyscore))/4)>=80.0 ) stuclass="B";
				else if(((Integer.parseInt(korscore)+Integer.parseInt(engscore)+Integer.parseInt(mathscore)+Integer.parseInt(historyscore))/4)>=70.0) stuclass="C";
				else stuclass="D";
				
				
				
				StuDAO dao=new StuDAO();
				
	
				
				//점수 0점~100점사이 그외는 예외처리
				if(Integer.parseInt(korscore)>100|| Integer.parseInt(korscore)<0||Integer.parseInt(mathscore)>100|| Integer.parseInt(mathscore)<0||Integer.parseInt(engscore)>100|| Integer.parseInt(engscore)<0||Integer.parseInt(historyscore)>100|| Integer.parseInt(historyscore)<0)
				{
					JOptionPane.showMessageDialog(null,"점수입력이 잘못되었습니다");
					//System.exit(DISPOSE_ON_CLOSE);
					
				}
				
				
				
				else if(dao.checknum(studentnumber)==true) {
					
					//파일로 저장
					try {
						
						FileWriter savefile=new FileWriter("studentinfo.csv",true);
						String studentnameap=txtnameadd.getText();
						String studentnumberap=txtphoneadd.getText();
						String studentSchoolap=txtschooladd.getText();
						String studentaddrap=txtAddradd.getText();
						String korscoreap=txtkoradd.getText();
						String mathscoreap=txtmathadd.getText();
						String engscoreap=txtengadd.getText();
						String historyscoreap=txthistoryadd.getText();
						String avggap=String.valueOf((Integer.parseInt(korscore)+Integer.parseInt(engscore)+Integer.parseInt(mathscore)+Integer.parseInt(historyscore))/4);
						
						savefile.write(studentnameap+","+studentnumberap+","+studentSchoolap+","+studentaddrap+","+korscoreap+","+engscoreap+","+mathscoreap+","+historyscoreap+","+avggap+"\n");
						savefile.close();
						
					}catch(Exception ee) {
						
						JOptionPane.showMessageDialog(null, "파일저장 실패");System.exit(DISPOSE_ON_CLOSE);
					}//파일저장부분끝
					
				dao.insertstu(studentname,studentnumber,studentSchool,studentaddr,stuclass);
				
				dao.insertscore(studentname,korscore,mathscore,engscore,historyscore,avgg);
				}
				//입력오류 예외처리	
			}catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "입력이 잘못되었습니다.");
			}
			
			}
		});
	
		
		ct.add(panel_addinfo);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		//new Addstuinfo();
	}

}
