package quanlysinhvien_java;

public class Students {
    public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentSpecialization() {
		return studentSpecialization;
	}
	public void setStudentSpecialization(String studentSpecialization) {
		this.studentSpecialization = studentSpecialization;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentDateOfBirth() {
		return studentDateOfBirth;
	}
	public void setStudentDateOfBirth(String studentDateOfBirth) {
		this.studentDateOfBirth = studentDateOfBirth;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public String getScore1() {
		return score1;
	}
	public void setScore1(String score1) {
		this.score1 = score1;
	}
	public String getScore2() {
		return score2;
	}
	public void setScore2(String score2) {
		this.score2 = score2;
	}
	public String getScore3() {
		return score3;
	}
	public void setScore3(String score3) {
		this.score3 = score3;
	}
	public String getStudentGPA() {
		return studentGPA;
	}
	public void setStudentGPA(String studentGPA) {
		this.studentGPA = studentGPA;
	}
	
	private String studentID; //mã số sv
	private String studentSpecialization; //chuyên ngành
    private String studentName; //họ và tên
    private String studentDateOfBirth; //ngày sinh
    private String studentGender; //giới tính
    private String score1; //điểm 1
    private String score2; //điểm 2
    private String score3; //điểm 3
    private String studentGPA; //điểm trung bình
    
    public Students() {	
    }
    
    public Students(String studentID, String studentSpecialization, String studentName, String studentDateOfBirth, String studentGender, String score1, String score2, String score3, String studentGPA) {
    	this.studentID = studentID;
    	this.studentSpecialization = studentSpecialization;
    	this.studentName = studentName;
    	this.studentDateOfBirth = studentDateOfBirth;
    	this.studentGender = studentGender;
    	this.score1 = score1;
    	this.score2 = score2;
    	this.score3 = score3;
    	this.studentGPA = studentGPA;
    }
}
