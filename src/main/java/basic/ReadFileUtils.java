package basic;

import java.io.*;

public class ReadFileUtils {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File("d:/aaa.txt")));
        PrintWriter pw = new PrintWriter(new FileOutputStream("d:/result.txt",true));
        String line = "";
        while((line = br.readLine()) != null) {
            if(line.contains("MULTI")) {
                String result = line.substring(line.indexOf("MULTI"));
                //pw.print("changeToAndroidInstruct(\"");
                //pw.print("strcpy(msg,\"");

                pw.print(result);
                //pw.print("\");");
                pw.println();

                /*pw.println("send(sclient, msg, strlen(msg), 0);");
                pw.println("usleep(10000);");*/
            }
        }
        br.close();
        pw.close();
    }
}
