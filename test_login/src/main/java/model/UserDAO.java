package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PRIVATE_MEMBER;

import model.DBManager;

public class UserDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	public void insertUser(UserDTO dto) {
		String sql = "INSERT INTO users VALUES(user_seq.nextval,?,?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_pw());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(pstmt, conn);
		}
	}

	public UserDTO loginOk(UserDTO dto) {
		UserDTO udto = new UserDTO();
		String id, pw;
		String sql = "select * from users where user_id=? and user_pw=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_pw());
			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				udto.setUser_id(rs.getString("user_id"));
				udto.setUser_pw(rs.getString("user_pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return udto;
	}

	/*
	 * public int userCheck(String id){
	 * 
	 * ArrayList<UserDTO> userlist = getAllUser(); for(UserDTO dto : userlist){
	 * if(id.equals(dto.getUser_id())){ return 1; } } return 0; }
	 */
}
