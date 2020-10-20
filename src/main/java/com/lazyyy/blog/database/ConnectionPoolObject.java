/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazyyy.blog.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.sql.DataSource;

/**
 *
 * @author hungpv
 */
public class ConnectionPoolObject {
    
    
    private String id;
    private Properties pro;
    
    public ConnectionPoolObject(Properties pro){
        this.pro = pro;
        this.id = pro.getProperty("dbName");
    }
    
    public DataSource createConnectionPool() throws Exception {
        HikariConfig config = new HikariConfig();
        String url = this.pro.getProperty("URL");
        if(url != null && !"".equals(url)){
            config.setJdbcUrl(url);
        }else{
            throw new Exception("URL not found !");
        }
        
        
        if(this.pro.getProperty("USERNAME") != null){
            config.setUsername(this.pro.getProperty("USERNAME"));
        }
        if(this.pro.getProperty("PASSWORD") != null){
            config.setPassword(this.pro.getProperty("PASSWORD"));
        }
        if(this.pro.getProperty("PASSWORD") != null){
            config.setDriverClassName(this.pro.getProperty("PASSWORD"));
        }
        if(this.pro.getProperty("TEST_SQL") != null){
            config.setConnectionTestQuery(this.pro.getProperty("TEST_SQL"));
        }
        
        HikariDataSource hds = new HikariDataSource(config);
        return hds;
    }
    
    
    public String getId(){
        return this.id;
    }
    
}
