package com.example.vechet.loginfrom_num;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.vechet.loginfrom_num.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button btnInsert, btnGet, btnSearch, btnDelete;
    UserDao userDao;
    EditText etUser, etPass;
    RecyclerView recyclerView;
    UserAdapter adapter;
    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        etUser.setOnClickListener(v->{
                adapter.clearData();
        });

        etPass.setOnClickListener(v -> {
                adapter.clearData();
        });

        btnDelete.setOnClickListener(v -> {
            String name = etUser.getText().toString();
            if(userDao.searchName(name).size() != 0) {
                userDao.removeByName(name);
                adapter.clearData();
                ToastMessage.showMessage(this,"Delete Successful.");
            }else{
                ToastMessage.showMessage(this,"Delete Failed.");
            }

        });

        btnSearch.setOnClickListener(v -> {
            String name = etUser.getText().toString();
            if(userDao.searchName(name).size() != 0){
                adapter.clearData();
                adapter.setUsers(userDao.searchName(name));
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);
            }else {
                ToastMessage.showMessage(this,"Name not found!");
                adapter.clearData();
            }

        });

        btnInsert.setOnClickListener(v -> {
            if((etUser.getText().length() != 0) && (etPass.getText().length() != 0)){
                User user = new User();
                user.name = etUser.getText().toString();
                user.password = etPass.getText().toString();
                userDao.addUser(user);
                ToastMessage.showMessage(this, "Insert Success.");
                etPass.setText("");
                etUser.setText("");
                etUser.requestFocus();
            }else{
                ToastMessage.showMessage(this,"You must input First!");
            }

        });

        btnGet.setOnClickListener(v -> {
            adapter.clearData();
            adapter = new UserAdapter(users, MainActivity.this);
            adapter.setUsers(userDao.getAllUser());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

            Log.e(TAG, "onCreate: " + userDao.getAllUser() );
        });

    }

    private void initView() {
        btnInsert = findViewById(R.id.btnInsert);
        btnGet = findViewById(R.id.btnShowAll);
        btnSearch = findViewById(R.id.btnSearch);
        btnDelete = findViewById(R.id.btnDelete);
        userDao = LoginDatabase.getDatabase(this).getUserDao();
        etPass = findViewById(R.id.etPassword);
        etUser = findViewById(R.id.etUserName);
        recyclerView = findViewById(R.id.recyclerView);

    }
}
