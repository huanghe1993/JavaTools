package com.huanghe.BeanMapConvert;

/**
 * @Author huanghe
 * @Date 2019/12/21 20:47
 * @Description
 */
public class Person {
    String age;
    String name;
    int score;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
