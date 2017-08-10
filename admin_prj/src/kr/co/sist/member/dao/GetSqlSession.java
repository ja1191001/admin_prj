package kr.co.sist.member.dao;

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
		//MyBatis로그를 남기기위한 method호출
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
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
				Reader reader = Resources.getResourceAsReader("kr/co/sist/member/dao/config/mybatis_config.xml");
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
