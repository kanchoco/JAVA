package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import vo.CustomerVO;

public class CustomerDAO {
//	- id중복검사
//	- 회원가입(동일한 핸드폰 번호로 최대 3번 가입 가능)
//		* 일반계정 2개, 탈퇴계정 1개 -> 가입 불가능
//	- 로그인
//	- 아이디 찾기
//	- 회원정보 수정
//	- 회원번호로 회원 전체 정보 검색
//	- 회원탈퇴(어떤 계정을 탈퇴할 지 선택)
//	- 회원탈퇴 복구(어떤 계정을 복구할 지 선택)
//	연결객체
	public Connection connection;
//	쿼리 객체
	public PreparedStatement preparedStatement;
//	결과 테이블 객체
	public ResultSet resultSet;
	
	public boolean checkId(String id)	{
		String query  = "select count(userId) from tbl_user where userId  = ?";
		
		boolean check = false;
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			
			check = resultSet.getInt(1) == 1;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("checkId() 쿼리문 오류");
		} finally {							//무조건 실행, 
	         try {
//	            연결 객체 모두 닫기
	            if(resultSet != null) {
	               resultSet.close();
	            }
	            if(preparedStatement != null) {
	               preparedStatement.close();
	            }
	            if(connection != null) {
	               connection.close();
	            }
	         } catch (SQLException e) {
	            throw new RuntimeException(e.getMessage());
	         }
	      }
		
		return check;
	}
//	- 회원가입(동일한 핸드폰 번호로 최대 3번 가입 가능)
//		* 일반계정 2개, 탈퇴계정 1개 -> 가입 불가능
	
	public void account(CustomerVO customer)	{
		String query = "INSERT INTO tbl_user(userId, userPassword, userName, userAge, userPhoneNumber, userBirth) VALUES(?, ?, ?, ?, ?, ?)";
		int i = 0;
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(++i, customer.getUserId());
			preparedStatement.setString(++i, customer.getUserPassword());
			preparedStatement.setString(++i, customer.getUserName());
			preparedStatement.setInt(++i, customer.getUserAge());
			preparedStatement.setString(++i, customer.getUserPhoneNumber());
			preparedStatement.setString(++i, customer.getUserBirth());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("account() 오류");
		}  finally {							//무조건 실행, 
	         try {
//		            연결 객체 모두 닫기
		            if(resultSet != null) {
		               resultSet.close();
		            }
		            if(preparedStatement != null) {
		               preparedStatement.close();
		            }
		            if(connection != null) {
		               connection.close();
		            }
		         } catch (SQLException e) {
		            throw new RuntimeException(e.getMessage());
		         }
		      }		
	}
//	- 로그인
	public int login(String id, String password)	{
		String query = "select userNumber from tbl_user where userId  = ? and userPassword  = ?";
		int userNumber = 0;
		try {
			connection = DBConnecter.getConnection();
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userNumber = resultSet.getInt("userNumber");
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("login() 에러");
		} finally {							//무조건 실행, 
	         try {
//		            연결 객체 모두 닫기
		            if(resultSet != null) {
		               resultSet.close();
		            }
		            if(preparedStatement != null) {
		               preparedStatement.close();
		            }
		            if(connection != null) {
		               connection.close();
		            }
		         } catch (SQLException e) {
		            throw new RuntimeException(e.getMessage());
		         }
		      }		
		return userNumber;
	}
	
//	- 아이디 찾기
	public void findId(String phoneNum)	{
		String query = "select userId from tbl_user where userPhoneNumber  = ?";
		
		try {
				connection = DBConnecter.getConnection();
				
			
			
		} catch (SQLException e) {
		}
	}
	
	
	
	
	
}
