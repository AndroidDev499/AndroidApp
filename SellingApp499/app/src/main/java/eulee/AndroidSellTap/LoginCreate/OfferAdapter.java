package eulee.AndroidSellTap.LoginCreate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import eulee.AndroidSellTap.ViewOfferActivity;
import eulee.sellingapp499.R;

/**
 * Created by ELEE on 3/6/2016.
 */
public class OfferAdapter extends BaseAdapter {

    private final List<SellTapOffer> offers;
    private Context context;

    public OfferAdapter(Context context, List<SellTapOffer> offers) {
        this.offers = offers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return offers.size();
    }

    @Override
    public Object getItem(int position) {
        return offers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return offers.get(position).getTitle().hashCode();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final DashboardRowDataHolder holder;

        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_offer, null);

            holder = new DashboardRowDataHolder();
            holder.offerImage = (ImageView) row.findViewById(R.id.imageView);
            holder.offerName = (TextView) row.findViewById(R.id.imageTextView);
            holder.offerCreator = (TextView) row.findViewById(R.id.imageTextView2);


            row.setTag(holder);
        } else {
            holder = (DashboardRowDataHolder) row.getTag();
        }

        //Set Image and recipe name
        String filename = offers.get(position).getImage1();
        Picasso.with(context).load(filename).fit().into(holder.offerImage);
        holder.offerName.setText(offers.get(position).getTitle());
        //holder.offerCreator.setText(offers.get(position).getUserCreated().toString());

        //Set Onclick event for Image or TextView too
        holder.offerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToOffer(offers.get(position));
            }
        });
        holder.offerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToOffer(offers.get(position));
            }
        });

        return row;
    }

    public class DashboardRowDataHolder {
        TextView offerName;
        TextView offerCreator;
        ImageView offerImage;
    }

    private void navigateToOffer(SellTapOffer sellTapOffer) {
        Intent offerIntent = new Intent(context, ViewOfferActivity.class);
        offerIntent.putExtra("offerId", sellTapOffer.getObjectId());
        context.startActivity(offerIntent);
    }
}