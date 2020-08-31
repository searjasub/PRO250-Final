package pro250.mobiledungeon.ui.items;

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

/**
 * A fragment representing a list of Items.
 */
public class ItemFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemFragment newInstance(int columnCount) {
        ItemFragment fragment = new ItemFragment();
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
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

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
                JSONArray array = object.getJSONArray("items");
                for (int i = 0; i < array.length(); i++) {
                    Item item = new Item();
                    JSONObject jo_inside = array.getJSONObject(i);
                    JSONObject names = jo_inside.getJSONObject("name");
                    String singular = names.getString("singular");
                    item.setName(singular);
                    item.setContent("Type: " + jo_inside.getString("type") + " | Rarity: " + jo_inside.getString("rarity") + "\nDamage: "
                            + jo_inside.getString("damage") + " | Hit rate: "+ jo_inside.getString("hitRate") + "\n");

                    if (jo_inside.getString("type").equals("Book")){
                        String tmp = item.getContent();
                        item.setContent(tmp + "\n" + jo_inside.getString("text"));
                    }

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
            InputStream is = Objects.requireNonNull(getContext()).getAssets().open("items.json");
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