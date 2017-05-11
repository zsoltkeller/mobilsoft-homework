package hu.bme.aut.mobsoft.lab.mobsoftlab.repository;

import android.content.Context;
import android.content.res.Resources;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.User;

/**
 * Created by mobsoft on 2017. 04. 28..
 */


public class SugarOrmRepository implements Repository {


    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<CostRecord> getCostRecords(Date date) {
        //TODO: DATE szűrés
        return SugarRecord.listAll(CostRecord.class);
    }

    @Override
    public CostRecord getCostRecordsById(Long id) {
        CostRecord cost = null;
        for (CostRecord c : SugarRecord.listAll(CostRecord.class)) {
            if (c.getId().equals(id)) {
                cost = c;
                break;
            }
        }
        return cost;
    }

    @Override
    public void addCostRecord(CostRecord costRecord) {
        SugarRecord.saveInTx(costRecord);
    }

    @Override
    public void updateCostRecord(List<CostRecord> costRecordsToUpdate) {
        List<CostRecord> costRecords = SugarRecord.listAll(CostRecord.class);
        List<CostRecord> toUpdate = new ArrayList<>(costRecords.size());
        for (CostRecord costRecordItem : costRecords) {
            for (CostRecord crToUpdate : costRecordsToUpdate) {
                if (crToUpdate.getId().equals(costRecordItem.getId())) {
                    toUpdate.add(crToUpdate);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeCostRecord(CostRecord costRecord) {
        SugarRecord.deleteInTx(costRecord);
    }

    @Override
    public boolean isInDB(CostRecord costRecord) {
        return SugarRecord.findById(CostRecord.class, costRecord.getId()) != null;
    }

    @Override
    public List<Category> getCategories() {
        return SugarRecord.listAll(Category.class);
    }

    @Override
    public void addCategory(Category category) {
        SugarRecord.saveInTx(category);
    }

    @Override
    public boolean isInDB(Category category) {
        return SugarRecord.findById(Category.class, category.getId()) != null;
    }

    @Override
    public User login(String userName, String password) {
        User user = null;
        for (User u : SugarRecord.listAll(User.class)) {
            if (u.getName() == userName && u.getPassword() == password) {
                user = u;
                break;
            }
        }
        return user;
    }
}
