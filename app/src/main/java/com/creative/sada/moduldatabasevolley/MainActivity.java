package com.creative.sada.moduldatabasevolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    List<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_helper);
        db=new DatabaseHelper(this);
        list=new ArrayList<>();
        list.add(new Model("nim","4313010037"));
        list.add(new Model("password","asdf"));
        db.volleyInsertMethodPOst(list,"http://www.technostudylife.com/index.php/techno_login/login");
    }
}
