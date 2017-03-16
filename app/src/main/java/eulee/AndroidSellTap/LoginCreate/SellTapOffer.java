package eulee.AndroidSellTap.LoginCreate;

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
    private String description;
    private String userCreated;

    private long uploaded;
    private String url;

    public String getObjectId() {
        return objectId;
    }

    public void setOwnerId() {
        this.ownerId = ownerId;
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

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated= userCreated;
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
}
