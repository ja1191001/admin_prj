package kr.co.sist.rent.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.rent.dao.RentDAO;
import kr.co.sist.rent.domain.CarDetail;
import kr.co.sist.rent.domain.RentAble;
import kr.co.sist.rent.domain.Schedual;
import kr.co.sist.rent.domain.cntData;
import kr.co.sist.rent.domain.pageData;
import kr.co.sist.rent.vo.DataVO;
import kr.co.sist.rent.vo.DetailVO;
import kr.co.sist.rent.vo.RentInsertVO;
import kr.co.sist.rent.vo.ScheSearchVO;
import kr.co.sist.rent.vo.ScheVO;

@Component("rent_service")
public class RentService {
	@Autowired(required=false)
	private RentDAO rd;
	
	public List<Schedual> searchRent(ScheVO sv){
		List<Schedual> list=null;
		
		try {
			list=rd.selectRent(sv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ScheSearchVO inputData(String start_date, String end_date, String id){
		ScheSearchVO ssv=new ScheSearchVO();
		ssv.setStart_date(start_date);
		ssv.setEnd_date(end_date);
		ssv.setId(id);
		
		return ssv;
	}
	
	public ScheVO inputValue(cntData cd, int currentPage, String start_date, String end_date, String id){
		ScheVO sv=new ScheVO();
		int pageScale=15;
		int endNum=cd.getNum()-(currentPage-1)*pageScale;
		int startNum=endNum-14;
		
		if(endNum<=15){
			startNum=1;
		}
		
		sv.setStart_num(startNum);
		sv.setEnd_num(endNum);
		sv.setStart_date(start_date);
		sv.setEnd_date(end_date);
		sv.setId(id);
		
		return sv;
	}
	
	public pageData searchPage(int currentPage, cntData cd){
		pageData pd=new pageData();
		
		int totalCount=cd.getNum();
		int pageScale=15;
		int totalPage=0;
		
		totalPage=totalCount/pageScale;
		if(totalCount%pageScale!=0){
			totalPage++;
		}
		
		int firstPage=(currentPage-1)/10;
		firstPage=firstPage*10+1;
		int lastPage=firstPage+9;
		
		if(totalPage<lastPage){
			lastPage=totalPage;
		}
		
		pd.setTotalPage(totalPage);
		pd.setFirstPage(firstPage);
		pd.setLastPage(lastPage);
		pd.setCurrentPage(currentPage);
		
		return pd;
	}
	
	public cntData searchCnt(ScheSearchVO ssv){
		cntData cd=null;
		
		try {
			cd=rd.selectCnt(ssv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cd;
	}
	
	public boolean removeSchedual(String resev_num){
		boolean flag=false;
		
		try {
			if(rd.deleteRent(resev_num)==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public List<RentAble> searchRentAble(DataVO dv){
		List<RentAble> list=null;
		
		try {
			list=rd.selectRentAble(dv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public CarDetail searchDetailCar(DetailVO dv){
		CarDetail cd=null;
		
		try {
			cd=rd.selectDetail(dv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cd;
	}
	
	public boolean addRent(RentInsertVO riv){
		boolean flag=false;
		
		try {
			if(rd.insertRent(riv)==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean searchMember(String id){
		boolean flag=false;
		
		try {
			if(rd.selectMember(id)!=null){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
