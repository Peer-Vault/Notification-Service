# Peer Vault - Notification Service

## 🚀 Overview
The **Notification Service** is a dedicated microservice in the Peer Vault ecosystem responsible for handling all outgoing communications, primarily email notifications. It integrates with Apache Kafka to send automated emails for events like user registration and file sharing, ensuring timely and reliable communication with users.

---

## ✨ Features
* **Email Sending:** Provides an API endpoint for sending general emails.
* **Kafka Integration:** Consumes messages from Kafka topics for event-driven notifications.
* **User Registration Notifications:** Automatically sends welcome emails upon user registration.
* **File Sharing Notifications:** Notifies users when a file is shared with them.
* Integrates with **Spring Mail** for email delivery.
* Registers with **Service Discovery** for seamless integration with other microservices.

---

## 🛠 Tech Stack
* Spring Boot
* Spring Mail
* Apache Kafka (Spring Kafka)
* Jackson (for JSON processing)
* Spring Cloud Netflix Eureka Client
* Docker & Docker Compose (optional for containerized deployment)

---

## 🏗 Installation & Setup

### Prerequisites
* Java 17 or higher
* Maven
* Git
* Running **Config Server**
* Running **Service Discovery Server**
* Running **Apache Kafka** instance
* Docker and Docker Compose (optional)

### Backend Setup

1.  **Clone the Notification Service repository:**
    ```bash
    git clone [https://github.com/Peer-Vault/Notification-Service.git](https://github.com/Peer-Vault/Notification-Service.git)
    cd Notification-Service
    ```

2.  **Configure the Notification Service `application.yml`** (located in the `src/main/resources` folder) to connect to your Config Server and register with Service Discovery. An example `application.yml` would look like this:
    ```yaml
    spring:
      application:
        name: notificationservice
      config:
        import: optional:configserver:http://localhost:8071/

    server:
      port: 8083 # Default port for the Notification Service
    ```
    Email server details (`spring.mail.*` properties) and Kafka broker addresses will be fetched from the Config Server. Ensure your Config Server has these properties defined for `notificationservice.yml`.

3.  **Configure Kafka Constants:**
    Update the `KafkaConstants.HOST_AND_PORT` in `com.peer.vault.notification_service.utils.KafkaConstants` to point to your Kafka broker(s). For example:
    ```java
    // In com.peer.vault.notification_service.utils.KafkaConstants
    public static final String HOST_AND_PORT = "localhost:9092"; // Your Kafka broker address
    public static final String USER_REGISTRATION = "user-registration-topic";
    public static final String File_SHARED = "file-shared-topic";
    public static final String GROUP_EMAIL = "email-group";
    ```

4.  **Run the Notification Service:**

    **Run Locally**
    ```bash
    mvn spring-boot:run
    ```

  

---

## 🎯 Usage
* Start the **Config Server**, **Service Discovery Server**, and **Gateway Server** before starting the Notification Service.
* Ensure your Kafka instance is running and accessible.

* **Send a direct email:**
    * **Endpoint:** `POST /notifications/sendEmail`
    * **Body:**
        ```json
        {
          "to": "recipient@example.com",
          "subject": "Test Subject",
          "body": "This is a test email from the Notification Service."
        }
        ```
    * **Authentication:** Requires JWT token in `Authorization: Bearer` header (if routed via Gateway).
    * **Response:** `200 OK` with "Email sent successfully".

* **Automated notifications via Kafka:**
    * The service automatically listens for messages on the `user-registration-topic` and `file-shared-topic` Kafka topics.
    * **For User Registration:**
        * When another service (e.g., User Service) publishes a message to `user-registration-topic` in the format `{"email": "user@example.com", "first": "John", "last": "Doe"}`, the Notification Service will send a registration success email.
    * **For File Sharing:**
        * When another service (e.g., File Service) publishes a message to `file-shared-topic` in the format `{"email": "recipient@example.com", "fileUrl": "http://gateway/file/download/shared/CID"}` (or similar), the Notification Service will send a file shared email.

---

## 🤝 Contributing
Contributions and suggestions are welcome! Feel free to open issues or submit pull requests to improve the project.


---

## 👨‍💻 Author
Developed and maintained by the Peer Vault team.

---

🌟 Star this repo if you find it helpful! 🌟
