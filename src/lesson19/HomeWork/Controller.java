package lesson19.HomeWork;

public class Controller {
    public static void put(Storage storage, File file) throws Exception {
        if (formatChecker(file.getFormat(), storage.getFormatsSupported()) == false)
            throw new Exception("this format is not supported");

        if (sizeCheker(storage, file.getSize()) == false)
            throw new Exception("not enough space in storage");

        if (sameFileCheker(storage, file.getId()) == false)
            throw new Exception("File with same id already defined in scope");

        if (emptyChecker(storage) == false)
            throw new Exception("No empty space in array");

        storage.setFiles(addFile(storage.getFiles(), file));
      //  return storage;


    }

    public static void delete(Storage storage, File file) throws Exception {
        File[] files = storage.getFiles();
        if (sameFileCheker(storage, file.getId()) == false) {
            for (int i = 0; i < storage.getFiles().length; i++) {
                if(files[i]!=null)
                if (files[i].getId() == file.getId())
                    files[i] = null;
            }
            storage.setFiles(files);
        }
        else
        throw new Exception("No such file in the scope");
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
    if(storageFrom.equals(null))
        throw new NullPointerException("Storage from is empty");

      if(sameFileCheker(storageFrom,id)==false){
          File file=null;
          for(int i=0;i<storageFrom.getFiles().length;i++){
              if(storageFrom.getFiles()[i]!=null)
              if(storageFrom.getFiles()[i].getId()==id) {
                  file = storageFrom.getFiles()[i];
                  break;
              }
          }
          try {
              put(storageTo,file);
              delete(storageFrom,file);
          }catch (Exception e){
              System.out.println(e.getMessage());
          }

      }
      else
          throw new Exception("No file with id "+id+ " found in the scope");

    }

    public static File[] addFile(File[] files, File file) {
        for (int i = 0; i < files.length; i++) {
            if (files[i]==(null)){
                files[i] = file;
                return files;
            }
        }
        return files;
    }

    public static boolean emptyChecker(Storage storage) {
        for (File file : storage.getFiles()) {
            if (file==null)
                return true;
        }
        return false;
    }

    public static boolean sameFileCheker(Storage storage, long id) {
        for (File file : storage.getFiles()) {
            if(file!=null)
            if (file.getId() == id)
                return false;
        }
        return true;
    }

    public static boolean sizeCheker(Storage storage, long size) {
        long result = size;
        for (File file : storage.getFiles()) {
            if(file!=null)
            result += file.getSize();
        }
        if (result > storage.getStorageSize())
            return false;
        return true;
    }

    public static boolean formatChecker(String format, String[] acceptedFormats) {
        for (String string : acceptedFormats) {
            if (format.equals(string)) {
                return true;
            }
        }
        return false;
    }
}
