package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 23.03.12
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
public class InputStreamHelper {

    public static String toString(InputStream xmlStream){
    BufferedReader buff = new BufferedReader(new InputStreamReader(xmlStream));
    StringBuffer strBuff = new StringBuffer();
    int c;
        try {
            while ( ( c = buff.read() ) != -1 ) {
                strBuff.append( ( char )c );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strBuff.toString();
    }

}
