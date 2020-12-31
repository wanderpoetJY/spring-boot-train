package com.wander.train.pojo;

import java.io.Serializable;

/**
 * example表对应实体类
 *
 * @author admin 2020/12/23/ 14:26
 */
public class Example implements Serializable {

    private int id;
    private String name;

    public Example() {
    }

    public Example(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
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

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
