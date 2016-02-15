package eulee.sellingapp499;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import eulee.sellingapp499.LoginCreate.SellTapOffer;

/**
 * Created by ELEE on 2/14/2016.
 */
public class SellTapOfferListingActivity extends ListActivity{

    private SellTapOffer sellTapOffer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sell_tap_offer);

       sellTapOffer = (SellTapOffer) getIntent().getSerializableExtra("offer");

        String title = sellTapOffer.getTitle();
        setTitle(title);

        TextView screenTitle = (TextView) findViewById(R.id.offerTitle);
        screenTitle.setText(title);

        String url = sellTapOffer.getImage1();
        ImageView screenImage = (ImageView) findViewById(R.id.offerPicture);
        Picasso.with(this).load(url).into(screenImage);




    }
}
