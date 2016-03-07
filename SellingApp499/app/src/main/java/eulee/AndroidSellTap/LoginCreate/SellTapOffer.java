package eulee.AndroidSellTap.LoginCreate;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

/**
 * Created by Elee on 2/13/2016.
 */
public class SellTapOffer {
    private String objectId;
    private String ownerId;
    private String title;
    private java.util.Date updated;
    private java.util.Date created;
    private int price;
    private String image1;
    private String description;
    private String userCreated;

    public SellTapOffer() {
    }

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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(BackendlessUser userCreated) {
        this.userCreated = userCreated.toString();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage1() {
        return image1;
    } //getURL

    public void setImage1(String image1) {
        this.image1 = image1; //setURL
    }

    public SellTapOffer save() {
        return Backendless.Data.of(SellTapOffer.class).save(this);
    }

    public void saveAsync(AsyncCallback<SellTapOffer> callback) {
        Backendless.Data.of(SellTapOffer.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(SellTapOffer.class).remove(this);
    }


    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(SellTapOffer.class).remove(this, callback);
    }

    public static SellTapOffer findById(String id) {
        return Backendless.Data.of(SellTapOffer.class).findById(id);
    }


    public static void findByIdAsync(String id, AsyncCallback<SellTapOffer> callback) {
        Backendless.Data.of(SellTapOffer.class).findById(id, callback);
    }

    public static SellTapOffer findFirst() {
        return Backendless.Data.of(SellTapOffer.class).findFirst();
    }


    public static void findFirstAsync(AsyncCallback<SellTapOffer> callback) {
        Backendless.Data.of(SellTapOffer.class).findFirst(callback);
    }

    public static SellTapOffer findLast() {
        return Backendless.Data.of(SellTapOffer.class).findLast();
    }


    public static void findLastAsync(AsyncCallback<SellTapOffer> callback) {
        Backendless.Data.of(SellTapOffer.class).findLast(callback);
    }

    public static BackendlessCollection<SellTapOffer> find(BackendlessDataQuery query) {
        return Backendless.Data.of(SellTapOffer.class).find(query);
    }


    public static void getAllOffers(AsyncCallback<BackendlessCollection<SellTapOffer>> callback) {
        Backendless.Data.of(SellTapOffer.class).find(callback);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<SellTapOffer>> callback) {
        Backendless.Data.of(SellTapOffer.class).find(query, callback);
    }

}
