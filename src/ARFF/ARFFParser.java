package ARFF;

import generator.Person;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Lukas
 */
public class ARFFParser {
    private List<ARFFParsable> params;
    private List<ARFFParsable> rowVals;
    private FastVector atts;
    private Instances data;
    private String relationName = "MyRelation";
    double[] vals;

    public void setRelationName(String RelationName) {
        this.relationName = RelationName;
    }

    public String getRelationName() {
        return relationName;
    }
    
    public ARFFParser(Object[] params)
    {
        this.atts = new FastVector();
        this.params = new ArrayList<ARFFParsable>();
        for(Object param:params)
        {
            ARFFParsable tmpParam = (ARFFParsable)(param);
            this.params.add(tmpParam);
            switch(tmpParam.getARFFParamType()){
                case INTEGER:
                case REAL:
                    atts.addElement(new Attribute(tmpParam.getARFFParamName()));
                    break;
                case NOMINAL:
                    
                    atts.addElement(new Attribute(tmpParam.getARFFParamName(),tmpParam.getARFFParamNominalValues()));
                    break;
                case STRING:
                    atts.addElement(new Attribute(tmpParam.getARFFParamName(), (FastVector) null));
                    break;
            }
            
        }
        data = new Instances(relationName, atts, 0);
    }
    
    public void appendData(Object[] rowVals)
    {
        vals = new double[data.numAttributes()];
        this.rowVals = new ArrayList<ARFFParsable>();
        int i = 0;
        for(Object rowVal:rowVals)
        {
            ARFFParsable tmpParam = (ARFFParsable)(rowVal);
            this.rowVals.add(tmpParam);
            switch(tmpParam.getARFFParamType()){
                case INTEGER:
                case REAL:
                    vals[i] = tmpParam.getARFFParamValue();
                    break;
                case NOMINAL:
                    vals[i] = tmpParam.getARFFParamValue();
                    break;
                case STRING:
                    
                    break;
            }
            i++;
        }
        data.add(new Instance(1.0, vals));
    }
    
    public void SaveToFile(String path){
        try {
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File("./data/test.arff"));
            //saver.setDestination(new File("./data/test.arff"));   // **not** necessary in 3.5.4 and later
            saver.writeBatch();
        } catch (IOException ex) {
            Logger.getLogger(ARFFParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }
    
    
    
    
}
