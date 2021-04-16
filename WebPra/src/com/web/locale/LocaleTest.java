package com.web.locale;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Mr.wxx
 * @create 2021-04-08-11:05
 **/
public class LocaleTest {
    public static void main(String[] args) {
        Locale ch = Locale.CHINA;
        System.out.println(ch);
        Locale us = Locale.US;
        System.out.println(us);
        //配置文件管理
        ResourceBundle chPro = ResourceBundle.getBundle("i18n", ch);
        System.out.println("username = " + chPro.getString("username"));
        System.out.println("password = " + chPro.getString("password"));
        ResourceBundle usPro = ResourceBundle.getBundle("i18n", us);
        System.out.println("username = " + usPro.getString("username"));
        System.out.println("password = " + usPro.getString("password"));

    }
}
