package com.example.ousama.medical;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Med {
    private ArrayList<String> AllSpecialists;
    private  ArrayList<String> AllRegions;
    public static ArrayList<Locations> AllLocations;
    private Context context;

    public Med(Context context) {
        this.context = context;
        AllSpecialists = new ArrayList<String>();
        AllRegions = new ArrayList<String>();
        AllLocations = new ArrayList<Locations>();
    }

    public void updateSpecialists(final Spinner spAllSpecialists) {
        String url = "http://app-1515400395.000webhostapp.com/getSpecialist.php";
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        // Request a json response from the provided URL.
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray ja) {
                        try {
                            for (int i = 0;i < ja.length();i++) {
                                JSONObject st = ja.getJSONObject(i);

                                AllSpecialists.add(st.getString("Description"));
                            }
                            spAllSpecialists.setAdapter(new ArrayAdapter<String>(context,
                                    android.R.layout.simple_list_item_1, AllSpecialists));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "That didn't work", Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(jsonRequest);
    }

    public void updateRegions(final Spinner spAllRegions) {
        String url = "http://app-1515400395.000webhostapp.com/getRegion.php";
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a json response from the provided URL.
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray ja) {
                        try {
                            for (int i = 0;i < ja.length();i++) {
                                JSONObject st = ja.getJSONObject(i);

                                AllRegions.add(st.getString("Name"));
                                AllLocations.add(new Locations(Double.parseDouble(st.getString("Longitude")), Double.parseDouble(st.getString("Latitude"))));
                            }
                            spAllRegions.setAdapter(new ArrayAdapter<String>(context,
                                    android.R.layout.simple_list_item_1, AllRegions));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "That didn't work", Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(jsonRequest);
    }



}

