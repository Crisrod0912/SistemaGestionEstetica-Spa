# 👑 Sistema de Gestión de Estética/Spa

Ana is an entrepreneur with a strong desire to improve herself; her beauty salon has been in the market for a long time and has decided it's time to give her business a technological boost.

The working hours are from 8 am to 6 pm. Ana works alone in her business, so the attention she can provide to her clients is individual and by appointment.

A facial takes 1 hour, an electrotherapy treatment takes 30 minutes, and relaxing massages also take 1 hour. (Invent at least 3 additional services).

Prices vary depending on the type of service; seniors and children under 5 years old receive a 12% discount at the time of billing.

## 🧩 Features

- 🔐 **Login**
- 👩‍💼 **Employee Module:** In this module, you can view the employees working for the company, modify their data (update and delete), and add new employees to the system. Data such as name, ID number, salary, and position must be entered in this section:
  - 🆔 Employee ID number.
  - 👤 Employee name.
  - 🏠 Employee address.
  - 📞 Employee phone number.
  - 📧 Employee email address.
  - 💰 Employee commission.
- 👥 **Customer Module:** In this module, you can view the customers already registered on the furniture store's customer list. You can modify their information if necessary and add new customers to the system. Data such as the customer's name, ID number, phone number, and address must be included in this module.
  - 🆔 Customer ID number.
  - 👤 ustomer name.
  - 🏠 Customer address.
  - 📞 Customer phone number.
  - 📧 Customer email address.
- 📅 **Reservation Module:** In this module, the customer will be asked for: the number of people, the condition of each person (child or senior citizen), the time they wish to reserve (selecting from the available times), and a reservation number will be generated. If the number of people reserving exceeds the venue's capacity, the system will indicate that there is no space available at the chosen time and that they must select another time. The reservation must also include the selected time, the name of the person who will assist them, and a reservation number.
- 🧾 **Billing Module:** It will request the customer's name and identification number, as well as the reservation number. With this number and the conditions defined in the reservation, it will create an invoice that must contain the company's information, the customer's information, the reservation details (number of people, condition of each person, time and amount to be paid), and the name of the employee who assisted them.
- 📊 **Reports Module:** It will generate the following reports, for which you must obtain the information from the flat files recorded for both reservations and billing.
  - 📆 Number of people served per day: divided by the staff member serving them, their age (female-male, child-adult-senior citizen).
  - 💰 Amount of money generated per day: divided by (adults-children and senior citizens). And by the employee who served them, as well as their commission.
  - ⏰ Peak hours: you must indicate the hours and the number of people served during a given period.
  - 🕰️ Lowest hours: you must indicate the hours and the number of people served during a given period.

## 🛠️ Technologies Used

- ☕ **Programming language:** Java
- 🗄️ **Database:** MySQL
- 🌱 **Version Control:** Git

## ⚙️ Installation

### 📋 Prerequisites

- 💻 [Apache Netbeans](https://netbeans.apache.org/front/main/index.html) (recommended: Apache Netbeans 28)
- 🔐 [JBCrypt](https://mvnrepository.com/artifact/org.mindrot/jbcrypt/0.4) (password hashing)
- 🔌 [MySQL Connector](https://dev.mysql.com/downloads/connector/j/)
- 🧰 [MySQL Workbench](https://www.mysql.com/products/workbench/)

---

### ⚙️ Configuration

Follow these steps to correctly configure and run the project:

📥 **Step 1: Clone the repository**

   ```bash
   git clone https://github.com/Crisrod0912/SistemaGestionEstetica-Spa.git
   ```

📂 **Step 2: Open the project folder in Apache Netbeans**

🔧 **Step 3: Configure the Database Connection**

   ```bash
   private final String URL = "jdbc:mysql://localhost:3306/";
   private final String DB = "sges";
   private final String USR = "root";
   private final String PWD = "your_password_here";
   private final String DRIVER = "com.mysql.cj.jdbc.Driver";
   ```

🗄️ **Step 4: Execute the SQL script**

  - Before using the project, you must execute the script `SGES.sql` in your database.

▶️ **Step 5: Run the project**

   - Click on "Run Project".

> [!NOTE]
> **Project Owner / Developer** 👨🏻‍💻  
>- Cristopher Rodríguez Fernández 
***
