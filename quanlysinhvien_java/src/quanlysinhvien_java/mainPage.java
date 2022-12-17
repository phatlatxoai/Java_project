package quanlysinhvien_java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class mainPage extends JFrame {
	private JPanel contentPanel;
	private JTextField txtSearchStudentID;
	private JTextField txtStudentID;
	private JTextField txtName;
	private JTextField txtDateOfBirth;
	private JTextField txtScore1;
	private JTextField txtScore2;
	private JTextField txtScore3;
	
	private JTable table;
	JComboBox<?> comboBox = new JComboBox<Object>();
	
	Vector<?> Vtieude=new Vector<Object>();
	Vector<?> Vnoidung=new Vector<Object>();
	Vector<?> Vdong;
	
	DefaultTableModel dtm = new DefaultTableModel();
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawLine(50, 125, 1400, 125);

	}
	
	public mainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1500, 800);
		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setBounds(600, 150, 867, 307);
		contentPanel.add(scrollPanel);
		
		
		///HEADER
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SINH VIÊN");
		Font fontLb = new Font(lblNewLabel.getFont().getName(), Font.PLAIN, 20);
		lblNewLabel.setFont(fontLb);
		lblNewLabel.setBounds(74, 20, 200, 30);
		lblNewLabel.setForeground(Color.RED);
		contentPanel.add(lblNewLabel);
		
		JLabel lbStudentID = new JLabel("MÃ SINH VIÊN");
		lbStudentID.setFont(fontLb);
		lbStudentID.setBounds(800, 30, 200, 30);
		contentPanel.add(lbStudentID);
		
		txtSearchStudentID = new JTextField();
		txtSearchStudentID.setBounds(1000, 32, 200, 30);
		contentPanel.add(txtSearchStudentID);
		
		JButton btnSearch = new JButton("TÌM");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.setBounds(1220, 32, 75, 28);
		contentPanel.add(btnSearch);
		
		JButton btnCancelSearch = new JButton("HỦY TÌM");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelSearch.setBackground(SystemColor.activeCaption);
		btnCancelSearch.setBounds(1300, 32, 100, 28);
		contentPanel.add(btnCancelSearch);
		///HEADER
		
		
		
		///MIDDLE
		JLabel lblmiddle1 = new JLabel("THÔNG TIN SINH VIÊN");
		Font fontLb2 = new Font(lblmiddle1.getFont().getName(), Font.PLAIN, 20);
		lblmiddle1.setFont(fontLb2);
		lblmiddle1.setBounds(50, 100, 250, 40);
		lblmiddle1.setForeground(Color.RED);
		contentPanel.add(lblmiddle1);
		
		
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
		scrollPanel.setViewportView(table);
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage frame = new mainPage();
					frame.setVisible(true);
					
					frame.addWindowListener(new WindowAdapter() {
					    public void windowClosing(WindowEvent evt) {
					        int resp = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?",
					            "Exit?", JOptionPane.YES_NO_OPTION);

					        if (resp == JOptionPane.YES_OPTION) {
					            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					        } else {
					            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					        }
					    }
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
