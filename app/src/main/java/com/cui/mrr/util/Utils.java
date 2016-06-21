package com.cui.mrr.util;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

/**
 * Created by cuiyang on 16/6/21.
 */
public class Utils {

    //参考自http://www.jianshu.com/p/92bb85fc07e8
    public static boolean writeResponseBodyToDisk(ResponseBody body) {
        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(createSDCardDir(Environment.getExternalStorageDirectory() + File.separator + "TempPic") + File.separator + "Img.png");
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                    Log.e("cui", "file download: " + fileSizeDownloaded + " of " + fileSize);
                }
                outputStream.flush();
                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    public static String createSDCardDir(String path) {
        File path1 = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) { //如果 有SDK卡
            path1 = new File(path);
            if (!path1.exists()) {
                path1.mkdirs();
            }
        }
        return path1.getAbsolutePath();
    }
}
