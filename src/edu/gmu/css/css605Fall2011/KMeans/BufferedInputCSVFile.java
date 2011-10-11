/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.KMeans;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.util.StringTokenizer;
import java.util.List;

/**
 *
 * @author ckhyde
 */
public class BufferedInputCSVFile 
{
    //public static String read(String filename) throws IOException // Reading input by lines:
    //public static List<Point> read(String filename, List<Point> pointList) throws IOException // Reading input by lines:
    public static void read(String filename, List<Point> pointList) throws IOException // Reading input by lines:
    {
        BufferedReader in = new BufferedReader(new FileReader(filename));        
        
        List<Point> p;        
        p = pointList;
        
        String s;
        String sTempID = "Null";
        double dTempX = 0;
        double dTempY = 0;        
        //StringBuilder sb = new StringBuilder();
        
        while((s = in.readLine())!= null)
        {                                 
            StringTokenizer st = new StringTokenizer(s, ",");
            //sb.append(s + "\n");
            while (st.hasMoreTokens()) 
            { 
                sTempID = st.nextToken() + " VS " + st.nextToken();
                
                dTempX = Double.parseDouble(st.nextToken());
                dTempY = Double.parseDouble(st.nextToken());
                //System.out.print(st.nextToken() + "\t"); 
            }
            
            p.add(new Point(dTempX, dTempY, sTempID));
        }  
        
        in.close();
        
        //return sb.toString();    
        //return p;
    }    
}
