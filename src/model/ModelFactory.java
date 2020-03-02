package model;

import java.sql.*;
import java.util.ArrayList;

public class ModelFactory {
	// ѧ����¼����
	public static SLogin stulogin(int sid, String spw) throws SQLException,
			ClassNotFoundException {
		SLogin re = null;
		String sql = "select * from student where sid =" + sid + " and spw='"
				+ spw + "'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if (rs.next()) {
			re = new SLogin(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		return re;
	}
	// ��ʦ��¼����
	public static TLogin tealogin(int tid, String tpw) throws SQLException,
			ClassNotFoundException {
		TLogin re = null;
		String sql = "select * from teacher where tid =" + tid + " and tpw='"
				+ tpw + "'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if (rs.next()) {
			re = new TLogin(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		return re;
	}
	// ����Ա��¼����
	public static AdLogin adLogin(String adname, String adpsw)
			throws SQLException, ClassNotFoundException {
		AdLogin re = null;
		String sql = "select * from admin where adname =" + adname
				+ " and adpsw='" + adpsw + "'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if (rs.next()) {
			re = new AdLogin(rs.getString(1), rs.getString(2));
		}
		return re;
	}
	/*
	 * 
	 * ����Ա����
	 */
	// ��������Ա
	public static AddAdmin AddAdmin(String adname, String adpsw)
			throws Exception {
		AddAdmin re = null;
		String sql = "select * from admin where adname ='" + adname
				+ "' and adpsw='" + adpsw + "'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if (rs.next()) {
			re = new AddAdmin(rs.getString(1), rs.getString(2));
		}
		if (re == null) {
			String sql1 = "insert into admin values('" + adname + "','" + adpsw
					+ "')";
			boolean rs1 = DataConnection.getStat().execute(sql1);
		}
		return re;
	}
	// ����ѧ��
	public static AddStudent AddStudent(int stuId, String stupsw,
			String stuName, String sex, String department, String stuClass)
			throws SQLException, ClassNotFoundException {
		AddStudent re = null;
		String sql = "select * from student where sid ='" + stuId + "'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if (rs.next()) {
			re = new AddStudent(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6));
		}
		if (re == null) {
			String sql1 = "insert into student values('" + stuId + "','"
					+ stupsw + "','" + stuName + "','" + sex + "','"
					+ department + "','" + stuClass + "')";
			boolean rs1 = DataConnection.getStat().execute(sql1);
		}
		return re;
	}
	// ��ӿγ�
	public static AddCourses AddCourses(String cname, String cteacher,
			String ctime, String state) throws SQLException,
			ClassNotFoundException {
		AddCourses re = null;
		String sql = "select * from course where cteacher ='" + cteacher
				+ "' and ctime='" + ctime + "'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if (rs.next()) {
			re = new AddCourses(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5));
		}
		if (re == null) {
			String sql1 = "insert into course values(null" + ",'" + cname
					+ "','" + cteacher + "','" + ctime + "','" + state + "')";
			boolean rs1 = DataConnection.getStat().execute(sql1);
		}
		return re;
	}
	// ���ӽ�ʦ
	public static Teacher AddTeacher(String tpw, String tname, String tsex)
			throws SQLException, ClassNotFoundException {
		Teacher re = null;
		String sql2 = "select * from teacher where tname ='" + tname + "'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql2);
		if (rs.next()) {
			re = new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs
					.getString(4));
		}
		if (re == null) {
			String sql = "insert into teacher values(null,'" + tpw + "','"
					+ tname + "','" + tsex + "')";
			boolean rs1 = DataConnection.getStat().execute(sql);
		}
		return re;
	}
	// �鿴����Ա
	public static ArrayList<AddAdmin> LookAdmin(java.sql.Statement statement)
			throws SQLException {
		String sql = "select * from admin";
		ResultSet rs = statement.executeQuery(sql);
		AddAdmin s = null;
		ArrayList<AddAdmin> results = new ArrayList<AddAdmin>();
		while (rs.next()) {
			s = new AddAdmin(rs.getString(1), rs.getString(2));
			results.add(s);
		}
		return results;
	}
	// �鿴ѧ��
	public static ArrayList<AddStudent> LookStu(java.sql.Statement statement)
			throws SQLException {
		String sql = "select * from student";
		ResultSet rs = statement.executeQuery(sql);
		AddStudent s = null;
		ArrayList<AddStudent> results = new ArrayList<AddStudent>();
		while (rs.next()) {
			s = new AddStudent(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6));
			results.add(s);
		}
		return results;

	}
	// �鿴��ʦ
	public static ArrayList<Teacher> LookTeacher(java.sql.Statement statement)
			throws SQLException {
		String sql = "select * from teacher";
		ResultSet rs = statement.executeQuery(sql);
		Teacher t = null;
		ArrayList<Teacher> results = new ArrayList<Teacher>();
		while (rs.next()) {
			t = new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs
					.getString(4));
			results.add(t);
		}
		return results;
	}
	// �鿴�γ�
	public static ArrayList<AddCourses> LookCourses(java.sql.Statement statement)
			throws SQLException {
		String sql = "select * from course";
		ResultSet rs = statement.executeQuery(sql);
		AddCourses t = null;
		ArrayList<AddCourses> results = new ArrayList<AddCourses>();
		while (rs.next()) {
			t = new AddCourses(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5));
			results.add(t);
		}
		return results;
	}
	// �޸ĸ�������
	public static void changePsw( Statement stat,String adname,String psw) throws Exception{
		String sql ="update admin set adpsw = '"+ psw +"' where adname = '"+ adname +"'";	
		stat.executeUpdate(sql);
	}
	// ɾ���γ�
	public static void deleteCourse( Statement stat,int id) throws Exception{
		String sql ="delete from course where cid ="+id;	
		stat.executeUpdate(sql);
	}	
	// ɾ����ʦ
	public static void deleteTeacher( Statement stat,int id) throws Exception{
		String sql ="delete from teacher where tid ="+id;	
		stat.executeUpdate(sql);
	}
	// ɾ��ѧ��
	public static void deleteStudent( Statement stat,int id) throws Exception{
		String sql ="delete from student where sid ="+id;	
		stat.executeUpdate(sql);
	}	
	/*
	 * ��ʦ����
	 * */
	//�鿴�γ�
	public static ArrayList<AddCourses> TLookCourse(Statement statement) throws SQLException{
		String sql = "select * from course where cteacher in (select tname from teacher where tid ="+ TLogin.getTid() +")";
		ResultSet rs = statement.executeQuery(sql);
		AddCourses c = null;
		ArrayList<AddCourses> results = new ArrayList<AddCourses>();
		while (rs.next()) {
			c = new AddCourses(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5));
			results.add(c);
		}
		return results;
	}	
	//�鿴ѧ��
	public static ArrayList<CourseSelection> CourseSelection(Statement statement) throws SQLException{
		String sql = "select course.cname,course.ctime,student.sid,student.sname,student.ssex,student.department,student.class from student,course,grade where grade.sid = student.sid and grade.cid = course.cid and course.cteacher = '"+TLogin.getTname()+"'";
		ResultSet rs = statement.executeQuery(sql);
		CourseSelection cs = null;
		ArrayList<CourseSelection> results = new ArrayList<CourseSelection>();
		while(rs.next()){
			cs = new CourseSelection(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			results.add(cs);
		}
		return results;
	}
	//�鿴�ɼ�
	public static ArrayList<Grade> Grade(Statement statement) throws SQLException{
		String sql ="select student.sid,student.sname,course.cname,course.ctime,grade.result from student,course,grade where grade.sid = student.sid and grade.cid = course.cid and course.cteacher = '"+TLogin.getTname()+"'";
		ResultSet rs = statement.executeQuery(sql);
		Grade gd = null;
		ArrayList<Grade> results = new ArrayList<Grade>();
		while(rs.next()){
			gd = new Grade(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
		    results.add(gd);
		}
		return results;
	}	
	//�޸Ŀ���״̬
	public static void changeCourse( Statement stat,int cid) throws Exception{
		String sql = "select state from course where cid = "+cid; 
		ResultSet res = stat.executeQuery(sql);
		if(res.next()){
			String cs = "���";
			if(res.getString(1).equals(cs)){
				String sqls ="update course set state = '����' where cid = "+cid;
				stat.executeUpdate(sqls);
			}	
			else
			{
				String sqld ="update course set state = '���' where cid = "+cid;
				stat.executeUpdate(sqld);
			}	
		}
	}
	//�޸ĵ��Ƴɼ�
	public static void changeResult( Statement stat,String cname,int sid,int result) throws Exception{
		String sql ="update grade set result = "+ result +" where sid = "+ sid +" and cid in (select cid from course where cname ='"+cname+"')";	
		stat.executeUpdate(sql);
	}
	//���ӿγ�ѧ��
	public static void addCourseStu( Statement stat,int cid,int sid) throws Exception{
		String sql ="insert into grade values("+sid+","+cid+","+"-1)";
		stat.executeUpdate(sql);
	}
	//ɾ��ѧ��
	public static void deleteCourseStu( Statement stat,String cname,int sid) throws Exception{
		String sql ="delete from grade where sid = "+sid+" and cid in(select cid from course where cname = '"+cname+"')";
		stat.executeUpdate(sql);
	}
	/*
	 * ѧ������
	 * */ 
	//�鿴�ɼ�
	public static ArrayList<StuGrade> StuGrade(Statement statement) throws SQLException{
		String sql ="select course.cname,grade.result from student,course,grade where grade.cid = course.cid and grade.sid = student.sid and grade.sid ="+SLogin.getSid();
		ResultSet rs = statement.executeQuery(sql);
		StuGrade sgd = null;
		ArrayList<StuGrade> results = new ArrayList<StuGrade>();
		while(rs.next()){
			sgd = new StuGrade(rs.getString(1), rs.getString(2));
		    results.add(sgd);
		}
		return results;
	} 	
}
