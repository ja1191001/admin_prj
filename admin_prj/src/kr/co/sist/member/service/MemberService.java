package kr.co.sist.member.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.member.dao.MemberDAO;
import kr.co.sist.member.domain.MemberCntData;
import kr.co.sist.member.domain.MemberData;
import kr.co.sist.member.domain.MemberPageData;
import kr.co.sist.member.vo.MemberSearchVO;
import kr.co.sist.member.vo.MemberValueVO;

@Component("member_service")
public class MemberService {
	@Autowired
	private MemberDAO md;

	
	public List<MemberData> searchMember(MemberValueVO mvVO){
		md= new MemberDAO();
		List<MemberData> list = null;
		try {
			list=md.selectMember(mvVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return list;
	}//searchMember
	
	public boolean updatem(String id){
		boolean flag=false;
		
		try {
			if(md.updateMember(id)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//updatem
	
	public MemberPageData searchMemberPage(int currentPage, MemberCntData mcd){
		MemberPageData mpd=new MemberPageData();
		//전체 글 수
		int totalCount=mcd.getNum();
		//한 페이지에 나올 글 수
		int pageScale=15;
		//전체 페이지 수
		int totalPage=0;
		
		totalPage=totalCount/pageScale;
		if(totalCount%pageScale!=0){totalPage++;}//나머지가 존재하는 경우 페이지 추가
		
		int firstPage=(currentPage-1)/10;
		firstPage=firstPage*10+1;
		int lastPage=firstPage+9;
		
		if(totalPage<lastPage){lastPage=totalPage;}//마지막 페이지가 10페이지가 안될 경우
		
		mpd.setTatalPage(totalPage);
		mpd.setFirstPage(firstPage);
		mpd.setLastPage(lastPage);
		mpd.setCurrentPage(currentPage);
		return mpd;
	}//searchMemberPage
	
	public MemberSearchVO inputSearchValue( String columnName, String keyword){
		MemberSearchVO msVO=new MemberSearchVO();
		
		msVO.setColumnName(columnName);
		msVO.setKeyword(keyword);
		
		return msVO;
	}//inputSearchValue
	
	public MemberCntData searchMemberCnt(MemberSearchVO msVO){
		
		MemberCntData mcd=null;
		
		try {
			mcd=md.selectmemberCnt(msVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return mcd;
	}//searchMemberCnt

	public MemberValueVO inputValue(MemberCntData qcd, int currentPage, String columnName, String keyword){
		MemberValueVO mvv=new MemberValueVO();
		int pageScale=15;
		
		int endNum=qcd.getNum()-(currentPage-1)*pageScale; 
		int startNum=endNum-14;
		
		if(endNum<=15){startNum=1;}//해당목록 최고 번호가 15 밑이라면 시작번호는 무조건 1번
		
		
		mvv.setStartNum(startNum);
		mvv.setEndNum(endNum);
		mvv.setColumName(columnName);
		mvv.setKeyword(keyword);
		
		return mvv;
	}

}//class
