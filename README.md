<p>This is an attempt to automate the HNB Solo application’s happy path as part of my self-study in automation testing. I’ve included all the necessary details related to the testing process and an Allure report for reference. If there are areas where I can improve, I would greatly appreciate any feedback or suggestions to enhance my knowledge and skills.</p>
<hr>

<h4>Task: UI Test Automation Suite Development using Selenium and Java</h4>

<h5>System Under Test (SUT)</h5>
<p><strong>URL:</strong> <a href="https://solo-admin-sit.hnb.lk/">https://solo-admin-sit.hnb.lk/</a></p>

<p><strong>Credentials:</strong><br>
Username: Please get in touch with me to get the Username<br>
Password: Don't hesitate to get in touch with me to get the Password
</p>

<h4>Objective</h4>
<p>Develop a UI test automation suite using Selenium and Java, following the Page Object Model (POM) design pattern and utilizing the Page Factory within your project. The test suite should cover the following scenarios:</p>

<h4>Scenario 1: Login and Verify "My Outlets" Hyperlink</h4>
<ul>
    <li><strong>Navigate to the URL:</strong><br> Access the system using the provided URL.</li>
    <li><strong>Login with Given Credentials:</strong><br> Use the credentials Username: Admin and Password: Think100% to log in.</li>
    <li><strong>Verify "My Outlets" Hyperlink:</strong><br> Ensure that the "My Outlets" hyperlink is displayed on the page after logging in.</li>
</ul>

<h4>Scenario 2: Create a New Outlet with Mandatory Fields and Image Upload</h4>
<ul>
    <li><strong>Login and Navigate to "My Outlets":</strong><br> Log in using the provided credentials and navigate to the "My Outlets" section.</li>
    <li><strong>Click on "Add":</strong><br> Click the "Add" button to create a new outlet.</li>
    <li><strong>Fill Mandatory Fields and Upload Image:</strong><br> Complete all mandatory fields in the form. Upload an image using the provided image URL. Click "Save" to create the outlet.</li>
    <li><strong>Verify Successful Outlet Creation:</strong><br> Assert that a success message is displayed, indicating the outlet was created successfully.</li>
    <li><strong>Search and Verify Outlet Name:</strong><br> Search for the newly created outlet and verify that the outlet name matches the one entered during creation.</li>
</ul>

<h4>Scenario 3: Filter and View Information of an Existing Outlet</h4>
<ul>
    <li><strong>Login and Navigate to "My Outlets":</strong><br> Log in using the provided credentials and navigate to the "My Outlets" section.</li>
    <li><strong>Click on "Filter":</strong><br> Click the "Filter" button to access the filtering options.</li>
    <li><strong>Enter Filter Criteria:</strong><br> Fill in the fields with appropriate filter criteria based on existing outlet information.</li>
    <li><strong>Click "Set Filter":</strong><br> Apply the filter by clicking the "Set Filter" button.</li>
    <li><strong>View Filtered Outlet Details:</strong><br> From the filtered results displayed in the table, select an outlet to view its detailed information.</li>
    <li><strong>Verify Outlet Information:</strong><br> On the detailed information page, verify the outlet’s status, name, and merchant information to ensure accuracy.</li>
</ul>

<h4>Notes:</h4>
<p>Utilize the Page Object Model (POM) and Page Factory design patterns throughout the implementation. Ensure that each scenario is automated as part of the test suite.</p>
