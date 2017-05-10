package hu.bme.aut.mobsoft.lab.mobsoftlab.repository;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MemoryRepository implements Repository {

    public static List<CostRecord> costRecords;
    public static List<Category> categories;


    @Override
    public void open(Context context) {
        Category cat1 = new Category(1L, "Utazás");
        Category cat2 = new Category(2L, "Szórakozás");

        categories = new ArrayList<>();
        categories.add(cat1);
        categories.add(cat2);

        CostRecord cost1 = new CostRecord(3L,"cost one", cat1, 2400, new Date(), "comment");
        CostRecord cost2 = new CostRecord(4L,"cost two", cat2, 4400, new Date(), "comment2");

        costRecords = new ArrayList<>();
        costRecords.add(cost1);
        costRecords.add(cost2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<CostRecord> getCostRecords(Date date) {
        //TODO: DATE szűrés
        List<CostRecord> costRecordsInDate = new ArrayList<CostRecord>();
        Date today = new Date();
        for(CostRecord c : costRecords){
            if(today.getDay() == c.getDate().getDay())
            {

            }
        }
        return costRecords;
    }

    @Override
    public CostRecord getCostRecordsById(Long id) {
        CostRecord cost = null;
        for (CostRecord c : costRecords) {
            if (c.getId().equals(id)) {
                cost = c;
                break;
            }
        }
        return cost;
    }

    @Override
    public void addCostRecord(CostRecord costRecord) {
        costRecords.add(costRecord);
    }

    @Override
    public void updateCostRecord(List<CostRecord> costRecords) {
        for (int i = 0; i < this.costRecords.size(); i++) {
            CostRecord cr = this.costRecords.get(i);
            for (CostRecord costRecord : costRecords) {
                if (costRecord.getId().equals(cr.getId())) {
                    this.costRecords.set(i, costRecord);
                }
            }
        }
    }

    @Override
    public void removeCostRecord(CostRecord costRecord) {
        costRecords.remove(costRecord);
    }

    @Override
    public boolean isInDB(CostRecord costRecord) {
        return costRecords.contains(costRecord);
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void addCategory(Category category) {
        categories.add(category);
    }

    @Override
    public boolean isInDB(Category category) {
        return categories.contains(category);
    }
}
