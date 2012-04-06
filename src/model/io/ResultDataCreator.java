package model.io;

import base.sequencies.Chain;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.MainOutputData;
import tools.FileExtension;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 17.03.12
 * Time: 12:11
 * To change this template use File | Settings | File Templates.
 */

/**
 * Allows you to create and store a result of research
 */
public abstract class ResultDataCreator implements ResultDataStrategy {
    /**
     * Creates a result list of output characteristic of research
     *
     * @return a result list of output characteristic
     */
    public abstract MainOutputData create();

    /**
     * Saves an output result to json file
     *
     * @param mainOutputData data to store
     * @return true - if operation is fully completed, false - otherwise
     */
    public static boolean saveToFile(MainOutputData mainOutputData) {
        PrintStream printStream = null;
        Gson gson = new GsonBuilder().create();
        String gsonData = gson.toJson(mainOutputData);
        File jsonFile = new File(buildFileName(mainOutputData.getChain()));

        try {
            printStream = new PrintStream(new FileOutputStream(jsonFile));
            printStream.println(gsonData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File is not found");
            return false;
        } finally {
            if (printStream != null)
                printStream.close();
        }
        return true;
    }

    private static String buildFileName(Chain chain) {
        return chain.getName() + "_" + System.nanoTime() + "." + FileExtension.JSON;
    }

}
