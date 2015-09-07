/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import ARFF.ARFFParsable;
import ARFF.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import weka.core.FastVector;



/**
 *
 * @author Lukas
 */
public enum MartialStatus implements ARFFParsable {
    SINGLE, MARRIED, DIVORCED, WIDOWED;
    
    public static MartialStatus getRandom(){
        Random r = new Random();
        int count = MartialStatus.values().length;
        return MartialStatus.values()[r.nextInt(count)];
    }
    
    public static MartialStatus getRandom(int age){
        
        if(age < 17)
        {
            return SINGLE;
        }else
        {
            double rndVal = Math.random();
            if(age < 18)
            {
                
                if(rndVal<0.9) return SINGLE;
                return MARRIED;
            
            }else
            if(age < 25)
            {
             
                if(rndVal<0.55) return SINGLE;
                if(rndVal<0.75) return MARRIED;
                if(rndVal<0.95) return DIVORCED;
                return WIDOWED;
                
            }else
            if(age < 60)
            {
             
                if(rndVal<0.28) return SINGLE;
                if(rndVal<0.65) return MARRIED;
                if(rndVal<0.92) return DIVORCED;
                return WIDOWED;
                
            }else
            {
             
                if(rndVal<0.20) return SINGLE;
                if(rndVal<0.50) return MARRIED;
                if(rndVal<0.70) return DIVORCED;
                return WIDOWED;
                
            }
        }
    }

    public String getARFFValue() {
        return Integer.toString(this.ordinal());
    }

    @Override
    public FastVector getARFFParamNominalValues() {
        FastVector retVal = new FastVector();
        for(MartialStatus val:MartialStatus.values())
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
        return new String("MartialStatus");
    }
    
}
