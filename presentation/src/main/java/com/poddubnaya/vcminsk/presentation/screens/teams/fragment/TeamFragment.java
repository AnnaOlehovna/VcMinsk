package com.poddubnaya.vcminsk.presentation.screens.teams.fragment;



import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poddubnaya.vcminsk.BR;
import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.databinding.FragmentTeamBinding;

public class TeamFragment extends Fragment {

    public static final String TEAM_NAME = "TEAM_NAME";

    private String team;
    private Activity activity;

    private  TeamViewModel teamViewModel;
    private FragmentTeamBinding binding;

    public void setActivity(Activity activity){
        this.activity = activity;
    }

    public static TeamFragment newInstance(String team) {
        Bundle args = new Bundle();
        args.putString(TEAM_NAME, team);
        TeamFragment fragment = new TeamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        team = getArguments().getString(TEAM_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_team,container,false);
        if(binding==null){
            binding = FragmentTeamBinding.bind(root);
        }
        teamViewModel = ViewModelProviders.of(this).get(TeamViewModel.class);
        teamViewModel.setTeamName(team);
        binding.setVariable(BR.viewModel,teamViewModel);

        binding.playersRecycler.setLayoutManager(new LinearLayoutManager(activity));
        binding.playersRecycler.setHasFixedSize(true);
        binding.playersRecycler.setAdapter(teamViewModel.playerAdapter);

        binding.staffRecycler.setLayoutManager(new LinearLayoutManager(activity));
        binding.staffRecycler.setHasFixedSize(true);
        binding.staffRecycler.setAdapter(teamViewModel.staffAdapter);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        teamViewModel.onResume();
    }
}
