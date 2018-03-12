package com.intruders.kisho.studentbuddy.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.intruders.kisho.studentbuddy.R;
import com.intruders.kisho.studentbuddy.utils.DividerItemDecoration;
import com.intruders.kisho.studentbuddy.utils.Events;
import com.intruders.kisho.studentbuddy.utils.EventsAdapter;
import com.intruders.kisho.studentbuddy.utils.RecyclerTouchListener;
import com.intruders.kisho.studentbuddy.utils.ServiceHandler;

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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private List<Events> eventsList = new ArrayList<>();
    private EventsAdapter eventsAdapter;
    private String Name,Time,Location,Members;

    String GET_EVENTLIST = "https://kishore000webhostcom.000webhostapp.com/get_eventList.php";
    RecyclerView recyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String json_event_string;
    String JSON_EVENT_STRING;

    private OnFragmentInteractionListener mListener;

    public EventsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_events, container, false);

        recyclerView =(RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        new GetEvents().execute();

        //  eventsAdapter = new EventsAdapter(eventsList);
        // recyclerView.setAdapter(eventsAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Events events = eventsList.get(position);
                Toast.makeText(getContext(), events.getEventName(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        return v;
    }



    public class GetEvents extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL(GET_EVENTLIST);
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


                jsonObject = new JSONObject(JSON_EVENT_STRING);
                int count = 0;
                jsonArray = jsonObject.getJSONArray("Events");
                while (count<jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    Name = object.getString("Name");
                    Time = object.getString("Time");
                    Location = object.getString("Location");
                    Members = object.getString("Members");
                    Events events = new Events(Name,Time,Location,Members);

                    eventsList.add(events);
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
            callEventList();
        }
    }

    public void callEventList() {

        eventsAdapter = new EventsAdapter(eventsList);
        recyclerView.setAdapter(eventsAdapter);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    //    if (context instanceof OnFragmentInteractionListener) {
     //       mListener = (OnFragmentInteractionListener) context;
     //   } else {
     //       throw new RuntimeException(context.toString()
     //               + " must implement OnFragmentInteractionListener");
     //   }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
