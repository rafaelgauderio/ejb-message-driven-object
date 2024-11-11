package br.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael de Luca
 */
public class ProductCrud {
    
    public ArrayList <Product> getAll () {
        ArrayList <Product> productList = new ArrayList<> ();
        productList.add(new Product(1, "Chair"));
        productList.add(new Product(2, "Bookcase"));
        productList.add(new Product(3, "Armchair"));
        productList.add(new Product(4, "Couch"));
        productList.add(new Product(5, "Double bed"));
        productList.add(new Product(6, "Table"));
        productList.add(new Product(7, "Two door closet"));
        
        return productList;
    }
    
}
