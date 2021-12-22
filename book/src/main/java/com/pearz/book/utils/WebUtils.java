package com.pearz.book.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 21:43 2021/12/16
 */
public class WebUtils {

    /**
     * TODO 把Map中的值注入到对应的JavaBean属性中。
     * @param value
     * @param bean
     * @return: T
    */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            System.out.println("注入之前：" + bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * TODO 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
        }
        return defaultValue;
    }
}
