package com.mta.busreservation;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mta.busreservation.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PaymentDelivery extends AppCompatActivity {
    EditText name,email,con,zip,city,add,card,aname,month,year,cvv;
    private Toolbar toolbar;
    private EditText inputName, inputEmail, inputPassword, inputzip, inputcity, inputaddress;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword, inputLayoutzip, inputLayoutcity, inputLayoutaddress;
    private Button btnSignUp;
    Thread t;
    String[] array;
    String cnm, id, pname,price;
    public static SharedPreferences sp;
    int total1;
    ArrayList<SearchResults> addToCardsArrayList;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_payment_delivery);
        sp = getSharedPreferences("Bus", MODE_WORLD_READABLE);

        name=(EditText)findViewById(R.id.input_name);
        email=(EditText)findViewById(R.id.input_email);
        con=(EditText)findViewById(R.id.input_password);
        zip=(EditText)findViewById(R.id.input_zip);
        city=(EditText)findViewById(R.id.input_city);
        add=(EditText)findViewById(R.id.input_address);
        card=(EditText)findViewById(R.id.card);
        aname=(EditText)findViewById(R.id.name);
        month=(EditText)findViewById(R.id.month);
        year=(EditText) findViewById(R.id.year);
        cvv=(EditText)findViewById(R.id.cvv);

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout)findViewById(R.id.input_layout_password);
        inputLayoutzip = (TextInputLayout)findViewById(R.id.input_layout_zip);
        inputLayoutcity = (TextInputLayout) findViewById(R.id.input_layout_city);
        inputLayoutaddress = (TextInputLayout) findViewById(R.id.input_layout_address);

        inputName = (EditText) findViewById(R.id.input_name);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        inputzip = (EditText) findViewById(R.id.input_zip);
        inputcity = (EditText)findViewById(R.id.input_city);
        inputaddress = (EditText)findViewById(R.id.input_address);


        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
        inputzip.addTextChangedListener(new MyTextWatcher(inputzip));
        inputcity.addTextChangedListener(new MyTextWatcher(inputcity));
        inputaddress.addTextChangedListener(new MyTextWatcher(inputaddress));

        btnSignUp = (Button)findViewById(R.id.btn_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
                t = new Thread() {
                    public void run() {
                        getsearch();
                    }
                };
                t.start();
                Intent intent = new Intent(PaymentDelivery.this, PaymentFragment.class);
                startActivity(intent);
            }
        });

    }

        private void submitForm() {
            if (!validateName()) {
                return;
            }

            if (!validateEmail()) {
                return;
            }

            if (!validatePassword()) {
                return;
            }
            if (!validateaddress()) {
                return;
            }
            if (!validatezip()) {
                return;
            }
            if (!validatecity()) {
                return;
            }


            Toast.makeText(PaymentDelivery.this, "Thank You!", Toast.LENGTH_SHORT).show();
        }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatezip() {
        if (inputzip.getText().toString().trim().isEmpty()) {
            inputLayoutzip.setError(getString(R.string.err_msg_zip));
            requestFocus(inputzip);
            return false;
        } else {
            inputLayoutzip.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatecity() {
        if (inputcity.getText().toString().trim().isEmpty()) {
            inputLayoutcity.setError(getString(R.string.err_msg_city));
            requestFocus(inputcity);
            return false;
        } else {
            inputLayoutcity.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateaddress() {
        if (inputaddress.getText().toString().trim().isEmpty()) {
            inputLayoutaddress.setError(getString(R.string.err_msg_address));
            requestFocus(inputaddress);
            return false;
        } else {
            inputLayoutaddress.setErrorEnabled(false);
        }

        return true;
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {

            //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
                case R.id.input_address:
                    validateaddress();
                    break;
                case R.id.input_zip:
                    validatezip();
                    break;
                case R.id.input_city:
                    validatecity();
                    break;

            }
        }
    }

    public void getsearch() {
        httpconnection obj = new httpconnection();
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", name.getText().toString()));
        l1.add(new BasicNameValuePair("email", email.getText().toString()));
        l1.add(new BasicNameValuePair("con", con.getText().toString()));
        l1.add(new BasicNameValuePair("zip", zip.getText().toString()));
        l1.add(new BasicNameValuePair("city", city.getText().toString()));
        l1.add(new BasicNameValuePair("add", add.getText().toString()));
        l1.add(new BasicNameValuePair("card", card.getText().toString()));
        l1.add(new BasicNameValuePair("aname", aname.getText().toString()));
        l1.add(new BasicNameValuePair("month", month.getText().toString()));
        l1.add(new BasicNameValuePair("year", year.getText().toString()));
        l1.add(new BasicNameValuePair("cvv", cvv.getText().toString()));
         l1.add(new BasicNameValuePair("id",sp.getString("id1","null")));
        //Toast.makeText(getApplicationContext(), email ,Toast.LENGTH_LONG).show();
        final String result = obj.get_httpvalue("http://www.saloni.3eeweb.com/Bus/manage_payment_details.php", l1,getApplicationContext());
        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;
            final int length = jArray.length();
            array = new String[length];
            int j = 0;
            for (int k = 0; k < length; k++) {
                json_data =jArray.getJSONObject(k);
                SearchResults sr1 = new SearchResults();
                // String id=31.170.166.5
            }
        } catch (Exception e) {
        }
    }
}

