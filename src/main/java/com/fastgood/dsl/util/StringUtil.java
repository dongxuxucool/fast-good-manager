package com.fastgood.dsl.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    
    private static Pattern chinese = Pattern.compile("[\\u4e00-\\u9fa5]");
    private static Pattern integerPattern = Pattern.compile("^[\\d]+$");
    private static Pattern floatPattern = Pattern.compile("^[\\d]+\\.[\\d]+$");
    private static Pattern tablePattern = Pattern.compile("^[\\w|_]+$");
    private static SimpleDateFormat format_short = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat format_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat format_short1 = new SimpleDateFormat("yyyy/MM/dd");
    private static SimpleDateFormat format_long1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static Properties properties = null;
    /**
     * 
     * 判断一个字符串是否为空白
     * 
     * @param expr
     * @return
     */
    public static boolean isBlank(String expr) {
        if(expr == null) return true;
        if(expr.trim().length()==0) return true;
        return false;
    }
    
    public static boolean containsFunction(String expr) {
        if((expr.indexOf("(")>0 && expr.indexOf(")")>0) 
                || expr.toLowerCase().indexOf("case when ")>=0) {
            return true;
        }
        return false;
    }
    
    public static String shortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "test";
        // 要使用生成 URL 的字符
        String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"

        };
        // 对传入网址进行 MD5 加密
        String hex = md5(key + url);

        String[] resUrl = new String[4];
        for (int i = 0; i < 4; i++) {

            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);

            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            String outChars = "";
            for (int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[(int) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        Random random=new Random();
        int j=random.nextInt(4);//产成4以内随机数
        
        return resUrl[j];
    }
    public static String md5(String str) {  
        MessageDigest messageDigest = null;  
        try {  
            messageDigest = MessageDigest.getInstance("MD5");  
            messageDigest.update(str.getBytes("UTF-8"));  
        } catch (Exception e) {  
           return e.getMessage();
        }
        byte[] byteArray = messageDigest.digest();  
        StringBuffer md5StrBuff = new StringBuffer();  
        for (int i = 0; i < byteArray.length; i++) {              
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
            else  
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
        }  
        return md5StrBuff.toString();  
    }
    
    /**
     * 判断字符串中是否包含汉字
     * @param str
     * @return 包含返回true,不包含返回false
     */
    public static boolean containChinese(String str) {
        Matcher m = chinese.matcher(str);
        if(m==null) return false;
        return m.find();
    }
    
    /**
     * 时间格式化，返回 2012-01-10 00:00:00的格式
     * @param date
     * @return
     */
    public static String fomateDate(Date date) {
//      if(date.getHours()==0 && date.getSeconds()==0 && date.getMinutes()==0) {
//          return format_short.format(date);
//      } else {
            return format_long.format(date);
//      }
    }
    
    public static boolean isTablePattern(String code) {
    	 Matcher m = tablePattern.matcher(code);
         if(m.find()) {
             return true;
         }
         return false;
    }
    
    public static boolean isNumberic(String str) {
        Matcher m = integerPattern.matcher(str);
        if(m.find()) {
            return true;
        }
        m = floatPattern.matcher(str);
        if(m.find()) {
            return true;
        }
        return false;
    }
    
    public static boolean isNumeric(String str) {
        if(str == null || str.equals(""))
            return false;
        if(str.startsWith("-")){
            str = str.substring(1);
        }
        String processedStr = str.replace(".", "");
        for (int i = 0; i < processedStr.length(); i++) {
            if (!Character.isDigit(processedStr.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static Properties loadContext() {
        if (properties == null) {
            properties = new Properties();
            InputStream inputStream = StringUtil.class
                    .getResourceAsStream("/application.properties");
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else
            return properties;

        return properties;
    }
    
    /**
     * get the property value from the property file
     * @param property
     * @return
     */
    public static String getProperty(String property) {
        Properties properties = loadContext();
        if (properties != null) {
            return properties.getProperty(property);
        }
        return null;
    }
    
    public static String removeQuotes(String value) {
        // &quot;28,421,615,033&quot;
        if (value == null) {
            return value;
        }

        String result = value.replaceAll("\'", "").replaceAll("\"", "").replaceAll("&quot;", "");
        return result;
    }
    
    public static void main(String[] args) {
        
        System.out.println(StringUtil.md5("aaaa"));
        System.out.println("74b87337454200d4d33f80c4663dc5e5".length());
        
        BigDecimal bd = new BigDecimal("2011E-2");
        System.out.print(bd.toPlainString());
        
        System.out.println("--------");
        
        String tt = "&quot;2\"8,421,6\'15,033&quot;";
        String v = removeQuotes(tt);
        System.out.println(v);
        System.out.println("shortUrl = " + shortUrl("feqfea12333"));
    }
}
