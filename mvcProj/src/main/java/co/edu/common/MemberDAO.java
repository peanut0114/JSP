package co.edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	//Oracle DB 정보
	private String jdbcDriver="oracle.jdbc.driver.OracleDriver";
	private String oracleUrl="jdbc:oracle:thin:@localhost:1521:xe";
	private String connectedId="hr";
	private String connectedPwd="hr";
	
	//공통으로 사용되는 필드 (자식클래스에서 쓰기 위해 protected)
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	//DB에 접속하는 메소드
	public void connect() {
		try {
			Class.forName(jdbcDriver); //드라이버 로딩		
			conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);//DriverManager클래스를 통해 넣어줌 (순서중요)
		}catch(ClassNotFoundException e) {	//원인이 명확히 다른 2가지 예외 구분해서 관리하기 
			System.out.println("jdbc driver 로딩 실패");
		}catch(SQLException e) {
			System.out.println("DB 연결 실패");
		}
	}
	
	//DB 접속을 해제하는 메소드
	public void disconnect() {
		try {
			if(rs != null) rs.close();	//인스턴스가 있는지 체크
			if(pstmt != null) pstmt.close();	//사용 안 된 필드를 닫으려 하면 NullPointExecption 발생
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {	//※ catch 문구 안은 비워두지 말 것! 
			e.printStackTrace();	//아무것도 안 뜨면 확인불가
		}
	}
	
	//입력처리
	public void insertMemeber(MemberVO vo) {
		String sql ="insert into member(id, name, password, mail) values(?,?,?,?)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getMail());
			
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
