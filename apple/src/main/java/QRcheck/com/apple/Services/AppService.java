package QRcheck.com.apple.Services;

import QRcheck.com.apple.Config.InFileQR;
import QRcheck.com.apple.MailFactory.Generate;
import QRcheck.com.apple.Model.CodeKeeper;
import QRcheck.com.apple.Model.Generator;
import QRcheck.com.apple.Model.Validator;
import QRcheck.com.apple.QrEngine.QrEngine;
import QRcheck.com.apple.repository.CodeRepository;
import QRcheck.com.apple.repository.QrRepository;

import QRcheck.com.apple.repository.ValidRepository;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Service;


import java.io.IOException;

import java.time.LocalDate;


import java.util.List;

import java.util.Optional;

@ServletComponentScan
@Service
@EnableMongoAuditing
public class AppService {


    @Autowired
    QrRepository qrRepository;

    @Autowired
    CodeRepository codeRepository;
    @Autowired
    Generate generate;
    @Autowired
    QrEngine qrEngine;
    @Autowired
    ValidRepository validRepository;

    @Autowired
    InFileQR inFileQR;

//get all
    public List<Generator> allEmp(){ return qrRepository.findAll();}

//get part
    public Optional<Generator> getEmp(String id){
        return  qrRepository.findById(id);
    }


//post - create new licence
    public void newEmp(Generator data){
        try{

            String id= data.getId();
            String name= data.getName();
            String asset= data.getAssetId();
            String serial= data.getSerialTag();

            int idlen=id.length();
            int namelen=name.length();
            int assetlen= asset.length();
            int seriallen= serial.length();
            String TokenString= id.substring(idlen/2)+name.substring(0,namelen/2)+asset.substring(0,assetlen/2)+serial.substring(seriallen/2);
            System.out.println("TokenString="+TokenString);

            data.setHash(Integer.toString(TokenString.hashCode()));
            qrRepository.save(data);

            Validator validator= new Validator();
            validator.setEndDate(data.getEndDate());
            validator.setId(data.getHash());
            validRepository.save(validator);
            CodeKeeper codeKeeper = new CodeKeeper();
            codeKeeper.setEmpid(id);
            codeKeeper.setId(TokenString);

            codeRepository.save(codeKeeper);


            try {

               qrEngine.getQRCodeImage(TokenString);
                generate.run(data.getEmail(),name+LocalDate.now(),TokenString);
             //   System.out.println(QR_CODE_IMAGE_PATH);
            } catch (WriterException e) {
                System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }


//delete
    public void del(String id){
qrRepository.deleteById(id);
    }




    //update
    public void update(String id,Generator data){
     data.setId(id);

        try{

            id= data.getId();
            String name= data.getName();
            String asset= data.getAssetId();
            String serial= data.getSerialTag();

            int idlen=id.length();
            int namelen=name.length();
            int assetlen= asset.length();
            int seriallen= serial.length();
            String TokenString= id.substring(idlen/2)+name.substring(0,namelen/2)+asset.substring(0,assetlen/2)+serial.substring(seriallen/2);
            System.out.println("TokenString="+TokenString);

            data.setHash(Integer.toString(TokenString.hashCode()));
            qrRepository.save(data);
            Validator validator= new Validator();
            validator.setEndDate(data.getEndDate());
            validator.setId(data.getHash());
            validRepository.save(validator);
            CodeKeeper codeKeeper = new CodeKeeper();
            codeKeeper.setEmpid(id);
            codeKeeper.setId(TokenString);
           //String  QR_CODE_IMAGE_PATH ="C:\\Users\\SAURAV ROY\\Desktop\\file\\"+name+LocalDate.now()+".png";
            codeRepository.save(codeKeeper);


            try {

                qrEngine.getQRCodeImage(TokenString);
                generate.run(data.getEmail(),name+LocalDate.now(),TokenString);

            } catch (WriterException e) {
                System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public Optional<CodeKeeper> output(String id){
        Optional<CodeKeeper> codeKeeper= codeRepository.findById(id);
        try {
            CodeKeeper code = new CodeKeeper();
            String empid = codeKeeper.get().getEmpid();
            Boolean valid = true;
            code.setEmpid(empid);
            code.setId(id);

            Optional<Validator>validator= validRepository.findById(Integer.toString(id.hashCode()));


            LocalDate today = LocalDate.now();
           LocalDate enddate = validator.get().getEndDate();
           System.out.println("enddate"+enddate);
            if(today.isAfter(enddate)){
               valid=false;
            }


            code.setValid(valid);
            codeRepository.save(code);


        }catch(Exception e){
            e.printStackTrace();
        }
        return codeRepository.findById(id);

    }


    public Optional<Validator> validate(String id) {
        return validRepository.findById(id);
    }
}
