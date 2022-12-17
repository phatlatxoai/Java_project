package quanlysinhvien_java;

public class SinhvienModel {
	

	private String Mssv;
	public SinhvienModel(String mssv, String cnghanh, String hoten, String nsinh, String gtinh, float diem1,
			float diem2, float diem3) {
		super();
		Mssv = mssv;
		Cnghanh = cnghanh;
		Hoten = hoten;
		Nsinh = nsinh;
		Gtinh = gtinh;
		Diem1 = diem1;
		Diem2 = diem2;
		Diem3 = diem3;
	}

	private String Hoten;

	private String Nsinh;

	private String Gtinh;

	private String Cnghanh;

	private float Diem1;

	private float Diem2;

	private float Diem3;
	
	private float Diemtb;
	
	private String Xephang;

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

	public float getDiem1() {
		return Diem1;
	}

	public void setDiem1(float diem1) {
		Diem1 = diem1;
	}

	public float getDiem2() {
		return Diem2;
	}

	public void setDiem2(float diem2) {
		Diem2 = diem2;
	}

	public float getDiem3() {
		return Diem3;
	}

	public void setDiem3(float diem3) {
		Diem3 = diem3;
	}

	public float getDiemtb() {
		
		Diemtb = (Diem1 + Diem2 + Diem3)/3;
		return Diemtb;
	}

	public void setDiemtb(float diemtb) {
		Diemtb = diemtb;
	}

	public String getXephang() {
		
		if (Diemtb >= 9) {
            Xephang = "Xuất sắc";
        } else if ((Diemtb >= 8) && (Diemtb < 9)) {
            Xephang = "Giỏi";
        } else if ((Diemtb >= 6.5) && (Diemtb < 8)) {
            Xephang = "Khá";
        } else if ((Diemtb > 5) && (Diemtb < 6.5)) {
            Xephang = "Trung bình";
        } else {
            Xephang = "Yếu";
        }
		return Xephang;
	}

	public void setXephang(String xephang) {
		Xephang = xephang;
	}

	

	

	
	

}
