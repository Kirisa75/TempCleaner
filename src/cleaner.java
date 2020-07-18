import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class cleaner {
    public static void main(String[] args){
        String path = "C:\\Users\\dksk4\\AppData\\Local\\Temp";
        deletefolder(path);

    }

    private static void deletefolder(String path) {

        File folder = new File(path);
        try{
            if(folder.exists()){
                File[] folder_list = folder.listFiles();

                for(int i=0; i<folder_list.length; i++){
                    if(folder_list[i].isFile()){
                        folder_list[i].delete();
                        System.out.println("삭제가능한 파일이 삭제 되었습니다.");
                    }else{
                        deletefolder(folder_list[i].getPath());
                        System.out.println("삭제가능한 폴더가 삭제 되었습니다");
                    }
                    folder_list[i].delete();
                }
                folder.delete();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }


}
