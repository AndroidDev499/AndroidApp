package eulee.AndroidSellTap.LoginCreate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import eulee.sellingapp499.R;

import java.util.List;

/**
 * Created by ELEE on 2/14/2016.
 */
public class OfferAdapter extends ArrayAdapter<SellTapOffer> {

    private LayoutInflater mInflater;
    private int mResource;
    private Context context;

    /**
     * Constructor
     *
     * @param context     The current context.
     * @param resource    The resource ID for a layout file containing a TextView to use when
     *                    instantiating views.
     * @param restaurants The objects to represent in the ListView.
     */
    public OfferAdapter( Context context, int resource, List<SellTapOffer> restaurants )
    {
        super( context, resource, restaurants );
        mResource = resource;
        mInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        this.context = context;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getView( int position, View convertView, ViewGroup parent )
    {
        View view = convertView == null ? mInflater.inflate( mResource, parent, false ) : convertView;

        TextView offerTitleView = (TextView) view.findViewById( R.id.offerTitle );
        ImageView offerImageView = (ImageView) view.findViewById( R.id.offerPicture );

        SellTapOffer item = getItem(position);

        offerTitleView.setText(item.getTitle());
        Picasso.with(context).load(item.getImage1()).into(offerImageView);

        return view;
    }
}
