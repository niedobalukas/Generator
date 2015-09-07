/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import ARFF.ARFFParsable;
import ARFF.Type;
import weka.core.FastVector;

/**
 *
 * @author Lukas
 */
public class Price implements ARFFParsable{
    public enum PriceDivision{
        from0to1000,from1000to5000,from5000to10000,from10000to20000,from20000to40000,from40000to60000,from60000to80000,over80000;
    }
    
    double priceVal;
    PriceDivision priceDiv;
    
    public double getPriceVal() {
        return priceVal;
    }

    public PriceDivision getPriceDiv() {
        return priceDiv;
    }
    
    
    
    Price(double price)
    {
        
        if(price < 0) this.priceVal = 0;
        else
        {
            this.priceVal = price;
            if(price < 1000)
            {
                this.priceDiv = PriceDivision.from0to1000;
            }else
            if(price < 5000)
            {
                this.priceDiv = PriceDivision.from1000to5000;
            }else
            if(price < 10000)
            {
                this.priceDiv = PriceDivision.from5000to10000;
            }else
            if(price < 20000)
            {
                this.priceDiv = PriceDivision.from10000to20000;
            }else
            if(price < 40000)
            {
                this.priceDiv = PriceDivision.from20000to40000;
            }else
            if(price < 60000)
            {
                this.priceDiv = PriceDivision.from40000to60000;
            }else
            if(price < 80000)
            {
                this.priceDiv = PriceDivision.from60000to80000;
            }else this.priceDiv = PriceDivision.over80000;
        }
    }

    @Override
    public FastVector getARFFParamNominalValues() {
        FastVector retVal = new FastVector();
        for(PriceDivision val:PriceDivision.values())
        {
            retVal.addElement(val.toString());       
        }
        return retVal;
    }
    

    @Override
    public double getARFFParamValue() {
        return this.priceDiv.ordinal();
    }

    @Override
    public Type getARFFParamType() {
        return Type.NOMINAL;
    }

    @Override
    public String getARFFParamName() {
        return "Price";
    }
    
}
