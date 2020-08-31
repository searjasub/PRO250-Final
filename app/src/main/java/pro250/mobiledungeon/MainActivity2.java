package pro250.mobiledungeon;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import pro250.mobiledungeon.java.commands.IssuedCommand;
import pro250.mobiledungeon.java.game.DungeonString;
import pro250.mobiledungeon.java.game.Game;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public Game g;
    public DungeonString startState;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_items, R.id.nav_tutorial, R.id.nav_achievements, R.id.nav_location)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        g = new Game();
        g.ma2 = this;
        g.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void OnSubmitButtonClicked(View view) {
        EditText e = (EditText) findViewById(R.id.editTextTextPersonName);
        String input = e.getText().toString();
        e.setText("");
        IssuedCommand ic = new IssuedCommand(input);
        g.processInput(ic);
    }

    public void AddToLog(String s) {
        TextView log = (TextView) findViewById(R.id.dungeonLog);
        if(counter == 0) {
            log.setText("");
            log.setMovementMethod(new ScrollingMovementMethod());
            log.append(startState.builder.toString());
            counter++;
        }
        log.append(s);
    }
}