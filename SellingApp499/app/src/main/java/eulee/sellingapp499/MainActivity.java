package eulee.sellingapp499;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eulee.sellingapp499.Backend.LoadingCallback;
import eulee.sellingapp499.LoginCreate.LoginActivity;
import eulee.sellingapp499.LoginCreate.RegisterActivity;
import eulee.sellingapp499.LoginCreate.SellTapOffer;
import eulee.sellingapp499.NavDrawer.NavigationDrawerCallbacks;
import eulee.sellingapp499.NavDrawer.NavigationDrawerFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private Toolbar mToolbar;
    private Boolean loaded = false;

    private BackendlessCollection<SellTapOffer> sellTapOffers;
    private List<SellTapOffer> totalSellTapOffers = new ArrayList<>();
    private boolean isLoadingItems = false;
    private OfferAdapter adapter;

    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);

        String appVersion = "v1";
        Backendless.initApp(this, "67F33700-EAE2-361A-FFF6-876070706F00", "331462D8-BB79-FE20-FF8E-8FE74A20F000", appVersion);

        // without this line, onNavigationDrawerItemSelected will run first for some reason
        this.loaded = true;
/*
        adapter = new OfferAdapter(MainActivity.this, R.layout.grid_item_offer, totalSellTapOffers);
        setListAdapter (adapter);

        QueryOptions queryOptions = new QueryOptions();
        queryOptions.setRelated(Arrays.asList("title"));

        BackendlessDataQuery query = new BackendlessDataQuery(queryOptions);

        Backendless.Data.of(SellTapOffer.class).find(query, new LoadingCallback<BackendlessCollection<SellTapOffer>>(this, "Loading offers...", true) {
            @Override
            public void handleResponse(BackendlessCollection<SellTapOffer> sellTapOfferBackendlessCollection) {
                sellTapOffers = sellTapOfferBackendlessCollection;
                addMoreItems(sellTapOfferBackendlessCollection);
                super.handleResponse(sellTapOfferBackendlessCollection);
            }
        });

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                {
                    if (needToLoadItems(firstVisibleItem, visibleItemCount, totalItemCount)) {
                        isLoadingItems = true;

                        sellTapOffers.nextPage(new LoadingCallback<BackendlessCollection<SellTapOffer>>(MainActivity.this) {
                            @Override
                            public void handleResponse(BackendlessCollection<SellTapOffer> nextPage) {
                                sellTapOffers = nextPage;

                                addMoreItems(nextPage);

                                isLoadingItems = false;
                            }
                        });
                    }
                }
            }

        }); */     //figure out how to make this work with listactivity
    }

    /**
     * Determines whether is it needed to load more items as user scrolls down.
     *
     * @param firstVisibleItem number of the first item visible on screen
     * @param visibleItemCount number of items visible on screen
     * @param totalItemCount   total number of items in list
     * @return true if user is about to reach the end of a list, else false
     */
    private boolean needToLoadItems(int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        return !isLoadingItems && totalItemCount != 0 && totalItemCount - (visibleItemCount + firstVisibleItem) < visibleItemCount / 2;
    }

    /**
     * Adds more items to list and notifies Android that dataset has changed.
     *
     * @param nextPage list of new items
     */
    private void addMoreItems(BackendlessCollection<SellTapOffer> nextPage) {
        totalSellTapOffers.addAll(nextPage.getCurrentPage());
        adapter.notifyDataSetChanged();
    }

    //@Override
    protected void onListItemClick(GridView l, View v, int position, long id) {
        Intent showOfferDetails = new Intent(this, SellTapOfferListingActivity.class);
        //showOfferDetails.putExtra( "offer", totalSellTapOffers.get(position));
        startActivity (showOfferDetails);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        if (!this.loaded) {
            return;
        }

        // update the main content by replacing fragments
        //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();

        switch (position) {
            case 0:
                Intent intent0 = new Intent(this, OfferCreateActivity.class);
                startActivity(intent0);
                break;
            case 1:
                //Intent intent1 = new Intent(this,MainActivity.class);
                //startActivity(intent1);
                Toast.makeText(this, R.string.AlphaDisabled, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                //Intent intent2 = new Intent(this, SettingsActivity.class);
                //startActivity(intent2);
                Toast.makeText(this, R.string.AlphaDisabled, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Intent intent3 = new Intent(this, LoginActivity.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(this, RegisterActivity.class);
                startActivity(intent4);
                break;
        }
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_message) {
            return true;
        }
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickedAlphaMessage(MenuItem item) {
        //Intent intent = new Intent(this, ChooseNicknameActivity.class);
        //startActivity(intent);

        Toast.makeText(this, R.string.AlphaDisabled, Toast.LENGTH_SHORT).show();
    }

}

