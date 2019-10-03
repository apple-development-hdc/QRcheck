package QRcheck.com.apple.MailFactory;


import QRcheck.com.apple.QrEngine.QrEngine;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private QrEngine qrEngine;

    public void sendSimpleMessage(Mail mail,String name, String text)throws Exception  {

        byte[] qrStream = qrEngine.getQRCodeImage(text);
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(mail.getSubject());
        helper.setText("Check QR");
        helper.setTo(mail.getTo());
        helper.setFrom(mail.getTo());
        InputStreamSource streamSource = new ByteArrayResource(qrStream);
        helper.addAttachment(name+ ".png", streamSource);
        emailSender.send(message);
    }

}