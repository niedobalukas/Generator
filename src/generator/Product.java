/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

/**
 *
 * @author Lukas
 */
public class Product {
    static int glb_id = 0;
    
    private int id;
    private Price price;
    
    public Product(double price)
    {
        this.price = new Price(price);
        this.id = glb_id++;
    }
    
    static void resetGenerator()
    {
        glb_id = 0;
    }

    public int getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }
    
    public double getNumPrice() {
        return price.getPriceVal();
    }
    
    

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", price=" + price + '}';
    }
    
    
    
}
