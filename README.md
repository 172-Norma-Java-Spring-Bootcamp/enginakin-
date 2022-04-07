This project reports type of classes and endpoint 

clone the project 




In the project you want to use the plugin, enter the values as dependency

go to terminal and run 'mvn install' command


        <dependencies>
             <dependency>
                    <groupId>com.tr</groupId>
                    <artifactId>report-class</artifactId>
                    <version>0.1</version>
                </dependency>
        </dependencies>
        
        
      <build>
        <plugins>
                    <plugin>
                        <groupId>com.tr</groupId>
                        <artifactId>report-class</artifactId>
                        <version>0.1</version>
                        <executions>
                            <execution>
                                <id>id.install</id>
                                <phase>install</phase>
                                <goals>
                                    <goal>run</goal><!-- name of mojo -->
                                </goals>

                            </execution>
                        </executions>
                    </plugin> 
         </plugins>   
      </build>


![reportexmp](https://user-images.githubusercontent.com/59319413/162286666-ff339076-a976-4589-9f09-ed295f3fa8f3.PNG)

        
        
