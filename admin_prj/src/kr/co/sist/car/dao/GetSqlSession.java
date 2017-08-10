package kr.co.sist.car.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSqlSession {
	private static GetSqlSession gss;
	private static SqlSessionFactoryBuilder ssfb;
	private GetSqlSession(){
	}
	public static GetSqlSession getInstance(){
		if(gss==null){
			gss=new GetSqlSession();
		}//end if
		return gss;
	}//getInstance
	SqlSessionFactory ssf = null;
	private SqlSessionFactory getFactoryBuilder(){
		if(ssfb==null){
			ssfb=new SqlSessionFactoryBuilder();
			try {
				Reader reader = Resources.getResourceAsReader("kr/co/sist/car/config/mybatis_config.xml");
				ssf=ssfb.build(reader);
				
				if(reader!=null){reader.close();}//end if
				
			} catch (IOException e) {
				e.printStackTrace();
			}//end if
		}//end if
		return ssf;
	}//getFactoryBuilder
	public SqlSession getSqlSession(){
		SqlSession ss = getFactoryBuilder().openSession();
		return ss;
	}
}//class
