package hu.bme.aut.mobsoft.lab.mobsoftlab.model;

import com.orm.dsl.Table;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

@Table
public class Category {
    private Long id = null;
    private String name;


    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
