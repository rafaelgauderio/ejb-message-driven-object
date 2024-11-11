package br.model;

import lombok.Data;

/**
 *
 * @author Rafael de Luca
 */
@Data
public class Product implements java.io.Serializable {

    private int code;
    private String name;

    public Product() {

    }

    public Product(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String toString() {
        return "Product, code: " + this.getCode() + ", description: " + this.getName() ;
    }
    
    

}
