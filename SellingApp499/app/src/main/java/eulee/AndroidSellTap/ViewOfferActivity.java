package eulee.AndroidSellTap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.squareup.picasso.Picasso;

import eulee.AndroidSellTap.LoginCreate.LoginActivity;
import eulee.AndroidSellTap.LoginCreate.SellTapOffer;
import eulee.AndroidSellTap.LoginCreate.SellTapUser;
import eulee.sellingapp499.R;

/**
 * Created by Elee on 3/1/2016.
 */
public class ViewOfferActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private AlertDialog.Builder builder;

    String offerId;
    SellTapOffer offer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_offer);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final ImageButton offerImage = (ImageButton) findViewById(R.id.listingImageView);
        final TextView offerPrice = (TextView) findViewById(R.id.priceTextView);
        final TextView offerTitle = (TextView) findViewById(R.id.titleTextView);
        final TextView offerCreator = (TextView) findViewById(R.id.creatorTextView);
        final TextView offerDescription = (TextView) findViewById(R.id.descriptionTextView);

        Intent offerIntent = getIntent();
        Bundle bd = offerIntent.getExtras();
        if (bd != null) {
            offerId = (String) bd.get("offerId");
        }

        Backendless.Persistence.of(SellTapOffer.class).findById(offerId, new AsyncCallback<SellTapOffer>() {
            @Override
            public void handleResponse(SellTapOffer sellTapOffer) {

                Picasso.with(ViewOfferActivity.this).load(sellTapOffer.getImage1()).fit().into(offerImage);
                offerPrice.setText("$" + String.valueOf(sellTapOffer.getPrice()));
                offerTitle.setText(sellTapOffer.getTitle());
                offerCreator.setText(Backendless.UserService.toString());
                offerDescription.setText(sellTapOffer.getDescription());

            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        });


    }

    public void sendOffer(View view) {
        if (Backendless.UserService.CurrentUser() != null) {
            builder = new AlertDialog.Builder(ViewOfferActivity.this);
            builder.setTitle("Send Offer");
            builder.setMessage("How much are you willing to buy it for?");
            LayoutInflater inflater = (ViewOfferActivity.this).getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.dialog_sendoffer, null));
            builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //backendless send email
                    builder = new AlertDialog.Builder(ViewOfferActivity.this);
                    builder.setTitle("Complete");
                    builder.setMessage("An email has been sent to the seller!");
                    builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog1 = builder.create();
                    dialog1.show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog2 = builder.create();
            dialog2.show();
        } else {
            Toast.makeText(ViewOfferActivity.this, "Log in before sending an offer!", Toast.LENGTH_SHORT).show();
            Intent intentFail = new Intent(this, LoginActivity.class);
            startActivity(intentFail);
        }
    }


    public void askQuestion(View view) {
        if (Backendless.UserService.CurrentUser() != null) {
            builder = new AlertDialog.Builder(ViewOfferActivity.this);
            builder.setTitle("Ask the Seller a Question");
            EditText editText = new EditText(ViewOfferActivity.this);
            builder.setView(editText);
            builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //backendless send email with question
                    builder = new AlertDialog.Builder(ViewOfferActivity.this);
                    builder.setTitle("Complete");
                    builder.setMessage("An email has been sent to the seller!");
                    builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog1 = builder.create();
                    dialog1.show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog2 = builder.create();
            dialog2.show();
        } else {
            Toast.makeText(ViewOfferActivity.this, "Log in before asking a question!", Toast.LENGTH_SHORT).show();
            Intent intentFail = new Intent(this, LoginActivity.class);
            startActivity(intentFail);
        }
    }

    public void sendReport(View view) {
        //backendless
        if (Backendless.UserService.CurrentUser() != null) {
            builder = new AlertDialog.Builder(ViewOfferActivity.this);
            builder.setTitle("Report");
            EditText editText = new EditText(ViewOfferActivity.this);
            builder.setView(editText);
            builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //backendless send email with question
                    Toast.makeText(ViewOfferActivity.this, "Your report has been sent.",
                            Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog2 = builder.create();
            dialog2.show();
        } else {
            Toast.makeText(ViewOfferActivity.this, "Log in before sending a report!", Toast.LENGTH_SHORT).show();
            Intent intentFail = new Intent(this, LoginActivity.class);
            startActivity(intentFail);
        }
    }

}
