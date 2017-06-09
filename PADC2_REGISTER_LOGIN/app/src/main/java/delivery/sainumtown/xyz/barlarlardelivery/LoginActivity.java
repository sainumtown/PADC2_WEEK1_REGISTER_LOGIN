package delivery.sainumtown.xyz.barlarlardelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    TextView tvNoAccount;
    TextView tvSkip;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById();
        listener();


    }

    private void listener() {
        tvNoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = RegisterActivity.newIntent(getApplicationContext());
                startActivity(i);
            }
        });

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = WelcomeActivity.newIntent(getApplicationContext());
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = WelcomeActivity.newIntent(getApplicationContext());
                startActivity(i);
            }
        });
    }

    private void findViewById() {
        tvNoAccount = (TextView) findViewById(R.id.tv_no_account);
        tvSkip = (TextView) findViewById(R.id.tv_skip);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}
