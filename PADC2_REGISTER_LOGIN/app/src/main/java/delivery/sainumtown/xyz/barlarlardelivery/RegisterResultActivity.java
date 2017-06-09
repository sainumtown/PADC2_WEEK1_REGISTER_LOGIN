package delivery.sainumtown.xyz.barlarlardelivery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Boolean.FALSE;

public class RegisterResultActivity extends AppCompatActivity {


    public static final String IE_PHONE = "IE_PHONE";
    public static final String IE_EMAIL = "IE_EMAIL";
    public static final String IE_DOB = "IE_DOB";
    public static final String IE_PASSWORD = "IE_PASSWORD";
    public static final String IE_STATUS = "IE_STATUS";
    public static final String IE_EMAIL_RESPONSE = "IE_EMAIL_RESPONSE";
    public static final String IE_CITY = "IE_CITY";
    TextView tvResult;
    public static final String IE_NAME = "IE_NAME";
    private Context context;

    public static Intent newIntent(Context context, String name, String phone, String email, String dob, String password, String status, boolean flagEmailResponse, String city) {

        Intent intent = new Intent(context, RegisterResultActivity.class);
        intent.putExtra(IE_NAME, name);
        intent.putExtra(IE_PHONE, phone);
        intent.putExtra(IE_EMAIL, email);
        intent.putExtra(IE_DOB, dob);
        intent.putExtra(IE_PASSWORD, password);
        intent.putExtra(IE_STATUS, status);
        intent.putExtra(IE_EMAIL_RESPONSE, flagEmailResponse);
        intent.putExtra(IE_CITY, city);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_result);
        context = getBaseContext();


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        tvResult = (TextView) findViewById(R.id.tv_result);

        String result;
        result = "Your Name :" + getIntent().getStringExtra(IE_NAME) + "\n" +
                "Your Email :" + getIntent().getStringExtra(IE_EMAIL) + "\n" +
                "Your Phone :" + getIntent().getStringExtra(IE_PHONE) + "\n" +
                "Your DOB :" + getIntent().getStringExtra(IE_DOB) + "\n" +
                "Your use for :" + getIntent().getStringExtra(IE_STATUS) + "\n" +
                "Your promotion response by mail :" + getIntent().getBooleanExtra(IE_EMAIL_RESPONSE, FALSE) + "\n" +
                "Your city :" + getIntent().getStringExtra(IE_CITY);
        ;
        tvResult.setText(result);

    }
}
