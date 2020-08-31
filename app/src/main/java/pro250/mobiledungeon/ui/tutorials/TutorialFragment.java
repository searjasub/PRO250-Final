package pro250.mobiledungeon.ui.tutorials;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import pro250.mobiledungeon.R;

public class TutorialFragment extends Fragment {

    private TutorialViewModel tutorialViewModel;
    private TextView textViewTutorial;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tutorialViewModel = ViewModelProviders.of(this).get(TutorialViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tutorial, container, false);

        textViewTutorial = root.findViewById(R.id.textViewTutorial);
        textViewTutorial.setText("The Game\nDungeon is a text-based, turn-based, open-world role-playing game.\n\nThe World\nYou are in control of a character and completely free to explore the world in which you start. This world is a tridimensional matrix of locations that vary from arid deserts to warm and moist swamps. Different foes lurk the land but will not attack you unless you harm them, what allows you to explore the world freely while searching for items.\nOn the ground, you will find a wide variety of items, from small edible fruits to fearsome weapons and tomes about magical spells. Collecting these items and using them in the appropriate occasions is the difference between conquering this world and dying to a rat.\n\nThe Character\nThe character is a human who woke up one day without remembering anything about what happened. He finds himself in a strange place and surrounded by various different creatures. While some of these creatures are familiar to him, there are monsters he has never seen before.\n\nFirst steps\nYou can issue 'commands' at any time to see a complete list of available commands.\nThe 'pick' command is used to grab something from the ground. Use 'items' to see what your character is carrying and 'eat' and 'equip' to manipulate the items in your inventory. Don't want something anymore? Just 'drop' it.\nIn order to walk to a given direction, issue 'go' followed by the direction towards which you want to move the character. e.g., 'go north'. Alternatively, use only the first character of the direction, as in 'go s'.\nTo issue your character to attempt to kill a creature use 'kill' followed by part of the name of the creature.\nIn order to regain your lost hit points you can eat, rest or sleep. Only eating and sleeping will heal you up to your full health. The character can only sleep when it is dark.");

        return root;
    }
}