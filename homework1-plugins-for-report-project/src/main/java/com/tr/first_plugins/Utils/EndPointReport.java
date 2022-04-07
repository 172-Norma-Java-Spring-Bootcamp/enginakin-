package com.tr.first_plugins.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EndPointReport {
    private List<String> getMappingEndPoints= new ArrayList<>();
    private List<String> postMappingEndPoints= new ArrayList<>();
    private final String getMapping="@GetMapping";
    private final String postMapping="@PostMapping";




    public void endPointReport(File file){
        try {

                String requestMapping="";
                String getMapping="";
                String postMapping="";
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if(data.contains("@RequestMapping")){
                        Pattern p = Pattern.compile("\"([^\"]*)\"");
                        Matcher m = p.matcher(data);
                        while (m.find()) {
                            requestMapping=m.group(1);

                        }
                    }
                    if(data.contains("@GetMapping")){
                        Pattern p = Pattern.compile("\"([^\"]*)\"");
                        Matcher m = p.matcher(data);
                        while (m.find()) {
                            getMapping=m.group(1);

                        }
                        getMappingEndPoints.add(requestMapping+getMapping);
                        getMapping="";
                    }
                    if(data.contains("@PostMapping")){
                        Pattern p = Pattern.compile("\"([^\"]*)\"");
                        Matcher m = p.matcher(data);
                        while (m.find()) {
                            postMapping=m.group(1);

                        }
                        postMappingEndPoints.add(requestMapping+postMapping);
                        postMapping="";
                    }

                }
                myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }




}
