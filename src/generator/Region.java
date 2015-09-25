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
public enum Region implements ARFFParsable {
    
    
        A,B,C;
    

    @Override
    public FastVector getARFFParamNominalValues() {
        FastVector retVal = new FastVector();
        for(Region val:Region.values())
        {
            retVal.addElement(val.toString());       
        }
        return retVal;    }

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
        return new String("Region");
    }
 
   
    
}
