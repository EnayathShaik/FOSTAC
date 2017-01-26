package com.zentect.list.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ListConstant {
	//Title
	private static final Map<String, String> titleMap;
    static {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("Mr", "Mr");
        aMap.put("Mrs", "Mrs");
        titleMap = Collections.unmodifiableMap(aMap);
    }
    //Training Type
    private static final Map<String, String> trainingTypeMap;
    static {
        Map<String, String> atrainingTypeMap = new HashMap<String, String>();
        atrainingTypeMap.put("IND", "Induction");
        atrainingTypeMap.put("REF", "Refresher");
        trainingTypeMap = Collections.unmodifiableMap(atrainingTypeMap);
    }
    
    //User Type
    private static final Map<String, String> userTypeMap;
    static {
        Map<String, String> auserTypeMap = new HashMap<String, String>();
        auserTypeMap.put("FSO", "FSO");
        auserTypeMap.put("AO", "AO");
        userTypeMap = Collections.unmodifiableMap(auserTypeMap);
    }
    
  //Training Phase
    private static final Map<String, String> trainingPhaseMap;
    static {
        Map<String, String> atrainingPhaseMap = new HashMap<String, String>();
        atrainingPhaseMap.put("FND", "FOUNDATION");
        trainingPhaseMap = Collections.unmodifiableMap(atrainingPhaseMap);
    }
    
  //Status
    private static final Map<String, String> statusMap;
    static {
        Map<String, String> astatusMap = new HashMap<String, String>();
        astatusMap.put("A", "Active");
        astatusMap.put("I", "InActive");
        statusMap = Collections.unmodifiableMap(astatusMap);
    }
    
  //User Status
    private static final Map<String, String> userStatusMap;
    static {
        Map<String, String> auserStatusMap = new HashMap<String, String>();
        auserStatusMap.put("PEN", "Pending");
        auserStatusMap.put("CON", "Confirmed");
        auserStatusMap.put("REH", "Rejected");
        userStatusMap = Collections.unmodifiableMap(auserStatusMap);
    }
    
  //No Of Option
    private static final Map<String, String> noOfOptionMap;
    static {
        Map<String, String> anoOfOptionMap = new HashMap<String, String>();
        anoOfOptionMap.put("1", "1");
        anoOfOptionMap.put("2", "2");
        anoOfOptionMap.put("3", "3");
        anoOfOptionMap.put("4", "4");
        anoOfOptionMap.put("5", "5");
        anoOfOptionMap.put("6", "6");
        noOfOptionMap = Collections.unmodifiableMap(anoOfOptionMap);
    }
    
  //Training Topic
    private static final Map<String, String> trainingTopicMap;
    static {
        Map<String, String> atrainingTopicMap = new HashMap<String, String>();
        atrainingTopicMap.put("FOOD", "FOOD");
        trainingTopicMap = Collections.unmodifiableMap(atrainingTopicMap);
    }
    
  //Exp Banckground
    private static final Map<String, String> expBGMap;
    static {
        Map<String, String> aexpBGMap = new HashMap<String, String>();
        aexpBGMap.put("IND", "Industry");
        aexpBGMap.put("ACD", "Academics");
        aexpBGMap.put("RD", "R&D");
        expBGMap = Collections.unmodifiableMap(aexpBGMap);
    }
    
    

}
