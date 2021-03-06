package com.github.whujack.utils;

/**
 * @author Created By LiJie at 2018/3/16
 */
public class StringUtils {

    private final static String DEFAULT_STRING = "(#\\{})";
    private static final String CAMEL_CASE_STR = "_(\\w)";

    public static String replace(String source, String... result) {
        if (source == null) {
            return null;
        }
        if (result == null) {
            return source;
        }
        for (int i = 0; i < result.length; i++) {
            source = source.replaceFirst(DEFAULT_STRING, result[i]);
        }
        return source;
    }

    /**
     * 驼峰命名法
     *
     * @param name 名字
     * @return 驼峰名
     */
    public static String toCamelCase(String name) {
        if (com.mysql.jdbc.StringUtils.isNullOrEmpty(name)) {
            return null;
        }
        String result = "";
        boolean isToUpper = false;
        for (int i = 0; i < name.length(); i++) {
            Character tmp = name.charAt(i);
            if (tmp.equals('_')) {
                isToUpper = true;
            } else {
                if (isToUpper) {
                    result += tmp.toString().toUpperCase();
                    isToUpper = false;
                } else {
                    result += tmp.toString();
                }
            }
        }
        return result;
    }

    /**
     * 首字母大写
     *
     * @param name 名字
     * @return 名字
     */
    public static String firstToUpper(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }

        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    /**
     * 获取setter name
     *
     * @param name 名称
     * @return 返回settername
     */
    public static String toSetterName(String name) {
        return "set" + firstToUpper(toCamelCase(name));
    }

    /**
     * 获取setter name
     *
     * @param name 名称
     * @return toGetterName
     */
    public static String toGetterName(String name) {
        return "get" + firstToUpper(toCamelCase(name));
    }

    public static void main(String[] args) {
        //String res = replace("#{}#{}#{}#1234", "a", "b", "c");
        String res = "sale_abc_afd_";
        System.out.print(toCamelCase(res));
    }
}
