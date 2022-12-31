package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.BungaeVO;
import vo.DanggeunVO;
import vo.JoonggoVO;
import vo.TotalDTO;

public class TotalDAO {

	public Connection connection; // 연결 객체
	public PreparedStatement preparedStatement; // 쿼리(SQL문) 객체
	public ResultSet resultSet; // 결과 테이블 객체

//   검색 결과 저장하기_중고나라
	public void joonggoResult(JoonggoVO joonggoVO) {
		String query = "INSERT INTO TBL_JOONGGO "
				+ "(JOONGGO_PRODUCTNUMBER, JOONGGO_NAME, JOONGGO_PRICE, JOONGGO_ADDRESS, JOONGGO_DATE, JOONGGO_URL) "
				+ "VALUES(JOONGGO_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, joonggoVO.getName());
			preparedStatement.setString(2, joonggoVO.getPrice());
			preparedStatement.setString(3, joonggoVO.getAddress());
			preparedStatement.setString(4, joonggoVO.getDate());
			preparedStatement.setString(5, joonggoVO.getUrl());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("joonggoResult에서 쿼리문 오류");
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

// 검색 결과 저장하기_당근
	public void danggeunResult(DanggeunVO danggeunVO) {
		String query = "INSERT INTO TBL_DANGGEUN "
				+ "(DANGGEUN_PRODUCTNUMBER, DANGGEUN_NAME, DANGGEUN_PRICE, DANGGEUN_ADDRESS, DANGGEUN_DATE, DANGGEUN_URL) "
				+ "VALUES(DANGGEUN_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, danggeunVO.getName());
			preparedStatement.setString(2, danggeunVO.getPrice());
			preparedStatement.setString(3, danggeunVO.getAddress());
			preparedStatement.setString(4, danggeunVO.getDate());
			preparedStatement.setString(5, danggeunVO.getUrl());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("danggeunResult에서 쿼리문 오류");
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

// 검색 결과 저장하기_번개
	public void bungaeResult(BungaeVO bungaeVO) {
		String query = "INSERT INTO TBL_BUNGAE "
				+ "(BUNGAE_PRODUCTNUMBER, BUNGAE_NAME, BUNGAE_PRICE, BUNGAE_ADDRESS, BUNGAE_DATE, BUNGAE_URL) "
				+ "VALUES(BUNGAE_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bungaeVO.getName());
			preparedStatement.setString(2, bungaeVO.getPrice());
			preparedStatement.setString(3, bungaeVO.getAddress());
			preparedStatement.setString(4, bungaeVO.getDate());
			preparedStatement.setString(5, bungaeVO.getUrl());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("danggeunResult에서 쿼리문 오류");
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	
	// 검색 결과 저장하기_통합
		public void totalResult(TotalDTO totalDTO) {
			String query = "INSERT INTO TBL_TOTAL "
					+ " (TOTAL_PRODUCTNUMBER, TOTAL_COMPANYNAME, TOTAL_NAME, TOTAL_PRICE, TOTAL_ADDRESS, TOTAL_DATE, TOTAL_URL) "
					+ " VALUES(TOTAL_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";

			try {
				connection = DBConnector.getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, totalDTO.getCompanyName());
				preparedStatement.setString(2, totalDTO.getName());
				preparedStatement.setString(3, String.valueOf(totalDTO.getPrice()));
				preparedStatement.setString(4, totalDTO.getAddress());
				preparedStatement.setString(5, totalDTO.getDate());
				preparedStatement.setString(6, totalDTO.getUrl());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("totalResult에서 쿼리문 오류");
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
}
