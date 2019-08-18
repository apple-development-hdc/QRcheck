package QRcheck.com.apple.MailFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Generate {
    @Autowired
    private EmailService emailService;
    public void run(String to, String name) throws Exception {
        Mail mail = new Mail();
        mail.setFrom("sauravarduino@gmail.com");
        mail.setTo(to);
        mail.setSubject("CHECK YOUR QR");
        mail.setContent(name);

        emailService.sendSimpleMessage(mail,name);
    }
}
