package org.example.lab5_nguyenhodangquang_21054971.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.example.lab5_nguyenhodangquang_21054971.models.Order;
import org.example.lab5_nguyenhodangquang_21054971.services.implement.CustomerService;
import org.example.lab5_nguyenhodangquang_21054971.services.implement.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {
    @Autowired
    private OrderService os;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private JavaMailSender mailSender;
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
    @JmsListener(destination = "order_product")
    public void receiveMessage(final Message jsonMessage) throws JMSException {
        String messageData = null;
        String response = null;
        if(jsonMessage instanceof TextMessage) {
        //1. read message data
            TextMessage textMessage = (TextMessage) jsonMessage;
            messageData = textMessage.getText();
        //2. ==> decode
            Order order = gson.fromJson(Encrypt.decrypt(messageData), Order.class);
        //3. check for quantity
            if(order.getProduct().getQuantity() - order.getQuantity() < 0) {
                response = "Failed";
            } else {
                response = "Success";
            }
        //4. make order or reject
            if(response.equals("Success")) {
                customerService.create(order.getCustomer());
                os.create(order);
            }
        //5. send email
            SimpleMailMessage smm = new SimpleMailMessage();
            smm.setFrom("quangproforever@gmail.com");
            smm.setTo(order.getCustomer().getEmail());
            smm.setSubject("Status Order Your Product");
            smm.setText("Your order has been received and is being processed. Thank you for your order!");
            mailSender.send(smm);
        }
    }
}
