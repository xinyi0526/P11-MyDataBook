package com.myapplicationdev.android.p12_mydatabook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] drawerItems;
    private int[] drawerIcons;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    FragmentManager fm;
    FragmentTransaction ft;
    ArrayAdapter<String> aa;
    CustomAdapter adapter;
    String currentTitle;
    int currentIcon;
    ActionBar ab;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.left_drawer);

        drawerItems = new String[] { "Bio", "Vaccination", "Anniversary" ,"About Us"};
        drawerIcons = new int[]{android.R.drawable.ic_dialog_info,android.R.drawable.ic_menu_edit,android.R.drawable.ic_menu_today,android.R.drawable.btn_star_big_on};
        ab = getSupportActionBar();

        //aa = new ArrayAdapter<String>(this,
                //android.R.layout.simple_list_item_activated_1, drawerItems);
        adapter = new CustomAdapter(this,drawerItems,drawerIcons);
        drawerList.setAdapter(adapter);

        // Set the list's click listener
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int
                    position, long arg3) {

                Fragment fragment = null;
                if (position == 0) {
                    fragment = new BioFragment();
                    fm = getSupportFragmentManager();
                    ft = fm.beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                } else if (position == 1) {
                    fragment = new VaccinationFragment();
                    fm = getSupportFragmentManager();
                    ft = fm.beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                } else if (position == 2) {
                    fragment = new AnniversaryFragment();
                    fm = getSupportFragmentManager();
                    ft = fm.beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                } else if (position == 3){
                    Intent i = new Intent(getApplicationContext(), AboutUsActivity.class);
                    startActivity(i);
                }




                /*if(position == 3){
                    Intent i = new Intent(getApplicationContext(),AboutUsActivity.class);
                    startActivity(i);
                }*/
                //startActivity(i);

                // Highlight the selected item,
                //  update the title, and close the drawer
                drawerList.setItemChecked(position, true);
                currentTitle = drawerItems[position];
                ab.setTitle(currentTitle);
                currentIcon = drawerIcons[position];
                ab.setIcon(currentIcon);
                drawerLayout.closeDrawer(drawerList);
            }
        });
        currentTitle = this.getTitle().toString();

        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, 	  /* DrawerLayout object */
                R.string.drawer_open, /* "open drawer" description */
                R.string.drawer_close /* "close drawer" description */
        ) {

            /** Would be called when a drawer has completely closed */
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                ab.setTitle(currentTitle);
            }

            /** Would be called when a drawer has completely open */
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                ab.setTitle("P12 - My Data Book");
            }
        };

        // Set the drawer toggle as the DrawerListener
        drawerLayout.addDrawerListener(drawerToggle);
        ab.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync toggle state so the indicator is shown properly.
        //  Have to call in onPostCreate()
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


}
