package co.dev.service;

import java.util.List;

import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVO;

//업무처리하는 비지니스 로직
public class MemberService {
	//싱글톤
	private static MemberService instance = new MemberService();
	private MemberService() {}
	public static MemberService getInstance() {
		return instance;
	}

	MemberDAO dao = new MemberDAO();
	
	//회원가입
	public void addMember(MemberVO vo) {
		dao.insertMemeber(vo);
	}
	
	//회원목록
	public List<MemberVO> memberList(){
		return dao.getList();
	}
	
	//회원조회
	public MemberVO getMember(String id) {
		return dao.searchMember(id);
	}
	
	//회원정보수정
	public void modifyMember(MemberVO vo) {
		dao.updateMember(vo);
	}
	
	//회원정보 삭제
	public boolean deleteMember(String id) {
		return dao.deleteMember(id);
	}
}
