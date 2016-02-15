package eulee.sellingapp499.LoginCreate;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

import java.io.File;
import eulee.sellingapp499.Future;

/**
 * Created by Elee on 2/13/2016.
 */
public class SellTapOffer {
    private String objectId;
    private String ownerId;
    private String Title;
    private java.util.Date updated;
    private java.util.Date created;
    private double Price;
    private String image1;
    //set images 2-4 later
    //private File image2;
    //private File image3;
    //private File image4;
    //File types are where the images are being stored
    private String description;

    public String getObjectId() {
        return objectId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getImage1() {
        return image1;
    } //getURL

    public void setImage1(String image1) {
        this.image1 = image1; //setURL
    }

    /*public File getImage2() {
        return image2;
    }

    public void setImage2(File image2) {
        this.image2 = image2;
    }

    public File getImage3() {
        return image3;
    }

    public void setImage3(File image3) {
        this.image3 = image3;
    }

    public File getImage4() {
        return image4;
    }

    public void setImage4(File image4) {
        this.image4 = image4;
    }*/

    public SellTapOffer save()
    {
        return Backendless.Data.of( SellTapOffer.class ).save( this );
    }

    public Future<SellTapOffer> saveAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<SellTapOffer> future = new Future<SellTapOffer>();
            Backendless.Data.of( SellTapOffer.class ).save( this, future );

            return future;
        }
    }

    public void saveAsync( AsyncCallback<SellTapOffer> callback )
    {
        Backendless.Data.of( SellTapOffer.class ).save( this, callback );
    }

    public Long remove()
    {
        return Backendless.Data.of( SellTapOffer.class ).remove( this );
    }

    public Future<Long> removeAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<Long> future = new Future<Long>();
            Backendless.Data.of( SellTapOffer.class ).remove( this, future );

            return future;
        }
    }

    public void removeAsync( AsyncCallback<Long> callback )
    {
        Backendless.Data.of( SellTapOffer.class ).remove( this, callback );
    }

    public static SellTapOffer findById( String id )
    {
        return Backendless.Data.of( SellTapOffer.class ).findById( id );
    }

    public static Future<SellTapOffer> findByIdAsync( String id )
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<SellTapOffer> future = new Future<SellTapOffer>();
            Backendless.Data.of( SellTapOffer.class ).findById( id, future );

            return future;
        }
    }

    public static void findByIdAsync( String id, AsyncCallback<SellTapOffer> callback )
    {
        Backendless.Data.of( SellTapOffer.class ).findById( id, callback );
    }

    public static SellTapOffer findFirst()
    {
        return Backendless.Data.of( SellTapOffer.class ).findFirst();
    }

    public static Future<SellTapOffer> findFirstAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<SellTapOffer> future = new Future<SellTapOffer>();
            Backendless.Data.of( SellTapOffer.class ).findFirst( future );

            return future;
        }
    }

    public static void findFirstAsync( AsyncCallback<SellTapOffer> callback )
    {
        Backendless.Data.of( SellTapOffer.class ).findFirst( callback );
    }

    public static SellTapOffer findLast()
    {
        return Backendless.Data.of( SellTapOffer.class ).findLast();
    }

    public static Future<SellTapOffer> findLastAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<SellTapOffer> future = new Future<SellTapOffer>();
            Backendless.Data.of( SellTapOffer.class ).findLast( future );

            return future;
        }
    }

    public static void findLastAsync( AsyncCallback<SellTapOffer> callback )
    {
        Backendless.Data.of( SellTapOffer.class ).findLast( callback );
    }

    public static BackendlessCollection<SellTapOffer> find( BackendlessDataQuery query )
    {
        return Backendless.Data.of( SellTapOffer.class ).find( query );
    }

    public static Future<BackendlessCollection<SellTapOffer>> findAsync( BackendlessDataQuery query )
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<BackendlessCollection<SellTapOffer>> future = new Future<BackendlessCollection<SellTapOffer>>();
            Backendless.Data.of( SellTapOffer.class ).find( query, future );

            return future;
        }
    }

    public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<SellTapOffer>> callback )
    {
        Backendless.Data.of( SellTapOffer.class ).find( query, callback );
    }
}
