package QRcheck.com.apple.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CodeKeeper {
    @Id
    private String id;

    private String Empid;
    private Boolean Valid;

    public CodeKeeper() {
    }

    public CodeKeeper(String empid,Boolean valid) {
        Empid = empid;
        Valid=valid;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getValid() {
        return Valid;
    }

    public void setValid(Boolean valid) {
        Valid = valid;
    }

//    public String getTokenId() {
//        return TokenId;
//    }
//
//    public void setTokenId(String tokenId) {
//        TokenId = tokenId;
//    }

    public String getEmpid() {
        return Empid;
    }

    public void setEmpid(String empid) {
        Empid = empid;
    }
}
