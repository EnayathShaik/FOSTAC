package com.ir.constantes;

public enum TableLink {
	ONE("logindetails",1,"SuperAdmin",""),
    TWO("",2,"Admin",""),
    THIRD("personalinformationtrainee",3,"Trainee","email"),
    FOURTH("personalinformationtrainer",4,"Trainer","TrainingCenterPermanentEmail"),
    FIFTH("personalinformationtrainingpartner",5,"Training Center","TrainingPartnerPermanentEmail"),
    SIXTH("personalinformationassessor",6,"Assessor","AssessorPermanentEmail"),
    SEVENTH("managetrainingpartner",7,"Training Partner","email"),
    EIGHTH("manageassessmentagency",8,"Assesssment Agency","email");
   

    private String tableName;
    private Integer profileID;
    private String title;
    private String email;

    TableLink(String tableName,Integer profileID, String title,String email) {
        this.tableName=tableName;
        this.profileID=profileID;
        this.title=title;
        this.email=email;
    }
    public String tableName()
    {
        return tableName;
    }
    public Integer profileID()
    {
        return profileID;
    }
    public String title()
    {
        return title;
    }
    public String email()
    {
        return email;
    }
    
    public static TableLink getByprofileID(int profileID) {
        for(TableLink e : values()) {
            if(e.profileID.equals(profileID)) return e;
        }
        return null;
     }
}

