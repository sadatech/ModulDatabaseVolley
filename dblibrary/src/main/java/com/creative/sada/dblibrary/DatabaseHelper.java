package com.creative.sada.dblibrary;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Toshiba-PC on 8/9/2016.
 */
public class DatabaseHelper {
    private ProgressDialog progressDialog;
    Context context;

    public DatabaseHelper() {
    }

    public DatabaseHelper(Context context) {
        this.context = context;
    }

    public void volleyInsertMethodPOst(final List<Model> list, String url) {
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
        StringRequest strReq = new StringRequest(Request.Method.POST, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONArray jsonArray = null;
                Log.e("data", s);
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressDialog.dismiss();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                for (int i = 0; i <list.size() ; i++) {
                    params.put(list.get(i).getKey(), list.get(i).getValue());
                }
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(strReq);
    }
}
