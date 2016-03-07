package eulee.AndroidSellTap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.files.BackendlessFile;

import eulee.AndroidSellTap.Backend.Defaults;
import eulee.AndroidSellTap.LoginCreate.SellTapOffer;
import eulee.sellingapp499.R;

public class OfferCreateActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    static final int CAMERA_REQUEST = 1;

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
    String mCurrentPhotoPath;

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
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        imageView1 = (ImageView) this.findViewById(R.id.imageView1);
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
        }
    }

    public void saveOfferImage() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        fileName = "st_" + timeStamp + "_1.jpg"; //.png

        Backendless.Files.Android.upload(photo,
                Bitmap.CompressFormat.PNG, 100,
                fileName,
                "offerImages",
                new AsyncCallback<BackendlessFile>() {
                    @Override
                    public void handleResponse(BackendlessFile response) {
                        Toast.makeText(getApplicationContext(), "Picture Taken", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(OfferCreateActivity.this, fault.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void saveNewOffer() {
        offer = new SellTapOffer();
        if (title != null) {
            offer.setTitle(title.getText().toString());
        }
        if (price != null) {
            offer.setPrice(Integer.parseInt(price.getText().toString()));
        }
        if (description != null) {
            offer.setDescription(description.getText().toString());
        }
        if (Backendless.UserService.CurrentUser() != null) {
            offer.setUserCreated(Backendless.UserService.CurrentUser());
        }
        offer.setImage1("https://api.backendless.com/" + Defaults.APPLICATION_ID + "/" + Defaults.VERSION + "/files/" + "offerImages" + "/" + fileName);



        Backendless.Persistence.save(offer, new BackendlessCallback<SellTapOffer>() {
            public void handleResponse(SellTapOffer response) {
// new Contact instance has been saved
            }

            public void handleFault(BackendlessFault fault) {
                Toast.makeText(OfferCreateActivity.this, fault.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
