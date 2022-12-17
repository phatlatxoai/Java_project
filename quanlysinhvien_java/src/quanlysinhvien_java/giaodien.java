package quanlysinhvien_java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
		btntim.setBackground(SystemColor.activeCaption);
		btntim.setBounds(1220, 32, 75, 28);
		contentPane.add(btntim);
		
		JButton btnhuytim = new JButton("HỦY TÌM");
		btntim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnhuytim.setBackground(SystemColor.activeCaption);
		btnhuytim.setBounds(1300, 32, 100, 28);
		contentPane.add(btnhuytim);
		///HEADER
		
		sdasd
		
		///MIDDLE
		JLabel lblmiddle1 = new JLabel("THÔNG TIN SINH VIÊN");
		Font fontLb2 = new Font(lblmiddle1.getFont().getName(), Font.PLAIN, 20);
		lblmiddle1.setFont(fontLb2);
		lblmiddle1.setBounds(50, 100, 250, 40);
		lblmiddle1.setForeground(Color.RED);
		contentPane.add(lblmiddle1);
		
		
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
