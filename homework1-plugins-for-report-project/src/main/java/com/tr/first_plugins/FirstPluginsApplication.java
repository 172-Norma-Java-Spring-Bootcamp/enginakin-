package com.tr.first_plugins;

import com.tr.first_plugins.Utils.EndPointReport;
import com.tr.first_plugins.Utils.ReportProjectDetails;
import com.tr.first_plugins.Utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FirstPluginsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstPluginsApplication.class, args);

        String path=System.getProperty("user.dir")+"\\src\\main\\java";

        ReportProjectDetails report=new ReportProjectDetails(path);
        EndPointReport endPointReport=report.getEndPoints();
        System.out.println("------------ end point for get ");

        for (String s:endPointReport.getGetMappingEndPoints()){
            System.out.println(s);
        }
        System.out.println("------------ end point for postMapping ");

        for (String s:endPointReport.getPostMappingEndPoints()){
            System.out.println(s);
        }

        }


}
