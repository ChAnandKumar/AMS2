package com.bartronics.ams2.ui.add_data;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.widget.Button;
import android.widget.EditText;

import com.bartronics.ams2.R;
import com.bartronics.ams2.data.db.model.PModel;
import com.bartronics.ams2.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by anand.chandaliya on 06-03-2017.
 */

public class AddDataActivity extends BaseActivity implements AddDataMvpView {


    @BindView(R.id.name_et)
    EditText nameEt;
    @BindView(R.id.designation_et)
    EditText designationEt;
    @BindView(R.id.department_et)
    EditText departmentEt;
    @BindView(R.id.work_loc_et)
    EditText workLocEt;
    @BindView(R.id.emp_no)
    EditText empNo;
    @BindView(R.id.emp_pin)
    EditText empPin;
    @BindView(R.id.save_btn)
    Button saveBtn;

    @Inject
    AddDataPresenter addDataPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data_layout);
        ButterKnife.bind(this);
        activityComponent().inject(this);
        addDataPresenter.attachView(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void addDtata() {

    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getWindow().getDecorView().getRootView(),message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @OnClick(R.id.save_btn)
    public void onClick() {

        String name = nameEt.getText().toString();
        String designation = designationEt.getText().toString();
        String department = departmentEt.getText().toString();
        String workLocation = workLocEt.getText().toString();
        String empNumber = empNo.getText().toString();
        int empID = Integer.parseInt(empNumber);
        int empPinNu = Integer.parseInt(empPin.getText().toString());
        PModel profile = new PModel(null,name,department,empNumber,empID,empPinNu,workLocation,designation);

        addDataPresenter.saveData(profile);

    }
}
