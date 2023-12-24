 # Jakarta EE 10: Empowering Enterprise Java

Jakarta EE 10 stands as the pinnacle of enterprise Java, offering standardized tools for agile application development. Formerly Java EE, this iteration streamlines development with a robust suite of APIs and specifications designed for enterprise-scale projects.

Notably, Jakarta EE 10 shines in its adaptability to modern paradigms like IoT and Microservices. Its versatile toolkit, including servlets, JPA, and CDI, seamlessly integrates into Microservices architectures and facilitates IoT application development, ensuring scalability and interoperability across systems.

Furthermore, Jakarta EE 10 aligns with DevOps practices, supporting rapid deployment and continuous integration. Its adherence to industry standards and vibrant community backing makes it an optimal choice for businesses seeking scalable, future-proof solutions for enterprise software development.
Getting Started

For our project you will need to install:

1. Git

2. JDK 17+

3. Apache Marven 3.9+

4. Payara Server 6.2023+

4. VsCode 1.85+

5. VsCode Payara Extension 1.3+

To start any development work, you have to prepare the development environment first. For convenience, I recommend you create a "JakartaEE10" folder where you will insert the "marven", "payara" and "projects" subfolders.
Creating the Project Structure

We will create our first Payara Server project on the official website Starter.

    On "Project Details" select "Marven" and follow the naming conventions given on Apache Marven.
    On "Project Configuration" select "Java SE 17" and don't mark "Include Tests".
    On "Jakarta EE" select version 10 and "Web Profile" as profile.
    On "Microprofile" select "Full MP" for our future projects.
    On "Payara Platform" select the version of Payara Server previously installed. Works perfectly with 6.2023.9
    Unzip the zip to the "projects" folder.

Java Tools in VS Code 

We also need to properly configure Java and Marven on VS Code. Follows all the instructions indicated on the official website, mainly installing and configuring the "Extension Pack for Java" and "Maven for Java" extensions. 

On VsCode's settings.json, it also adds the following lines:

"java.configuration.runtimes": [ { "name": "JavaSE-17", "path": "absolute path to jdk17", "default": true }, ], 
"java.jdt.ls.java.home": "absolute path to jdk17"

Starting Payara Server 

The 'asadmin' command-line utility is used to control and manage Payara Server (start, stop, configure, deploy applications, etc.). We have two methods to start it: 

    Go to the directory where Payara Server is located and type: On Unix: payara6/bin/asadmin start-domain On Windows: payara6\bin\asadmin start-domain You can create your own PATH to the bin folder for convenience. In your browser, go to http://localhost:8080 to see the default landing page. To stop Payara Server, just issue the following command: asadmin stop-domain. 
    You can launch Payara Server from VsCode by following the official instructions.

Exploring Project Structure

    It is a standard Maven project, in the project root folder, there is a pom.xml to manage Maven build lifecycle.
    Under the src/main/src/java folder, expand the package com.impesud.hello, it contains two java files.
    There is the /target folder with the files already packaged and ready for deployment.

Running our Web App

To make sure everything works correctly we will follow the following steps:

    Go to the "Maven" section on VS Code, right-click on the visible project, go to "Run Maven commands" and then click on "clean". The /target folder will be removed.
    Following the same path, click on "package" and the /target folder will be recreated.
    If everything went well, you will find the .war file in the /target folder.
    Right-click the .war file and select "Run on Payara Server".
    Your web application will open locally.BONUS:
    Go to the Administration Console by accessing http://localhost:4848/ and you will find your application stored in the "Applications" section.

The code can be downloaded at https://github.com/Impesud/jakartaEE10/tree/main/hello-world 




