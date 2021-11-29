package com.project.core.services;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ComponentsInfoService {

    List<Map<String, String>> getComponents(final String path);
    
    List<Map<String, String>> getComponentReferences(final String component);

    

}
