package com.zentect.list.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ListConstant {
	//Title
	public static final Map<String, String> titleMap;
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
    public static final Map<String, String> userTypeMap;
    static {
        Map<String, String> auserTypeMap = new HashMap<String, String>();
        auserTypeMap.put("FSO", "FSO");
        auserTypeMap.put("AO", "AO");
        userTypeMap = Collections.unmodifiableMap(auserTypeMap);
    }
    
  //User Type
    private static final Map<String, String> trainingPhaseMap;
    static {
        Map<String, String> atrainingPhaseMap = new HashMap<String, String>();
        atrainingPhaseMap.put("FND", "FOUNDATION");
        trainingPhaseMap = Collections.unmodifiableMap(atrainingPhaseMap);
    }
    
  //User Type
    private static final Map<String, String> statusMap;
    static {
        Map<String, String> astatusMap = new HashMap<String, String>();
        astatusMap.put("A", "Active");
        astatusMap.put("I", "InActive");
        statusMap = Collections.unmodifiableMap(astatusMap);
    }
    
  //User Type
    private static final Map<String, String> userStatusMap;
    static {
        Map<String, String> auserStatusMap = new HashMap<String, String>();
        auserStatusMap.put("PEN", "Pending");
        auserStatusMap.put("CON", "Confirmed");
        auserStatusMap.put("REH", "Rejected");
        userStatusMap = Collections.unmodifiableMap(auserStatusMap);
    }
    
  //User Type
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
    
  //User Type
    private static final Map<String, String> trainingTopicMap;
    static {
        Map<String, String> atrainingTopicMap = new HashMap<String, String>();
        atrainingTopicMap.put("FOOD", "FOOD");
        trainingTopicMap = Collections.unmodifiableMap(atrainingTopicMap);
    }
    
  //User Type
    private static final Map<String, String> expBGMap;
    static {
        Map<String, String> aexpBGMap = new HashMap<String, String>();
        aexpBGMap.put("IND", "Industry");
        aexpBGMap.put("ACD", "Academics");
        aexpBGMap.put("RD", "R&D");
        expBGMap = Collections.unmodifiableMap(aexpBGMap);
    }
    
    
	public static final Map<String, String> stateMap;
    static {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("Andaman and Nicobar Islands","Andaman and Nicobar Islands");
        aMap.put("Andhra Pradesh","Andhra Pradesh");
        aMap.put("Arunachal Pradesh","Arunachal Pradesh");
        aMap.put("Assam","Assam");
        aMap.put("Bihar","Bihar");
        aMap.put("Chandigarh","Chandigarh");
        aMap.put("Chhattisgarh","Chhattisgarh");
        aMap.put("Dadra and Nagar Haveli","Dadra and Nagar Haveli");
        aMap.put("Daman and Diu","Daman and Diu");
        aMap.put("Delhi","Delhi");
        aMap.put("Goa","Goa");
        aMap.put("Gujarat","Gujarat");
        aMap.put("Haryana","Haryana");
        aMap.put("Himachal Pradesh","Himachal Pradesh");
        aMap.put("Jammu and Kashmir","Jammu and Kashmir");
        aMap.put("Jharkhand","Jharkhand");
        aMap.put("Karnataka","Karnataka");
        aMap.put("Kerala","Kerala");
        aMap.put("Lakshadweep","Lakshadweep");
        aMap.put("Madhya Pradesh","Madhya Pradesh");
        aMap.put("Maharashtra","Maharashtra");
        aMap.put("Manipur","Manipur");
        aMap.put("Meghalaya","Meghalaya");
        aMap.put("Mizoram","Mizoram");
        aMap.put("Nagaland","Nagaland");
        aMap.put("Odisha","Odisha");
        aMap.put("Puducherry","Puducherry");
        aMap.put("Punjab","Punjab");
        aMap.put("Rajasthan","Rajasthan");
        aMap.put("Sikkim","Sikkim");
        aMap.put("Tamil Nadu","Tamil Nadu");
        aMap.put("Telengana","Telengana");
        aMap.put("Tripura","Tripura");
        aMap.put("Uttar Pradesh","Uttar Pradesh");
        aMap.put("Uttarakhand","Uttarakhand");
        aMap.put("West Bengal","West Bengal");
        stateMap = Collections.unmodifiableMap(aMap);
    }
    
	public static final Map<String, String> AssesmentTypeMap;
    static {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("Before Training", "Before Training");
        aMap.put("After Training", "After Training");
        AssesmentTypeMap = Collections.unmodifiableMap(aMap);
    }
    
    
    //feedbackUserTypeMap
    public static final Map<String, String> feedbackUserTypeMap;
    static {
        Map<String, String> auserTypeMap = new HashMap<String, String>();
        auserTypeMap.put("Trainer", "Trainer");
        auserTypeMap.put("Trainer", "Trainer");
        feedbackUserTypeMap = Collections.unmodifiableMap(auserTypeMap);
    }
    
    
  //feedbackCategoryMap
    public static final Map<String, String> feedbackCategoryMap;
    static {
        Map<String, String> auserTypeMap = new HashMap<String, String>();
        auserTypeMap.put("Trainer", "Trainer");
        auserTypeMap.put("Trainer", "Trainer");
        feedbackCategoryMap = Collections.unmodifiableMap(auserTypeMap);
    }
    
    // course 
    
    public static final Map<String, String> courseNameMap;
    static {
        Map<String, String> auserTypeMap = new HashMap<String, String>();
        auserTypeMap.put("GC-MS/MS", "GC-MS/MS");
        auserTypeMap.put("LC-MS/MS", "LC-MS/MS");
        auserTypeMap.put("ICS-MS", "ICS-MS");
        courseNameMap = Collections.unmodifiableMap(auserTypeMap);
    }
    
    
    public static final Map<String, String> TypeMap;
    static {
        Map<String, String> auserTypeMap = new HashMap<String, String>();
        auserTypeMap.put("Cancel", "Cancel");
        auserTypeMap.put("Update", "Update");
        TypeMap = Collections.unmodifiableMap(auserTypeMap);
    }
    
    
    //User Type
    public static final Map<String, String> vacancyMap;
    static {
        Map<String, String> avacancyMap = new HashMap<String, String>();
        avacancyMap.put("P", "Part time");
        avacancyMap.put("F", "Full time");
        vacancyMap = Collections.unmodifiableMap(avacancyMap);
    }
    

}
