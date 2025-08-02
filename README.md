#  Janitri QA Assignment

This repository contains both **Manual** and **Automation Testing** solutions for the login functionality of Janitri's dashboard application ([https://dev-dash.janitri.in](https://dev-dash.janitri.in)), as part of the **Janitri QA Internship** assignment.

---

##  Assignment Contents

### I. Manual Testing

**File:** `Janitri_Login_Manual_TestCases.xlsx`

**Covered Test Scenarios:**
1. Field validations  
2. Login button behavior  
3. Password masking toggle  
4. Error message handling  

**Details Included:**
- Test case ID  
- Steps  
- Expected result  
- Actual result  
- Status  
- Remarks  

---

### II. Automation Testing (Selenium + TestNG)

**Tech Stack:**  
- Java  
- Selenium WebDriver  
- TestNG

**Automated Test Scenarios:**
1. Login button enable/disable  
2. Password visibility toggle  
3. Invalid credentials error message  
4. Presence of page elements (e.g., input fields)


| File/Folder                         | Description                                 |
|------------------------------------|---------------------------------------------|
| `Janitri_Login_Manual_TestCases.xlsx` | Manual test cases in Excel format            |
| `README.md`                        | Project overview                             |
| `/base`                            | Base test setup using WebDriver + TestNG     |
| `/pages`                           | Page Object Model for login page             |
| `/tests`                           | Test cases for login functionality           |


