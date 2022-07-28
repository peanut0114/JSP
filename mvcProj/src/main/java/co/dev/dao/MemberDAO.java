package co.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.dev.vo.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//서버에 있는 커넥션 툴을 가져온다
	public void connect() {
		try {
			//커넥션풀의 객체를 가져오기 위함
			InitialContext ic = new InitialContext();
			//커넥션풀에 등록해둔 리소스 이름(jdbc/myoracle)으로 가져옴(컨테이너마다 형태가 다름)
			//톰캣은 java:comp/env/
			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//connect()
	public void disconnect() {
		try {
			if(rs != null) 
				rs.close();	//인스턴스가 있는지 체크
			if(pstmt != null) 
				pstmt.close();	//사용 안 된 필드를 닫으려 하면 NullPointExecption 발생
			if(conn != null) 
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//입력
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
	
	//리스트 출력
	public List<MemberVO> getList(){
		List<MemberVO> list = new ArrayList<>();
		connect();
		String sql = "select * from member order by 1";
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("password"));
				vo.setMail(rs.getString("mail"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//단건조회 (id)
	public MemberVO searchMember(String id) {
		String sql = "select * from member where id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setMail(rs.getString("mail"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("password"));
				
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	//수정
	public void updateMember(MemberVO vo) {
		String sql = "UPDATE member "
				+ "SET name=?, password=? ,mail=? "
				+ "WHERE id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getMail());
			pstmt.setString(4, vo.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//삭제
	public void deleteMember(String id) {
		String sql="DELETE from member WHERE id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
