package com.intruders.kisho.studentbuddy.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by kisho on 28-06-2017.
 */

public class ServiceHandler {

     static InputStream is =null;
    static String response = null;
    public final static  int GET =1;
    public final static int POST=2;

    public ServiceHandler(){

    }

    public String makeServiceCall(String url,int method){
        return this.makeServiceCall(url,method,null);
    }

    public String makeServiceCall(String url, int method, List<NameValuePair> params){

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            if (method == POST){
                HttpPost httpPost = new HttpPost(url);
                if (params!=null){
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                }
                httpResponse = httpClient.execute(httpPost);
            }else if (method == GET){
                if (params!=null){
                    String paramString = URLEncodedUtils.format(params,"UTF-8");
                    url += "?" + paramString;
                }
                HttpGet httpGet = new HttpGet(url);
                httpResponse = httpClient.execute(httpGet);
            }
            httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is,"UTF-8"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                sb.append(line + "\n");
            }
            is.close();
            response = sb.toString();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

}
