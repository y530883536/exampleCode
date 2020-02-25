package com.zero.local.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 这个类是测试代码的地方，记得及时清掉测试过代码，并且不要删除这个类
 * @author yechangfeng
 * @date 2018/12/20
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
        /*Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.YEAR, -2);
        System.out.println(startDate.getTime());

        *//*Set<String> aaa = new HashSet<>();
        aaa.add("Wish");
        aaa.add("SMT");
        System.out.println(aaa);
        System.out.println(aaa.toString().contains("Wish"));
        System.out.println(aaa.toString().contains("Shopee"));*//*

        Pattern p = Pattern.compile("[^a-z]abc[^a-z]");
        Matcher m1 = p.matcher("abc");
        Matcher m2 = p.matcher("aabc");
        Matcher m3 = p.matcher(" abc");
        Matcher m4 = p.matcher(",abc");
        Matcher m5 = p.matcher(",abc ");
        System.out.println(m1.matches());
        System.out.println(m2.matches());
        System.out.println(m3.matches());
        System.out.println(m4.matches());
        System.out.println(m5.matches());
        System.out.println("aaaadf".replace("d",""));

        User user1 = new User(1,"1");
        User user2 = new User(2,"2");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        System.out.println(userList);
        userList.remove(user1);
        System.out.println(userList);
        System.out.println(System.currentTimeMillis());*/
        /*Semaphore semaphore = new Semaphore(10);
        System.out.println(semaphore.availablePermits());
        Thread t1 = new Thread(() -> {
            try{
                semaphore.acquire();
                System.out.println("线程开始");
                Thread.sleep(10000);
                semaphore.release();
                System.out.println("线程结束");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();
        for (int i = 0; i < 20; i++) {
            try{
                Thread.sleep(1000);
                System.out.println(semaphore.availablePermits());
                System.out.println(semaphore.hasQueuedThreads());
                System.out.println(semaphore.getQueueLength());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        /*Calendar fromC = Calendar.getInstance();
        fromC.add(Calendar.DAY_OF_YEAR,-2);
        fromC.set(Calendar.HOUR_OF_DAY, 0);
        fromC.set(Calendar.MINUTE, 0);
        fromC.set(Calendar.SECOND, 0);
        Long from = fromC.getTime().getTime()/1000;
        System.out.println(from);
        Calendar toC = Calendar.getInstance();
        toC.set(Calendar.HOUR_OF_DAY, 0);
        toC.set(Calendar.MINUTE, 0);
        toC.set(Calendar.SECOND, 0);
        Long to = toC.getTime().getTime()/1000;
        System.out.println(to);
        System.out.println(to - from);

        String aaa = "123555666777";
        aaa = aaa.replace("555","a").replace("666","b");
        System.out.println(aaa);

        //不会报错
        JSONArray jsonArray = JSONArray.parseArray(null);
        //输出"null"这个字符串
        System.out.println(jsonArray);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(fromC.getTime()));
        System.out.println(simpleDateFormat.format(toC.getTime()));

        String since = simpleDateFormat.format((System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000));
        String upto = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(since + ":" +upto);*/

        String str = "{\"3TT200119-GD\":0.0,\"2S40885-S\":9.9,\"4NB701019-BK\":14.0,\"7HH2000059\":70.0,\"3TT301040-W\":23.3,\"3TT200123-S\":15.5,\"3TT301195-B\":44.6,\"7HH901392-10\":87.5,\"7HH1106184-B\":7.0,\"6EE402211\":35.0,\"2S10325\":19.2,\"2S90646-PL\":42.0,\"7HH300284\":9.2,\"7HH901908-D\":20.5,\"1A40916\":12.0,\"4NB700419\":43.8,\"2S9580-BK\":49.0,\"D13839-WBK\":6.0,\"D17718\":29.9,\"3TT701093\":19.2,\"2SS701295-1\":112.0,\"2S9448-BK\":28.8,\"7HH1101108\":25.2,\"D13840-BKW\":26.6,\"7HH401029-BK\":18.7,\"7HH101909\":77.0,\"39601-R\":9.3,\"7HH102410-R\":112.0,\"4NB501335-3\":13.3,\"3TT700432-BN\":5.4,\"4NB801225\":10.5,\"D16097-BK\":26.7,\"7HH1000037-PK\":28.5,\"3TB00360\":0.0,\"7HH901392-4\":17.2,\"6EE402325\":42.0,\"2S10310\":18.0,\"30376\":86.3,\"7HH901392-2\":11.7,\"7HH901392-3\":0.0,\"7HH901392-1\":3.7,\"4NB501335-7\":31.5,\"4N01426-W\":35.0,\"4NB101257\":49.0,\"7HH1101476\":30.3,\"4NB501269-GN\":3.5,\"2SR0144-BN\":63.0,\"3TA00087\":126.0,\"7HH901272\":0.0,\"D10736\":20.4,\"2SS201259\":40.2,\"3TT300643\":40.8,\"3TT700856-CF\":35.0,\"7HH101429-GN\":12.6,\"6EE404095\":5.7,\"3TT200124-S\":20.7,\"4NB601828-BK\":0.0,\"2S9448-W\":154.0,\"4NB501585-BK\":8.4,\"2S11676-R\":28.0,\"7HH302005\":51.0,\"4NB600022\":26.8,\"7HH1300040\":22.4,\"7HH1105126\":15.5,\"2S9448-T\":42.5,\"2SS304322-RGD\":41.2,\"6EE404700-BK\":49.0,\"2SS500455\":14.0,\"4N01864\":21.0,\"2SS800174\":19.2,\"D21183\":14.2,\"2SS300660\":7.0,\"4NB402037-BK\":17.5,\"D21184\":21.6,\"2S90345\":35.0,\"4NB800712\":1.8,\"4N60584\":161.0,\"8QQ1400280\":25.9,\"3TZ00086-BK\":42.0,\"2S10803-B\":32.7,\"5AC301908-01\":46.7,\"6EE702088-B\":70.0,\"7HH102565-R\":28.0,\"7HH102409-GN\":5.1,\"7HH301961\":32.2,\"2SS201142\":357.0,\"4NB1000202-R\":28.0,\"4NB402036-W\":7.0,\"7HH1104031-2\":32.7,\"C5599-RM\":10.5,\"7HH1104031-8\":20.0,\"2S10154-BK\":74.2,\"7HH1104031-1\":31.5,\"2S9580-WR\":112.0,\"2S9234-CF\":42.0,\"3TT200125-S\":273.0,\"7HH1104134\":14.0,\"4NB600876-6V\":30.0,\"2SS100690\":14.0,\"32400\":14.0,\"7HH101429-Y\":21.0,\"4NB1100289\":14.0,\"7HH101429-R\":21.0,\"4N00815\":42.0,\"7HH101429-O\":91.0,\"3TB00274-GD\":147.0,\"7HH100474-PL\":30.3,\"2S10475-014\":25.7,\"4NB601522-CPU\":14.0,\"4NB1000615\":14.0,\"4NB601523\":0.0,\"7HH300790-BK\":17.3,\"2SS201258-4\":16.3,\"1AA701078-1\":12.0,\"2SS201258-3\":91.0,\"2SS201258-2\":35.0,\"2SS201258-1\":52.5,\"2SS801173\":19.2,\"3TB00095\":31.9,\"7HH400708-10\":35.0,\"4NB701019-S\":14.0,\"6EE404976\":49.0,\"3TT300641-PK\":23.3,\"5AC700519-02\":10.5,\"4NB601533-CPU\":14.0,\"2S10475-007\":13.1,\"7HH102410-SB\":16.3,\"9FF700339-70\":3.5,\"7HH901117\":22.1,\"4NB600341\":63.0,\"4NB900320-BK-S\":130.7,\"3T3269\":12.2,\"9DD200219\":77.0,\"7HH1000071-B\":25.1,\"7HH1000071-C\":23.1,\"7HH900150\":23.3,\"3TT200130-S\":26.6,\"7HH1101404\":40.8,\"D19639\":250.2,\"6EE403198\":10.1,\"3TT200124-GD\":9.1,\"5A60664\":14.0,\"8QQ600008\":31.5,\"C5472-BK\":4.1,\"2SS200659\":222.2,\"1A60110\":5.7,\"6EE201423-DY\":35.0,\"3TT200129-GD\":49.0,\"5AC201630\":19.0,\"7HH901006\":3.9,\"2S91009-3\":10.5,\"2S91009-2\":84.0,\"5AC401394\":5.8,\"4NB1000202-BK\":91.0,\"D14959\":112.0,\"6EE400880-3\":18.2,\"7HH900482\":23.3,\"45474\":10.1,\"2SS800342\":7.0,\"2SS303378-BKS\":4.5,\"3T01633-R\":77.0,\"7HH600591-BK-S\":18.0,\"3TT200130-BK\":42.0,\"6EE400880-1\":28.7,\"4N1320-BK\":31.8,\"3TT200118-BK\":30.3,\"2S90510\":84.0,\"1A0015\":469.0,\"4NB700291-L\":91.0,\"7HH1101500\":693.0,\"6EE100773-W-2XL\":11.0,\"7HH102409-BL\":33.2,\"7HH201867-1-B\":7.0,\"7HH102377-B\":28.0,\"D12429\":40.5,\"6EE300519-FC\":7.0,\"2S9570\":26.2,\"8YY200835-BK\":0.0,\"7HH101489-GN\":10.5,\"4NB700372\":7.3,\"6EE402321-2\":4.3,\"6EE402321-1\":77.0,\"4NB801191\":7.0,\"6EE201423-GG\":28.0,\"7HH1000129\":21.2,\"4N50448-BK\":23.9,\"4NB600515\":49.0,\"7HH400821-5BK\":133.0,\"6EE101691-GY-M\":3.5,\"D21409-EU\":40.8,\"3TT300031\":28.0,\"6EE401821-BK\":14.0,\"1A40975\":37.3,\"7HH1000318-4\":28.0,\"7HH1000318-3\":217.0,\"7HH1000318-2\":133.0,\"7HH900583\":76.8,\"D8674\":33.6,\"3TB00050\":5.6,\"3TT200123-GD\":84.0,\"6EE400881-1\":87.5,\"7HH1106480-1\":14.0,\"4NB500390\":32.7,\"4NB500391\":12.4,\"D17403\":67.5,\"D12076\":112.0,\"2S5515\":82.8,\"D13531-W\":15.8,\"4NB501268-BK\":32.7,\"6EE900641-BG\":10.5,\"4NB1000203-BK\":10.5,\"2SS201420\":18.7,\"6EE900641-BK\":0.0,\"6EE100860-PK-L\":21.0,\"7HH600591-W-L\":2.8,\"3TT700293-05\":77.0,\"3TT301258-BL\":5.0,\"7HH1104073-S\":91.0,\"6EE900458-D\":62.3,\"7HH600933-R-4XL\":0.0,\"4N02210-R\":28.0,\"6EE900458-C\":115.5,\"4NB501365\":27.5,\"6A51276-BN\":98.0,\"7HH1100155-8\":32.7,\"7HH402221\":19.2,\"7HH102408-SB\":84.0,\"2SS500292\":21.0,\"2SS800187-BK\":28.9,\"2S9219-GY\":8.4,\"3TT200124-BK\":154.0,\"2SS200869-L\":427.0,\"7HH100772-GY\":29.0,\"2SSA00321-W\":126.0,\"4NB402009\":0.3,\"7HH1103200-S\":8.1,\"7HH1400006\":52.5,\"2SS302513-GD\":24.5,\"7HH301521-61\":9.3,\"2S9011-BK\":41.5,\"4NB501272-BK\":20.9,\"4NB701025\":4.2,\"3TB00278\":51.3,\"8AF100324-EU-BK\":23.3,\"3TT601171-BK\":35.0,\"6EE201423-LG\":70.0,\"7HH100474-O\":29.9,\"4NB600876-12V\":8.3,\"2S11732\":31.1,\"2S9580-W\":39.7,\"5AC500319\":70.0,\"3T1227\":30.8,\"6EE700350-W-S\":14.0,\"2SS800701\":35.0,\"4NB800918-T\":80.5,\"7HH101605-1\":42.0,\"3TT700817\":24.0,\"23537\":56.0,\"7HH300851-GN\":203.0,\"7HH901669-C\":24.2,\"4NB701188-GN\":9.9,\"7HH300535\":16.3,\"5AC501412\":35.0,\"5AC400152-R\":14.0,\"6EE100860-GY-L\":16.3,\"7HH102402\":1.0,\"7HH600591-GY-M\":7.0,\"2S40345\":61.7,\"7HH102401\":7.6,\"4NB402037-R\":21.0,\"2S9642\":32.7,\"9FF1000038-Y\":16.8,\"3TZ00086-PL\":42.0,\"3TT700563-BK\":38.5,\"2S90256\":119.0,\"4N01517-RBL\":28.0,\"45409-S\":13.2,\"3TT200123-BZ\":30.5,\"2SS600074\":126.0,\"7AY00748-BK\":29.2,\"C5599-RXL\":105.0,\"7HH400674-BK\":24.2,\"D12271\":25.7,\"7HH300604-BK\":12.8,\"3TT200119-S\":0.0,\"5AC501981\":77.0,\"3TT900114-BK\":28.0,\"4NB600863\":5.2,\"7HH901512\":112.0,\"MA106153-1\":25.5,\"5AC501624\":18.7,\"7HH1000104-10\":29.6,\"2S91016-6\":2.8,\"7AH00099-RL\":28.0,\"7AF00002-BKXL\":16.9,\"4NB401932-DB-XL\":0.0,\"6EE403104-3\":49.0,\"1AA800450\":56.0,\"2SS900773-3\":35.0,\"7HH600911-AP-S\":7.0,\"4N02210-BK\":109.7,\"5A60705\":11.2,\"8YY100550\":21.0,\"7HH1200479-PK\":38.5,\"6EE101866-BK\":23.3,\"7HH600591-W-2XL\":0.0,\"9A30032\":3.1,\"9A30031\":21.0,\"7HH1103221-S\":17.3,\"3TT700662-BK\":121.3,\"7HH901526\":49.0,\"7HH900959-10\":31.5}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println("helloWorld");
    }

    public static boolean judgeInfrimentWord(String content,String infringementWord) {
        //如果开头是侵权词，那么判断是否有"侵权词+空格"的组成方式，有的话就包含侵权词
        if(StringUtils.startsWithIgnoreCase(content,infringementWord+" ")){
            return true;
        }
        //如果几位是侵权词，那么判断是否有"空格+侵权词"的组成方式，有的话就包含侵权词
        if(StringUtils.endsWithIgnoreCase(content," "+infringementWord)) {
            return true;
        }
        //此外的所有情况，都要符合"空格+侵权词+空格"的组成方式才包含侵权词
        if(StringUtils.containsIgnoreCase(content," "+infringementWord+" ")) {
            return true;
        }
        return false;
    }

    public static double format(double input) {
        return format(input, "0.##");
    }

    public static double format(double input, String style) {
        double res = 0;
        if (input != 0 && StringUtils.isNotBlank(style)) {
            DecimalFormat df = new DecimalFormat();
            df.applyPattern(style);
            res = Double.valueOf(df.format(input));
        }
        return res;
    }

    static class User{
        private int id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public User(int id){
            this.id = id;
        }

        public User(){}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            //return Objects.hash(id);
            return id;
        }
    }

    public static Timestamp getTimestamp(Map<String, Object> param, String key, SimpleDateFormat gmtSdf) {
        if (param == null) {
            return null;
        }

        if (gmtSdf == null) {
            gmtSdf = new SimpleDateFormat("yyyyMMddHHmmssS");
        }

        Object value = param.get(key);

        if (value != null) {
            try {
                Date parse = gmtSdf.parse(value.toString());
                return new Timestamp(parse.getTime());
            }
            catch (Exception e) {
                return null;
            }
        }

        return null;
    }
}

