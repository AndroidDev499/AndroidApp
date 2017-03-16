package eulee.AndroidSellTap;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import eulee.AndroidSellTap.LoginCreate.SellTapOffer;
import eulee.AndroidSellTap.LoginCreate.LoginActivity;
import eulee.AndroidSellTap.LoginCreate.RegisterActivity;
import eulee.AndroidSellTap.NavDrawer.NavigationDrawerCallbacks;
import eulee.AndroidSellTap.NavDrawer.NavigationDrawerFragment;
import eulee.sellingapp499.R;


public class MainActivity extends AppCompatActivity
        implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private Toolbar mToolbar;
    private Boolean loaded = false;

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);

        String appVersion = "v1";
        Backendless.initApp(this, "67F33700-EAE2-361A-FFF6-876070706F00", "331462D8-BB79-FE20-FF8E-8FE74A20F000", appVersion);

        // without this line, onNavigationDrawerItemSelected will run first for some reason
        this.loaded = true;


        gridView = (GridView) findViewById(R.id.gridView);
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
        /*if (id == R.id.action_message) {
            return true;
        }*/

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

class Offer{
    int imageId;
    String offerName;
    Offer (int imageId, String offerName){
        this.imageId = imageId;
        this.offerName = offerName;
    }
}

class offerAdapter extends BaseAdapter {
    ArrayList<Offer> list;
    Context context;
    offerAdapter(Context context){ //fill data
        this.context = context;
        list = new ArrayList<Offer>();
            Resources res = context.getResources();
        String[] offerNames = res.getStringArray(R.array.offernames);
        int[] offerImages = {R.drawable.avatar, R.drawable.avatar, R.drawable.avatar, R.drawable.avatar, R.drawable.avatar, R.drawable.avatar, R.drawable.avatar, R.drawable.avatar, R.drawable.avatar, R.drawable.avatar,};
        for (int i=0;i<10; i++) {
            Offer tempOffer = new Offer(offerImages[i], offerNames[i]);
            list.add(tempOffer);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        ImageButton myOffer;
        TextView myOfferText;
        ViewHolder(View v){
            myOffer= (ImageButton) v.findViewById((R.id.imageViewButton));
            myOfferText= (TextView) v.findViewById((R.id.imageTextView));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;
        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_offer, parent, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        Offer temp = list.get(position);
        holder.myOffer.setImageResource(temp.imageId);
        holder.myOfferText.setText(temp.offerName);
        return row;
    }
}