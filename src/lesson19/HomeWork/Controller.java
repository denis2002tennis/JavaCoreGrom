package lesson19.HomeWork;

public class Controller {
    public static void put(Storage storage,File file) throws Exception{
        if(formatChecker(file.getFormat(),storage.getFormatsSupported())==false)
            throw new Exception("this format is not supported");
        if(sizeCheker(storage,file.getSize())==false)
            throw new Exception("not enough space in storage");
        if(sameFileCheker(storage,file.getId())==false)
            throw new Exception("File with same id already defined in scope");
        if(emptyChecker(storage)==true)
            throw new Exception("No empty space if array");



//           for(File filer: storage.getFiles()){
//             //  if(filer.getId()==file.getId())
//                   //checker=true;
//           }

        }

    public static void delete(Storage storage,File file){

    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception{

    }

    public static void transferFile(Storage storageFrom, Storage storageTo,long id){

    }
    public static File[] addFile(File[] files,File file){
        for(int i=0;i<files.length;i++)
        {
            if(files[i].equals(null))
               files[i]=file;
        }
        return files;
    }
    public static boolean emptyChecker(Storage storage){
        for(File file:storage.getFiles())
        {
            if(file.equals(null))
                return true;
        }
        return false;
    }
    public static boolean sameFileCheker(Storage storage,long id){
        for(File file:storage.getFiles())
        {
         if(file.getId()==id)
             return false;
        }
        return true;
    }

    public static boolean sizeCheker(Storage storage,long size){
    long result=size;
            for(File file:storage.getFiles())
            {
                result+=file.getSize();
            }
            if(result>storage.getStorageSize())
                return false;
            return true;
    }

    public static boolean formatChecker(String format,String[] acceptedFormats){
        for(String string :acceptedFormats)
        {
            if(format.equals(string)){
                return true;
            }
        }
        return false;
    }
}
