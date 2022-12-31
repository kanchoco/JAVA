package view;

import java.sql.Connection;
import java.util.Scanner;

import dao.BunjangDAO;
import dao.JungnaDAO;

public class Test {
	public static void main(String[] args) {
		Connection connection = null;
		
		BunjangDAO bunjang = new BunjangDAO();
		JungnaDAO jungna = new JungnaDAO();
		String keyword = null ;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("검색어 입력 > ");
		keyword = sc.nextLine();
		
//		bunjang.crawling();
		jungna.crawling(keyword);
		
		System.out.println("완료");
		
	
		
	
		
		
		
		
//		try {
//			connection= DBConnecter.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally	{
//			if(connection != null) {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e.getMessage());
//				}
//			}
//		}
	}
}