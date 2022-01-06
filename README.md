## Drones

[[_TOC_]]

---

:scroll: **START**


### Introduction

There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.

Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

---

### Task description

We have a fleet of **10 drones**. A drone is capable of carrying devices, other than cameras, and capable of delivering small loads. For our use case **the load is medications**.

A **Drone** has:
- serial number (100 characters max);
- model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
- weight limit (500gr max);
- battery capacity (percentage);
- state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).

Each **Medication** has:
- name (allowed only letters, numbers, ‘-‘, ‘_’);
- weight;
- code (allowed only upper case letters, underscore and numbers);
- image (picture of the medication case).
- state (DISPATCHED, IN-TRANSIT, DELIVERED)

Develop a service via REST API that allows clients to communicate with the drones (i.e. **dispatch controller**). The specific communicaiton with the drone is outside the scope of this task.

The service should allow:
- registering a drone; -- in progress
- registering a medication -- pending
- loading a drone with medication items; -- pending
- checking loaded medication items for a given drone; -- done
- checking available drones for loading; -- done
- check drone battery level for a given drone; -- done

> Feel free to make assumptions for the design approach.

---

### Requirements

While implementing your solution **please take care of the following requirements**:

#### Functional requirements

- There is no need for UI;
- Prevent the drone from being loaded with more weight that it can carry;
- Prevent the drone from being in LOADING state if the battery level is **below 25%**;
- Introduce a periodic task to check drones battery levels and create history/audit event log for this.

---

#### Non-functional requirements

- Input/output data must be in JSON format;
- Your project must be buildable and runnable;
- Your project must have a README file with build/run/test instructions (use DB that can be run locally, e.g. in-memory, via container);
- Required data must be preloaded in the database.
- JUnit tests are optional but advisable (if you have time);
- Advice: Show us how you work through your commit history.

---

:scroll: **END**


## DRONE SERVICE API DETAILED INSTRUCTION 

---
`APPLICATION SETUP INSTRUCTION`

There are two profiles for this application as configured with `spring.profiles.active` in application.yml file:

#### MYSQL
- Set profile as `spring.profiles.active: mysqldb` to use MySQL database connection.
- Create a MySQL database as `create database droneservicedb;`
- Configured database username is `root` and password is `password`

#### FileDB
- Set profile as `spring.profiles.active: filedb` to use in-memory file database connection.

*NOTE:* You required in-memory database but my experience shows that MySQL configuration works better and produces 
a better result; hence, I advise you follow MySQL configuration setup.

`FILE UPLOAD DIRECTORY`
- File upload directory is configured as `upload-dir: file:///${project.basedir}/uploads`

`APPLICATION RUNNING HTTP PORT`
- This application runs on port `8084`

####`BUILD / RUN INSTRUCTION`
- The compiled JAR file is located in the target directory in the root folder.
- Run as follows: `java -jar DroneService-0.0.1-SNAPSHOT.jar` but note that the default profile is **mysqldb**.
- You can also import this project's source code into intelliJ IDE and run from there.


#### `POSTMAN API DOCUMENTATION`
- Documentation URL: https://documenter.getpostman.com/view/3234509/UVXdNyep

#### `TEST INSTRUCTIONS & APIs' EXPLANATIONS`
- **Generate Medication Code API** : Helps to generate unique reference using the rule "allowed only upper case letters, 
underscore and numbers". The codes generated here was used for medication code, drone serial number 
and medication package reference. 

- **Register Drone API** : Helps to register or create a new drone in the drone service. Every drone registered 
will require a new and unique serial number.

- **Upload File Endpoint API** : Helps to upload a medication image file. This endpoint should be executed before 
registering a medication. Its response contain a file download URL 
(i.e. `"fileDownloadUri": "http://localhost:8084/downloadFile/Screenshot%202022-01-02%20at%2017.24.36.png"`) that will 
be used as image file path while creating or registering a medication.

- **Medication Register API** : Helps to register or create a new medication in the drone service. Every medication 
registered will require a new and unique medication code.

- **Load Drone With Items API** : Helps to load a collection of registered medications to a registered drone. 
This collection is associated with a package which is represented as the package_reference.

- **Get Drone By Item API** : Helps to get a loaded or previously loaded drone by using an item 
medication code and package reference.

- **List All Available Drones API** : Helps to get or list all available drones. A drone is termed 
available if its state is `IDLE`.

- **Check Drone Battery Level API** : Helps to get a drone battery level using the drone serial number.

- **SCREENSHOTS FOLDER** :  The folder `drone-service-api-screenshots` screenshots of the tested endpoints from Postman.

- **DUMPED SQL DATA** : A MySQL dump of the database records is stored `droneservicedb.sql` at the project 
root's folder

- **CronService** : contains the cron jobs that periodically checks application battery level