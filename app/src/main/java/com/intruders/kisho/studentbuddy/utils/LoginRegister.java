package com.intruders.kisho.studentbuddy.utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.intruders.kisho.studentbuddy.SelectCollege;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by kisho on 26-08-2017.
 */


public class LoginRegister extends AsyncTask<String,Void,String> {
    Context context;
    public LoginRegister(Context context){
        this.context = context;
    }

    private String LOGIN_URL ="https://kishore000webhostcom.000webhostapp.com/login_data_to_membership.php";
    private String REGISTER_URL ="https://kishore000webhostcom.000webhostapp.com/add_data_to_membership.php";
    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        if (method.equals("register")){
            String username = params[1];
            String userpass = params[2];
            String email = params[3];
            String mobile = params[4];
            try {
                URL url = new URL(REGISTER_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS));

                String data = URLEncoder.encode("Username","UTF-8") +"="+ URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8") +"="+ URLEncoder.encode(userpass,"UTF-8")+"&"+
                URLEncoder.encode("Email","UTF-8") +"="+ URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("Mobile","UTF-8") +"="+ URLEncoder.encode(mobile,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IN = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IN,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    response +=line;
                }
                bufferedReader.close();
                IN.close();
                httpURLConnection.disconnect();

                return response;

               // return "Registration Success...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (method.equals("login")){

            String username = params[1];
            String userpass = params[2];
            try {
                URL url = new URL(LOGIN_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

                String data = URLEncoder.encode("Username","UTF-8") +"="+ URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8") +"="+ URLEncoder.encode(userpass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    response +=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

         if (result.equals("Login Success")){
            Intent i = new Intent(context,SelectCollege.class);
            context.startActivity(i);
        }


    }




}
