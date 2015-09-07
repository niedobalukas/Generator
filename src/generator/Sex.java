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
public enum Sex implements ARFFParsable {
    MALE,FEMALE;
    
    public static Sex getRandom(){
        Random r = new Random();
        int count = Sex.values().length;
        return Sex.values()[r.nextInt(count)];
    }

    @Override
    public FastVector getARFFParamNominalValues() {
        FastVector retVal = new FastVector();
        for(Sex val:Sex.values())
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
        return "Sex";
    }
    
    
}
