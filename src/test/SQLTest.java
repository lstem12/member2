package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.member.lib.common.Connector;


public class SQLTest {

	public static void main(String[] args) throws SQLException {
		Connection con = Connector.open();
		String sql = "insert into employee(emp_no, emp_name, emp_credat, emp_salary, grd_no)";
		sql += "values(seq_employee_emp_no.nextval, ?, sysdate,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		String[] fNames = {"김","박","이","최","송","신","유"};
		String[] lNames = {"영수","동수","진혁","미래","철수","미래","상화","상훈","상미","동동","인화","철원","강원","민상"};
		Random r = new Random();
		for(int i=1;i<=200;i++) {
			String fName = fNames[r.nextInt(fNames.length)];
			String lName = lNames[r.nextInt(lNames.length)];
			String name = fName + lName;
			int grade = r.nextInt(6)+1;
			int salary = (r.nextInt(5)+1) * 1000000;
			ps.setString(1,name);
			ps.setInt(2, salary);
			ps.setInt(3, grade);
			System.out.println(i + ":" + ps.executeUpdate());
		}
		con.commit();
	}
}
