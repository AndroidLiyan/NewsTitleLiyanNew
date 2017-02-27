package com.bwie.newstitleliyannew.utils;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class UrlUtils {
    public static final String URL_TOP = "http://c.m.163.com/nc/article/headline/";
    public static final String VIDEO_TOP = "http://c.3g.163.com/nc/video/list/";
    public static final String URL_MIDDLE = "/";
    public static final String VIDEO_MIDDLE = "/n/";
    public static final String URL_END = "-20.html";
    public static final String VIDEO_END = "-10.html";
    public static final String FOOTBALL_ID = "T1399700447917";// 足球
    public static final String HOUSE_ID = "5YyX5Lqs";// 房产id
    public static final String ENTERTAINMENT_ID = "T1348648517839";// 娱乐
    public static final String SPORTS_ID = "T1348649079062";// 体育
    public static final String FINANCE_ID = "T1348648756099";// 财经
    public static final String TECH_ID = "T1348649580692";// 科技
    public static final String MOVIE_ID = "T1348648650048";// 电影
    public static final String CAR_ID = "T1348654060988";// 汽车
    public static final String JOKE_ID = "T1350383429665"; // 笑话
    public static final String GAME_ID = "T1348654151579"; // 游戏
    public static final String FASHION_ID = "T1348650593803"; // 时尚 public static ﬁnal String EMOTION_ID = "T1348650839000"; // 情感 public static ﬁnal String CHOICE_ID = "T1370583240249"; // 精选 public static ﬁnal String RADIO_ID = "T1379038288239"; // 电台 public static ﬁnal String NBA_ID = "T1348649145984"; // nba public static ﬁnal String DIGITAL_ID = "T1348649776727"; // 数码 public static ﬁnal String MOBILE_ID = "T1351233117091"; // 移动 public static ﬁnal String LOTTERY_ID = "T1356600029035"; // 彩票 public static ﬁnal String EDUCATION_ID = "T1348654225495"; // 教育 public static ﬁnal String FORUM_ID = "T1349837670307"; // 论坛 public static ﬁnal String TOUR_ID = "T1348654204705"; // 旅游
    public static String geturl(String ID,int currentpage){
        String URL = URL_TOP+ID+URL_MIDDLE+currentpage+URL_END;
        return URL;
    }
    public static String geturlVideo(String ID,int currentpage){
        String URL = VIDEO_TOP+ID+VIDEO_MIDDLE+currentpage+VIDEO_END;
        return URL;
    }
}
