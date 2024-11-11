package br.ejb;

import br.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Rafael de Luca
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "java/Topic"),
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Topic")
})
public class EjbConsumerProductSecond implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        System.out.println("Topic - Message received by " + this.getClass().getSimpleName());
        try {
            ObjectMessage textMessage = (ObjectMessage) msg;
            System.out.println(textMessage.getClass().getSimpleName());
            System.out.println("Casting to Product List");
            List<Product> productList = new ArrayList<Product>();
            productList = (List<Product>) textMessage.getObject();
            for (Product prod : productList) {
                System.out.println(prod);
            }

        } catch (JMSException exce) {
            System.out.println("Error");
            System.out.println(exce.getMessage());
        }
    }
}
