package QRcheck.com.apple.Model;

import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@Document
public class Generator {
    @Id
    private String id;
    private String Name;
    private String AssetId;
    private LocalDate StartDate;
    private String SerialTag;
    private LocalDate EndDate;
    private String Email;
    private String Hash;




    public Generator(){

    }

    public Generator(String name, String assetId, LocalDate startDate, String serialTag, LocalDate endDate, String email, String hash) {
        Name = name;
        AssetId = assetId;
        StartDate = startDate;
        SerialTag = serialTag;
        EndDate = endDate;
        Email = email;
       Hash=hash;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String hash) {
        Hash = hash;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSerialTag() {
        return SerialTag;
    }

    public void setSerialTag(String serialTag) {
        SerialTag = serialTag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAssetId() {
        return AssetId;
    }

    public void setAssetId(String assetId) {
        AssetId = assetId;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    @Override
    public String toString() {
        return "Generator{" +
                "EmpId='" + id+ '\'' +
                "Name='" + Name + '\'' +
                "AssetId='" + AssetId + '\'' +
                "Email='" + Email + '\'' +
                "StartDate='" + StartDate + '\'' +
                "Hash='" + Hash + '\'' +
                ", EndDate ='" + EndDate +
                '}';
    }


}
