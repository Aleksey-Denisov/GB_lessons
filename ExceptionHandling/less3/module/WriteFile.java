package ExceptionHandling.less3.module;
import java.io.*;

public class WriteFile {
    public WriteFile(String[] userData){
        try{
            String path = "ExceptionHandling/less3/" + userData[0];
            File file = new File(path);
            StringBuilder sb = new StringBuilder();
            if(!file.exists()){
                file.createNewFile();
            }else{
                BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
                String line = br.readLine();
                while(line != null){
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                br.close();
            }
            for(int idElement = 0; idElement < userData.length; idElement++){
                sb.append("<" + userData[idElement] + ">");
            }
            sb.append(System.lineSeparator());
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            bw.write(sb.toString());
            bw.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
