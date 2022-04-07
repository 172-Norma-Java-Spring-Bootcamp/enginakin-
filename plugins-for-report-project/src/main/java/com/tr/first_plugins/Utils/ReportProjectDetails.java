package com.tr.first_plugins.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;



public class ReportProjectDetails {

    private List<File> files;
    private int numOfClass;
    private int numOfServiceClass;
    private int numOfControllerClass;
    private int numOfModelClass;


    public ReportProjectDetails(List<File> files){
        this.files=files;
        numOfClass=files.size();
        reportClassDetails();
    }

    private void reportClassDetails(){
        try {
            for(File file:files){
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if(data.equals("@Service")){
                        this.numOfServiceClass++;
                    }
                   if(data.equals("@Controller") || data.equals("@RestController")){
                        this.numOfControllerClass++;
                    }
                    if(data.equals("@Entity")){
                        this.numOfModelClass++;
                    }
                }
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public int getNumOfClass() {
        return numOfClass;
    }

    public void setNumOfClass(int numOfClass) {
        this.numOfClass = numOfClass;
    }

    public int getNumOfServiceClass() {
        return numOfServiceClass;
    }

    public void setNumOfServiceClass(int numOfServiceClass) {
        this.numOfServiceClass = numOfServiceClass;
    }

    public int getNumOfControllerClass() {
        return numOfControllerClass;
    }

    public void setNumOfControllerClass(int numOfControllerClass) {
        this.numOfControllerClass = numOfControllerClass;
    }

    public int getNumOfModelClass() {
        return numOfModelClass;
    }

    public void setNumOfModelClass(int numOfModelClass) {
        this.numOfModelClass = numOfModelClass;
    }
}
