package com.huanghe.BeanMapConvert;

import org.junit.Before;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class BeanMapConvertTest {

    Person Person;

    @Before
    public void setUp() throws Exception {
        Person = new Person();
        Person.setAge("12");
        Person.setName("zhangsan");
        Person.setScore(60);
    }

    @Test
    public void bean2MapObject() {
        Map<String, Object> map = BeanMapConvert.bean2MapObject(Person);
        map.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + map.get(key)));
    }

    @Test
    public void map2Bean() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", "30");
        map.put("name", "lisi");
        map.put("score", 100);
        Person o = (Person) BeanMapConvert.map2Bean(map, new Person());
        System.out.println(o.toString());

    }

    @Test
    public void mapToBean() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", "30");
        map.put("name", "lisi");
        map.put("score", 100);
        Person o = (Person) BeanMapConvert.mapToBean(map, Person.class);
        System.out.println(o.toString());

    }

    @Test
    public void testIntro() throws Exception {
        Person p = new Person();
        BeanInfo beanInfo = Introspector.getBeanInfo(p.getClass(), Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            System.out.println(pd.getName());
        }

    }

    @Test
    public void test4() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        Person p = new Person();
        Method setAgeMethod = pd.getWriteMethod();
        setAgeMethod.invoke(p, "23");
        Method getAgeMethod = pd.getReadMethod();
        System.out.println(getAgeMethod.invoke(p, null));
    }


}
