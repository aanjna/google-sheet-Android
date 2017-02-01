package com.prodyogic.google_sheet_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class InfoActivity extends AppCompatActivity {

    private RadioGroup groupGender;
    private RadioButton radioButtonGender;
    private Button buttonEnterData2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        onClickListenerButton();

    }

    public void onClickListenerButton() {

        groupGender = (RadioGroup) findViewById(R.id.groupGender);
        buttonEnterData2 = (Button) findViewById(R.id.buttonEnterData2);

        final String email = getIntent().getStringExtra("eSalary");

        buttonEnterData2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedID = groupGender.getCheckedRadioButtonId();
                radioButtonGender = (RadioButton) findViewById(selectedID);

                Intent intent = new Intent(InfoActivity.this,GetDataActivity.class);

                intent.putExtra("email",email);
                intent.putExtra("eGender",radioButtonGender.getText().toString());
                startActivity(intent);

            }
        });

    }
}
