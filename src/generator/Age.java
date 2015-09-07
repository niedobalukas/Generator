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
public class Age implements ARFFParsable {
    
    private int age;
    public Age(int age)
    {
        this.age = age;
    }

    public int getVal() {
        return age;
    }
    
    

    @Override
    public FastVector getARFFParamNominalValues() {
        return null;
    }

    @Override
    public double getARFFParamValue() {
        return age;
    }

    @Override
    public Type getARFFParamType() {
        return Type.INTEGER;
    }

    @Override
    public String getARFFParamName() {
        return "Age";
    }
    
}
