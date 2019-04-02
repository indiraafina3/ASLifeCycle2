package com.codepolitan.myapplicationviewpager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepolitan.myapplicationviewpager.Config;
import com.codepolitan.myapplicationviewpager.R;
import com.codepolitan.myapplicationviewpager.adapter.MyRecycleViewAdapter;
import com.codepolitan.myapplicationviewpager.artikel.Artikel;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKetiga extends Fragment {

    RecyclerView rvlist;
    List<Artikel> artikelList;
    MyRecycleViewAdapter adapter;

    public FragmentKetiga() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_pertama, container, false);
        rvlist = view.findViewById(R.id.rv_list);
        artikelList = new ArrayList<>();
        rvlist.setLayoutManager(new LinearLayoutManager(getContext()));

//        for (int i = 0; i < 10; i++) {
//        artikelList.add(new Artikel(
//                    "21769",
//                    "python-software-foundation-terima-hibah-170000-dari-mozilla-open-source-program-5a275ad53f531",
//                    "Python Software Foundation Terima Hibah $170.000 dari Mozilla Open Source Program",
//                    "Lod Voldemort",
//                    "http://www.gravatar.com/avatar/6a7d1f244946a619883181f5b6f0cddd?s=100",
//                    "Beberapa waltu yang lalu, Python Software Foundation (PSF) menerima hibah $170.000 dari Mozilla Open Source Program. Hibah ini diberikan oleh...",
//                    "06 Dec 2017",
//                    "http://www.codepolitan.com/python-software-foundation-terima-hibah-170000-dari-mozilla-open-source-program-5a275ad53f531",
//                    "http://static.cdn-cdpl.com/270x135/998b78e349061b4971c0a2b0e8d6be41/header-python-logo-flat-image700x350-crop-image700x350-crop-1-image(700x350)-image(700x350-crop).png",
//                    ""));

        //  rvlist.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new MyRecycleViewAdapter(artikelList,getContext());
        rvlist.setAdapter(adapter);
        readCodepolitan();
        // Inflate the layout for this fragment
        return view;
    }

    public void readCodepolitan() {
        AsyncHttpResponseHandler asyncHttpResponseHandler = new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                Log.d("FragmentPertama", "onSuccess: pembacaan data API dimulai");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("FragmentPertama", "onSuccess: pembacaan data API berhasil");

                String responseStr ="";
                //convert byte to string sebelum parsing
                try {
                    responseStr = new String(responseBody,"UTF-8");
                    JSONObject root = new JSONObject(responseStr);
                    JSONArray result = root.getJSONArray("result");
                    for(int i=0;i<result.length();i++){
                        //dplct ctrl+d
                        JSONObject obj = result.getJSONObject(i);
                        String id = obj.getString("id");
                        String slug = obj.getString("slug");
                        String title = obj.getString("title");
                        String author_name = obj.getString("author_name");
                        String author_image = obj.getString("author_image");
                        String description = obj.getString("description");
                        String date = obj.getString("date");
                        String link = obj.getString("link");
                        String thumbnail = obj.getString("thumbnail");
                        String total_views = obj.getString("total_views");
                        artikelList.add(new Artikel(id,slug,title,author_name,author_image,description,date,link,thumbnail,total_views));
                        adapter.notifyDataSetChanged();
                    }
                } catch (UnsupportedEncodingException e) { //ini exception buat ubah byte jadi string
                    e.printStackTrace();
                } catch (JSONException e) {//ini exception ubah string jd json object
                    e.printStackTrace();
                }

                Log.d("FragmentPertama","OnsuccesData :" + responseStr);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("FragmentPertama", "onFailure: pembacaan data API gagal dngan kode :" + statusCode);

            }
        };
        //deklarasi dan instansiasi/membuat object Asynhttpclient
        AsyncHttpClient client = new AsyncHttpClient();
        //panggo; method dari objecy Asynchttpclient (melakukan request network)
        client.get(Config.BASE_URL + "tutorial", asyncHttpResponseHandler);
    }

}