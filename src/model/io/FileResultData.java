package model.io;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import model.MainOutputData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.03.12
 * Time: 23:49
 * To change this template use File | Settings | File Templates.
 */

/**
 * Result shaper from file.
 */
public class FileResultData extends ResultDataCreator {
    private File file;

    public FileResultData(File file) {
        this.file = file;
    }

    @Override
    public MainOutputData create() {
        MainOutputData result = null;
        FileReader freader = null;
        if (file.exists() && file.isFile()) {
            Gson json = new Gson();
            try {
                freader = new FileReader(file);
                result = json.fromJson(freader, MainOutputData.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                return null;
            }
            return result;
        }

        return null;
    }
}
