package pro250.mobiledungeon.ui.achievements;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import pro250.mobiledungeon.R;
import pro250.mobiledungeon.ui.items.Item;
import pro250.mobiledungeon.ui.items.MyItemRecyclerViewAdapter;

/**
 * A fragment representing a list of Items.
 */
public class AchievementFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AchievementFragment() {
    }


    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AchievementFragment newInstance(int columnCount) {
        AchievementFragment fragment = new AchievementFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_achievement_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            List<Item> items = new ArrayList<>();

            try {
                JSONObject object = new JSONObject(loadJSONFromAsset());
                JSONArray array = object.getJSONArray("achievements");
                for (int i = 0; i < array.length(); i++) {
                    Item item = new Item();
                    JSONObject jo_inside = array.getJSONObject(i);
                    item.setName(jo_inside.getString("name"));
                    item.setContent(jo_inside.getString("info"));
                    items.add(item);
                }

            } catch (JSONException e) {
                System.out.println("Error loading jason?");
                e.printStackTrace();
            }

            Collections.sort(items);
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(items));
        }
        return view;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = Objects.requireNonNull(getContext()).getAssets().open("achievements.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}