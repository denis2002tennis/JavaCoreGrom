package lesson19.HomeWork;

public class Controller {
    public static void put(Storage storage, File file) throws Exception {
        try {
            formatChecker(file.getFormat(), storage.getFormatsSupported());
            sizeCheker(storage, file.getSize());
            sameFileCheker(storage, file);
            emptyChecker(storage);
        } catch (Exception e) {
            throw e;
        }
        storage.setFiles(addFile(storage.getFiles(), file));
    }

    public static void delete(Storage storage, File file) throws Exception {
        File[] files = storage.getFiles();
        try {
            sameFileCheker(storage, file);
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (files[i] != null)
                    if (files[i].getId() == file.getId())
                        files[i] = null;
            }
            storage.setFiles(files);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom.equals(null))
            throw new NullPointerException("Storage from is empty");
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            try {
                sameFileCheker(storageTo, storageFrom.getFiles()[i]);
            } catch (Exception e) {
                throw e;
            }
        }
        Storage storageFromer = storageFrom;
        Storage storagerTo = storageTo;
        for (int i = 0; i < storageFromer.getFiles().length; i++) {
            if (storageFromer.getFiles()[i] != null)
                try {
                    transferFile(storageFromer, storageTo, storageFromer.getFiles()[i].getId());
                } catch (Exception e) {
                    throw new Exception("Files can't be moved");
                }
        }
        storageFrom.setFiles(storageFromer.getFiles());
        storageTo.setFiles(storagerTo.getFiles());
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        if (storageFrom.equals(null))
            throw new NullPointerException("Storage from is empty");


        File file = null;
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if (storageFrom.getFiles()[i] != null)
                if (storageFrom.getFiles()[i].getId() == id) {
                    file = storageFrom.getFiles()[i];
                    break;
                }
        }
        if (file != null) {
            try {
                put(storageTo, file);
                delete(storageFrom, file);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else
            throw new Exception("No file with id " + id + " found in the scope");
    }

    public static File[] addFile(File[] files, File file) {
        for (int i = 0; i < files.length; i++) {
            if (files[i] == (null)) {
                files[i] = file;
                return files;
            }
        }
        return files;
    }

    public static void emptyChecker(Storage storage) throws Exception {
        for (File file : storage.getFiles()) {
            if (file == null)
                return;
        }
        throw new Exception("No empty space in array");
    }

    public static void sameFileCheker(Storage storage, File file) throws Exception {
        for (File filer : storage.getFiles()) {
            if (filer != null)
                if (filer.equals(file))
                    throw new Exception("File with same id already defined in scope");
        }
    }

    public static void sizeCheker(Storage storage, long size) throws Exception {
        long result = size;
        for (File file : storage.getFiles()) {
            if (file != null)
                result += file.getSize();
        }
        if (result > storage.getStorageSize())
            throw new Exception("not enough space in storage");
    }

    public static void formatChecker(String format, String[] acceptedFormats) throws Exception {
        for (String string : acceptedFormats) {
            if (format.equals(string)) {
                return;
            }
        }
        throw new Exception("this format is not supported");
    }
}
