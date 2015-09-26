/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import ARFF.ARFFParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas
 */


public class Generator {
    static List<Person> persons = new ArrayList<Person>();
    static List<Product> products = new ArrayList<Product>();
    static List<Trade> trades = new ArrayList<Trade>();
    static double rndSeed = 0.1;
     

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        generatePersons(30000);
        //printPersons();
        insertProducts();
        generateTrades(100000);
        //printTrades();
        try{
            /*CSVParser par=new CSVParser(new String[]{"jedna","dva","tri"}, "c:\\myC");
            for(int i=0 ;i<20 ;i++) par.append(new Object[]{i, 'a', "string"});*/  
            CSVParser par=new CSVParser(new String[]{"PRICE","AGE","SEX","MARTIAL_STATUS","TITLE","LEGAL_STATUS","REGION","SHOP"},"c:\\Users\\Lukas\\generated");
            for(Trade trade:trades) par.append(trade.getObject());
            par.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        } 
        Price price = new Price(4);
        Age age = new Age(1);
        Sex sex = Sex.getRandom();
        Title title = Title.Bc;
        LegalStatus legalStatus = LegalStatus.getRandom();
        Region region = Region.getRandom();
        Shop shop = Shop.getRandom();
        
        MartialStatus martial = MartialStatus.DIVORCED;
  
        ARFFParser arff = new ARFFParser(new Object[]{price,age,sex,martial,title,legalStatus,region,shop});
        for(Trade trade:trades) arff.appendData(trade.getArff());
        //System.out.println(arff);
        arff.SaveToFile(null);

        
        
    }

    public Generator() {
    }
    
    public static void generateTrades(int how_much)
    {
        int buyer_index;
        Person buyer;
        for(int i = 0;i < how_much; i++)
        {
            buyer = persons.get((int)(Math.random()*(persons.size())));
            // TREE follows
            if(buyer.getAge().getVal() <= 37)
            {
                switch(buyer.getMartial_status())
                {
                    case SINGLE:
                        if(buyer.getSex()==Sex.MALE)
                        {
                            insertTrade(products.get(5),buyer,rndSeed);
                        }
                        else
                        {
                            insertTrade(products.get(4),buyer,rndSeed);
                        }
                        break;
                    case MARRIED:
                        insertTrade(products.get(3),buyer,rndSeed);;
                        break;
                    case DIVORCED:
                        if(buyer.getSex()==Sex.MALE)
                        {
                            insertTrade(products.get(6),buyer,rndSeed);
                        }
                        else
                        {
                            insertTrade(products.get(2),buyer,rndSeed);
                        }
                        break;
                    case WIDOWED:
                        insertTrade(products.get(1),buyer,rndSeed);
                        break;
                        
                }
            }
            else
            {
                switch(buyer.getTitle())
                {
                    case None:
                        insertTrade(products.get(1),buyer,rndSeed);
                        break;
                    case Bc:
                        insertTrade(products.get(5),buyer,rndSeed);
                        break;
                    case Ing:
                        insertTrade(products.get(6),buyer,rndSeed);
                        break;
                    case Dr:
                        insertTrade(products.get(4),buyer,rndSeed);
                        break;
                    case Other:
                        insertTrade(products.get(2),buyer,rndSeed);
                        break;
                        
                        
                        
                }
            }
            
        }
        
    }
    
    public static void insertTrade(Product product, Person buyer, double seed)
    {
        if(seed > 0)
        {
            double rndVal = Math.random();
            if(rndVal<seed) trades.add(new Trade(products.get((int)(Math.random()*(products.size()))),buyer));
            else trades.add(new Trade(product,buyer));
        }
        else trades.add(new Trade(product,buyer));
    }
    
    
    
    public static void insertProducts()
    {
        products.add(new Product(999));
        products.add(new Product(5231));
        products.add(new Product(7895));
        products.add(new Product(13899));
        products.add(new Product(23999));
        products.add(new Product(48650));
        products.add(new Product(74999));
    }
    
    public static void generatePersons(int how_much)
    {
        for(int i = 0;i < how_much;i++)
        {
            persons.add(new Person());
        }
    }
    
    public static void printPersons(){
        for (Person person : persons) {
            System.out.println(person);
        }
    }
    
    public static void printTrades(){
        for (Trade trade : trades) {
            System.out.println(trade);
        }
    }
    
    
}
