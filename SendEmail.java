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

import java.io.FileWriter;;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class SendEmail {

	public void email(Generate data) {
		
		Queue<Object> q= new LinkedList<>();
		
		try {
			
			q.peek();
			
			try {
				
				q.peek();
				
				try {
					
					q.peek();
					
					try {
						
						generate.run(data.getEmail(),name+LocalDate.now());
					}catch(Exception e) {
						
						q.add(generate.run(data.getEmail(),name+LocalDate.now()));
					}
				}catch(Exception e) {
					
					q.add(generate.run(data.getEmail(),name+LocalDate.now()));
				}
			}catch(Exception e) {
				
				q.add(generate.run(data.getEmail(),name+LocalDate.now()));
			}
		}catch(Exception e) {
			try {
			 	FileWriter fw=new FileWriter("D:\\failedMail.txt");    
	            fw.write(data.getEmail());    
	            fw.close();    
	   }
		catch(Exception e){
			System.out.println(e);} 
		}
	}
	}
}
