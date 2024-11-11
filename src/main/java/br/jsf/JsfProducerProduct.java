package br.jsf;

import br.ejb.EjbProduct;
import br.model.Product;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

/**
 *
 * @author Rafael de Luca
 */
@Named(value = "jsfProducerProduct")
@RequestScoped
public class JsfProducerProduct {

    @EJB
    private EjbProduct ejbProduct;

    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java/Topic")
    private Topic topic;

    public JsfProducerProduct() {

    }

    public void sendObject() {

        try {
            ArrayList<Product> productList;
            productList = ejbProduct.getAll();
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            ObjectMessage objectMessage = session.createObjectMessage();
            
            objectMessage.setObject(productList);
            JMSContext jmsContext = connectionFactory.createContext();
            
            jmsContext.createProducer().send(topic,objectMessage);

        } catch (Exception exce) {
            System.out.println("Error");
            System.out.println(exce.getMessage());
        }
    }

}
