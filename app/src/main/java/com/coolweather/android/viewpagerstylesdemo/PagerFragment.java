package com.coolweather.android.viewpagerstylesdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pager_fragment, container, false);
        TextView textView = (TextView) view .findViewById(R.id.pager_tv_fragment);
        Bundle bundle =getArguments();
        //int ms=bundle.getInt("args");
        String ms=bundle.getString("args");
        textView.setText(ms+"我来了");
        return view ;
    }

}
