package quanlysinhvien_java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import javax.swing.RowSorter;
import javax.swing.SortOrder;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.table.TableModel;

import javax.swing.table.TableRowSorter;

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
	int rowselected = -1;
	private JTable table;
	JComboBox comboBox = new JComboBox();
	
	Vector Vtieude=new Vector();
	Vector Vnoidung=new Vector();
	Vector Vdong;
	
	char nganh = 'C';
	String khoa = "CNTT";
	
	DefaultTableModel dtm = new DefaultTableModel();
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawLine(50, 125, 1400, 125);
		g.drawLine(50, 600, 1400, 600);

	}
	
	void Tieude() {
		Vtieude.add("MÃ SV");
		Vtieude.add("NGÀNH");
		Vtieude.add("HỌ TÊN");
		Vtieude.add("NGÀY SINH");
		Vtieude.add("GIỚI TÍNH");
		Vtieude.add("ĐIỂM 1");
		Vtieude.add("ĐIỂM 2");
		Vtieude.add("ĐIỂM 3");
		Vtieude.add("ĐIỂM TB");
		Vtieude.add("XẾP HẠNG");
		
	}
	
	void Nhap(SinhvienModel svmd) {
		Vdong = new Vector();
		Vdong.add(svmd.getMssv());
		Vdong.add(svmd.getCnghanh());
		Vdong.add(svmd.getHoten());
		Vdong.add(svmd.getNsinh());
		Vdong.add(svmd.getGtinh());
		Vdong.add(svmd.getDiem1());
		Vdong.add(svmd.getDiem2());
		Vdong.add(svmd.getDiem3());
		Vdong.add(svmd.getDiemtb());
		Vdong.add(svmd.getXephang());
		Vnoidung.add(Vdong);
		
	}
	
	
	public giaodien() {
		Tieude();
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
				
				if (txtmasvtim.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane,
			                "VUI LÒNG NHẬP MÃ SỐ SINH VIÊN MUỐN TÌM",
			                "THÔNG BÁO",
			                JOptionPane.INFORMATION_MESSAGE);
				}else {
					
				String query = txtmasvtim.getText().toString();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>((DefaultTableModel) table.getModel());
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(query));
				}
			}	
		});
		btntim.setBounds(1220, 32, 75, 28);
		contentPane.add(btntim);
		
		JButton btnhuytim = new JButton("HỦY TÌM");
		btnhuytim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txtmasvtim.setText("");
				String query = txtmasvtim.getText().toString();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>((DefaultTableModel) table.getModel());
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(query));
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
        radioBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				radioBtn2.setSelected(isUndecorated());
				
			}
		});
        radioBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				radioBtn1.setSelected(isUndecorated());
				
			}
		});        
        contentPane.add(radioBtn1);
        radioBtn1.setSelected(isFocusable());
        contentPane.add(radioBtn2);
        
        JButton btnCNTT = new JButton("CNTT");
        
        btnCNTT.setBackground(Color.LIGHT_GRAY);
        btnCNTT.setBounds(200, 355, 75, 28);
		contentPane.add(btnCNTT);
		btnCNTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
        
        JButton btnKINHTE = new JButton("KINH TẾ");
        btnKINHTE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nganh = btnKINHTE.getText().toString();
				
			}
		});

        btnKINHTE.setBounds(300, 355, 100, 28);
		contentPane.add(btnKINHTE);
		btnCNTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCNTT.setBackground(Color.LIGHT_GRAY);
				btnKINHTE.setBackground(null);
				lbl6.setText("ĐIỂM HTML");
				lbl7.setText("ĐIỂM CSS");
				lbl8.setText("ĐIỂM JAVA");
				nganh='C';
				khoa = "CNTT";
			}
		});
		btnKINHTE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnKINHTE.setBackground(Color.LIGHT_GRAY);
				btnCNTT.setBackground(null);
				lbl6.setText("ĐIỂM MARKETING");
				lbl7.setText("ĐIỂM NLKT");
				lbl8.setText("ĐIỂM KINH TẾ VĨ MÔ");
				nganh='K';
				khoa = "KINH TẾ";
						
			}
		});
        

        
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
			null,
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
					if(txtmasv.getText().isEmpty() || txthoten.getText().isEmpty() || txtngaysinh.getText().isEmpty() || txtd2.getText().isEmpty() || txtd3.getText().isEmpty() || txtd1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(contentPane,
				                "VUI LÒNG NHẬP HẾT THÔNG TIN TRƯỚC KHI THÊM",
				                "THÔNG BÁO",
				                JOptionPane.INFORMATION_MESSAGE);
				    }
					else if(txtmasv.getText().toString().charAt(0) != 'C'&&txtmasv.getText().toString().charAt(0) != 'c'&& txtmasv.getText().toString().charAt(0) != 'k'&& txtmasv.getText().toString().charAt(0) != 'K' ) {
						JOptionPane.showMessageDialog(contentPane,
				                "MÃ SINH VIÊN PHẢI BẮT ĐẦU BẰNG CÁC KÝ TỰ [C,c,K,K]",
				                "THÔNG BÁO",
				                JOptionPane.INFORMATION_MESSAGE);
					}
					else if(txtmasv.getText().toString().toUpperCase().charAt(0) != nganh ) {
						JOptionPane.showMessageDialog(contentPane,
				                "MÃ SINH VIÊN PHẢI TRÙNG VỚI NGÀNH BẠN CHỌN",
				                "THÔNG BÁO",
				                JOptionPane.INFORMATION_MESSAGE);
					}else {
						String masv = txtmasv.getText();
						String hoten = txthoten.getText();
						String ngaysinh = txtngaysinh.getText();
						String gioitinh = "";
						if(radioBtn1.isSelected()) {
							gioitinh = "Nam";
						}
						if(radioBtn2.isSelected()) {
							gioitinh = "Nữ";
						}
						float diem1 = Float.parseFloat(txtd1.getText());
						float diem2 = Float.parseFloat(txtd2.getText());
						float diem3 = Float.parseFloat(txtd3.getText());
						SinhvienModel svmd = new SinhvienModel(masv, khoa, hoten, ngaysinh, gioitinh, diem1, diem2, diem3);
						Nhap(svmd);
						table.setModel(new DefaultTableModel(Vnoidung, Vtieude));
					}
					
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
		 
		 table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			 @Override
			 public void valueChanged(ListSelectionEvent e) {
				 // TODO Auto-generated method stub
				 rowselected = table.getSelectedRow();
				 System.out.println(rowselected);
				 
			 }
		 });
		 JButton btnSUA = new JButton("SỬA");
		 
		 btnSUA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int resp = JOptionPane.showConfirmDialog(null, "Bạn có thay đổi dữ liệu không ?", "Sửa?", JOptionPane.YES_NO_OPTION);
				    if (resp == JOptionPane.YES_OPTION) {
				    	String mssv  = txtmasv.getText().toString();
				    	String hoten = txthoten.getText().toString();
				    	String ngaysinh = txtngaysinh.getText().toString();
				    	float  diem1 = Float.parseFloat(txtd1.getText().toString());
				    	float  diem2 = Float.parseFloat(txtd2.getText().toString());
				    	float  diem3 = Float.parseFloat(txtd3.getText().toString());
				    	String gioitinh = "";
				    	if(radioBtn1.isSelected()) {
				    		gioitinh = "Nam";
				    	}
				    	if(radioBtn2.isSelected()) {
				    		gioitinh = "Nữ";
				    	}
				    	SinhvienModel sv = new SinhvienModel(mssv, khoa, hoten, ngaysinh, gioitinh, diem1, diem2, diem3);
				    	DefaultTableModel model = (DefaultTableModel) table.getModel();
				    	model.setValueAt(sv.getMssv(), rowselected, 0);
				    	model.setValueAt(sv.getCnghanh(), rowselected, 1);
				    	model.setValueAt(sv.getHoten(), rowselected, 2);
				    	model.setValueAt(sv.getNsinh(), rowselected, 3);
				    	model.setValueAt(sv.getGtinh(), rowselected, 4);
				    	model.setValueAt(sv.getDiem1(), rowselected, 5);
				    	model.setValueAt(sv.getDiem2(), rowselected, 6);
				    	model.setValueAt(sv.getDiem3(), rowselected, 7);
				    	model.setValueAt(sv.getDiemtb(), rowselected, 8);
				    	model.setValueAt(sv.getXephang(), rowselected, 9);
				    	JOptionPane.showMessageDialog(contentPane,
				                "Cập nhật thành công",
				                "THÔNG BÁO",
				                JOptionPane.INFORMATION_MESSAGE);
				    	
				    	txtmasv.setText(null);
						txthoten.setText(null);
						txtngaysinh.setText(null);
						txtd1.setText(null);
						txtd2.setText(null);
						txtd3.setText(null);
						radioBtn1.setSelected(isUndecorated());
						radioBtn2.setSelected(isUndecorated());
						btnCNTT.setBackground(null);
						btnKINHTE.setBackground(null);

				    }else {
				    	
				    }
					
					
				}
			});

		 btnSUA.setBounds(500, 625, 75, 28);
		 contentPane.add(btnSUA);
		 
		 JButton btnDOC = new JButton("ĐỌC FILE");
		 btnDOC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
					
					try {
						  //  Block of code to try
						JFileChooser c = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
						c.setFileFilter(filter);
						int rVal = c.showOpenDialog(null);
						String filename = "";
					    String dir = "";
						if (rVal == JFileChooser.APPROVE_OPTION) {
						     filename = c.getSelectedFile().getName();
						     dir = c.getCurrentDirectory().toString();
						}
						
						String filePath = dir+"\\"+filename;
						BufferedReader br = new BufferedReader (new FileReader (filePath));
						
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						Object[] tableLines = br.lines ().toArray();
						for (int i = 0; i < tableLines.length; i++)
						{
							
							String line = tableLines [i].toString().trim();
							String[] dataRow = line.split(";");
							SinhvienModel sv = new SinhvienModel(dataRow[0], dataRow[1], dataRow[2], dataRow[3]
									, dataRow[4], Float.parseFloat( dataRow[5])
									,Float.parseFloat( dataRow[6]),Float.parseFloat( dataRow[7]));

							Nhap(sv);
							table.setModel(new DefaultTableModel(Vnoidung, Vtieude));
						}
						JOptionPane.showMessageDialog(contentPane,
				                "Đọc thành công",
				                "THÔNG BÁO",
				                JOptionPane.INFORMATION_MESSAGE);			
					}
					catch(Exception e1) {
					  //  Block of code to handle errors
						JOptionPane.showMessageDialog(contentPane,
				                "Đọc không thành công",
				                "THÔNG BÁO",
				                JOptionPane.INFORMATION_MESSAGE);				
					}
				}
			});

		 btnDOC.setBounds(200, 675, 100, 28);
		 contentPane.add(btnDOC);
		 JButton btnGHI = new JButton("GHI FILE");
		 btnGHI.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(contentPane,
				                "VUI LÒNG THÊM SINH VIÊN",
				                "THÔNG BÁO",
				                JOptionPane.INFORMATION_MESSAGE);

						
					}else {
						 try {
								JFileChooser c = new JFileChooser();
								FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
								c.setFileFilter(filter);
								int rVal = c.showSaveDialog(null);
								String filename = "";
							    String dir = "";
								if (rVal == JFileChooser.APPROVE_OPTION) {
								      filename = c.getSelectedFile().getName();
								      dir = c.getCurrentDirectory().toString();
								 }
								String filePath = dir+"\\"+filename+".txt";
								File file = new File (filePath);
								
								FileWriter fw = new FileWriter (file);
								BufferedWriter bw = new BufferedWriter (fw);
								for (int i=0; i < table.getRowCount(); i++) { //rows
									for (int j = 0; j < table.getColumnCount(); j++) { //columns
										bw.write(table.getValueAt (i, j).toString()+";");
									}
									bw.newLine();
								}
								bw.close();
								fw.close();
								JOptionPane.showMessageDialog(contentPane,
						                "GHI THÀNH CÔNG",
						                "THÔNG BÁO",
						                JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(contentPane,
					                "GHI KHÔNG THÀNH CÔNG",
					                "THÔNG BÁO",
					                JOptionPane.INFORMATION_MESSAGE);
						}
					
					}
				}
			});

		 btnGHI.setBounds(350, 675, 100, 28);
		 contentPane.add(btnGHI);
		 
		 JButton btnCAPNHAT = new JButton("Xem Thông tin");
		 btnCAPNHAT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rowselected == -1) {
						JOptionPane.showMessageDialog(contentPane,
				                "BẠN CHƯA CHỌN SINH VIÊN ĐỂ CẬP NHẬP",
				                "THÔNG BÁO",
				                JOptionPane.INFORMATION_MESSAGE);
					}else {
						
						txtmasv.setText(table.getValueAt(rowselected, 0).toString());
						txthoten.setText(table.getValueAt(rowselected, 2).toString());
						txtngaysinh.setText(table.getValueAt(rowselected, 3).toString());
						txtd1.setText(table.getValueAt(rowselected, 5).toString());
						txtd2.setText(table.getValueAt(rowselected, 6).toString());
						txtd3.setText(table.getValueAt(rowselected, 7).toString());
						if(table.getValueAt(rowselected, 4).toString() == "Nam") {
							radioBtn1.setSelected(isFocusable());
							radioBtn2.setSelected(isUndecorated());
						}
						else {
							radioBtn2.setSelected(isFocusable());
							radioBtn1.setSelected(isUndecorated());
						}
						
						if(table.getValueAt(rowselected, 1).toString() == "CNTT") {
							khoa = "CNTT";
							btnCNTT.setBackground(Color.LIGHT_GRAY);
							btnKINHTE.setBackground(null);
						}
						else {
							khoa = "KINH TẾ";
							btnKINHTE.setBackground(Color.LIGHT_GRAY);
							btnCNTT.setBackground(null);
						}
					}
					
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
						
                      if ( table.getRowCount() == 0) {
			            	JOptionPane.showMessageDialog(contentPane,
					                "VUI LÒNG THÊM SINH VIÊN KHI SẮP XẾP TÊN",
					                "THÔNG BÁO",
					                JOptionPane.INFORMATION_MESSAGE);
			            }else {
			            	TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		                      table.setRowSorter(sorter);
		                      List<RowSorter.SortKey> sortKeys = new ArrayList<>();

		                      int columnIndexToSort = 2;
		                      sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

		                      sorter.setSortKeys(sortKeys);
		                      sorter.sort();
			            }
					}
				});

			btnSXTEN.setBounds(900, 625, 75, 28);
			 contentPane.add(btnSXTEN);
			 
			 JButton btnDIEMTB = new JButton("ĐIỂM TB");
			 btnDIEMTB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
	                      if ( table.getRowCount() == 0) {
				            	JOptionPane.showMessageDialog(contentPane,
						                "VUI LÒNG THÊM SINH VIÊN KHI SẮP XẾP TÊN",
						                "THÔNG BÁO",
						                JOptionPane.INFORMATION_MESSAGE);
				            }else {
				            	TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
			                      table.setRowSorter(sorter);
			                      List<RowSorter.SortKey> sortKeys = new ArrayList<>();

			                      int columnIndexToSort = 8;
			                      sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
			                      sorter.setSortKeys(sortKeys);
			                      sorter.sort();
				            }
					}
				});

			 btnDIEMTB.setBounds(1050, 625, 100, 28);
			 contentPane.add(btnDIEMTB);
			 
			 
			 
			 
			 JButton btnlkCNTT = new JButton("CNTT");
			 btnlkCNTT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel dtm = (DefaultTableModel) table.getModel();
						final TableRowSorter<TableModel> sorter = new TableRowSorter<>(dtm);
						table.setRowSorter(sorter);
						String txt = "CNTT"; 
						sorter.setRowFilter(RowFilter.regexFilter(txt));
			            if (table.getRowCount() == 0) {
			            	JOptionPane.showMessageDialog(contentPane,
					                "VUI LÒNG THÊM SINH VIÊN KHI LỌC",
					                "THÔNG BÁO",
					                JOptionPane.INFORMATION_MESSAGE);
			            }
						
						
					}
				});

			 btnlkCNTT.setBounds(900, 675, 100, 28);
			 contentPane.add(btnlkCNTT);
			 
			 JButton btnlkKINHTE = new JButton("KINH TẾ");
			 btnlkKINHTE.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel dtm = (DefaultTableModel) table.getModel();
						final TableRowSorter<TableModel> sorter = new TableRowSorter<>(dtm);
						table.setRowSorter(sorter);
						String txt = "KINH TẾ";
						sorter.setRowFilter(RowFilter.regexFilter(txt));
						if (table.getRowCount() == 0) {
			            	JOptionPane.showMessageDialog(contentPane,
					                "VUI LÒNG THÊM SINH VIÊN KHI LỌC",
					                "THÔNG BÁO",
					                JOptionPane.INFORMATION_MESSAGE);
			            }
					}
				});

			 btnlkKINHTE.setBounds(1050, 675, 100, 28);
			 contentPane.add(btnlkKINHTE);

			 JButton btnlkall = new JButton("TẤT CẢ");
			 btnlkall.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel dtm = (DefaultTableModel) table.getModel();
						final TableRowSorter<TableModel> sorter = new TableRowSorter<>(dtm);
						table.setRowSorter(sorter);
						sorter.setRowFilter(null);
						if (table.getRowCount() == 0) {
			            	JOptionPane.showMessageDialog(contentPane,
					                "VUI LÒNG THÊM SINH VIÊN KHI LỌC",
					                "THÔNG BÁO",
					                JOptionPane.INFORMATION_MESSAGE);
			            }else {
			            	
			            }
					}
				});

			 btnlkall.setBounds(1220, 675, 100, 28);
			 contentPane.add(btnlkall);
			 
			 JButton btnthoat = new JButton("THOÁT");
			 btnthoat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int resp = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không ?", "Thoát?", JOptionPane.YES_NO_OPTION);
					    if (resp == JOptionPane.YES_OPTION) {
					    	dispose();
					    }
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
