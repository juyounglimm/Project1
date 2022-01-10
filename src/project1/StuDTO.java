package project1;

public class StuDTO {
	String studentname,studentnumber,studentschool,studentaddr,studentclass;
	int studentID,korscore,mathscore,engscore,historyscore,teacherID;
	double avgg;
	//teacher table
	String teachername,teachernumber,teachersubject,teacherclass;
 
	
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getTeachernumber() {
		return teachernumber;
	}
	public void setTeachernumber(String teachernumber) {
		this.teachernumber = teachernumber;
	}
	public String getTeachersubject() {
		return teachersubject;
	}
	public void setTeachersubject(String teachersubject) {
		this.teachersubject = teachersubject;
	}
	public String getTeacherclass() {
		return teacherclass;
	}
	public void setTeacherclass(String teacherclass) {
		this.teacherclass = teacherclass;
	}
	public int getKorscore() {
		return korscore;
	}
	public void setKorscore(int korscore) {
		this.korscore = korscore;
	}
	public int getMathscore() {
		return mathscore;
	}
	public void setMathscore(int mathscore) {
		this.mathscore = mathscore;
	}
	public int getEngscore() {
		return engscore;
	}
	public void setEngscore(int engscore) {
		this.engscore = engscore;
	}
	public int getHistoryscore() {
		return historyscore;
	}
	public void setHistoryscore(int historyscore) {
		this.historyscore = historyscore;
	}
	public double getAvgg() {
		return avgg;
	}
	public void setAvgg(double avgg) {
		this.avgg = avgg;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentnumber() {
		return studentnumber;
	}
	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}
	public String getStudentschool() {
		return studentschool;
	}
	public void setStudentschool(String studentschool) {
		this.studentschool = studentschool;
	}
	public String getStudentaddr() {
		return studentaddr;
	}
	public void setStudentaddr(String studentaddr) {
		this.studentaddr = studentaddr;
	}
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	
}
