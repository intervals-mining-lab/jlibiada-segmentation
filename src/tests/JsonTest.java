package tests;

import com.google.gson.Gson;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.03.12
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class JsonTest extends TestCase {
    public void testMapToGson() {
        Gson gson = new Gson();
        Hashtable<String, ArrayList<Integer>> colours = new Hashtable<String, ArrayList<Integer>>();
        colours.put("BLACK", new ArrayList<Integer>(Arrays.asList(1, 2)));
        colours.put("RED", new ArrayList<Integer>(Arrays.asList(1, 2)));
        colours.put("GREEN", new ArrayList<Integer>(Arrays.asList(1, 2)));
        colours.put("BLUE", new ArrayList<Integer>(Arrays.asList(1, 2)));
        colours.put("YELLOW", new ArrayList<Integer>(Arrays.asList(1, 2)));

        System.out.println(gson.toJson(colours));
    }
}
