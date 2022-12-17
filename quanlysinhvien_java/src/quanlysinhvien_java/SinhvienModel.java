package quanlysinhvien_java;

public class SinhvienModel {
	
	public SinhvienModel(String mssv, String hoten, String nsinh, String gtinh, String cnghanh, String diem1,
			String diem2, String diem3) {
		super();
		Mssv = mssv;
		Hoten = hoten;
		Nsinh = nsinh;
		Gtinh = gtinh;
		Cnghanh = cnghanh;
		Diem1 = diem1;
		Diem2 = diem2;
		Diem3 = diem3;
	}

	private String Mssv;
	private String Hoten;

	private String Nsinh;

	private String Gtinh;

	private String Cnghanh;

	private String Diem1;

	private String Diem2;

	private String Diem3;

	public String getMssv() {
		return Mssv;
	}

	public void setMssv(String mssv) {
		Mssv = mssv;
	}

	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public String getNsinh() {
		return Nsinh;
	}

	public void setNsinh(String nsinh) {
		Nsinh = nsinh;
	}

	public String getGtinh() {
		return Gtinh;
	}

	public void setGtinh(String gtinh) {
		Gtinh = gtinh;
	}

	public String getCnghanh() {
		return Cnghanh;
	}

	public void setCnghanh(String cnghanh) {
		Cnghanh = cnghanh;
	}

	public String getDiem1() {
		return Diem1;
	}

	public void setDiem1(String diem1) {
		Diem1 = diem1;
	}

	public String getDiem2() {
		return Diem2;
	}

	public void setDiem2(String diem2) {
		Diem2 = diem2;
	}

	public String getDiem3() {
		return Diem3;
	}

	public void setDiem3(String diem3) {
		Diem3 = diem3;
	}

	
	

}
