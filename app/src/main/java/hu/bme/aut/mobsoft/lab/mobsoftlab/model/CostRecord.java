package hu.bme.aut.mobsoft.lab.mobsoftlab.model;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

import com.orm.dsl.Table;

import java.util.Date;

@Table
public class CostRecord {
    private Long id = null;
    private String name;
    private String category;
    private double cost;
    private Date date;
    private String comment;


    public CostRecord() {
    }

    public CostRecord(Long id, String name, String category, double cost, Date date, String comment) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.date = date;
        this.comment = comment;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
