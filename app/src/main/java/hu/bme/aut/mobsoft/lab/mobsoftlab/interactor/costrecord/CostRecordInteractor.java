package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class CostRecordInteractor {
    @Inject
    Repository repository;

    public CostRecordInteractor() {
        //MobSoftApplication.injector.inject(this);
    }

}
