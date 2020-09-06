package com.m6code.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.leaderboard.data.SkillQ;
import com.m6code.leaderboard.services.ApiServiceBuilder;
import com.m6code.leaderboard.services.ApiServices;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkillFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkillFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillFragment newInstance(String param1, String param2) {
        SkillFragment fragment = new SkillFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_learning, container, false);

        RecyclerView skillList =  rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        skillList.setLayoutManager(layoutManager);

//        SkillDummyData dummyData = new SkillDummyData();
//        dummyData.initSkillData();
//
//        SkillFragRecyclerAdapter skillFragRecyclerAdapter = new SkillFragRecyclerAdapter(getActivity(), dummyData.getDataList());
//        skillList.setAdapter(skillFragRecyclerAdapter);

        ApiServices apiServices = ApiServiceBuilder.buildApiService(ApiServices.class);
        Call<ArrayList<SkillQ>> topSkillsIQRequest = apiServices.getTopSkillIQScores();

        topSkillsIQRequest.enqueue(new Callback<ArrayList<SkillQ>>() {
            @Override
            public void onResponse(@NotNull Call<ArrayList<SkillQ>> call, @NotNull Response<ArrayList<SkillQ>> response) {
                SkillFragRecyclerAdapter skillFragRecyclerAdapter = new SkillFragRecyclerAdapter(getActivity(), response.body());
                skillList.setAdapter(skillFragRecyclerAdapter);
            }

            @Override
            public void onFailure(@NotNull Call<ArrayList<SkillQ>> call, @NotNull Throwable t) {
                Toast.makeText(getContext(), "Failed to retrieve Skill IQ", Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}