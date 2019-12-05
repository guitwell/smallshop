package com.baizhi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyUtils {
	//将字符串转化为sqlDate的工具类
	public static java.sql.Date getSqlDate(String theday) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = null;
		try {
			utilDate = sdf.parse(theday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long dates = utilDate.getTime();
		java.sql.Date sqldate = new java.sql.Date(dates);

		return sqldate;
	}

	//将字符串转化为UtilDate的工具类
	public static Date getUtilDate(String date){
		//将字符串转化为UtilDate
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = null;
		try {
			utilDate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilDate;
	}

	//将UtilDate转化为SqlDate
	public static java.sql.Date utilTOsql(Date date){
		long dates = date.getTime();
		java.sql.Date sqldate = new java.sql.Date(dates);
		return sqldate;
	}
	//获取当前的utildate
	public static Date getNowUtilDate() {
		Date t = new Date();
		return t;
	}
	//生成一个去除了'-'的UUID
	public static String getUUIDs() {
		UUID uuid =UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.substring(0, 8) +str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) +str.substring(24);
		return temp;
	}

	//生成一个UUID
	public static String getUUID() {
		UUID uuid =UUID.randomUUID();
		return uuid.toString();
	}

	//输入一个  pageNo为当前页码  pageSize为每页数量 和一个大集合，返回一个该页的小集合
	public static <T> List<T> page(int pageNo, int pageSize, List<T> list) throws Exception {
		if(pageNo<1) {pageNo=1;}
		List<Object> result = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			int allCount = list.size();
			int pageCount = (allCount + pageSize - 1) / pageSize;
			if (pageNo >= pageCount) {
				pageNo = pageCount;
			}
			int start = (pageNo - 1) * pageSize;
			int end = pageNo * pageSize;
			if (end >= allCount) {
				end = allCount;
			}
			for (int i = start; i < end; i++) {
				result.add(list.get(i));
			}
		}
		return (List<T>) ((result != null && result.size() > 0) ? result : null);
	}
	//输入一个集合和其每页展示的数据条数返回其最大页数
	public static <T> Integer findBigestPage(List<T> list,Integer everyPageMessageNum) {
		Integer listsize = list.size();
		if (everyPageMessageNum>listsize) {
			everyPageMessageNum=listsize;
		}
		if(everyPageMessageNum<1) {
			everyPageMessageNum=1;
		}
		System.out.println(everyPageMessageNum+"=====================");
		Integer pages = listsize%everyPageMessageNum==0 ? listsize/everyPageMessageNum : listsize/everyPageMessageNum+1;
		System.out.println(pages+"=====================");
		if (pages<1) {
			pages=1;
		}
		return pages;
	}


	//生成当前时间String
	public static String pattern = "yyyy-MM-dd";
	public static SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	public static String getStringDate() {
		String dateString = formatter.format(new Date());
		return dateString;
	}

	//输入一个位数生成一个指定位的字符串类型的随机数
	public static String getRandom(int length){
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}

	//输入一个位数生成一个指定位的Integer类型的随机数(PS:Integer最大2147483647)
	public static Integer getIntegerRandom(int length){
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return Integer.valueOf(val);
	}
	//输入一个范围(这个范围不能为0-1)生成其范围内的的一个随机数(包含头尾不能为)
	public static Integer getIntegerformTowNumbers(Integer firstnum,Integer secondnum) {
		return new Random().nextInt(secondnum) + firstnum;
	}
	//输入一个范围生成其范围内的n个随机数
	public static List<Integer> getSomeRownumIntegers(Integer firstnum,Integer secondnum,Integer num){
		List<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i=0; i<num; i++) {
			list.add(rand.nextInt(secondnum)+firstnum);
		}
		return list;
	}


}











