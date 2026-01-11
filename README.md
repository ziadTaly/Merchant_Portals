# Merchant Portal Test Automation - Complete Summary

## 📂 Project Structure

```
D:\ZIAD\MERCHANT\SRC
├── main
│   └── java
│       └── Merchant_Taly
│           ├── PageBase.java
│           ├── dashboard
│           │   ├── DashboardPage.java
│           │   ├── TransactionsPage.java
│           │   └── total_volume.java
│           └── Login
│               └── LoginPage.java
└── test
    └── java
        ├── Data
        │   ├── JsonDataReader.java
        │   └── UserData.json
        └── Merchant_Taly_Test
            ├── TestBase.java
            ├── dashboardTest_TC
            │   ├── DashboardPageTest_TC1.java
            │   └── TransactionsPageTest_TC2.java
            └── Login_TC
                └── LoginPageTest_TC0.java
```

## 📋 Test Cases Overview

### TC0 - Login Test Cases (1 Test)
- **TC0.1**: Verify successful login functionality

### TC1 - Dashboard Test Cases (17 Tests)
1. **TC1.1**: Verify Dashboard page loads successfully
2. **TC1.2**: Verify Dashboard title is displayed correctly
3. **TC1.3**: Verify all sidebar navigation elements
4. **TC1.4**: Verify Monthly Performance section
5. **TC1.5**: Verify Total Transaction Count card
6. **TC1.6**: Verify Total Volume card
7. **TC1.7**: Verify Top Branches card
8. **TC1.8**: Verify BNPL radio switch in Transaction Count
9. **TC1.9**: Verify BNPL radio switch in Volume
10. **TC1.10**: Verify theme toggle functionality
11. **TC1.11**: Verify language button
12. **TC1.12**: Verify sidebar toggle
13. **TC1.13**: Verify navigation to Transactions page
14. **TC1.14**: Verify navigation to Payment page
15. **TC1.15**: Verify all cards are present
16. **TC1.16**: Verify no data messages
17. **TC1.17**: Verify dashboard active state

### TC2 - Transactions Test Cases (32 Tests)
1. **TC2.1**: Verify Transactions page loads successfully
2. **TC2.2**: Verify Transactions navigation is active
3. **TC2.3**: Verify Filters section title
4. **TC2.4**: Verify all filter elements displayed
5. **TC2.5**: Verify date range picker functionality
6. **TC2.6**: Verify transaction type dropdown
7. **TC2.7**: Verify channel type dropdown
8. **TC2.8**: Verify transaction scheme dropdown
9. **TC2.9**: Verify TID input field
10. **TC2.10**: Verify Batch ID input field
11. **TC2.11**: Verify Auth Code input field
12. **TC2.12**: Verify transaction status dropdown
13. **TC2.13**: Verify branch dropdown
14. **TC2.14**: Verify reset button functionality
15. **TC2.15**: Verify apply filters button
16. **TC2.16**: Verify Transactions section title
17. **TC2.17**: Verify total gross amount display
18. **TC2.18**: Verify export button
19. **TC2.19**: Verify all table headers
20. **TC2.20**: Verify select all checkbox
21. **TC2.21**: Verify table contains data
22. **TC2.22**: Verify row checkbox functionality
23. **TC2.23**: Verify merchant name display
24. **TC2.24**: Verify row action button
25. **TC2.25**: Verify pagination is displayed
26. **TC2.26**: Verify current page number
27. **TC2.27**: Verify next page navigation
28. **TC2.28**: Verify previous page navigation
29. **TC2.29**: Verify page number click
30. **TC2.30**: Verify navigation to Dashboard
31. **TC2.31**: Verify navigation to Payment
32. **TC2.32**: Verify filter input clear with reset

## 🎯 Total Test Coverage
- **Total Test Cases**: 50
- **Login Tests**: 1
- **Dashboard Tests**: 17
- **Transactions Tests**: 32

## 📊 Test Data (UserData.json)

### Login Data
- userName: admin@DeglaSmart.com
- password: Admin@123

### Dashboard Data
- Dashboard title verification
- Card titles (Transaction Count, Volume, Top Branches)
- Radio button labels (Acceptance, BNPL)
- No data messages

### Transactions Data
- Filter labels and placeholders
- Sample test data (TID, Batch ID, Auth Code)
- Table headers
- Transaction types (Sale, Void, Refund, etc.)
- Channel types (POS, Gateway)
- Transaction schemes (MasterCard, VISA, Meeza, OnUs)
- Merchant information

## 🔧 Key Features Implemented

### Page Object Model (POM)
- ✅ Comprehensive page objects with @FindBy annotations
- ✅ Reusable methods for common actions
- ✅ Clear separation of page elements and actions

### Test Framework
- ✅ TestNG framework with priorities
- ✅ Data-driven testing using JSON
- ✅ Comprehensive logging with LoggerHelper
- ✅ Screenshot capture on test failure
- ✅ Browser management with TestBase

### Test Coverage
- ✅ UI element verification
- ✅ Navigation testing
- ✅ Filter functionality
- ✅ Table operations
- ✅ Pagination testing
- ✅ Input field validation
- ✅ Dropdown interactions
- ✅ Button functionality

## 🚀 How to Run Tests

### Run All Tests
```xml
testng_complete_suite.xml
```

### Run Specific Test Suite
```xml
<!-- Login Only -->
testng_login.xml

<!-- Dashboard Only -->
testng_dashboard.xml
```

### Run from Command Line
```bash
mvn test -DsuiteXmlFile=testng_complete_suite.xml
```

## 📝 Test Execution Order
1. **Login** → Authenticate user
2. **Dashboard** → Verify main dashboard functionality
3. **Transactions** → Verify transactions page features

## ⚙️ Browser Configuration
- Default: Chrome
- Supported: Chrome, Firefox, Edge, Internet Explorer
- Can be changed via testng.xml parameter

## 📸 Screenshots
- Automatically captured on test failure
- Saved with test method name
- Located in project screenshots folder

## 🔍 Logging
- Comprehensive logging using LoggerHelper
- Success (✅) and Error (❌) indicators
- All logs saved to: `Wallet_Automation_Log.log`

## 🎨 Best Practices Followed
1. ✅ Page Object Model design pattern
2. ✅ Explicit waits for element interactions
3. ✅ Data-driven testing
4. ✅ Descriptive test names
5. ✅ Proper error handling
6. ✅ Code reusability
7. ✅ Clear documentation
8. ✅ Maintainable test structure

## 📦 Dependencies Required
- Selenium WebDriver
- TestNG
- JSON Simple Parser
- Java 8 or higher

## 🔐 Test Environment
- URL: https://10.20.73.2:8090/
- Environment: SandBox
- Authentication: Required (handled in TestBase)

---

**Note**: All test cases are designed to be independent and can run in any order within their test class. The test suite ensures proper setup and teardown for each test execution.
