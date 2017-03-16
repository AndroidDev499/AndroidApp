package eulee.AndroidSellTap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import eulee.sellingapp499.R;

/**
 * Created by Elee on 3/1/2016.
 */
public class ViewOfferActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_offer);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void sendOffer(View view) {
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
    }


    public void askQuestion(View view) {
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
    }

    public void sendReport(View view) {
        //send a report via backendless
    }
}
