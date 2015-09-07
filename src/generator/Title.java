/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import ARFF.ARFFParsable;
import ARFF.Type;
import java.util.Random;
import weka.core.FastVector;

/**
 *
 * @author Lukas
 */
public enum Title implements ARFFParsable {
    None, Bc, Ing, Dr, Other;
    
    public static Title getRandom(){
        Random r = new Random();
        int count = Title.values().length;
        return Title.values()[r.nextInt(count)];
    }
    
    public static Title getRandom(int age){
        
        if(age < 20) return Title.None;
        else
        {
            double rndVal = Math.random();
            if(age < 23)
            {
                
                if(rndVal<0.40) return None;
                if(rndVal<0.80) return Other;
                return Bc;
                
            }else
            if(age < 25)
            {
             
                if(rndVal<0.50) return None;
                if(rndVal<0.75) return Bc;
                if(rndVal<0.85) return Ing;
                return Other;
                
            }else
            {
                if(rndVal<0.50) return None;
                if(rndVal<0.70) return Other;
                if(rndVal<0.80) return Bc;
                if(rndVal<0.92) return Ing;
                return Dr;
            }
        }
        
    }

    @Override
    public FastVector getARFFParamNominalValues() {
        FastVector retVal = new FastVector();
        for(Title val:Title.values())
        {
            retVal.addElement(val.toString());       
        }
        return retVal;
    }

    @Override
    public double getARFFParamValue() {
        return this.ordinal();
    }

    @Override
    public Type getARFFParamType() {
        return Type.NOMINAL;
    }

    @Override
    public String getARFFParamName() {
        return "Title";
    }
    
}
