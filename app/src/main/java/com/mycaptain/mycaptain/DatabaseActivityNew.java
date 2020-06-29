package com.mycaptain.mycaptain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DatabaseActivityNew extends AppCompatActivity implements View.OnClickListener {
    EditText etInputText, etInputTextName;
    TextView tvResult;
    Button btnAdd, btnDelete, btnUpdate, btnGet, btnGetAll;
    DatabaseHelperNew databaseHelperNew;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_activity_new);

        initialize();
        setClickListerncers();
    }



    private void initialize() {
        etInputText = findViewById(R.id.et_input_text);
        etInputTextName = findViewById(R.id.et_input_text_name);
        tvResult = findViewById(R.id.tv_result);
        btnAdd = findViewById(R.id.btn_add_record);
        btnDelete = findViewById(R.id.btn_delete_record);
        btnUpdate = findViewById(R.id.btn_update_record);
        btnGet = findViewById(R.id.btn_get_record);
        btnGetAll = findViewById(R.id.btn_get_all_record);
    }

    private void setClickListerncers() {
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnGet.setOnClickListener(this);
        btnGetAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_record:

                String value = etInputText.getText().toString();
                if(!value.isEmpty()) {
                    databaseHelperNew = new DatabaseHelperNew(this);
                    String id = databaseHelperNew.addRecord(value);

                    tvResult.setText(id);
                }
                break;
            case R.id.btn_delete_record:
                String value1 = etInputText.getText().toString();
                if(!value1.isEmpty()){
                    databaseHelperNew = new DatabaseHelperNew(this);
                    databaseHelperNew.deleteRecord(Integer.parseInt(value1)); //string to integer
                }
                break;
            case R.id.btn_update_record:
                String id = etInputText.getText().toString();
                //We had bug over here previously it was String name = etInputText.getText().toString();
                // we were getting the id instead of name
                String name = etInputTextName.getText().toString();
                if(!id.isEmpty() && !name.isEmpty()) {
                    databaseHelperNew = new DatabaseHelperNew(this);
                    databaseHelperNew.updatePerson(Integer.parseInt(id), name);
                }
                break;
            case R.id.btn_get_record:
                String id1 = etInputText.getText().toString();
                if(!id1.isEmpty()){
                    databaseHelperNew = new DatabaseHelperNew(this);
                    String valueResult = databaseHelperNew.getPerson(Integer.parseInt(id1));
                    tvResult.setText(valueResult);
                }
                break;
            case R.id.btn_get_all_record:
                Intent listViewActivity = new Intent(DatabaseActivityNew.this,
                        ListViewActivity.class);
                startActivity(listViewActivity);
                break;
            default:
                break;

        }
    }
}
