package MainPakage;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class RequiredOperation {
    File file ;
    String path;
    Scanner scanner;

// This Method is used to take the folder path and select the workflow
    public void operation() {
        try {
            if (path==null) {
                scanner = new Scanner(System.in);
                System.out.println("Enter The Directory (path):");
                path= scanner.next();
            }
            workFlow();

            } catch(Exception e){
                e.printStackTrace();
            }

    }
    // Sort the files in Ascending order
    public static void ascendingOrder(File folder) {
        try {

            folder.exists();
            File[] listOfFiles = folder.listFiles();
            Arrays.sort(listOfFiles);
            if (listOfFiles.length > 0) {
                for(int i = 0; i < listOfFiles.length; i++) {

                    System.out.println("File :" + listOfFiles[i].getName());
                }
            } else {
                System.out.println("No Files in the folder");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // Create the New file
    public static void createFile(String path) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the file name :");
            String filepath = path+"/"+scanner.next();
           File newFile = new File(filepath);
            newFile.createNewFile();
            System.out.println("File is Created Successfully");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    // Delete the Files
    public static void deleteFile(String path) {
        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the file to delete :");
            String del= scanner.next();
            File file=new File(path+"/"+del);
            if(file.exists()){
                file.delete();
                System.out.println("*-------File Is Deleted Successfully---------*");
            }
            else {
                System.out.println("File does not exist");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    // Find file in folder
    public static void searchFile(String path){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the File Name You need to Find:");
            String name = scanner.next();
            File file = new File(path + "/" + name);
            if (file.isFile()) {
                file.getName();
                System.out.println("File Exists");
            }
            else{
                    System.out.println("File Not Found");

                }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    // Print Options
    public void options(){
        System.out.println("1:Ascending Order");
        System.out.println("2:Add File");
        System.out.println("3:Delete File");
        System.out.println("4:Search File");
        System.out.println("5:New Context ");
        System.out.println("6:Exit");
    }
    // Select the workflow for the selected Option
    public void workFlow()
    {
        System.out.println("Enter the Option:");
        options();
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                file = new File(path);
                if(file.isDirectory()) {
                    ascendingOrder(file);

                } else {
                    System.out.println("Invalid path please select new context to continue");
                }
                System.out.println("\n");
                operation();
                break;
            case 2:
                file = new File(path);
                if(file.isDirectory()) {
                    createFile(path);
                    System.out.println("[If you want to view the file added in the folder ,select option 1,else please continue]");
                }else {
                    System.out.println("Invalid path please select new context to continue");
                }
                System.out.println("\n");
                operation();
                break;
            case 3:
                file = new File(path);
                if(file.isDirectory()) {
                    deleteFile(path);
                    System.out.println("\n");
                }else {
                    System.out.println("Invalid path please select new context to continue");
                }
                operation();
                break;
            case 4:
                file = new File(path);
                if(file.isDirectory()) {
                    searchFile(path);
                    System.out.println("\n");
                }else {
                    System.out.println("Invalid path please select new context to continue");
                }
                operation();
                break;
            case 5:
                file = new File(path);
                if(file.isDirectory()) {
                    System.out.println("The current execution context is closed--------/");
                    System.out.println("\n");
                }else {
                    System.out.println("-----------Invalid Input-----------");
                }
                path=null;
                operation();
                break;
            case 6:
                System.out.println("--------------Thank You For Using File System------------");
                break;
            default:
                System.out.println("The Option You Have Entered Does not exist ,Please enter the valid option:");
                workFlow();
        }
    }

}

