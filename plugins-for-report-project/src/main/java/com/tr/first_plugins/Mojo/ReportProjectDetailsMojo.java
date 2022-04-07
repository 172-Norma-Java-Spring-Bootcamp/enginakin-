package com.tr.first_plugins.Mojo;

import com.tr.first_plugins.Utils.ReportProjectDetails;
import com.tr.first_plugins.Utils.Utils;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

import java.io.File;
import java.util.List;

@Mojo(name = "report-project-details", defaultPhase = LifecyclePhase.INSTALL)
public class ReportProjectDetailsMojo extends AbstractMojo {

    // first  : mvn clean install
    // second : mvn groupId:artifactId:goal  =>  mvn com.tr:first_plugins:report-project-details

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    String path=System.getProperty("user.dir")+"\\src\\main\\java";

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        // create report class while compile time in execute function
        // utils.getAllFileInProject return all file in project
        // ReportProjectDetails class count of the service class , controller class , data class and all class

        List<File> files=new ArrayList<>();

        ReportProjectDetails report=new ReportProjectDetails(Utils.listf(path,files));

        // write project detail
        getLog().info("********************  REPORT **************************");
        getLog().info("* Number of class: "+report.getNumOfClass());
        getLog().info("* Number of Service class: "+report.getNumOfServiceClass());
        getLog().info("* Number of Controller class: "+report.getNumOfControllerClass());
        getLog().info("* Number of Data class: "+report.getNumOfModelClass());
        getLog().info("* Name of group id : "+project.getGroupId());
        getLog().info("* Name of artifact id : "+project.getArtifactId());
        getLog().info("* Description of project: "+project.getDescription());
        getLog().info("********************  END  **************************");
        List<Dependency> dependencies = project.getDependencies();
        long numDependencies = dependencies.stream().count();
        getLog().info("Number of dependencies: " + numDependencies);

        // in this project output :
        /*
[INFO] ********************  REPORT **************************
[INFO] num of class: 10
[INFO] num of Service class: 1
[INFO] num of Controller class: 2
[INFO] num of Data class: 2
[INFO] ********************  END  **************************

         */

    }



}
