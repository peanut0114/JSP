package com.tst.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tst.common.DAO;

public class BoardDAO extends DAO{

	//등록
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board values("
				+ "(select nvl(MAX(board_id),0)+1 from board),"
				+ "?,?,?,sysdate,0)";
		connect();	//DB와 연결
		try {
			pstmt = conn.prepareStatement(sql); //pstmt를 통해 데이터를 주고받음
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	//목록
	public List<BoardVO> boardList(){
		List<BoardVO> list= new ArrayList();
		try {
			connect();
			String sql = "select * from board order by 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id")
										,rs.getString("title")
										,rs.getString("content")
										,rs.getString("writer")
										,rs.getString("create_date")
										,rs.getInt("cnt"));
				list.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	//단건조회
	public BoardVO getBoard(int boardNo) {
		String sql = "select * from board where board_id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			//key값이기 때문에 결과는 0 또는 1개
			if(rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id")
						,rs.getString("title")
						,rs.getString("content")
						,rs.getString("writer")
						,rs.getString("create_date")
						,rs.getInt("cnt"));
				
				setCnt(boardNo);	//출력 후 조회수 증가
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	//조회수증가
	public void setCnt(int boardNo) {
		String sql = "update board set cnt=cnt+1 where board_id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//글내용 수정
	public void updateBoard(BoardVO vo) {
		String sql = "update board set title=?, content=? where board_id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardId());
			
			int r = pstmt.executeUpdate();	//쿼리 실행
			System.out.println(r+"건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	//삭제
	public void deleteBoard(int boardNo) {
		String sql = "delete from board where board_id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			int r = pstmt.executeUpdate();	//쿼리 실행
			System.out.println(r+"건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//로그인체크
	public UserVO loginCheck(String id, String pass) {
		String sql = "select * from users where id=? and passwd=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}
