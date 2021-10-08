import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static List<String> changeString(String string){
        List<String> stringList=new ArrayList<>();
        if(string!=null){
            String[] newString=string.split(",");
            for (String a:newString
                 ) {
                stringList.add(a);
            }
        }
        return stringList;
    }
    public static void display(List<String> stringList){
        System.out.println(
                "Country [ID:"+stringList.get(0)+", Code:"+stringList.get(1)+", name: "+stringList.get(2)+"]"
        );
    }

    public static void main(String[] args) {
        File file=null;
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        try {
            file=new File("countries.csv");
            fileReader= new FileReader(file);
            bufferedReader=new BufferedReader(fileReader);
            String line;
            while((line=bufferedReader.readLine())!=null){
                display(changeString(line));
            }
        }catch (Exception e){
            System.out.println("error");
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
