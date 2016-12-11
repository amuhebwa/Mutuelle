package edu.cmu.mutuelle.mutuelle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import edu.cmu.mutuelle.mutuelle.fragment.Reports;

public class OverViewActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Overview elements
    private ImageButton myPlan, payment, reports, addDependent;
    private Button checkinButton;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize Overview elements
        myPlan = (ImageButton) findViewById(R.id.myPlanButton);
        payment = (ImageButton) findViewById(R.id.paymentButton);
        reports = (ImageButton) findViewById(R.id.reportsButton);
        addDependent = (ImageButton) findViewById(R.id.addDependentButton);
        checkinButton = (Button) findViewById(R.id.checkinButton);

        //add on click listeners
        myPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OverViewActivity.this, MyPlanActivity.class));
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OverViewActivity.this, MyPaymentsActivity.class));
            }
        });

        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OverViewActivity.this, ReportsActivity.class));
            }
        });

        addDependent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OverViewActivity.this, AddDependentActivity.class));
            }
        });

        checkinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OverViewActivity.this, CheckInActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }

    // Display selected scree
    private void displaySelectedScreen(int itemId)
    {
        Fragment fragment = null;
        switch (itemId)
        {
            case R.id.nav_subscription:
                startActivity(new Intent(this, NewSubscriptionActivity.class));
                break;
            case  R.id.nav_payment:
                startActivity(new Intent(OverViewActivity.this, MyPaymentsActivity.class));
                break;
            case R.id.nav_nearbyHospital:
                startActivity(new Intent(this, NearbyActivity.class));
                break;
            case R.id.nav_add_dependent:
                startActivity(new Intent(this, AddDependentActivity.class));
                break;
            case R.id.nav_reports:
                startActivity(new Intent(this, ReportsActivity.class));
                break;
        }
        if (fragment != null)
        {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_main, fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}