package com.mycaptain.mycaptain;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView lvPersonList;
    ArrayList<String> list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_activity);

        lvPersonList = findViewById(R.id.lv_person_name);

        DatabaseHelperNew dbHelper = new DatabaseHelperNew(this);
        list = dbHelper.getAllPersons();


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_view_activity_item, R.id.tv_person_name, list);

        lvPersonList.setAdapter(adapter);

        lvPersonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
