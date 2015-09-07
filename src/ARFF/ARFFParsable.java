/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARFF;

import weka.core.FastVector;

/**
 *
 * @author Lukas
 */
public interface ARFFParsable {
    
    public FastVector getARFFParamNominalValues();
    public double getARFFParamValue();
    public Type getARFFParamType();
    public String getARFFParamName();
    
}
