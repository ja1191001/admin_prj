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
		//��ü �� ��
		int totalCount=mcd.getNum();
		//�� �������� ���� �� ��
		int pageScale=15;
		//��ü ������ ��
		int totalPage=0;
		
		totalPage=totalCount/pageScale;
		if(totalCount%pageScale!=0){totalPage++;}//�������� �����ϴ� ��� ������ �߰�
		
		int firstPage=(currentPage-1)/10;
		firstPage=firstPage*10+1;
		int lastPage=firstPage+9;
		
		if(totalPage<lastPage){lastPage=totalPage;}//������ �������� 10�������� �ȵ� ���
		
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
		
		if(endNum<=15){startNum=1;}//�ش��� �ְ� ��ȣ�� 15 ���̶�� ���۹�ȣ�� ������ 1��
		
		
		mvv.setStartNum(startNum);
		mvv.setEndNum(endNum);
		mvv.setColumName(columnName);
		mvv.setKeyword(keyword);
		
		return mvv;
	}

}//class
