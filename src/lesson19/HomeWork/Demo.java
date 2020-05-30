package lesson19.HomeWork;

public class Demo {


    public static void main(String[] args) {
        File file1=new File(1,"valik","jpg",12);
        File file2=new File(2,"dsf","txt",10);
        File file3=new File(3,"fd","txt",11);
        File file4=new File(4,"fdfd","jpg",33);
        File file5=new File(5,"dfdf","jpg",22);
        File file6=new File(6,"ffff","jpg",12);
        File file11=new File(1,"sds","jpg",12);
        File file12=new File(12,"dssdsdf","txt",11);
        File file13=new File(13,"dssd","txt",21);
        File file14=new File(14,"fdfd","jpg",12);
        File file15=new File(15,"dsd","jpg",32);
        File file16=new File(16,"ds","jpg",23);
        File[] files=new File[10];
        files[0]=file1;
        files[1]=file2;
        files[2]=file3;
        files[3]=file4;
        files[4]=file5;
        File[] files1=new File[10];
        files1[0]=file11;
        files1[1]=file12;
        files1[2]=file13;
        files1[3]=file14;
        files1[4]=file15;
        String[] supportedFormats=new String[3];
        supportedFormats[0]="jpg";
        supportedFormats[1]="txt";
        Storage storage=new Storage(1,files,supportedFormats,"Ukraine",1000);
        Storage storage1=new Storage(2,files1,supportedFormats,"Ukraine",1000);
        try {
            Controller.put(storage,file6);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       printer(storage);

        try {
            Controller.delete(storage,file3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

      printer(storage);
     printer(storage1);

        try {
            Controller.transferFile(storage1,storage,14);
         }catch (Exception e){
            System.out.println(e.getMessage());
        }
       printer(storage);
       printer(storage1);
        try {
            Controller.transferAll(storage,storage1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       printer(storage);
       printer(storage1);


    }
    private static void printer(Storage storage){
        System.out.println();   System.out.println();   System.out.println();
        for(int i=0;i<storage.getFiles().length;i++){
            System.out.println(storage.getFiles()[i]);
        }
    }

}
