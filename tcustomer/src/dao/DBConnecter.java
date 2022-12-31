package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
   public static Connection getConnection() {
      Connection connection = null;
      try {
//         연결에 필요한 정보
         String userName = "root"; // 오라클 ID
         String password = "1234"; // 오라클 비번
         String url = "jdbc:mysql://localhost:3306/customer";

//         드라이버를 메모리에 할당
         Class.forName("com.mysql.cj.jdbc.Driver");

//         정보를 전달하여 연결 객체 가져오기
         connection = DriverManager.getConnection(url, userName, password);

         System.out.println("연결 성공");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         System.out.println("드라이버 로딩 실패");
//      이렇게 catch로 오류들 출력해놓으면 어디서 잘못됬는지 알수있다.

      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("연결 실패");

      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("알 수 없는 오류");
      }
      return connection;
   }

}