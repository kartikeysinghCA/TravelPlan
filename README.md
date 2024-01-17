# Documentation

## Backend
- Springboot (Java)
- Dependencies: Spring Web, Spring Security, MySQL Connect and Lombok
- Model: Employee, Travel and Association
- Database: MySQL (Schema: EmployeeDB, Tables: Employee, Travel and Assoc)
- Endpoints:
  /api/employees (GET,DEL,POST)
  /api/employees/{id} (GET, DELETE)
  /api/travel (GET,DEL,POST)
  /api/travel/{id} (GET, DELETE)
  /api/assoc (GET,DEL,POST)
  /api/assoc/{id} (GET, DELETE)

## Frontend
- ReactJS (+ViteJS)
- npm: Package manager
- axios for hitting end points
- toast for notification 
- Bootstrap for aesthetics

## Microservice (Backend)
- Flask (Python)
- API Endpoints: /api/notif/{delete,create,login,logout,incorrect,invalid,unauth}

