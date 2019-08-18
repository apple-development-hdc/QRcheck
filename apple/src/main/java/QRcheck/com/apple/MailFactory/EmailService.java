package QRcheck.com.apple.MailFactory;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(Mail mail,String name)throws Exception  {

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject(mail.getSubject());
        helper.setText("Check QR");
        helper.setTo(mail.getTo());
        helper.setFrom(mail.getTo());
        helper.addAttachment(name, new File("C:\\Users\\SAURAV ROY\\Desktop\\file\\"+name+".png"));
        emailSender.send(message);

    }

}