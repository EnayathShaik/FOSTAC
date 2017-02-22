
INSERT INTO profile(  profileid, profilename) VALUES (1, 'SuperAdmin');
INSERT INTO profile(  profileid, profilename) VALUES (2, 'Admin');
INSERT INTO profile(  profileid, profilename) VALUES (3, 'Trainee');
INSERT INTO profile(  profileid, profilename) VALUES (4, 'Trainer');
INSERT INTO profile(  profileid, profilename) VALUES (5, 'Training Center');
INSERT INTO profile(  profileid, profilename) VALUES (6, 'Assessor');
INSERT INTO profile(  profileid, profilename) VALUES (7, 'Training Partner');
INSERT INTO profile(  profileid, profilename) VALUES (8, 'Assesssment Agency');

INSERT INTO kindofbusiness(  kindofbusinessid, kindofbusinessname) VALUES (1, 'Permanent/Temporary Stall Holder');
INSERT INTO kindofbusiness(  kindofbusinessid, kindofbusinessname) VALUES (2, 'Hawker (Itinerant/Mobile Food Vender)');
INSERT INTO kindofbusiness(  kindofbusinessid, kindofbusinessname) VALUES (3, 'HomeBasedCanteens/Dabba Wallas');
INSERT INTO kindofbusiness(  kindofbusinessid, kindofbusinessname) VALUES (4, 'Petty Retailer of Snacks');
INSERT INTO kindofbusiness(  kindofbusinessid, kindofbusinessname) VALUES (5, 'Manufacturer / Processor');
INSERT INTO kindofbusiness(  kindofbusinessid, kindofbusinessname) VALUES (6, 'Not in business');
INSERT INTO kindofbusiness(  kindofbusinessid, kindofbusinessname) VALUES (7, 'Others');

INSERT INTO title( titleid, titlename)  VALUES (1, 'Mr.');
INSERT INTO title( titleid, titlename)  VALUES (2, 'Mrs.');
INSERT INTO title( titleid, titlename)  VALUES (3, 'Miss');
INSERT INTO title( titleid, titlename)  VALUES (4, 'Master');

INSERT INTO coursetype(coursetypeid, coursetype) VALUES (1, 'Basic');
INSERT INTO coursetype(coursetypeid, coursetype) VALUES (2, 'Advance');
INSERT INTO coursetype(coursetypeid, coursetype) VALUES (3, 'Special');INSERT INTO coursetype(coursetypeid, coursetype) VALUES (4, 'TOT');

INSERT INTO Steps (stepId,steps) values (1 ,'Course EnrollMent');
INSERT INTO Steps (stepId,steps) values (2 ,'Get Your Admit Card');
INSERT INTO Steps (stepId,steps) values (3 ,'Attend Training');
INSERT INTO Steps (stepId,steps) values (4 ,'Get Your Self Assessed');
INSERT INTO Steps (stepId,steps) values (5 ,'Give Your Feedback');
INSERT INTO Steps (stepId,steps) values (6 ,'Get Your Certificate');

INSERT INTO state(  stateid, statename, status) VALUES (100, 'UP', 'A');
INSERT INTO state(  stateid, statename, status) VALUES (99, 'MP', 'A');

INSERT INTO district( districtid, districtname, stateid, status) VALUES (100000, 'Agra', 100, 'A');
INSERT INTO district( districtid, districtname, stateid, status) VALUES (100001, 'Aligarh', 100, 'A');
INSERT INTO district( districtid, districtname, stateid, status) VALUES (100002, 'Gwalior', 99, 'A');
INSERT INTO district( districtid, districtname, stateid, status) VALUES (100003, 'Morena', 99, 'A');

INSERT INTO city(  cityid, cityname, districtid, status) VALUES (1000000, 'Agra_Cantt', 100000, 'A');
INSERT INTO city(  cityid, cityname, districtid, status) VALUES (1000001, 'Agra_City', 100000, 'A');
INSERT INTO city(  cityid, cityname, districtid, status) VALUES (1000002, 'Sasni_Gate', 100001, 'A');
INSERT INTO city(  cityid, cityname, districtid, status) VALUES (1000003, 'Bus_Stand', 100001, 'A');
INSERT INTO city(  cityid, cityname, districtid, status) VALUES (1000004, 'Thatipur', 100002, 'A');
INSERT INTO city(  cityid, cityname, districtid, status) VALUES (1000005, 'Gwl_Cantt', 100002, 'A');
INSERT INTO city(  cityid, cityname, districtid, status) VALUES (1000006, 'Morena_Cantt', 100003, 'A');
INSERT INTO city(  cityid, cityname, districtid, status) VALUES (1000007, 'Morena_Stand', 100003, 'A');

--INSERT INTO logindetails( id, encrypted_password, password, loginid, profileid, status) VALUES (2, 'jhjhj', 'Password', 'SUPERADMIN', 1, 'A');
--commit;
--INSERT INTO adminusermanagement( adminusermanagementid, aadharnumber, firstname, lastname, middlename, logindetails) VALUES (1, 123456789123, 'Lalit', 'Kr', 'Pachauri', 2);
create sequence assessmentsequence increment by 1 start with 100;
create table assessmenteligibility(id integer default nextval('assessmentsequence'), coursenameid integer, eligibility integer);
INSERT INTO ASSESSMENTELIGIBILITY(COURSENAMEID, ELIGIBILITY) VALUES (?, ?);
create table assessmenteligibilitytrainer(id integer default nextval('assessmentsequence'), coursenameid integer, eligibility integer);
INSERT INTO ASSESSMENTELIGIBILITYTRAINER(COURSENAMEID, ELIGIBILITY) VALUES (?, ?);

--- RUNNING
----alter table courseenrolled add column trainingstatus character varying(10);
--ALTER TABLE public.personalinformationtrainingpartner drop COLUMN NoOfTrainingSessionWishToConductInAMonth
--ALTER TABLE public.personalinformationtrainingpartner drop COLUMN NoOfYearsInBusinessOfTraining
--ALTER TABLE public.personalinformationtrainingpartner drop COLUMN noofinhousetrainers