package br.jsf;

import br.ejb.EjbProduct;
import br.model.Product;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Rafael de Luca
 */
@Named(value = "jsfProduct")
@RequestScoped
public class JsfProduct {

    @EJB
    private EjbProduct ejbProduct;

    public JsfProduct() {

    }

    public ArrayList <Product> getAllProduct() {
        return ejbProduct.getAll();
    }
}
