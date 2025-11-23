# PC Parts Hub


A Spring Boot inventory management system for a computer parts store with MVC architecture, Thymeleaf templates, and custom validation logic.

[![Live Demo](https://img.shields.io/badge/demo-live-success?logo=render&logoColor=white&color=28a745)]

## Live Demo


**[View Live Application](https://pcpartshub.onrender.com/mainscreen)** 


## Features


- **Parts & Products Management** - Track individual components (GPUs, CPUs, RAM) and complete pre-built systems
- **Buy Now Functionality** - Instant purchase with automatic inventory decrement and validation
- **Min/Max Stock Validation** - Custom business rules prevent inventory from going below minimum or above maximum levels
- **In-House & Outsourced Parts** - Separate forms and logic for different part sourcing types
- **Sample Data Auto-Population** - Application loads with pre-configured inventory on startup
- **Confirmation Pages** - User-friendly success/error screens for all actions (purchase, add, update, delete)


## Tech Stack

- **Framework**: Spring Boot (Java)
- **Template Engine**: Thymeleaf (server-side HTML rendering)
- **Build Tool**: Maven
- **Persistence**: JPA with embedded SQL database
- **Styling**: Bootstrap CSS
- **Deployment**: Docker + Render


## Getting Started


cd PCPartsHub
mvn clean install
mvn spring-boot:run

Visit [http://localhost:8080/mainscreen](http://localhost:8080/mainscreen) in your browser.

## Key Implementation Details


### Business Logic


- Min/max inventory constraints enforced at service layer
- Purchase validation prevents overselling with insufficient stock errors
- Automatic inventory decrement on successful purchases



### Architecture


- Clean MVC separation: controllers, services, repositories, domain models
- Custom validators for inventory rules and input validation
- Bootstrap component for sample data initialization



### Data Persistence


- JPA entity relationships between parts and products
- Repository pattern for data access abstraction
- Embedded database for local development



## Potential Improvements


- Add user authentication with admin and customer roles
- Replace Thymeleaf frontend with React or Angular for modern SPA experience
- Implement order history and tracking system
- Add product search and filtering by specifications (brand, price, type)
- Include product images and richer component details
- Create automated low-stock alerts and restock recommendations



## Author


**Cody Holm**


- GitHub: [@CodyHolm](https://github.com/CodyHolm)