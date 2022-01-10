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

public class Changeteacherinfo extends JFrame{
	JTextField txttnamechange = new JTextField();
	JTextField txttphonechange = new JTextField();
	JTextField txttsubjectchange = new JTextField();
	JTextField txttchangeclass = new JTextField();
	String tphonechange;
	Changeteacherinfo(){
		setTitle("교사정보수정창");
		setBounds(100, 100, 550, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container ct= getContentPane();
		ct.setLayout(null);
		
		JPanel panel_changetinfo= new JPanel();
		panel_changetinfo .setBounds(0, 0, 549, 567);
		ct.add(panel_changetinfo);
		panel_changetinfo.setLayout(null);
		panel_changetinfo.setBackground(Color.decode("#F7E6C2"));
		
		JLabel label_titlechange= new JLabel("교사정보수정");
		label_titlechange.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 36));
		label_titlechange.setBounds(181, 1, 200, 76);
		panel_changetinfo.add(label_titlechange);
		
		JLabel label_tnamechange = new JLabel("이름");
		label_tnamechange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_tnamechange.setBounds(87, 80, 48, 39);
		panel_changetinfo.add(label_tnamechange);
		
		JLabel label_tphonechange= new JLabel("연락처");
		label_tphonechange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_tphonechange.setBounds(87, 131, 66, 39);
		panel_changetinfo.add(label_tphonechange);
		
			
		JLabel label_tsubjectchange = new JLabel("과목명");
		label_tsubjectchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_tsubjectchange.setBounds(87, 175, 66, 39);
		panel_changetinfo.add(label_tsubjectchange);
		
		JLabel label_taddrchange = new JLabel("반");
		label_taddrchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		label_taddrchange.setBounds(87, 226, 66, 39);
		panel_changetinfo.add(label_taddrchange);
		
		

		txttnamechange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txttnamechange.setBounds(205, 89, 146, 30);
		panel_changetinfo.add(txttnamechange);
		txttnamechange.setColumns(10);
		txttnamechange.setEditable(false);
	
		txttphonechange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txttphonechange.setColumns(10);
		txttphonechange.setBounds(205, 135, 146, 30);
		panel_changetinfo.add(txttphonechange);
		
		txttsubjectchange.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txttsubjectchange.setColumns(10);
		txttsubjectchange.setBounds(205, 179, 146, 30);
		panel_changetinfo.add(txttsubjectchange);
		
		txttchangeclass.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		txttchangeclass.setColumns(10);
		txttchangeclass.setBounds(205, 230, 146, 30);
		panel_changetinfo.add(txttchangeclass);
		
		JButton btnchangesave = new JButton("입력완료");
		btnchangesave.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		btnchangesave.setBounds(194, 516, 113, 39);
		panel_changetinfo.add(btnchangesave);

		txttnamechange.setText("");
		txttphonechange.setText("");
		txttsubjectchange.setText("");
		txttchangeclass.setText("");
		btnchangesave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//번호는 자동생성이므로 뺀다.
		try {	String teachername=txttnamechange.getText();
				String teachernumber=txttphonechange.getText();
				String teachersubject=txttsubjectchange.getText();
				String teacherclass=txttchangeclass.getText();
				
				TeacherDAO dao=new TeacherDAO();
				if(teachernumber.length()!=11) {
					JOptionPane.showMessageDialog(null, "전화번호형식이 잘못되었습니다.");
				}
				else if(tphonechange.equals(teachernumber)) {
				dao.updatechanget(teachername,teachernumber,teachersubject,teacherclass);
				
				JOptionPane.showMessageDialog(null, "수정완료");}
				
				else if(dao.checknum(teachernumber)==true) {
					dao.updatechanget(teachername,teachernumber,teachersubject,teacherclass);
					JOptionPane.showMessageDialog(null, "수정완료");}
		}catch(NumberFormatException nume) {
			JOptionPane.showMessageDialog(null, "수정할내용이 잘못입력되었습니다. 다시입력하세요");
		}
			}
		});
		ct.add(panel_changetinfo);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Changeteacherinfo();
		
	}
	
	public void change(String tnamech, String tnumberch, String tsubjectch, String tclassch) {
		txttnamechange.setText(tnamech);
		txttphonechange.setText(tnumberch);
		txttsubjectchange.setText(tsubjectch);
		txttchangeclass.setText(tclassch);
		tphonechange=tnumberch;
	}//수정창 띄울때 내용나오게

}
