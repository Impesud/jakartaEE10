 Jakarta EE 10, the latest iteration of the enterprise Java platform, represents a robust ecosystem for building scalable and secure applications. In tandem with this evolution, integrating Jakarta EE 10 with MySQL, the widely-used open-source relational database, offers developers a powerful foundation to craft versatile, high-performance solutions. This synergy between Jakarta EE 10 and MySQL unlocks a seamless amalgamation, empowering developers to create sophisticated, data-driven applications with enhanced flexibility and reliability.

A connector for linking to MySQL is pivotal as it furnishes the necessary interface to enable Jakarta EE 10 to communicate with the MySQL database. This connector serves as the communication interface that translates Java application requests written in Jakarta EE 10 into understandable commands for MySQL, and vice versa. Without a proper connector, the integration between Jakarta EE 10 and MySQL would be challenging, if not impossible, significantly constraining development capabilities and application portability on this platform.

If you haven't read or received the previous newsletter about Jakarta EE 10, go to this link and do all the setup. We will use the same code.

The project will configure Jakarta EE 10 with MySQL, so that a variety of products will then be read from the database.
Getting Started

For our project you will need to install and/or config:

    MySQL 8.0+. Version 8.0.35 was used for this project.
    MySQL Connector 8.2+. Version 8.2.0 was used for this project.
    Create a database called ecommerce, upload and run the script to our repository, and insert your products.
    The connector must be uploaded to our Payara server, exactly in the glassfish\lib and glassfish\domains\domain1\lib folders.

Configuring Payara Server

    Start Payara Server (asadmin start-domain) and access the Admin Panel, then go to Resources --> JDBC.
    On JDBC Connection Pools create a new one, call it ecommerce-pool and insert the information present on the images:

    On JDBC Resources create a new one, call it jdbc/ecommercePool and insert the information present on the image:

    Go to Domain --> Password Aliases and enter your database password.

Programming on Jakarta EE 10

    Taking the code of the previous project as a reference, in this step we will add dependencies to JPA and MySQL Connector on pom.xml, and rename the artifact ID to jakarta10-mysql. 

 <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
            <version>3.2.0-M1</version>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.2.0</version>
        </dependency>

    We add the persistence.xml file to /resources/META-INF

 <persistence-unit name="databaseUnit" transaction-type="JTA">
        <jta-data-source>jdbc/ecommercePool</jta-data-source>
    </persistence-unit>

    We create the config folder and the AppConfig.java file

@ApplicationPath("/api") public class AppConfig extends Application {    
} 

    We rename the hello folder to products and create our java files: controller to handle HTTP requests, model class to represent the data, class that provides access to data, service that implements business logic.
    In the index.html file we will insert our code to recall the names and prices present in our database.

 <h2>All Products</h2>
        <button onclick="getProducts()">Products List</button>
        <ul id="productList"></ul>
    
        <script>
            function getProducts() {
                fetch('api/products') 
                    .then(response => response.json())
                    .then(data => displayProducts(data))
                    .catch(error => console.error('Error:', error));
            }
    
            function displayProducts(products) {
                const productListElement = document.getElementById('productList');
                productListElement.innerHTML = '';
    
                products.forEach(product => {
                    const listItem = document.createElement('li');
                    listItem.textContent = `Name: ${product.name}, Price: ${product.price}`; 
                    productListElement.appendChild(listItem);
                });
            }
        </script>

    Run the clean, package and run commands as seen in the previous project. And voilà!

    If you have any errors, go to api/products and check any messages.

The code can be downloaded at https://github.com/Impesud/jakartaEE10/tree/main/jakarta10-mysql 


