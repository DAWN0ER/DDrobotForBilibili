package com.dawn.mylog;

import com.dawn.pojo.LogInfo;

import java.io.*;

public class LogOutput {

    public LogOutput() {
    }

    public void write(LogInfo log) throws IOException {
        File logfile = new File("../DDrobot.log");
        if(logfile.exists()&&logfile.isFile()){
            FileOutputStream outputStream = new FileOutputStream(logfile,true);
            OutputStreamWriter streamWriterwriter = new OutputStreamWriter(outputStream,"UTF-8");
            BufferedWriter writer = new BufferedWriter(streamWriterwriter);

            writer.newLine();
            writer.write("#Data=" + log.getDate() + ",Dynamic_Id=" + log.getDynamic_id());
            writer.newLine();
            writer.write("Content:{" + log.getDynamic_content() + '}');
            writer.newLine();
            writer.write("Comment:{" + log.getComment() + '}');

            writer.close();
            streamWriterwriter.close();
            outputStream.close();

        }else{
            logfile.createNewFile();
            this.write(log);
            return;
        }
        return;
    }

    public void error_Write(String error) throws IOException {

        File logfile = new File("../DDrobot.log");

        if(logfile.exists()&&logfile.isFile()) {

            FileOutputStream outputStream = new FileOutputStream(logfile, true);
            OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter writer = new BufferedWriter(streamWriter);

            writer.newLine();
            writer.write(error);

            writer.close();
            streamWriter.close();
            outputStream.close();

        }else{
            logfile.createNewFile();
            this.error_Write(error);
            return;
        }
        return;

    }

}
