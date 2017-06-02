package com.liumapp.jspbasic.entity;

import sun.plugin2.message.Serializer;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * Created by liumapp on 6/2/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class User implements HttpSessionBindingListener , HttpSessionActivationListener , Serializable {

    private String userName;

    private String passWord;

    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("user valueBound , name is : " + httpSessionBindingEvent.getName());
    }

    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("user valueUnBound , name is : " + httpSessionBindingEvent.getName());
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    //钝化
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionWillPassivate : " + httpSessionEvent.getSource());
    }

    //活化
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionDidActivate : " + httpSessionEvent.getSource());
    }
}
