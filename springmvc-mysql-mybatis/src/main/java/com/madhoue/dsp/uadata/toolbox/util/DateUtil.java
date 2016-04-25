/**
 *
 */
package com.madhoue.dsp.uadata.toolbox.util;


import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期、时间类
 */
public class DateUtil {

    /**
     * 日期转换
     *
     * @param date
     * @param fmt  : yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatTime(Date date, String fmt) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.format(date);
    }
    public static String getDate(){
        try {
            return DateUtil.formatDate(new Date(), "yyyy-MM-dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String getPreDate(){
        try {
            Date preDate= DateUtils.addDays(new Date(), -1);
            return DateUtil.formatDate(preDate, "yyyy-MM-dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 日期转换
     *
     * @param time
     * @param fmt  : yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatTime(Timestamp time, String fmt) {
        if (time == null) {
            return "";
        }
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.format(time);
    }

    /**
     * 获取系统当前时间（秒）
     *
     * @return
     */
    public static Timestamp getTime() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取系统当前时间（毫秒）
     *
     * @return
     */
    public static long getTimeToMillisecond() {
        return new Date().getTime();
    }

    /**
     * 获取当前日期(时间 00:00:00)
     *
     * @return
     */
    public static Timestamp getDateFirst() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取当前日期(时间 23:59:59)
     *
     * @return
     */
    public static Timestamp getDateLast() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

//    /**
//     * 获取当前日期
//     *
//     * @return
//     */
//    public static Date getDate() {
//        Calendar calendar = Calendar.getInstance();
//        return calendar.getTime();
//    }

    /**
     * yyyy-MM-dd HH:mm:ss 转换成 Timestamp
     *
     * @param timeString
     * @return
     */
    public static Timestamp getTime(String timeString) {
        return Timestamp.valueOf(timeString);
    }

    /**
     * 自定义格式的字符串转换成日期
     *
     * @param timeString
     * @param fmt
     * @return
     * @throws Exception
     */
    public static Timestamp getTime(String timeString, String fmt) throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        Date date = myFormat.parse(timeString);
        myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return getTime(myFormat.format(date));
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param fmt
     * @return
     * @throws Exception
     */
    public static String formatDate(Date date, String fmt) throws Exception {
        if (date == null) {
            return "";
        }
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.format(date);
    }

