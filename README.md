# Doctor-Patient System

The Doctor-Patient System is a web application that facilitates the management of doctors and patients. It allows patients to search for doctors based on their symptoms and location, and helps doctors manage their appointments and patient information.

## Features

- Add and remove doctors from the system
- Add patients and assign them to doctors
- Search for doctors based on patient symptoms and location
- View doctor details, including their specialty and contact information
- Manage appointments and patient information

## Technologies Used

- Java
- Spring Boot
- MySQL
  

## Installation

1. Clone the repository:
   git clone https://github.com/nitu8860/doctor-patient-system.git
2. Import the project into your preferred IDE (e.g., IntelliJ IDEA or Eclipse).
3. Configure the database connection in the application.properties file:
   spring.datasource.url=jdbc:mysql://localhost:3306/doctor_patient_system

   spring.datasource.username=root

   spring.datasource.password=your-password

4. Run the application.
5. Access the application in your web browser:
   http://localhost:8080

## Usage
1. Register a doctor:
    - Provide the required details, such as name, specialty, and contact information.
    - Click the "Add Doctor" button to save the doctor in the system.

2. Add a patient:
   - Enter the patient's details, including name, symptoms, city, email, and phone number.
   - Select a doctor from the dropdown menu to assign the patient to that doctor.
   - Click the "Add Patient" button to save the patient in the system.

3. Search for doctors:
   - Enter the patient's symptoms and location.
   - Click the "Search" button to find doctors matching the given criteria.
   - View the list of suggested doctors and their details.

3. Manage appointments:
    - Select a doctor to view their appointments.
    - Add, edit, or delete appointments as necessary.

## Screenshot
![Swagger UI - Google Chrome 28-06-2023 20_26_08](https://github.com/nitu8860/Doctor-Patient/assets/112774001/9b49a672-00e7-4740-ab6c-cd82a93bfb1a)
![MySQL Workbench 28-06-2023 20_47_13](https://github.com/nitu8860/Doctor-Patient/assets/112774001/42756a7b-ca19-4ce1-8664-0b7f975caa3d)

