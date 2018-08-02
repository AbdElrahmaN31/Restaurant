package com.example.abdelrahman.temp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.abdelrahman.temp.Models.City;
import com.example.abdelrahman.temp.Models.User;
import com.example.abdelrahman.temp.Presenter.CityPresenter;
import com.example.abdelrahman.temp.Presenter.RegistrationPresenter;
import com.example.abdelrahman.temp.R;
import com.example.abdelrahman.temp.View.CityVeiw;
import com.example.abdelrahman.temp.View.RegisterView;
import com.fourhcode.forhutils.FUtilsValidation;

import java.util.HashMap;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements RegisterView,CityVeiw {

    EditText name,password,address,phone,mail;
    RadioGroup gender_rg;
    RadioButton male,female;
    String gender;
    Button register;

    RegistrationPresenter registrationPresenter;

    CityPresenter cityPresenter;
    Spinner citySpinner;
    HashMap<Integer,String> spinnerMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name = findViewById(R.id.register_ed_name);
        password = findViewById(R.id.register_ed_password);
        phone = findViewById(R.id.register_ed_phone);
        mail = findViewById(R.id.register_ed_mail);
        address = findViewById(R.id.register_ed_address);
        citySpinner = findViewById(R.id.register_sp_city);
        gender_rg = findViewById(R.id.gender_rg);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        register = findViewById(R.id.register_bt);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "0";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "1";
            }
        });

        cityPresenter = new CityPresenter(this,this);
        registrationPresenter = new RegistrationPresenter(this,this);
        cityPresenter.getCites();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FUtilsValidation.isEmpty(address, "Please Insert Your  Address");
                FUtilsValidation.isEmpty(name,"Please Insert Your Name");
                FUtilsValidation.isEmpty(password,"Please Insert Password");
                FUtilsValidation.isEmpty(mail,"Please Insert Mail");
                FUtilsValidation.isEmpty(phone,"Please Insert Phone Number");
                FUtilsValidation.isLengthCorrect(password.getText().toString(),8,20);

                if(!FUtilsValidation.isLengthCorrect(password.getText().toString(),8,20))
                        password.setError("Password min is 8 and max is 20");
                if(!address.getText().toString().equals("") && !name.getText().toString().equals("") &&
                        !mail.getText().toString().equals("") && !phone.getText().toString().equals("") &&
                        FUtilsValidation.isLengthCorrect(password.getText().toString(),8,20) &&
                        (male.isChecked() || female.isChecked())){
                    User user = new User();
                    final City city = new City();
                    user.setAddress(address.getText().toString());
                    user.setName(name.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.setMail(mail.getText().toString());
                    user.setPhone(phone.getText().toString());
                    user.setGender(gender);
                    city.setId(Integer.valueOf(spinnerMap.get(citySpinner.getSelectedItemPosition())));
                    registrationPresenter.register(user,city);
                }
            }
        });

    }

    @Override
    public void showCites(List<City> cities) {
        String[] spinnerArray = new String[cities.size()];

        for (int i = 0; i < cities.size(); i++) {
            spinnerMap.put(i,cities.get(i).getId().toString());
            spinnerArray[i] = cities.get(i).getEnglishName();
        }
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);
    }

    @Override
    public void openMain() {
        Intent intent = new Intent(this,CategoryActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this,"R Error Eccuored",Toast.LENGTH_LONG).show();
    }
}
