package hu.bme.aut.mobsoft.lab.mobsoftlab.repository;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

import android.content.Context;

import java.util.Date;
import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.User;

public interface Repository {

    void open(Context context);

    void close();

    List<CostRecord> getCostRecords(Date date);

    CostRecord getCostRecordsById(Long id);

    void addCostRecord(CostRecord costRecord);

    void updateCostRecord(List<CostRecord> costRecords);

    void removeCostRecord(CostRecord costRecord);

    boolean isInDB(CostRecord costRecord);

    List<Category> getCategories();

    void addCategory(Category category);

    boolean isInDB(Category category);

    User login(String userName, String password);
}