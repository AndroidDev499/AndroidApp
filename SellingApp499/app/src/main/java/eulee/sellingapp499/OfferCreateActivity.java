package eulee.sellingapp499;

import java.util.Random;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.files.BackendlessFile;

import eulee.sellingapp499.Backend.Defaults;
import eulee.sellingapp499.LoginCreate.SellTapOffer;

public class OfferCreateActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    static final int CAMERA_REQUEST = 1888;

    ImageView imageView1;
    //ImageView imageView2;
    //ImageView imageView3;
    //ImageView imageView4;
    EditText title;
    EditText description;
    EditText price;
    Bitmap photo;
    SellTapOffer offer;

    int randomNumber;
    String fileName;

    private FloatingActionButton fab;
    private Button creationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_create);

        initUI();
    }

    private void initUI() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView1 = (ImageView) this.findViewById(R.id.imageView1);
        //imageView2 = (ImageView) this.findViewById(R.id.imageView2);
        //imageView3 = (ImageView) this.findViewById(R.id.imageView3);
        //imageView4 = (ImageView) this.findViewById(R.id.imageView4);
        title = (EditText) this.findViewById(R.id.editTextTitle);
        description = (EditText) this.findViewById(R.id.editTextDesc);
        price = (EditText) this.findViewById(R.id.editTextPrice);

        fab = (FloatingActionButton) this.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }

        });

        creationButton = (Button) this.findViewById(R.id.createButton);
        creationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                saveOfferImage();
                saveNewOffer();

                Intent intent = new Intent(OfferCreateActivity.this, MainActivity.class);
                OfferCreateActivity.this.startActivity (intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");

            imageView1.setImageBitmap(photo);

            //add images 2-4 later
            /*if (imageView1.getDrawable() == null) {
                imageView1.setImageBitmap(photo);
            } else if (imageView2.getDrawable() == null) {
                imageView2.setImageBitmap(photo);
            } else if (imageView3.getDrawable() == null) {
                imageView3.setImageBitmap(photo);
            } else if(imageView4.getDrawable() == null) {
                imageView4.setImageBitmap(photo);
            }*/
        }

        //if (imageView4.getDrawable() != null) {
        //    fab.setVisibility(View.INVISIBLE);
        //}
    }

    public void saveOfferImage() {
        Random random = new Random();
        randomNumber = random.nextInt ();
        fileName = "st_" + randomNumber + "_1";

        Backendless.Files.Android.upload(photo,
                Bitmap.CompressFormat.PNG, 100,
                fileName,
                "offerImages",
                new AsyncCallback<BackendlessFile>() {
                    @Override
                    public void handleResponse(BackendlessFile response) {
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                    }
                });
    }

    public void saveNewOffer() {
        offer = new SellTapOffer();
        if (title != null) {
            offer.setTitle(title.getText().toString());
        }
        if (price != null) {
            offer.setPrice(Double.parseDouble(price.getText().toString()));
        }
        if (description != null) {
            offer.setDescription(description.getText().toString());
        }
        offer.setImage1( "https://api.backendless.com/" + Defaults.APPLICATION_ID + "/" + Defaults.VERSION + "/files/" + "offerImages" + "/" + fileName);


        Backendless.Persistence.save(offer, new AsyncCallback<SellTapOffer>() {
            public void handleResponse(SellTapOffer response) {
// new Contact instance has been saved
            }

            public void handleFault(BackendlessFault fault) {
// an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });

    }


}
