package groupA;

/**
 * Created by student on 6/20/17.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/*create table Red(

    redDate date,
    redAuthor varChar (255),
    redTitle varChar (255),
    redUrl double,
    redID integer auto_increment,
    primary key (redID)
);*/
@Entity
public class Reddit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@NotNull
    //@Min(1)
    private int redID;
    @NotNull
    @Size(min=2, max=100)
    private String redTitle="  ";
    @NotNull
    @Size(min=2, max=30)
    private String redAuthor="  ";
    @NotNull
    @Size(min=2, max=255)
    private String redUrl="  ";

    private Date redDate=new Date();

    public int getRedID() {
        return redID;
    }

    /*public void setMateID(int redID) {
        this.redID = redID;
    }*/
    public String getRedTitle() {
        return redTitle;
    }

    public String getRedAuthor() {
        return redAuthor;
    }

    public String getRedUrl() {
        return redUrl;
    }


    public Date getRedDate() {
        return redDate;
    }


    public String getFormatDate(){
        SimpleDateFormat format = new SimpleDateFormat("EEEE MMMMM dd, yyyy hh:mm a zzzz", Locale.US);
        return format.format(redDate);
    }

    public void setRedTitle (String redTitle) {
        this.redTitle = redTitle;
    }

    public void setRedAuthor (String redAuthor) {
        this.redAuthor = redAuthor;
    }

    public void setRedUrl (String redUrl) {
        this.redUrl = redUrl;
    }

}