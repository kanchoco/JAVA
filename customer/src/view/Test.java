package view;

import dao.DBConnecter;
import vo.CustomerVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import dao.CustomerDAO;

public class Test {
	public static void main(String[] args) {

		Connection connection = null;
		
//		try {
//			connection = DBConnecter.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally	{
//			if(connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					throw new RuntimeException(e.getMessage());
//				}
//			}
//		}
		
		CustomerDAO dao = new CustomerDAO();
		
//		if(dao.checkId("hds")) {
//			System.out.println("아이디 있음");
//		} else {
//			System.out.println("없는 아이디");
//		}
//		CustomerVO user = new CustomerVO();
//		user.setUserName("cddd");
//		user.setUserId("cddd123");
//		user.setUserPassword("123");
//		user.setUserPhoneNumber("01045677894");
//		user.setUserAge(25);
//		
//		dao.account(user);
//		
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		String id = sc.next();
		String pw = sc.next();
		
		if(dao.login(id, pw) != 0)	{
			System.out.println("로그인 성공");
		}else {System.out.println("로그인 실패");}
		
		
		
	}
}
