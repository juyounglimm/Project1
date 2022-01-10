package project1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddteacherInfo extends JFrame{
	
	AddteacherInfo(){
		setTitle("교사정보추가프로그램");
		setBounds(100, 100, 550, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container ct= getContentPane();
		ct.setLayout(null);
		JPanel panel_addtinfo = new JPanel();
		panel_addtinfo .setBounds(0, 0, 549, 567);
		ct.add(panel_addtinfo);
		panel_addtinfo.setLayout(null);
		panel_addtinfo.setBackground(Color.decode("#F7E6C2"));
		
		JLabel label_titleadd= new JLabel("교사정보입력");
		label_titleadd.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 36));
		label_titleadd.setBounds(181, 1, 200, 76);
		panel_addtinfo.add(label_titleadd);
		
		JLabel label_tnameadd = new JLabel("이름");
		label_tnameadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_tnameadd.setBounds(87, 80, 48, 39);
		panel_addtinfo.add(label_tnameadd);
		
		JLabel label_tphoneadd= new JLabel("연락처");
		label_tphoneadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_tphoneadd.setBounds(87, 131, 66, 39);
		panel_addtinfo.add(label_tphoneadd);
		
		JLabel label_tsubject= new JLabel("과목명");
		label_tsubject.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_tsubject.setBounds(87, 175, 66, 39);
		panel_addtinfo.add(label_tsubject);
		
		JLabel label_tclass = new JLabel("반");
		label_tclass.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_tclass.setBounds(87, 226, 66, 39);
		panel_addtinfo.add(label_tclass);
		
		
		JTextField txttnameadd = new JTextField();
		txttnameadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txttnameadd.setBounds(205, 89, 146, 30);
		panel_addtinfo.add(txttnameadd);
		txttnameadd.setColumns(10);
		
		JTextField txttphoneadd = new JTextField();
		txttphoneadd .setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txttphoneadd .setColumns(15);
		txttphoneadd.setText("-제외");
		txttphoneadd .setBounds(205, 135, 146, 30);
		panel_addtinfo.add(txttphoneadd);
		
		JTextField txttsubjectadd= new JTextField();
		txttsubjectadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txttsubjectadd.setColumns(10);
		txttsubjectadd.setBounds(205, 179, 146, 30);
		panel_addtinfo.add(txttsubjectadd);
		
		JTextField txttclassadd= new JTextField();
		txttclassadd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txttclassadd.setColumns(10);
		txttclassadd.setBounds(205, 230, 146, 30);
		panel_addtinfo.add(txttclassadd);
		
		
		
		JButton btnaddsave = new JButton("입력완료");
		btnaddsave.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		btnaddsave.setBounds(194, 516, 113, 39);
		panel_addtinfo.add(btnaddsave);
		
		
		//입력완료누르면 테이블 내용에 insert되는것 구현 1.student 2. score
		btnaddsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//번호는 자동생성이므로 뺀다.

		
				String teachername=txttnameadd.getText();
				String teachernumber=txttphoneadd.getText();
				String teachersubject=txttsubjectadd.getText();
				String teacherclass=txttclassadd.getText();
				
				if(teacherclass.equals("")) {
				teacherclass="null";
				}
				
				TeacherDAO dao=new TeacherDAO();
				System.out.println("teachernumber"+teachernumber);
				if(teachername.length()==0||teachernumber.length()==3||teachernumber.length()==0||teachersubject.length()==0) {
					JOptionPane.showMessageDialog(null,"입력된값이 없습니다."); //System.exit(EXIT_ON_CLOSE);
				}
				else if(teachernumber.length()!=11) {JOptionPane.showMessageDialog(null,"입력한 전화번호형식이 잘못되었습니다");}
				//System.exit(DISPOSE_ON_CLOSE); }
				
				//dao.checknum(teachernumber);
				
				else if(dao.checknum(teachernumber)==true) {
					
					dao.insert(teachername,teachernumber,teachersubject,teacherclass);
					}
				
			
			
			}
		});
	
		
		ct.add(panel_addtinfo);
		setVisible(true);
	}
	public static void main(String[] args) {
		//new AddteacherInfo();
	}

}
