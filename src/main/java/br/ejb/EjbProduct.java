package br.ejb;

import br.model.ProductCrud;
import br.model.Product;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Rafael de Luca
 */
@Stateless
public class EjbProduct {
    
    public ArrayList <Product> getAll () {
        
        ProductCrud productCrud = new ProductCrud ();
        return productCrud.getAll();
    }    
    
}
