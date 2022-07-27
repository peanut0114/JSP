package co.edu.common;
//업무처리
public class MemberService {
	//싱글톤
	private static MemberService instance = new MemberService();	//생성자로 초기화
	private MemberService() {
		
	}
	public static MemberService getInstance() {
		return instance;
	}
	
	//필드
	MemberDAO dao = new MemberDAO();
	
	//입력기능 : 테이블에 맴버 추가
	
	public void memberAdd(MemberVO vo) {
		dao.insertMemeber(vo);
	}
}
