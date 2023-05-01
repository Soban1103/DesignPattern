package Structural;

import java.util.ArrayList;
import java.util.List;

// Component
abstract class File{
    protected String name;
    protected int size;

    public File(String n,int p){
        this.name = n;
        this.size = p;
    }

    public File(String n){
        this.name = n;    
    }

    public abstract void showDetail();
    public abstract int getSize();
}

// Leaf
class leaf extends File{
    public leaf(String n,int p){
        super(n,p);
    }

    @Override
    public void showDetail(){
        System.out.println("File Name : \t" + name + ", \tSize : " + size);
    }

    @Override
    public int getSize() {
        return size;
    }
}

// Composite
class Folder extends File{
    private List<File> fl = new ArrayList<File>();
    int TSize=0;
    public Folder(String n){
        super(n);
    }

    public int getSize() {
        return size;
    }

    public void addFile(File f){
        fl.add(f);
    }

    public void RemoveFile(File f){
        fl.remove(f);
    }

    public List<File> getFl() {
        return fl;
    }

    public void showDetail(){
        for(File f : fl){
            TSize=TSize+f.getSize();
        }

        System.out.println("Folder Name : \t" + name + ", \tSize : " + TSize);
        System.out.println("File List :");
        for(File f : fl){
            f.showDetail();
        }
        System.out.println();
    }
    
}


public class Composite {
    public static void main(String[] args) {
        File f1 = new leaf("ABC1", 10);
        File f2 = new leaf("ABC2", 20);
        File f3 = new leaf("ABC3", 5);
        File f4 = new leaf("ABC4", 6);
        File f5 = new leaf("ABC5", 14);
        
        Folder Fold1 = new Folder("Folder1");
        Folder Fold2 = new Folder("Folder2");
        Folder Fold3 = new Folder("Folder3");

        Fold1.addFile(f1);
        Fold1.addFile(f2);

        Fold2.addFile(f3);
        Fold2.addFile(f4);

        Fold3.addFile(f5);

        
        Fold1.showDetail();
        Fold2.showDetail();
        Fold3.showDetail();
    }
}
// 