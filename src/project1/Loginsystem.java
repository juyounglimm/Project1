package project1;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



class ImagePanel1 extends JPanel{
private Image img;

public ImagePanel1(Image img) {
	this.img=img;
	setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
	setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
}
public void paintComponent(Graphics g) {
	g.drawImage(img,0,0,null);
}
}

public class Loginsystem extends JFrame{
		
		JPanel panelMTitle;
		JPanel panelMScreen;
		
		
		Loginsystem(){
		    JFrame frame=new JFrame();
		    setSize(480,400);
		    frame.setBounds(100, 120, 450, 360);
		    
			setTitle("로그인화면");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setSize(480,450);
			frame.setResizable(false);
			Container ct=getContentPane();
			
			ImagePanel1 imgpanel=new ImagePanel1(new ImageIcon("image\\LoginUI.jpg").getImage());
			ct.add(imgpanel, BorderLayout.SOUTH);
			
			imgpanel.setLayout(null);
		
			TextField text_id = new TextField();
			text_id.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			text_id.setBackground(new Color(255, 250, 205));
			text_id.setBounds(166, 158, 230, 40);
			imgpanel.add(text_id);
			
			JPasswordField txt_password = new JPasswordField();
			txt_password.setBackground(new Color(255, 250, 205));
			txt_password.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			txt_password.setBounds(166, 236, 230, 40);
			imgpanel.add(txt_password);
			
			JButton btnlogin = new JButton("");
			btnlogin.setIcon(new ImageIcon("image\\buttonLogin1.jpg"));
		
			btnlogin.setBounds(176, 297, 159, 79);
			imgpanel.add(btnlogin);
		
			JLabel lblNewLabel = new JLabel("학원관리시스템");
			lblNewLabel.setForeground(new Color(188, 143, 143));
			lblNewLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 50));
			lblNewLabel.setBounds(82, 44, 353, 80);
			imgpanel.add(lblNewLabel);
		
			//로그인버튼 동작
			btnlogin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String id="abc";
					String pw="1234";
					
					if(text_id.getText().length()==0||txt_password.getPassword().length==0) {
						JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 입력되지않았습니다.");
					}
					
					else if(id.equals(text_id.getText())&&pw.equals(txt_password.getText())){
						JOptionPane.showMessageDialog(null, "로그인되었습니다.");
							new Manageprogram();
						
					}else{
						JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 틀렸습니다.");
					}
					
					
				}
			});
			//로그인버튼동작
			
		
			setVisible(true);
		}
	

		
		
		
		
	public static void main(String[] args) {
		new Loginsystem();
		
	}

}



	
	
	
	
