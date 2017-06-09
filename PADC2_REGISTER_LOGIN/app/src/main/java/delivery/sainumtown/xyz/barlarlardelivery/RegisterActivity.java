package delivery.sainumtown.xyz.barlarlardelivery;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    EditText etUserName;
    EditText etPhone;
    EditText etEmail;
    EditText etDob;
    EditText etPassword;
    RadioGroup radioStatus;
    RadioButton radioStatusBtn;
    ToggleButton tbEmailResponse;
    Spinner spnCity;
    Button btnRegister;

    public static Intent newIntent(Context context) {

        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViewById();
        listener();

    }

    private void listener() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToResult();
            }
        });


        etDob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePicker();
                }
            }
        });
    }

    private void goToResult() {
        String name = etUserName.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String dob = etDob.getText().toString();
        String password = etPassword.getText().toString();
        String status = getStatus();
        boolean flagEmailResponse = tbEmailResponse.isChecked();
        String city = getCity();

        Intent intent = RegisterResultActivity.newIntent(getApplicationContext(),
                name, phone, email
                , dob, password, status,
                flagEmailResponse, city);
        startActivity(intent);
    }

    private void findViewById() {
        etUserName = (EditText) findViewById(R.id.et_user_name);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        etDob = (EditText) findViewById(R.id.et_dob);
        radioStatus = (RadioGroup) findViewById(R.id.radioStatus);
        tbEmailResponse = (ToggleButton) findViewById(R.id.tb_email_response);
        spnCity = (Spinner) findViewById(R.id.spn_city);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }

    private String getCity() {
        return String.valueOf(spnCity.getSelectedItem());
    }

//    public void addListenerOnSpinnerItemSelection() {
//
//        spnCity.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//    }

    private String getStatus() {
        String selectdRadioText;
        int selectedId = radioStatus.getCheckedRadioButtonId();
        radioStatusBtn = (RadioButton) findViewById(selectedId);
        selectdRadioText = (String) radioStatusBtn.getText();
        return selectdRadioText;
    }


    private void showDatePicker() {

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                RegisterActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");

    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        etDob.setText(getStringDateFormat(year, monthOfYear, dayOfMonth));
    }

    @NonNull
    private String getStringDateFormat(int year, int monthOfYear, int dayOfMonth) {
        return year + "-" + String.format("%02d", monthOfYear + 1) + "-" + String.format("%02d", dayOfMonth);
    }

}
