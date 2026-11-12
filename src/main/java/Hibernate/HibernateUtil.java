package Hibernate;

import java.lang.module.Configuration;


public class HBConfiguration {
    private static Configuration configuration;
    private  static HBConfiguration instance;

    private  HBConfiguration(){
        configuration.set
    }
    private static HBConfiguration getInstance(){
        if (instance==null){
            instance=new HBConfiguration();
        }
        return instance;
    }
    public Configuration getConfiguration(){
        return configuration;
    }

}
