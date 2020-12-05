package com.miraz.tvmaze.view.fragments;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.miraz.tvmaze.R;
import com.miraz.tvmaze.model.entitites.Episode;
import com.miraz.tvmaze.model.entitites.Show;
import com.miraz.tvmaze.presenter.ListEpisodesPresenter;
import com.miraz.tvmaze.presenter.interfaces.IListEpisodes;
import com.miraz.tvmaze.utils.RecyclerViewOnItemClickListener;
import com.miraz.tvmaze.view.adapters.EpisodeAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;


public class InfoShowFragment extends Fragment implements IListEpisodes.View {

    private Show show;
    private static final String ARG_PARAM1 = "show";
    @BindView(R.id.name) TextView name;
    @BindView(R.id.image) ImageView image;
    @BindView(R.id.summary) TextView summary;
    @BindView(R.id.on_air) TextView onAir;
    @BindView(R.id.genres) TextView genres;
    @BindView(R.id.episodes) RecyclerView recycler;
    private AlertDialog dialog;

    public InfoShowFragment() {
        // Required empty public constructor
    }

    public static InfoShowFragment newInstance(Show show) {
        InfoShowFragment fragment = new InfoShowFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, show);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            show = (Show)getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_show, container, false);
        ButterKnife.bind(this, view);

        SpotsDialog.Builder sp = new SpotsDialog.Builder();
        sp.setContext(getContext()).setCancelable(false).setMessage("Loading...");
        dialog = sp.build();

        ListEpisodesPresenter presenter = new ListEpisodesPresenter(this);
        dialog.show();
        presenter.makeQuery(show.getId());

        setViews();
        return view;
    }

    private void setViews(){
        name.setText(Html.fromHtml("<b>" + show.getName() +"</b>", Html.FROM_HTML_MODE_COMPACT));

        if (show.getImage() != null) {
            if(show.getImage().getMedium() != null) {
                Picasso.get().load(show.getImage().getMedium()).into(image);
            } else if(show.getImage().getOriginal() != null){
                Picasso.get().load(show.getImage().getOriginal()).into(image);
            }
        }

        String s = "<b>Summary:</b> " +  show.getSummary();
        summary.setText(Html.fromHtml(s, Html.FROM_HTML_MODE_COMPACT));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            summary.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }
        String o = "<b>Schedule:</b> " + toCSV(show.getSchedule().getDays()) + " at " + show.getSchedule().getTime() + " (" + show.getRuntime() + "min)";
        onAir.setText(Html.fromHtml(o, Html.FROM_HTML_MODE_COMPACT));

        if(show.getGenres() != null && !show.getGenres().isEmpty()) {
            String g = "<br><b>Genres:</b> " + toCSV(show.getGenres()) + "<br>";
            genres.setText(Html.fromHtml(g, Html.FROM_HTML_MODE_COMPACT));
        }
    }

    private String toCSV(List<String> array) {
        String result = "";
        if (!array.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String s : array) {
                sb.append(s).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            result = sb.deleteCharAt(sb.length() - 1).toString();
        }
        return result;
    }


    @Override
    public void showEpisodes(final ArrayList<Episode> episodes) {
        GridLayoutManager grid = new GridLayoutManager(getContext(), 1);
        recycler.setLayoutManager(grid);
        EpisodeAdapter adapter = new EpisodeAdapter(episodes, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Fragment fragment = InfoEpisodeFragment.newInstance(episodes.get(position));
                assert getFragmentManager() != null;
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        recycler.setAdapter(adapter);
        dialog.dismiss();
    }
}