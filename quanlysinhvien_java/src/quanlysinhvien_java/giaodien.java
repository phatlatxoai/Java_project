package quanlysinhvien_java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import java.awt.Font;
import java.awt.Graphics;

public class giaodien extends JFrame {
	private JPanel contentPane;
	private JTextField txtmasvtim;
	private JTextField txtmasv;
	private JTextField txthoten;
	private JTextField txtngaysinh;
	private JTextField txtd1;
	private JTextField txtd2;
	private JTextField txtd3;
	
	private JTable table;
	JComboBox comboBox = new JComboBox();
	
	Vector Vtieude=new Vector();
	Vector Vnoidung=new Vector();
	Vector Vdong;
	
	DefaultTableModel dtm = new DefaultTableModel();
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawLine(50, 125, 1400, 125);
		g.drawLine(50, 600, 1400, 600);

	}
	
	public giaodien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(600, 150, 867, 307);
		contentPane.add(scrollPane);
		
		
		///HEADER
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SINH VIÊN");
		Font fontLb = new Font(lblNewLabel.getFont().getName(), Font.PLAIN, 20);
		lblNewLabel.setFont(fontLb);
		lblNewLabel.setBounds(74, 20, 200, 30);
		lblNewLabel.setForeground(Color.RED);
		contentPane.add(lblNewLabel);
		
		JLabel lbhdmsv = new JLabel("MÃ SINH VIÊN");
		lbhdmsv.setFont(fontLb);
		lbhdmsv.setBounds(800, 30, 200, 30);
		contentPane.add(lbhdmsv);
		
		txtmasvtim = new JTextField();
		txtmasvtim.setBounds(1000, 32, 200, 30);
		contentPane.add(txtmasvtim);
		
		JButton btntim = new JButton("TÌM");
		btntim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btntim.setBounds(1220, 32, 75, 28);
		contentPane.add(btntim);
		
		JButton btnhuytim = new JButton("HỦY TÌM");
		btntim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnhuytim.setBounds(1300, 32, 100, 28);
		contentPane.add(btnhuytim);
		///HEADER
		
		
		
		///MIDDLE
		JLabel lblmiddle1 = new JLabel("THÔNG TIN SINH VIÊN");
		Font fontLb2 = new Font(lblmiddle1.getFont().getName(), Font.PLAIN, 20);
		lblmiddle1.setFont(fontLb2);
		lblmiddle1.setBounds(50, 100, 250, 40);
		lblmiddle1.setForeground(Color.RED);
		contentPane.add(lblmiddle1);
		
		JLabel lbl1 = new JLabel("MÃ SINH VIÊN");
		lbl1.setBounds(50, 150, 250, 40);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("HỌ TÊN");
		lbl2.setBounds(50, 200, 250, 40);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("NGÀY SINH");
		lbl3.setBounds(50, 250, 250, 40);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("GIỚI TÍNH");
		lbl4.setBounds(50, 300, 250, 40);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel("CHUYÊN NGÀNH");
		lbl5.setBounds(50, 350, 250, 40);
		contentPane.add(lbl5);
		JLabel lbl6 = new JLabel("ĐIỂM HTML");
		lbl6.setBounds(75, 400, 250, 40);
		contentPane.add(lbl6);
		JLabel lbl7 = new JLabel("ĐIỂM CSS");
		lbl7.setBounds(75, 425, 250, 40);
		contentPane.add(lbl7);
		JLabel lbl8= new JLabel("CHUYÊN JAVA");
		lbl8.setBounds(75, 450, 250, 40);
		contentPane.add(lbl8);
		
		txtmasv = new JTextField();
		txtmasv.setBounds(200, 155, 150, 30);
		contentPane.add(txtmasv);
		
		txthoten = new JTextField();
		txthoten.setBounds(200, 205, 150, 30);
		contentPane.add(txthoten);
		
		txtngaysinh = new JTextField();
		txtngaysinh.setBounds(200, 255, 150, 30);
		contentPane.add(txtngaysinh);
		
		
		
		JRadioButton radioBtn1 = new JRadioButton("NAM");
        JRadioButton radioBtn2 = new JRadioButton("NỮ");
        radioBtn1.setBounds(200, 300, 60, 30);
        radioBtn2.setBounds(300, 300, 50, 30);
        contentPane.add(radioBtn1);
        contentPane.add(radioBtn2);
        
        JButton btnCNTT = new JButton("CNTT");
        btnCNTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
        btnCNTT.setBackground(Color.LIGHT_GRAY);
        btnCNTT.setBounds(200, 355, 75, 28);
		contentPane.add(btnCNTT);
        
        JButton btnKINHTE = new JButton("KINH TẾ");
        btnKINHTE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

        btnKINHTE.setBounds(300, 355, 100, 28);
		contentPane.add(btnKINHTE);

        

        
        txtd1 = new JTextField();
        txtd1.setBounds(200, 408, 50, 25);
		contentPane.add(txtd1);
		
        txtd2 = new JTextField();
        txtd2.setBounds(200, 433, 50, 25);
		contentPane.add(txtd2);
		
        txtd3 = new JTextField();
        txtd3.setBounds(200, 458, 50, 25);
		contentPane.add(txtd3);
		
		JLabel lblmiddle2 = new JLabel("DANH SÁCH SINH VIÊN");

		lblmiddle2.setFont(fontLb2);
		lblmiddle2.setBounds(900, 100, 250, 40);
		lblmiddle2.setForeground(Color.RED);
		contentPane.add(lblmiddle2);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"MÃ SV", "NGÀNH", "HỌ TÊN", "NGÀY SINH", "GIỚI TÍNH", "ĐIỂM 1", "ĐIỂM 2", "ĐIỂM 3", "ĐIỂM TB", "XẾP HẠNG"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(81);
		scrollPane.setViewportView(table);
		///MIDDLE
		
		
		
		
		
		///FOOTER
		 JButton btnTHEM = new JButton("THÊM");
		 btnTHEM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

		 btnTHEM.setBounds(200, 625, 75, 28);
		 contentPane.add(btnTHEM);
		 
		 JButton btnXOA = new JButton("XÓA");
		 btnXOA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

		 btnXOA.setBounds(350, 625, 75, 28);
		 contentPane.add(btnXOA);
		 
		 JButton btnSUA = new JButton("SỬA");
		 btnSUA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

		 btnSUA.setBounds(500, 625, 75, 28);
		 contentPane.add(btnSUA);
		 
		 JButton btnDOC = new JButton("ĐỌC FILE");
		 btnDOC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

		 btnDOC.setBounds(200, 675, 100, 28);
		 contentPane.add(btnDOC);
		 
		 JButton btnGHI = new JButton("GHI FILE");
		 btnGHI.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

		 btnGHI.setBounds(350, 675, 100, 28);
		 contentPane.add(btnGHI);
		 
		 JButton btnCAPNHAT = new JButton("CẬP NHẬT FILE");
		 btnCAPNHAT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

		 btnCAPNHAT.setBounds(500, 675, 150, 28);
		 contentPane.add(btnCAPNHAT);
		 
		 
		 JLabel lbl10 = new JLabel("SẮP XẾP");
			lbl10.setBounds(800, 620, 250, 40);
			contentPane.add(lbl10);
			
			JLabel lbl11 = new JLabel("LIỆT KÊ");
			lbl11.setBounds(800, 670, 250, 40);
			contentPane.add(lbl11);
			
			JButton btnSXTEN = new JButton("TÊN");
			btnSXTEN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});

			btnSXTEN.setBounds(900, 625, 75, 28);
			 contentPane.add(btnSXTEN);
			 
			 JButton btnDIEMTB = new JButton("ĐIỂM TB");
			 btnDIEMTB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});

			 btnDIEMTB.setBounds(1050, 625, 100, 28);
			 contentPane.add(btnDIEMTB);
			 
			 
			 
			 
			 JButton btnlkCNTT = new JButton("CNTT");
			 btnlkCNTT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});

			 btnlkCNTT.setBounds(900, 675, 100, 28);
			 contentPane.add(btnlkCNTT);
			 
			 JButton btnlkKINHTE = new JButton("KINH TẾ");
			 btnlkKINHTE.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});

			 btnlkKINHTE.setBounds(1050, 675, 100, 28);
			 contentPane.add(btnlkKINHTE);

			 JButton btnlkall = new JButton("TẤT CẢ");
			 btnlkall.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});

			 btnlkall.setBounds(1220, 675, 100, 28);
			 contentPane.add(btnlkall);
			 
			 JButton btnthoat = new JButton("THOÁT");
			 btnthoat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
			 btnthoat.setBounds(1350, 700, 100, 28);
			 contentPane.add(btnthoat);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaodien frame = new giaodien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

}
}