    public static String formatDateS(Date date, String fmt) {
        try {
            if (date == null) {
                return "";
            }
            SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
            return myFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 返回日期或者时间，如果传入的是日期，返回日期的 00:00:00 时间
     *
     * @param timeString
     * @return
     * @throws Exception
     */
    public static Timestamp getDateFirst(String timeString) throws Exception {
        if (timeString == null || timeString.equals("")) {
            return null;
        }
        if (timeString.length() > 10) {
            return getTime(timeString, "yyyy-MM-dd HH:mm:ss");
        } else {
            return getTime(timeString, "yyyy-MM-dd");
        }
    }

    /**
     * 返回日期或者时间，如果传入的是日期，返回日期的 23:59:59 时间
     *
     * @param timeString
     * @return
     * @throws Exception
     */
    public static Timestamp getDateLast(String timeString) throws Exception {
        if (timeString == null || timeString.equals("")) {
            return null;
        }
        if (timeString.length() > 10) {
            return getTime(timeString, "yyyy-MM-dd HH:mm:ss");
        } else {
            return getTime(timeString + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 获取本周周一时间，返回格式 yyyy-MM-dd 00:00:00
     *
     * @return
     */
    public static Timestamp getMonday() {
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0)
            dayofweek = 7;
        calendar.add(Calendar.DATE, -dayofweek + 1);
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }


    /**
     * 获取本周周日时间，返回格式 yyyy-MM-dd 23:59:59
     *
     * @return
     */
    public static Timestamp getSunday() {
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0)
            dayofweek = 7;
        calendar.add(Calendar.DATE, -dayofweek + 7);
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 增加天数
     *
     * @param time
     * @param day
     * @return
     */
    public static Timestamp addDay(Timestamp time, Long day) {
        Timestamp time2 = new Timestamp(time.getTime() + day * 1000 * 60 * 60 * 24);
        return time2;
    }

    /**
     * 比较 2 个日期格式的字符串
     *
     * @param str1 格式 ：yyyyMMdd
     * @param str2 格式 ：yyyyMMdd
     * @return
     */
    public static Integer compareDate(String str1, String str2) throws Exception {
        return Integer.parseInt(str1) - Integer.parseInt(str2);
    }

    /**
     * 2 个时间的相差天数
     *
     * @param time1
     * @param time2
     * @return
     */
    public static Integer getDay(Timestamp time1, Timestamp time2) {
        Long dayTime = (time1.getTime() - time2.getTime()) / (1000 * 60 * 60 * 24);
        return dayTime.intValue();
    }

    /**
     * 获取系统当前时间（分）
     *
     * @return
     */
    public static String getMinute() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return myFormat.format(new Date());
    }

    /**
     * 转换成时间 字符串格式必须为 yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd
     *
     * @return
     * @throws java.text.ParseException
     */
    public static Date parseToDate(String val) {
        Date date = null;
        try {
            if (val != null && val.trim().length() != 0 && !val.trim().toLowerCase().equals("null")) {
                val = val.trim();
                if (val.length() > 10) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    date = sdf.parse(val);

                }
                if (val.length() <= 10) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    date = sdf.parse(val);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获取上月的第一天 yyyy-MM-dd 00:00:00 和最后一天 yyyy-MM-dd 23:59:59
     *
     * @return
     */
    @SuppressWarnings("static-access")
    public static Map<String, String> getPreMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first_prevM = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first_prevM).append(" 00:00:00");
        day_first_prevM = str.toString(); //上月第一天

        calendar.add(cal.MONTH, 1);
        calendar.set(cal.DATE, 1);
        calendar.add(cal.DATE, -1);
        String day_end_prevM = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_end_prevM).append(" 23:59:59");
        day_end_prevM = endStr.toString();  //上月最后一天

        Map<String, String> map = new HashMap<String, String>();
        map.put("prevMonthFD", day_first_prevM);
        map.put("prevMonthPD", day_end_prevM);
        return map;
    }


    /**
     * 获取上周周一时间，返回格式 yyyy-MM-dd 00:00:00
     *
     * @return
     */
    @SuppressWarnings("static-access")
    public static Timestamp getPreMonday() {
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        //System.out.println(dayofweek);
        if (dayofweek == 1) {
            calendar.add(calendar.WEEK_OF_MONTH, -1);
        }

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(calendar.WEEK_OF_MONTH, -1);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取上周周日时间，返回格式 yyyy-MM-dd 23:59:59
     *
     * @return
     */
    @SuppressWarnings("static-access")
    public static Timestamp getPreSunday() {
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayofweek != 1) {
            calendar.add(calendar.WEEK_OF_MONTH, +1);
        }

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(calendar.WEEK_OF_MONTH, -1);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static String getDateTime() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return myFormat.format(new Date());
    }


    /**
     * 日期格式化成字符串
     *
     * @param date
     * @param fmt
     * @return
     * @throws Exception
     */
    public static Date strFormatDate(String date, String fmt) throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.parse(date);
    }

    /**
     * 根据 时间格式  将字符串转化为 时间戳
     *
     * @param val
     * @param fmt
     * @return
     * @throws java.text.ParseException
     */
    public static Timestamp parseToTime(String val, String fmt) throws ParseException {
        Date date = null;
        if (val != null && val.trim().length() != 0 && !val.trim().toLowerCase().equals("null")) {
            val = val.trim();
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            date = sdf.parse(val);
        }
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mystrdate = myFormat.format(date);
        return Timestamp.valueOf(mystrdate);
    }


    /**
     * 格式化时分秒
     *
     * @param seconds 秒
     * @param full
     * @return
     * @date 2014-4-9
     */
    public static String queuesTimeString(int seconds, boolean full) {
        if (seconds == 0) {
            return "0 秒";
        }

        int minutes = seconds / 60;
        seconds = seconds % 60;

        int hours = minutes / 60;
        minutes = minutes % 60;

        int days = hours / 24;
        hours = hours % 24;


        if (full) {
            return (days != 0 ? days + " 天" : "") +
                    (hours != 0 ? hours + " 时" : "") +
                    (minutes != 0 ? minutes + " 分" : "") +
                    (seconds != 0 ? seconds + " 秒" : "");

        } else {
            String sb = (days != 0 ? days + "d, " : "") + (hours != 0 ? hours + "h, " : "") +
                    (minutes != 0 ? minutes + "m, " : "") + (seconds != 0 ? seconds + "s, " : "");

            return sb;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
