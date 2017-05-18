package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.R;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class AddActivity extends AppCompatActivity implements AddScreen, View.OnClickListener{

    @Inject
    AddPresenter addPresenter;

    private Spinner categorySpinner;
    private EditText name;
    private EditText date;
    private EditText cost;
    private EditText comment;
    private ArrayAdapter<Category> adapter;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);

        categorySpinner = (Spinner) findViewById(R.id.categories);
        name = (EditText)findViewById(R.id.name);
        cost = (EditText) findViewById(R.id.cost);
        comment = (EditText) findViewById(R.id.comment);
        date = (EditText) findViewById(R.id.date);
        addBtn = (Button)findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        addPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        addPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void costRecordSuccessfullyAdded(){

    }

    @Override
    public void showCategories(List<Category> categories){

    }

    @Override
    public void categoryAdded(Category category){

    }

    @Override
    public void onClick(View v) {
        CostRecord c = new CostRecord();
        c.setCategory((Category)categorySpinner.getSelectedItem());
        c.setCost(Integer.parseInt(cost.getText().toString()));
        //c.setDate(date.getText().toString()));
        c.setName(name.getText().toString());
        c.setComment(comment.getText().toString());
        addPresenter.addCostRecord(c.getId(),c.getName(),c.getCategory(), c.getCost(), c.getDate(), c.getComment());
    }
}