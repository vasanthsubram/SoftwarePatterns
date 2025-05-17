package patterns.structural.composite.fileDemo;

import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemItem {
    void show(String indent);
    long getSize();
}

// Leaf
class File implements FileSystemItem {
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public void show(String indent) {
        System.out.println(indent + "- File: " + name);
    }
}

// Composite
class Directory implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    public long getSize() {
        return children.stream()
                .mapToLong(FileSystemItem::getSize)
                .sum();
    }
    public void show(String indent) {
        System.out.println(indent + "+ Dir: " + name);
        for (FileSystemItem item : children) {
            item.show(indent + "  ");
        }
    }
}

// Client
public class CompositePattern_FileSystem_Demo {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        File file1 = new File("file1.txt", 100);
        Directory subDir = new Directory("subdir");
        File file2 = new File("file2.txt", 200);

        root.add(file1);
        subDir.add(file2);
        root.add(subDir);

        root.show("");
    }
}
