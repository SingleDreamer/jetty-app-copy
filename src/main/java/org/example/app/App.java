package org.example.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;


import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;

import java.util.List;
import java.util.Map;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Hello world!
 *
 */
public class App
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {


    	/*System.out.println("-------- MySQL JDBI Connection Testing ------------");

    	//image ip: 172.17.0.2
    	//docker ip: 192.168.99.100
    	Handle handle = null;
//        DBI dbi = new DBI("jdbc:mysql://localhost:3306/test",
//                "root", "GitPass1");
    	DBI dbi = new DBI("jdbc:mysql://192.168.99.100:3306/task",
                "myuser", "mysecretpassword");
        String sql = "SELECT * FROM Cars";


        try {

            handle = dbi.open();
            Query<Map<String, Object>> q = handle.createQuery(sql);
            List<Map<String, Object>> l = q.list();

            for (Map<String, Object> m : l) {

                System.out.printf("%d ", m.get("Id"));
                System.out.printf("%s ", m.get("Name"));
                System.out.println(m.get("Price"));
            }

        } finally {
            if (handle != null) {
                handle.close();
            }
        }*/

    	/*
    	System.out.println("-------- MySQL JDBC Connection Testing ------------");

    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		System.out.println("Where is your MySQL JDBC Driver?");
    		e.printStackTrace();
    		return;
    	}

    	System.out.println("MySQL JDBC Driver Registered!");
    	Connection connection = null;

    	try {
    		connection = DriverManager
    		.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false","root", "*HnYnKkn4869");

    	} catch (SQLException e) {
    		System.out.println("Connection Failed! Check output console");
    		e.printStackTrace();
    		return;
    	}

    	if (connection != null) {
    		System.out.println("You made it, take control your database now!");
    	} else {
    		System.out.println("Failed to make connection!");
    	}
    	*/

        Server server = new Server(8081);

        ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);

        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);

        ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/api/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter(
                "jersey.config.server.provider.packages",
                "org.example.app.resources"
        );

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            logger.error("Error occurred while starting Jetty", ex);
            System.exit(1);
        }

        finally {
            server.destroy();
        }

    }
}
