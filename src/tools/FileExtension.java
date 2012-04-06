package tools;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.03.12
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
public class FileExtension {
    public final static String TXT = "txt";
    public final static String JSON = "json";
    public final static String DAT = "dat";

    /*
    * Get the extension of a file.
    */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
