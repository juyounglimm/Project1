package project1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class ChangeStuinfo extends JFrame{
	JTextField txtnamechange = new JTextField();
	JTextField txtphonechange = new JTextField();
	JTextField txtschoolchange = new JTextField();
	JTextField txtAddrchange = new JTextField();
	JTextField txtchangeclass = new JTextField();
	JTextField txtkorchange = new JTextField();
	JTextField txtmathchange = new JTextField();
	JTextField txtengchange = new JTextField();
	JTextField txthistorychange = new JTextField();
	int stuid;
	String phonechange;
	ChangeStuinfo(){
		setTitle("학생정보수정창");
		setBounds(100, 100, 550, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container ct= getContentPane();
		ct.setLayout(null);
		
		JPanel panel_changeinfo= new JPanel();
		panel_changeinfo .setBounds(0, 0, 549, 567);
		ct.add(panel_changeinfo);
		panel_changeinfo.setLayout(null);
		panel_changeinfo.setBackground(Color.decode("#F7E6C2"));
		
		JLabel label_titlechange= new JLabel("학생정보수정");
		label_titlechange.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 36));
		label_titlechange.setBounds(181, 1, 200, 76);
		panel_changeinfo.add(label_titlechange);
	
		
		JLabel label_namechange = new JLabel("이름");
		label_namechange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_namechange.setBounds(87, 80, 48, 39);
		panel_changeinfo.add(label_namechange);
		
		JLabel label_phonechange= new JLabel("연락처");
		label_phonechange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_phonechange.setBounds(87, 131, 66, 39);
		panel_changeinfo.add(label_phonechange);
		
				
		JLabel label_classchange = new JLabel("반");
		label_classchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_classchange.setBounds(87, 268, 66, 39);
		panel_changeinfo.add(label_classchange);
		

		txtchangeclass.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtchangeclass.setColumns(10);
		txtchangeclass.setBounds(205, 274, 146, 30);
		panel_changeinfo.add(txtchangeclass);
		
		
		JLabel label_schoolchange = new JLabel("학교명");
		label_schoolchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_schoolchange.setBounds(87, 175, 66, 39);
		panel_changeinfo.add(label_schoolchange);
		
		JLabel label_addrchange = new JLabel("주소");
		label_addrchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_addrchange.setBounds(87, 226, 66, 39);
		panel_changeinfo.add(label_addrchange);
		
		
		txtnamechange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtnamechange.setBounds(205, 89, 146, 30);
		panel_changeinfo.add(txtnamechange);
		txtnamechange.setColumns(10);
		txtnamechange.setEditable(false);
		
		
		txtphonechange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtphonechange.setColumns(10);
		txtphonechange.setBounds(205, 135, 146, 30);
		panel_changeinfo.add(txtphonechange);
		
		txtschoolchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtschoolchange.setColumns(10);
		txtschoolchange.setBounds(205, 179, 146, 30);
		panel_changeinfo.add(txtschoolchange);
		
		txtAddrchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtAddrchange.setColumns(10);
		txtAddrchange.setBounds(205, 230, 146, 30);
		panel_changeinfo.add(txtAddrchange);
		
		
		JLabel label_scorechange = new JLabel("점수");
		label_scorechange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_scorechange.setBounds(87, 319, 48, 39);
		panel_changeinfo.add(label_scorechange);
		
		JLabel label_korchange = new JLabel("국어");
		label_korchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_korchange.setBounds(168, 316, 66, 39);
		panel_changeinfo.add(label_korchange);
		
		JLabel label_mathchange = new JLabel("수학");
		label_mathchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_mathchange.setBounds(168, 367, 66, 39);
		panel_changeinfo.add(label_mathchange);
		
		JLabel label_engchange= new JLabel("영어");
		label_engchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_engchange.setBounds(168, 414, 66, 39);
		panel_changeinfo.add(label_engchange);
		
		JLabel label_historychange= new JLabel("한국사");
		label_historychange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_historychange.setBounds(168, 456, 66, 39);
		panel_changeinfo.add(label_historychange);
				
		txtkorchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtkorchange.setColumns(10);
		txtkorchange.setBounds(235, 323, 146, 30);
		panel_changeinfo.add(txtkorchange);
		
		txtmathchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtmathchange.setColumns(10);
		txtmathchange.setBounds(235, 367, 146, 30);
		panel_changeinfo.add(txtmathchange);
		
		txtengchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txtengchange.setColumns(10);
		txtengchange.setBounds(235, 418, 146, 30);
		panel_changeinfo.add(txtengchange);
		
		txthistorychange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txthistorychange.setColumns(10);
		txthistorychange.setBounds(235, 460, 146, 30);
		panel_changeinfo.add(txthistorychange);
		
		JButton btnchangesave = new JButton("입력완료");
		btnchangesave.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		btnchangesave.setBounds(194, 516, 113, 39);
		panel_changeinfo.add(btnchangesave);
		
		txtnamechange.setText("");
		txtphonechange.setText("");
		txtschoolchange.setText("");
		txtAddrchange.setText("");
		txtchangeclass.setText("");	
		txtkorchange.setText("");
		txtengchange.setText("");
		txtmathchange.setText("");
		txthistorychange.setText("");
	
		
		
			
		//입력완료누르면 테이블 내용에 update 되는것 구현 1.student 2. score
		btnchangesave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//번호는 자동생성이므로 뺀다.
		try {	int studentID=stuid;
				String studentname=txtnamechange.getText();
				String studentnumber=txtphonechange.getText();
				String studentSchool=txtschoolchange.getText();
				String studentaddr=txtAddrchange.getText();
				String studentclass=txtchangeclass.getText();
				String korscore=txtkorchange.getText();
				String mathscore=txtmathchange.getText();
				String engscore=txtengchange.getText();
				String historyscore=txthistorychange.getText();
				String avgg=String.valueOf((Integer.parseInt(korscore)+Integer.parseInt(engscore)+Integer.parseInt(mathscore)+Integer.parseInt(historyscore))/4);
				StuDAO dao=new StuDAO();
				
				if(Integer.parseInt(korscore)>100|| Integer.parseInt(korscore)<0||Integer.parseInt(mathscore)>100|| Integer.parseInt(mathscore)<0||Integer.parseInt(engscore)>100|| Integer.parseInt(engscore)<0||Integer.parseInt(historyscore)>100|| Integer.parseInt(historyscore)<0)
				{
					JOptionPane.showMessageDialog(null,"점수입력이 잘못되었습니다");
				
					
				}
				
				else if(phonechange.equals(studentnumber)) {
					dao.updatechangestu(stuid,studentname,studentnumber,studentSchool,studentaddr,studentclass);
					
					dao.updatescore(korscore,engscore,mathscore,historyscore,avgg,stuid);
					JOptionPane.showMessageDialog(null, "수정완료");
				}
				else if(dao.checknum(studentnumber)==true) {
				dao.updatechangestu(stuid,studentname,studentnumber,studentSchool,studentaddr,studentclass);
				
				dao.updatescore(korscore,engscore,mathscore,historyscore,avgg,stuid);
				JOptionPane.showMessageDialog(null, "수정완료");}
			
				
		}catch(NumberFormatException nume) {
			JOptionPane.showMessageDialog(null, "수정할내용이 잘못입력되었습니다. 다시입력하세요");
		}
			}
		});
	
		
		ct.add(panel_changeinfo);
		setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args) {
		//new ChangeStuinfo();
		
	}



	public void change(int studentIDch,String stunamech, String stunumberch, String stuschoolch, String stuaddrch, String stuclassch, String korscorech, String mathscorech, String engscorech, String historyscorech) {
		stuid=studentIDch;
		txtnamechange.setText(stunamech);
		txtphonechange.setText(stunumberch);
		txtschoolchange.setText(stuschoolch);
		txtAddrchange.setText(stuaddrch);
		txtchangeclass.setText(stuclassch);
		txtkorchange.setText(korscorech);
		txtmathchange.setText(mathscorech);
		txtengchange.setText(engscorech);
		txthistorychange.setText(historyscorech);
		phonechange=stunumberch;
	}//수정창 띄울때 내용나오게

	
	

}
