package com.intruders.kisho.studentbuddy;

import android.app.Activity;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.intruders.kisho.studentbuddy.Fragment.EventsFragment;
import com.intruders.kisho.studentbuddy.utils.College;
import com.intruders.kisho.studentbuddy.utils.Dept;
import com.intruders.kisho.studentbuddy.utils.Events;
import com.intruders.kisho.studentbuddy.utils.Region;
import com.intruders.kisho.studentbuddy.utils.ServiceHandler;
import com.intruders.kisho.studentbuddy.utils.Year;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class  SelectCollege extends Activity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerRegion;
    private Spinner spinnerCollege;
    private Spinner spinnerDept;
    private Spinner spinnerYear;

    JSONObject jsonObject;
    JSONArray jsonArray;
    String json_event_string;
    String Cid,NameCollege,Did,DeptName,Yid,Year;

    private ArrayList<Region> regionArrayList;
    private ArrayList<College> collegeArrayList;
    private ArrayList<Dept> deptArrayList;
    private ArrayList<Year> yearArrayList;
    String JSON_EVENT_STRING;
    private String REGION_URL ="https://kishore000webhostcom.000webhostapp.com/get_regionList.php";
    private String COLLEGE_URL ="https://ajaymysql.000webhostapp.com/get_TamilNaduCollegeList.php";
    private String DEPT_URL ="https://kishore000webhostcom.000webhostapp.com/get_dept.php";
    private String YEAR_URL ="https://kishore000webhostcom.000webhostapp.com/get_yearOfStudy.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_college);

        new GetRegion().execute();
        new GetCollege().execute();
        new GetDept().execute();
        new GetYear().execute();
        spinnerRegion = (Spinner)findViewById(R.id.spin_region);
        spinnerCollege = (Spinner)findViewById(R.id.spin_college);
        spinnerDept = (Spinner)findViewById(R.id.spin_dept);
        spinnerYear = (Spinner)findViewById(R.id.spin_year);

        regionArrayList = new ArrayList<>();
        collegeArrayList = new ArrayList<>();
        deptArrayList = new ArrayList<>();
        yearArrayList = new ArrayList<>();

        spinnerRegion.setOnItemSelectedListener(this);
        spinnerCollege.setOnItemSelectedListener(this);
        spinnerDept.setOnItemSelectedListener(this);
        spinnerYear.setOnItemSelectedListener(this);


    }

    public class GetYear extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL(YEAR_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream in = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

                StringBuilder stringBuilder = new StringBuilder();
                while((json_event_string = bufferedReader.readLine())!=null){

                    stringBuilder.append(json_event_string+"\n");

                }
                bufferedReader.close();
                in.close();
                httpURLConnection.disconnect();
                JSON_EVENT_STRING = stringBuilder.toString().trim();

                Log.e("RESPONSEE->",JSON_EVENT_STRING);
                jsonObject = new JSONObject(JSON_EVENT_STRING);
                int count = 0;
                jsonArray = jsonObject.getJSONArray("Year");
                while (count<jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    Year = object.getString("Year");
                    Yid = object.getString("Yid");

                    Year year = new Year(Yid,Year);
                    yearArrayList.add(year);
                    count++;

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            populateSpinnerYear();
        }
    }

    protected  void populateSpinnerYear() {

        List<String> labels = new ArrayList<String>();

        for (int i = 0;i<yearArrayList.size();i++){

            labels.add(yearArrayList.get(i).getYear());

        }

        ArrayAdapter<String> spinnerYearAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,labels);

        spinnerYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(spinnerYearAdapter);

    }

    public class GetDept extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL(DEPT_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream in = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

                StringBuilder stringBuilder = new StringBuilder();
                while((json_event_string = bufferedReader.readLine())!=null){

                    stringBuilder.append(json_event_string+"\n");

                }
                bufferedReader.close();
                in.close();
                httpURLConnection.disconnect();
                JSON_EVENT_STRING = stringBuilder.toString().trim();

                Log.e("RESPONSEE->",JSON_EVENT_STRING);
                jsonObject = new JSONObject(JSON_EVENT_STRING);
                int count = 0;
                jsonArray = jsonObject.getJSONArray("Dept");
                while (count<jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    DeptName = object.getString("Dept");
                    Did = object.getString("Did");
                    Dept dept = new Dept(Did,DeptName);
                    deptArrayList.add(dept);
                    count++;

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            populateSpinnerDept();
        }
    }

    protected  void populateSpinnerDept() {

        List<String> labels = new ArrayList<String>();

        for (int i = 0;i<deptArrayList.size();i++){

            labels.add(deptArrayList.get(i).getDept());

        }

        ArrayAdapter<String> spinnerDeptAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,labels);

        spinnerDeptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDept.setAdapter(spinnerDeptAdapter);

    }


    public class GetCollege extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL(COLLEGE_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream in = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

                StringBuilder stringBuilder = new StringBuilder();
                while((json_event_string = bufferedReader.readLine())!=null){

                    stringBuilder.append(json_event_string+"\n");

                }
                bufferedReader.close();
                in.close();
                httpURLConnection.disconnect();
                JSON_EVENT_STRING = stringBuilder.toString().trim();

                Log.e("RESPONSEE->",JSON_EVENT_STRING);
                jsonObject = new JSONObject(JSON_EVENT_STRING);
                int count = 0;
                jsonArray = jsonObject.getJSONArray("Name");
                while (count<jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    NameCollege = object.getString("Name");
                    Cid = object.getString("Cid");
                    College college = new College(Cid,NameCollege);

                    collegeArrayList.add(college);
                    count++;

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            populateSpinnerCollege();
        }
    }
    protected  void populateSpinnerCollege() {

        List<String> labels = new ArrayList<String>();

        for (int i = 0;i<collegeArrayList.size();i++){

            labels.add(collegeArrayList.get(i).getName());

        }

        ArrayAdapter<String> spinnerCollegeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,labels);

        spinnerCollegeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCollege.setAdapter(spinnerCollegeAdapter);

    }

    public class GetRegion extends AsyncTask<String,Void,String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... voids) {


            ServiceHandler jsonParser = new ServiceHandler();
            String json = jsonParser.makeServiceCall(REGION_URL, ServiceHandler.GET);

            Log.e("Response: ", ">"+json);

            if (json!=null){
                try{
                    JSONObject jsonObject  = new JSONObject(json);
                    if (jsonObject!=null){
                        JSONArray localities = jsonObject.getJSONArray("Name");

                        for (int i =0;i<localities.length();i++){
                            JSONObject localObj = (JSONObject) localities.get(i);
                            Region region  = new Region(localObj.getInt("Rid"),localObj.getString("Name"));
                            regionArrayList.add(region);
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                Log.e("JSON DATA","dint receive any data");
            }


            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            populateSpinnerLocality();

        }
    }


    protected  void populateSpinnerLocality() {

        List<String> labels = new ArrayList<String>();

        for (int i = 0;i<regionArrayList.size();i++){

            labels.add(regionArrayList.get(i).getRegion());

        }

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,labels);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion.setAdapter(spinnerAdapter);
    }

    public void moveTo(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
