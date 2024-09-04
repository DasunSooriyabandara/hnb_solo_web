This is an attempt to automate the HNB Solo application’s happy path as part of my self-study in automation testing. 
I’ve included all the necessary details related to the testing process, along with an Allure report for reference. 
If there are areas where I can improve, 
I would greatly appreciate any feedback or suggestions to enhance my knowledge and skills.


**Task: UI Test Automation Suite Development using Selenium and Jav**a
System Under Test (SUT)
URL: https://solo-admin-sit.hnb.lk/
Credentials:
Username: Please contact me to get the Username
Password:Please contact me to get the Password

**Objective**
Develop a UI test automation suite using Selenium and Java, following the Page Object Model (POM) design pattern and utilizing the Page Factory within your project. The test suite should cover the following scenarios:

**Scenario 1: Login and Verify "My Outlets" Hyperlink**
Navigate to the URL:

Access the system using the provided URL.
Login with Given Credentials:

Use the credentials Username: Admin and Password: Think100% to log in.
Verify "My Outlets" Hyperlink:

Ensure that the "My Outlets" hyperlink is displayed on the page after logging in.

**Scenario 2: Create a New Outlet with Mandatory Fields and Image Upload**

Login and Navigate to "My Outlets":
Log in using the provided credentials.
Navigate to the "My Outlets" section.
Click on "Add":

Click the "Add" button to create a new outlet.
Fill Mandatory Fields and Upload Image:

Complete all mandatory fields in the form.
Upload an image using the provided image URL.
Click "Save" to create the outlet.
Verify Successful Outlet Creation:

Assert that a success message is displayed, indicating that the outlet was created successfully.
Search and Verify Outlet Name:

Search for the newly created outlet.
Verify that the outlet name matches the one you entered during creation.


**Scenario 3: Filter and View Information of an Existing Outlet**
Login and Navigate to "My Outlets":

Log in using the provided credentials.
Navigate to the "My Outlets" section.
Click on "Filter":

Click the "Filter" button to access the filtering options.
Enter Filter Criteria:

Fill in the fields with appropriate filter criteria based on existing outlet information.
Click "Set Filter":

Apply the filter by clicking the "Set Filter" button.
View Filtered Outlet Details:

From the filtered results displayed in the table, select an outlet to view its detailed information.
Verify Outlet Information:

On the detailed information page, verify the outlet’s status, name, and merchant information to ensure accuracy.


**Notes:**
Utilize the Page Object Model (POM) and Page Factory design patterns throughout the implementation.
Ensure that each scenario is automated as part of the test suite.
