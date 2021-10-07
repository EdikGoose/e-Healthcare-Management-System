# e-Healthcare-Management-System
## Project description

### Design Patterns

The main design pattern our team has implemented is an **abstract factory**. We are using an ****abstract factory pattern since our implementation uses two departments of the hospital (for children and for adults), and two types of medical staff (doctors and nurses). An abstract factory allows us to work with various categories of medical staff that perform some specific actions (i.e. treatment) in their own way. At the same moment, our code doesn't depend on concrete medical staff classes. Applying abstract factory allows us to extend our programs in a simple manner, extending existing departments and employees and creating new ones.

What is more, we applied **singleton** design pattern for several classes: `Database`, `Registry`, and controllers (classes regulating communication with the database).

### System Details

Registry in our application is responsible for making reports which are necessary for both patients and hospital staff.

Hospital employees are split into two parts: healthcare employees (doctors, nurses) and management staff (system manager, registry ). Healthcare employees are also split into two departments: adult and child.

### Code Elements

- Simulation of the **database**.
- **Controller classes** for each entity that accesses the database. Controllers provide safe communication between classes and the database. They play the role of data access objects.
- **Frontend classes** showing the operability of the program.

### UML diagram

UML diagram for our system shows all classes, abstract classes, interfaces, and relations within our program, which was implemented in the *Java* programming language.

The diagram can be accessed through the link below:
https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d32e6ce4-616f-4c44-9025-1a43cd68b322/SSAD_PROJECT1.drawio.html?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20211007%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211007T161204Z&X-Amz-Expires=86400&X-Amz-Signature=f2855f268c244f741bb194dda2b8b8b835fb098cf8167d92b43a83b92f8ec3da&X-Amz-SignedHeaders=host
