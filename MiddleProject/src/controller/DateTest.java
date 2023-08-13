package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;

public class DateTest {
	
	private String sc_no;
	private String sc_title;
	private Date sc_sdate;
	private String sc_edate;
	private String users_no;
	
	
	public static void main(String[] args) {
		SqlSession session = MybatisUtil.getSqlSession();
		Date res = session.selectOne("tourism.date");

//		Date date = null;
//		try {
//			date = new SimpleDateFormat("yyyyMMdd").parse(res);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("res=======>"+res);
//		System.out.println("date =====>"+date);
		
	}
}
