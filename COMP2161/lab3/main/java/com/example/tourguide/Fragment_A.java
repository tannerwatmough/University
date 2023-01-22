package com.example.tourguide;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_A#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_A extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OnFragmentInteractionListener mListener;

    public Fragment_A() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_A.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_A newInstance(String param1, String param2) {
        Fragment_A fragment = new Fragment_A();
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
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    /*
     * So since onActivityCreated was deprecated, I spent at least six hours trying
     * to determine how to get it to work. After scouring the web, stack overflow, etc.,
     * all I had to do was search the different on... methods to find onViewCreated which
     * worked perfectly. The joys of programming.
     */

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listview = (ListView) getActivity().findViewById(R.id.listView);
        Resources res = getResources();
        String [] cities = res.getStringArray(R.array.string_array_cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1,android.R.id.text1, cities);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d("TAG", "Fragment Log ->>> Item " + position + " selected!");
                if (mListener != null) {
                    mListener.onFragmentInteraction(position);
                }

                if (position < 5) {
                    TextView cityDescription = (TextView) getActivity().findViewById(R.id.textView);
                    switch (position) {
                        case 0:
                            String calgaryDesc = getResources().getString(R.string.calgaryDescirption);
                            cityDescription.setText(calgaryDesc);
                            break;
                        case 1:
                            String victoriaDesc = getResources().getString(R.string.victoriaDescirption);
                            cityDescription.setText(victoriaDesc);
                            break;
                        case 2:
                            String vancouverDesc = getResources().getString(R.string.vancouverDescirption);
                            cityDescription.setText(vancouverDesc);
                            break;
                        case 3:
                            String torontoDesc = getResources().getString(R.string.torontoDescirption);
                            cityDescription.setText(torontoDesc);
                            break;
                        case 4:
                            String kamloopsDesc = getResources().getString(R.string.kamloopsDescirption);
                            cityDescription.setText(kamloopsDesc);
                            break;
                        default:
                            break;
                    }
                }
            }
        });

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
    }
}