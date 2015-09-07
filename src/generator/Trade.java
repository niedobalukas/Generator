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
public class Trade {
    static int glb_id = 0;
    private int id;
    private Product product;
    private Person person;
    
    public Trade(Product product,Person person)
    {
        this.person = person;
        this.product = product;
        this.id = glb_id++;
    }
    
    
    static void resetGenerator(){
        glb_id = 0;
    }

    public Object[] getObject()
    {
        return new Object[]{product.getId(),person.DB_getAge(),person.getSex().name(),person.getDBMartial_status(),person.getDBTitle()};
    }
    
    public Object[] getArff()
    {
        return new Object[]{product.getPrice(),person.getAge(),person.getSex(),person.getMartial_status(),person.getTitle()};
    }
    
    @Override
    public String toString() {
        return "Trade{" + "id=" + id + ", product=" + product + ", person=" + person + '}';
    }
    
    
    
    
    
}
