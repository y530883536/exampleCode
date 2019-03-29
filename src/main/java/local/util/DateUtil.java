package local.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DateUtil {

	/**
	 * 获取两个时间相差的分钟数
	 * @param start
	 * @param end
	 * @return
	 */
	public static double getDiffMinute(Date start, Date end) {
		double diff = (end.getTime() - start.getTime()) / 1000 / 60 ;
		return diff;
	}

	/**
	 * 获取两个时间相差的小时数
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static double getDiffHour(Date start, Date end) {
		double diff = (end.getTime() - start.getTime()) / 1000 / 60 / 60;
		return diff;
	}

	/**
	 * 获取两个时间相差的天数
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDiffDay(Date start, Date end) {
		int diff = (int) ((end.getTime() - start.getTime()) / 1000 / 60 / 60 / 24);
		return diff;
	}

	/**
	 * 获取两个时间相差的天数 保留小数点
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static float getDiffDayOne(Date start, Date end) {
		BigDecimal diffTime = new BigDecimal(end.getTime() - start.getTime());
		BigDecimal d = new BigDecimal(1000 * 60 * 60 * 24);
		BigDecimal diff = diffTime.divide(d, 1, BigDecimal.ROUND_HALF_EVEN);
		return diff.floatValue();
	}

	/**
	 * 计算两个日期相差天数，忽略时间，只计算日期差
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDiffByDay(Date start, Date end) {
		String s = formatDataYYYYMMDDLine(start);
		String e = formatDataYYYYMMDDLine(end);
		start = toDataYYYYMMDDLine(s);
		end = toDataYYYYMMDDLine(e);
		int diff = (int) ((end.getTime() - start.getTime()) / 1000 / 60 / 60 / 24);
		return diff;
	}

	/**
	 * 计算两个日期相差的年份
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDiffYearByDate(Date start, Date end) {
		String s = formatDataYYYYMMDDLine(start);
		String e = formatDataYYYYMMDDLine(end);
		start = toDataYYYYMMDDLine(s);
		end = toDataYYYYMMDDLine(e);
		int diff = (int) ((end.getTime() - start.getTime()) / 1000 / 60 / 60 / 24 / 365);
		return diff;
	}

	public static String sdf = "yyyy-MM-dd";
	public static String sdf2 = "yyyyMMdd";
	public static String sdf3 = "yyMMdd";
	public static String sdf4 = "yyyy-MM-dd HH:mm:ss";
	public static String sdf5 = "yyyyMMddHHmmss";
	public static String sdf12 = "MMdd";
	public static String sdf6 = "yyyy年MM月dd日 HH:mm:ss";
	public static String sdf7 = "yyyy年MM月dd日 HH:mm";
	public static String sdf8 = "【yyyy】年【MM】月【dd】日";
	public static String sdf9 = "yyyy年MM月dd日";
	public static String sdf10 = "yyyyMM";
	public static String sdf11 = "yyyy.MM.dd";
	public static String sdf13 = "yyyyMMddHHmmssSSS";
	public static String sdf14 = "yyyy-MM";
	public static String sdf15 = "yyyy-MM-dd HH:mm";

	public static SimpleDateFormat yearFor = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat monthFor = new SimpleDateFormat("MM");
	public static SimpleDateFormat dayFor = new SimpleDateFormat("dd");

	public static String formatDataMM(Date date) {
		return monthFor.format(date);
	}

	public static String formatDataDD(Date date) {
		return dayFor.format(date);
	}

	public static Date toDataYYYY(String str) {
		try {
			return yearFor.parse(str);
		} catch (ParseException e) {
			log.error("",e);
		}
		return null;
	}

	public static Date toDataYYYYMMDDLine(String str) {
		try {
			return new SimpleDateFormat(sdf).parse(str);
		} catch (ParseException e) {
			log.error("",e);
		}
		return null;
	}

	public static Date toDataYYYYMMDDHHMMLine(String str) {
		try {
			return new SimpleDateFormat(sdf15).parse(str);
		} catch (ParseException e) {
			log.error("",e);
		}
		return null;
	}

	public static Date toDataYYYYMMDD(String str) {
		try {
			return new SimpleDateFormat(sdf2).parse(str);
		} catch (ParseException e) {
			log.error("",e);
		}
		return null;
	}

	public static Date toDataYYYYMM(String str) {
		try {
			return new SimpleDateFormat(sdf10).parse(str);
		} catch (ParseException e) {
			log.error("",e);
		}
		return null;
	}

	public static Date toDataYYYYMMDDHHMMSS(String str) {
		try {
			return new SimpleDateFormat(sdf4).parse(str);
		} catch (ParseException e) {
			log.error("",e);
		}
		return null;
	}

	public static String formatDataYYYYMM(Date date) {
		return new SimpleDateFormat(sdf10).format(date);
	}

	public static String formatDataYYYY(Date date) {
		return yearFor.format(date);
	}

	public static String formatDataYYYYMMDDK(Date date) {
		return new SimpleDateFormat(sdf8).format(date);
	}

	public static String formatDataYYYYMMDDC(Date date) {
		return new SimpleDateFormat(sdf9).format(date);
	}

	public static String formatDataYYYYMMDD(Date date) {
		return new SimpleDateFormat(sdf2).format(date);
	}

	public static String formatDataYYYYMMDDPoint(Date date) {
		return new SimpleDateFormat(sdf11).format(date);
	}

	public static String formatDataMMDD(Date date) {
		return new SimpleDateFormat(sdf12).format(date);
	}

	public static String formatDataYYMMDD(Date date) {
		return new SimpleDateFormat(sdf3).format(date);
	}

	public static String formatDataYYMMDDHHMMSS(Date date) {
		return new SimpleDateFormat(sdf5).format(date);
	}

	public static String formatDataYYYYMMDDLine(Date date) {
		return new SimpleDateFormat(sdf).format(date);
	}

	public static String formatDataToDatetime(Date date) {
		return new SimpleDateFormat(sdf4).format(date);
	}
	public static String formatDataToDatetimeLine(Date date) {
		return new SimpleDateFormat(sdf15).format(date);
	}

	public static String formatDataToYYYYMMDDHHMMSSSSS(Date date) {
		return new SimpleDateFormat(sdf13).format(date);
	}

	public static String formatDataToYYYYMMLine(Date date) {
		return new SimpleDateFormat(sdf14).format(date);
	}

	/**
	 * 获取当前日期month个月后的日期
	 *
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getAddMonthDate(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	/**
	 * 获取当前日期后的日期
	 *
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getAddDate(Date date, int day) {
		if (day == 0)
			return date;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

	/**
	 * 获取当前小时前后的日期
	 *
	 * @param 2date
	 * @param hours
	 * @return
	 */
	public static Date getHoursAgoTime(int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hours); // 把时间设置为当前时间-1小时，同理，也可以设置其他时间
		return calendar.getTime();
	}

	/**
	 * 格式化日期x年x月x日 xx:xx
	 *
	 * @param date
	 * @return
	 */
	public static String getZHDate(Date date) {
		String zhDate = new SimpleDateFormat(sdf6).format(date);
		return zhDate;
	}

	/**
	 * 按天借款的方式 返款时间的计算
	 *
	 * @param releaseTime
	 *            放款时间
	 * @param termCount
	 *            借款天数
	 * @return 还款日期
	 */
	public static Date getDayRepayDate(Date releaseTime, int termCount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(releaseTime);
		calendar.add(Calendar.DATE, termCount);
		return calendar.getTime();
	}

	/**
	 * 获取某天之前或者之后自然日 返回格式 ：yyyy-MM-dd
	 *
	 * @param releaseTime
	 * @param termCount
	 *            负数则为之前 正数则为之后
	 * @return
	 */
	public static String getNatureDay(Date releaseTime, int termCount) {
		Date date = getDayRepayDate(releaseTime, termCount);
		return new SimpleDateFormat(sdf).format(date);
	}

	/**
	 * 获取某天之前或者之后的几个月自然日 返回格式 ：yyyy-MM-dd
	 *
	 * @param date
	 * @param month
	 *            负数则为之前 正数则为之后
	 * @return
	 */
	public static String getNatureMonth(Date date, int month) {
		Date dateCal = getAddMonthDate(date, month);
		return new SimpleDateFormat(sdf).format(dateCal);
	}

	public static void main(String[] args) {
		/*String d = "2014-10-29 00:00:00";
		String d2 = "2014-10-29 00:00:00";
		try {
			System.out.println(getDiffByDay(new SimpleDateFormat(sdf4).parse(d), new SimpleDateFormat(sdf4).parse(d2)));
			System.out.println(getAddDate(new Date(), 3));
			int a = getYearThing(new Date()).get("day");
			System.out.println(a);
		} catch (ParseException e) {
			logger.error("",e);
		}*/

		LocalDate localDate = LocalDate.now();
	}

	// 获得年份和月份 2016.4.11
	public static Map<String, Integer> getYearThing(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Map<String, Integer> mp = new HashMap<String, Integer>();
		mp.put("month", calendar.get(Calendar.MONTH) + 1);
		mp.put("year", calendar.get(Calendar.YEAR));
		mp.put("day", calendar.get(Calendar.DAY_OF_MONTH));
		return mp;
	}

	// 判断闰年的方法：能被4整除同时不能被100整除或者能被400整除 2016.4.11。根据年份和月份计算
	public static int daysOfMonth(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return 29;
		}
		return 28;
	}

	// min分钟之前的时间
	public static String minBeforeToNow(Date date, int min) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - min);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(calendar.getTime());
	}

	/**
	 * @return 形如 yyyyMMddHHmmssSSS-Z0000019558195832297 的(28位)保证唯一的递增的序列号字符串，
	 *         主要用于数据库的主键，方便基于时间点的跨数据库的异步数据同步。
	 *         前半部分是currentTimeMillis，后半部分是nanoTime（正数）截取补齐10位的字符串，
	 *         如果通过System.nanoTime()获取的是负数，则通过nanoTime =
	 *         nanoTime+Long.MAX_VALUE+1; 转化为正数或零。
	 */
	public static String getTimeMillisSequence() {
		long nanoTime = System.nanoTime();
		String preFix = "";
		String nanoTimeStr = String.valueOf(nanoTime);

		int difBit = String.valueOf(Long.MAX_VALUE).length() - nanoTimeStr.length() - 10;
		for (int i = 0; i < difBit; i++) {
			preFix = preFix + "0";
		}
		nanoTimeStr = preFix + nanoTimeStr;
		nanoTimeStr = nanoTimeStr.substring(nanoTimeStr.length() - 10, nanoTimeStr.length());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); // 24小时制
		return sdf.format(System.currentTimeMillis()) + nanoTimeStr;
	}

	/**
	 * 计算date加减几个小时
	 * 
	 * @param date
	 * @param hours
	 * @return
	 */
	public static Date getAddHours(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hours);
		return calendar.getTime();
	}
	
	/**
	 * 获取指定日期是星期几
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date){  
        String[] weeks = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;  
        if (week_index < 0) {  
            week_index = 0;  
        }   
        return weeks[week_index];  
    }
	
	/**
	 * 获取某天之前或者之后自然日 返回格式 ：DATE
	 * 
	 * @param releaseTime
	 * @param termCount
	 *            负数则为之前 正数则为之后
	 * @return
	 */
	public static Date getNatureDayToDate(Date releaseTime, int termCount) {
		Date date = getDayRepayDate(releaseTime, termCount);
		return date;
	}

	/**
	 * 获取某天之前或者之后的几个月自然日 返回格式 ：DATE
	 * 
	 * @param date
	 * @param month
	 *            负数则为之前 正数则为之后
	 * @return
	 */
	public static Date getNatureMonthToDate(Date date, int month) {
		Date dateCal = getAddMonthDate(date, month);
		return dateCal;
	}

	/**
	 /* 
    * 将时间戳转换为时间
    */
   public static String stampToDate(String s) {
       String res;
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sdf4);
       long lt = new Long(s);
       Date date = new Date(lt);
       res = simpleDateFormat.format(date);
       return res;
   }
   
   public static Date getAddMinutes(Date sourceDate, int n) {
		Instant instant = sourceDate.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		return Date.from(localDateTime.plusMinutes(n).atZone(zone).toInstant());
	}


	public static Date getAddMonths(Date sourceDate, int n) {
		Instant instant = sourceDate.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		return Date.from(localDateTime.plusMonths(n).atZone(zone).toInstant());
	}

	//获取当前天数的最后时间，2018-10-1 08:00:00就是2018-10-1 23:59:59
	public static Date getDayEndTime(Date sourceDate){
		Date date = getAddDate(sourceDate, 1);
		date.setTime(date.getTime()-1000);
		return date;
	}

}
