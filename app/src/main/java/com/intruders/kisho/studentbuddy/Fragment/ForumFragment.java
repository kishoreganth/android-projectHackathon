package com.intruders.kisho.studentbuddy.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.intruders.kisho.studentbuddy.MainActivity;
import com.intruders.kisho.studentbuddy.R;
import com.intruders.kisho.studentbuddy.utils.Events;

import im.delight.android.webview.AdvancedWebView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ForumFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ForumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForumFragment extends Fragment implements AdvancedWebView.Listener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private WebView mWebView;
    private String URL_FORUM = "https://hhgg.createaforum.com/index.php?thememode=mobile;redirect=https%3A%2F%2Fhhgg.createaforum.com%2Findex.php%3Faction%3Dregister";
    private OnFragmentInteractionListener mListener;
    String JSON_EVENT_STRING;
    public ForumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForumFragment newInstance(String param1, String param2) {
        ForumFragment fragment = new ForumFragment();
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
                             Bundle save0dInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        ((MainActivity) getActivity())
                .setActionBarTitle("Forum");

        ((AppCompatActivity) getActivity()).getSupportActionBar().show();



        View v = inflater.inflate(R.layout.fragment_forum, container, false);
       mWebView = (WebView)v.findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                Toast.makeText(getContext(), "Finished loading", Toast.LENGTH_SHORT).show();
            }

        });
        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

        });
       // mWebView.addHttpHeader("X-Requested-With", "");
      //  mWebView.loadUrl("https://hhgg.createaforum.com");
        mWebView.loadUrl("https://ajaymysql.000webhostapp.com/forum/main_forum.php");
        return v;

    }
    @SuppressLint("NewApi")
    @Override
    public void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }
    @SuppressLint("NewApi")
    @Override
    public void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }





    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        mWebView.setVisibility(View.INVISIBLE);
    }
    @Override
    public void onPageFinished(String url) {
        mWebView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }


    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) { }

    @Override
    public void onExternalPageRequest(String url) { }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
     //   if (context instanceof OnFragmentInteractionListener) {
      //      mListener = (OnFragmentInteractionListener) context;
     //   } else {
      //      throw new RuntimeException(context.toString()
      //              + " must implement OnFragmentInteractionListener");
     //   }
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
