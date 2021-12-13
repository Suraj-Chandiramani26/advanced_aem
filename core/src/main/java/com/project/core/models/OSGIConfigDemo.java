package com.project.core.models;


public interface OSGIConfigDemo {

    abstract String getServiceName();
    public int getServiceCount();
    public boolean isLiveData();
    public String[] getCountries() ;
    public String getRunModes();


}
