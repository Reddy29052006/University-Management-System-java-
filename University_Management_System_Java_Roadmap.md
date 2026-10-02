# University Management System --- Core Java Project Blueprint

**Project type:** Modular, console-based application\
**Language:** Core Java (Java 17+)\
**Persistence:** Local file system\
**UI:** Console only\
**Build:** Start with plain Java; Maven may be introduced later\
**Testing:** JUnit 5 in the testing phase\
**Architecture:** Feature-oriented packages with clear layers and
dependency inversion

------------------------------------------------------------------------

## 1. Project purpose

Build a University Management System that provides student, teacher,
course, examination, attendance, fee, and reporting features.

The project is intentionally designed to teach Java through a real
application. It should demonstrate classes, objects, encapsulation,
inheritance, abstract classes, interfaces, overloading, overriding,
polymorphism, `static`, `final`, packages, access modifiers, exceptions,
collections, generics, file I/O, date/time, lambdas, streams, and
testing.

The design goals are:

1.  **Reusable:** avoid copying the same logic into multiple modules.
2.  **Maintainable:** keep each class focused and keep module boundaries
    clear.
3.  **Refactorable:** allow internal implementations to change without
    changing the application's behavior.
4.  **Understandable:** introduce complexity gradually; do not create
    abstractions before there is a real need.
5.  **Testable:** business rules should be testable without reading from
    the console or depending on real files.

This is a learning project, so prefer clear code over clever code.

------------------------------------------------------------------------

## 2. Scope and non-goals

### Included initially

-   Console menus and input
-   Student and teacher records
-   Courses and enrollments
-   Examinations and marks
-   Attendance
-   Fee records and receipts
-   Reports
-   Local file persistence
-   Validation and meaningful errors
-   Automated tests once the core behavior exists

### Not included initially

-   GUI, web interface, or mobile application
-   Spring Boot or other application frameworks
-   A database server
-   Real payment gateway integration
-   Authentication and authorization
-   Network communication

A simulated payment method is for learning only. It must not collect
real card or bank credentials.

------------------------------------------------------------------------

## 3. Complete target folder structure

The structure below is the **target structure**, not a requirement to
create every file on day one. Each phase tells you which files to add.
Keep the package names lowercase.

``` text
university-management-system/
├── README.md
├── .gitignore
├── docs/
│   ├── architecture.md
│   ├── design-decisions.md
│   └── user-guide.md
├── data/
│   ├── .gitkeep
│   ├── students/
│   ├── teachers/
│   ├── courses/
│   ├── enrollments/
│   ├── examinations/
│   ├── attendance/
│   └── payments/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── university/
│   │               ├── app/
│   │               │   ├── Main.java
│   │               │   ├── Application.java
│   │               │   └── ApplicationFactory.java
│   │               ├── common/
│   │               │   ├── domain/
│   │               │   │   ├── Person.java
│   │               │   │   ├── Identifiable.java
│   │               │   │   └── Printable.java
│   │               │   ├── exception/
│   │               │   │   ├── ValidationException.java
│   │               │   │   ├── NotFoundException.java
│   │               │   │   └── DuplicateRecordException.java
│   │               │   └── util/
│   │               │       ├── InputReader.java
│   │               │       └── FileSupport.java
│   │               ├── student/
│   │               │   ├── domain/
│   │               │   │   ├── Student.java
│   │               │   │   ├── GraduateStudent.java
│   │               │   │   └── StudentStatus.java
│   │               │   ├── application/
│   │               │   │   ├── StudentService.java
│   │               │   │   └── StudentValidator.java
│   │               │   ├── repository/
│   │               │   │   └── StudentRepository.java
│   │               │   └── infrastructure/
│   │               │       ├── InMemoryStudentRepository.java
│   │               │       └── FileStudentRepository.java
│   │               ├── teacher/
│   │               │   ├── domain/
│   │               │   │   └── Teacher.java
│   │               │   ├── application/
│   │               │   │   └── TeacherService.java
│   │               │   ├── repository/
│   │               │   │   └── TeacherRepository.java
│   │               │   └── infrastructure/
│   │               │       ├── InMemoryTeacherRepository.java
│   │               │       └── FileTeacherRepository.java
│   │               ├── course/
│   │               │   ├── domain/
│   │               │   │   ├── Course.java
│   │               │   │   └── Enrollment.java
│   │               │   ├── application/
│   │               │   │   └── CourseService.java
│   │               │   ├── repository/
│   │               │   │   └── CourseRepository.java
│   │               │   └── infrastructure/
│   │               │       ├── InMemoryCourseRepository.java
│   │               │       └── FileCourseRepository.java
│   │               ├── examination/
│   │               │   ├── domain/
│   │               │   │   ├── Examination.java
│   │               │   │   ├── ExamResult.java
│   │               │   │   └── Grade.java
│   │               │   ├── application/
│   │               │   │   ├── ExaminationService.java
│   │               │   │   └── GradeCalculator.java
│   │               │   ├── repository/
│   │               │   └── infrastructure/
│   │               ├── attendance/
│   │               │   ├── domain/
│   │               │   │   ├── AttendanceRecord.java
│   │               │   │   └── AttendanceStatus.java
│   │               │   ├── application/
│   │               │   │   └── AttendanceService.java
│   │               │   ├── repository/
│   │               │   └── infrastructure/
│   │               ├── payment/
│   │               │   ├── domain/
│   │               │   │   ├── Payment.java
│   │               │   │   └── PaymentStatus.java
│   │               │   ├── application/
│   │               │   │   └── PaymentService.java
│   │               │   ├── strategy/
│   │               │   │   ├── PaymentProcessor.java
│   │               │   │   ├── CashPaymentProcessor.java
│   │               │   │   └── SimulatedOnlinePaymentProcessor.java
│   │               │   ├── repository/
│   │               │   └── infrastructure/
│   │               ├── reporting/
│   │               │   ├── ReportService.java
│   │               │   └── ReportFormatter.java
│   │               └── console/
│   │                   ├── MainMenu.java
│   │                   ├── StudentMenu.java
│   │                   ├── TeacherMenu.java
│   │                   ├── CourseMenu.java
│   │                   ├── ExaminationMenu.java
│   │                   ├── AttendanceMenu.java
│   │                   └── PaymentMenu.java
│   └── test/
│       └── java/
│           └── com/
│               └── university/
│                   ├── student/
│                   ├── course/
│                   ├── examination/
│                   ├── attendance/
│                   └── payment/
└── pom.xml                 (add in the Maven phase; optional before then)
```

### Structure rules

-   `domain`: business objects and rules; no `Scanner`, console
    printing, or file access.
-   `application`: use-case coordination, such as registering a student.
-   `repository`: interfaces describing data operations.
-   `infrastructure`: concrete file or in-memory storage
    implementations.
-   `console`: reads user input and displays output; it calls
    application services.
-   `app`: creates and connects objects and starts the application.
-   `common`: only genuinely shared code. Do not turn it into a dumping
    ground.
-   `data`: runtime data. Do not store Java source files here.
-   `test`: tests mirror the production package layout.

Keep dependencies pointing inward: console may call application
services; services may use domain types and repository interfaces.
Domain classes must not depend on console or file-storage classes.

------------------------------------------------------------------------

## 4. Important design decisions

### 4.1 Prefer composition for "has-a" relationships

A course has enrollments; a payment belongs to a student; an examination
has results. These are usually modeled with fields or IDs, not by making
one class inherit from another.

### 4.2 Use inheritance only for a genuine "is-a" relationship

`Student` and `Teacher` can extend `Person` because both are people. Do
not make `Course` extend `Student`, for example.

### 4.3 Keep business logic out of menus

A menu should collect values and call a service. It should not contain
all registration, grading, or payment rules.

### 4.4 Depend on interfaces at replaceable boundaries

A service should depend on `StudentRepository`, not directly on
`FileStudentRepository`. This lets the implementation change from memory
to files without rewriting the service.

### 4.5 Avoid premature generic frameworks

Start with a clear `StudentRepository`. After you have multiple
repositories and understand the repeated behavior, decide whether a
generic repository is actually useful. Do not force every class into a
shared abstraction.

### 4.6 File format

Start with a simple, documented record format. A delimiter-based format
must handle delimiters and newlines in user data; do not assume names or
text can never contain commas. A later phase can introduce escaping or a
safer format. Always write files using UTF-8.

### 4.7 IDs

Use stable IDs. Do not use a list index as an ID because deleting or
sorting records changes indexes. The ID generator must avoid collisions
with records already loaded from disk.

### 4.8 Error handling

Use validation errors for invalid user input, not-found errors for
missing records, and I/O errors for storage failures. Do not silently
ignore failed writes.

------------------------------------------------------------------------

# 5. Step-by-step implementation plan

Each step lists the files to create or modify, what to implement,
concepts covered, and a completion check. Follow the order. Do not
create later-phase files early unless needed.

## Phase 0 --- Workspace and project skeleton

**Goal:** Create a Java program that compiles and starts.

### Files

Create: - `src/main/java/com/university/app/Main.java` - `.gitignore` -
`README.md`

### Work

1.  Confirm Java 17+ is installed (`java -version` and
    `javac -version`).
2.  Create the folder structure only through `app` for now.
3.  Write `Main` with `public static void main(String[] args)`.
4.  Print the application title and a temporary message.
5.  Compile and run from the terminal.
6.  Initialize Git if you are using version control.

### Concepts

JDK, source files, packages, `main`, compilation, classpath basics.

### Completion check

The program compiles and runs from a clean terminal. README contains
project purpose and how to run it.

------------------------------------------------------------------------

## Phase 1 --- Console shell

**Goal:** Make a reliable menu loop before adding business features.

### Files

Create: - `console/MainMenu.java` - `common/util/InputReader.java` -
Modify `app/Main.java`

### Work

1.  Display the main menu with options for each module.
2.  Read a choice.
3.  Keep showing the menu until Exit is selected.
4.  Handle non-numeric input without crashing.
5.  Use one shared input reader rather than creating multiple `Scanner`
    objects over `System.in`.
6.  For now, each menu option can print "Not implemented yet."
7.  Keep input parsing separate from menu rendering where practical.

### Concepts

Loops, `switch`, methods, `Scanner`, input validation, `static` entry
point.

### Completion check

Letters, blank input, and out-of-range choices do not crash the app.
Exit works.

### Refactor checkpoint

Remove repeated input-reading code. Keep the menu thin; it should not
contain business rules.

------------------------------------------------------------------------

## Phase 2 --- Domain foundation and encapsulation

**Goal:** Model people and validate their basic state.

### Files

Create: - `common/domain/Person.java` -
`common/domain/Identifiable.java` - `student/domain/Student.java` -
`teacher/domain/Teacher.java`

### Work

1.  Define the common person fields: ID, name, age, and email.
2.  Keep fields private.
3.  Validate required values at construction or through explicit
    methods.
4.  Add getters; add setters only when changing a value is a valid
    domain operation.
5.  Create `Student` with department and semester.
6.  Create `Teacher` with department and subject.
7.  Add a readable `toString()` for debugging; do not rely on it as a
    permanent file format.
8.  Add small temporary object-creation checks in `Main` or a temporary
    test class, then remove the temporary code.

### Concepts

Classes, objects, constructors, encapsulation, access modifiers, `this`,
`toString`.

### Completion check

Valid objects can be created. Invalid values are rejected consistently.
Fields cannot be changed directly from outside.

### Refactor checkpoint

Compare `Student` and `Teacher`. Shared person data belongs in `Person`;
student-only data stays in `Student`.

------------------------------------------------------------------------

## Phase 3 --- Inheritance, abstract classes, overriding, and polymorphism

**Goal:** Learn inheritance in a meaningful model.

### Files

Create/modify: - `common/domain/Person.java` -
`student/domain/Student.java` - `student/domain/GraduateStudent.java` -
`teacher/domain/Teacher.java`

### Work

1.  Make `Person` abstract if the application should never create a
    generic person.
2.  Add an abstract `displayRole()` or equivalent behavior only if all
    subclasses meaningfully implement it.
3.  Have `Student` and `Teacher` extend `Person`.
4.  Call the parent constructor with `super(...)`.
5.  Override the abstract method in each subclass.
6.  Add `GraduateStudent extends Student` to demonstrate multilevel
    inheritance, with a genuinely graduate-specific field such as thesis
    topic.
7.  Demonstrate a `List<Person>` containing students and teachers and
    call the overridden method.
8.  Demonstrate method overloading with distinct parameter lists; do not
    confuse overloading with changing only the return type.

### Concepts

Abstract class/method, single/hierarchical/multilevel inheritance,
`extends`, `super`, overriding, overloading, runtime polymorphism,
dynamic dispatch, `@Override`.

### Completion check

A collection of `Person` references can contain `Student` and `Teacher`
objects, and the correct overridden behavior runs for each object.

### Refactor checkpoint

Do not add methods to `Person` merely to make the inheritance diagram
larger. Keep only truly shared behavior there.

------------------------------------------------------------------------

## Phase 4 --- First service and repository boundary (in memory)

**Goal:** Separate the use case from data storage before adding files.

### Files

Create: - `student/repository/StudentRepository.java` -
`student/infrastructure/InMemoryStudentRepository.java` -
`student/application/StudentService.java` -
`common/exception/NotFoundException.java` -
`common/exception/DuplicateRecordException.java` -
`common/exception/ValidationException.java`

### Work

1.  Define repository operations: save, find by ID, find all, update,
    and delete. Choose return types deliberately (for example,
    `Optional<Student>` for a possibly missing lookup).
2.  Implement the interface with a `Map<Integer, Student>`.
3.  Keep storage details inside the repository.
4.  Implement service operations for registration, lookup, update, and
    deletion.
5.  Check duplicate IDs in the appropriate business flow.
6.  Inject the repository through the service constructor.
7.  Keep the service independent of `Scanner` and `System.out`.
8.  Decide whether exceptions are checked or unchecked and use the
    choice consistently.

### Concepts

Interfaces, implementation, collections, `Map`, generics, `Optional`,
dependency injection, exceptions, separation of concerns.

### Completion check

Student operations work using in-memory storage. The service can be
tested without console input or files.

### Refactor checkpoint

The service should not instantiate its own repository. The application
composition layer will supply it.

------------------------------------------------------------------------

## Phase 5 --- Student console module

**Goal:** Connect the menu to the student use cases.

### Files

Create: - `console/StudentMenu.java` - Modify `console/MainMenu.java` -
Modify `app/Main.java`

### Work

1.  Add student submenu options: register, update, delete, search, list,
    back.
2.  Read values in the menu.
3.  Call `StudentService` for operations.
4.  Display success, not-found, and validation messages.
5.  Keep formatting and prompts in the console layer.
6.  Do not catch every possible exception with one broad catch. Handle
    expected errors clearly; report unexpected failures without hiding
    them.
7.  Add a confirmation prompt before deletion.

### Concepts

Layering, method calls, `switch`, input/output, exception handling,
dependency injection.

### Completion check

A user can perform all student operations during one run. Restarting
still loses records at this stage; that is expected.

### Refactor checkpoint

If the menu contains rules such as duplicate-ID checking or grade
calculation, move them into the appropriate service/domain component.

------------------------------------------------------------------------

## Phase 6 --- File persistence

**Goal:** Keep student data between application runs.

### Files

Create: - `student/infrastructure/FileStudentRepository.java` -
`common/util/FileSupport.java` - Runtime file:
`data/students/students.csv` - Modify `app/ApplicationFactory.java`
(create it now) - Modify `app/Main.java`

### Work

1.  Choose and document a record format.
2.  Use `Path` and `Files` with UTF-8.
3.  Create the data directory/file when needed.
4.  Implement reading and writing in `FileStudentRepository`.
5.  Load records at startup or read them on demand; choose one strategy
    and document it.
6.  Implement save, update, delete, and find operations.
7.  Ensure updates do not accidentally erase unrelated records.
8.  Handle malformed records and report which record failed. Decide
    whether startup should stop or continue with a clear warning.
9.  Write safely: avoid leaving a half-written file if possible (write a
    temporary file, then replace the original).
10. Keep file parsing and serialization inside the infrastructure layer.
11. Configure the app to inject `FileStudentRepository` into
    `StudentService`.
12. Test persistence by registering a student, exiting, restarting, and
    searching for that student.

### Concepts

`Path`, `Files`, `IOException`, UTF-8, try-with-resources, repository
substitution, parsing, file persistence.

### Completion check

Student records survive restart. The service and console code do not
need to know the data is stored in a file.

### Refactor checkpoint

Switch between in-memory and file repositories by changing application
wiring, not service logic.

------------------------------------------------------------------------

## Phase 7 --- Teacher module

**Goal:** Repeat the proven pattern without copying the student module
blindly.

### Files

Create: - `teacher/repository/TeacherRepository.java` -
`teacher/infrastructure/InMemoryTeacherRepository.java` -
`teacher/infrastructure/FileTeacherRepository.java` -
`teacher/application/TeacherService.java` - `console/TeacherMenu.java` -
Runtime file: `data/teachers/teachers.csv` - Modify `MainMenu.java`,
`ApplicationFactory.java`

### Work

1.  Define teacher repository operations.
2.  Implement in-memory storage first.
3.  Implement teacher registration, update, delete, search, and list.
4.  Add validation for teacher-specific fields.
5.  Add the console submenu.
6.  Add file persistence and restart testing.
7.  Reuse common person validation only where the rules are truly the
    same.

### Concepts

Interfaces, encapsulation, inheritance, file I/O, reusable patterns,
package boundaries.

### Completion check

Teacher operations work and data persists after restart.

### Refactor checkpoint

Compare student and teacher repositories. Extract shared infrastructure
only if it reduces real duplication without making the design harder to
understand.

------------------------------------------------------------------------

## Phase 8 --- Course and enrollment module

**Goal:** Model relationships between entities.

### Files

Create: - `course/domain/Course.java` -
`course/domain/Enrollment.java` -
`course/repository/CourseRepository.java` -
`course/infrastructure/InMemoryCourseRepository.java` -
`course/infrastructure/FileCourseRepository.java` -
`course/application/CourseService.java` - `console/CourseMenu.java` -
Runtime files under `data/courses/` and `data/enrollments/`

### Work

1.  Define a course ID, title, department, and capacity.
2.  Represent enrollment explicitly, with student ID, course ID, and
    enrollment date.
3.  Implement create, update, search, and list course operations.
4.  Implement enroll and withdraw operations.
5.  Validate that the student and course exist.
6.  Prevent duplicate enrollment.
7.  Enforce course capacity.
8.  Decide what happens when a course or student is deleted if
    enrollments exist; document the rule.
9.  Persist courses and enrollments.
10. Add console menus and tests.

### Concepts

Association, composition/aggregation modeling, collections, `LocalDate`,
validation, service coordination, file persistence.

### Completion check

Students can enroll in courses, duplicate enrollment is rejected, and
enrollment data persists.

### Refactor checkpoint

Avoid storing full copies of student objects inside course records
unless there is a clear reason. Stable IDs help avoid duplicated and
stale data.

------------------------------------------------------------------------

## Phase 9 --- Examination and grading

**Goal:** Separate examination records from grading policy.

### Files

Create: - `examination/domain/Examination.java` -
`examination/domain/ExamResult.java` - `examination/domain/Grade.java` -
`examination/application/GradeCalculator.java` -
`examination/application/ExaminationService.java` - Appropriate
repository interface and file implementation -
`console/ExaminationMenu.java` - Runtime files under
`data/examinations/`

### Work

1.  Create an examination associated with a course.
2.  Define maximum marks and exam date.
3.  Record a result for a student.
4.  Validate that marks are within the allowed range.
5.  Implement a grading policy.
6.  Keep grading rules outside the console menu.
7.  Allow a different grading policy to be supplied through an interface
    if needed.
8.  Retrieve a student's result and course results.
9.  Persist examinations and results.
10. Test boundary marks, invalid marks, and missing records.

### Concepts

Interfaces, strategy pattern, polymorphism, enums, date/time,
validation, persistence.

### Completion check

Results can be recorded, validated, retrieved, and retained after
restart.

### Refactor checkpoint

Changing grade boundaries should not require rewriting the console menu
or repository.

------------------------------------------------------------------------

## Phase 10 --- Attendance

**Goal:** Track attendance with clear rules and dates.

### Files

Create: - `attendance/domain/AttendanceRecord.java` -
`attendance/domain/AttendanceStatus.java` -
`attendance/application/AttendanceService.java` - Attendance repository
interface and implementation - `console/AttendanceMenu.java` - Runtime
files under `data/attendance/`

### Work

1.  Define attendance statuses such as PRESENT, ABSENT, and LATE if
    needed.
2.  Record student, course, and date.
3.  Prevent duplicate records for the same student/course/date unless an
    explicit edit operation is used.
4.  Calculate attendance percentage.
5.  Display attendance history.
6.  Generate a course attendance summary.
7.  Persist records.
8.  Test date boundaries and percentage calculations.

### Concepts

Enums, `LocalDate`, collections, service rules, file I/O, calculations.

### Completion check

Attendance can be recorded and summarized consistently after application
restarts.

### Refactor checkpoint

Keep percentage calculation in a domain/service component, not in the
menu.

------------------------------------------------------------------------

## Phase 11 --- Fees and payments

**Goal:** Track charges and payments without integrating a real payment
provider.

### Files

Create: - `payment/domain/Payment.java` -
`payment/domain/PaymentStatus.java` -
`payment/strategy/PaymentProcessor.java` -
`payment/strategy/CashPaymentProcessor.java` -
`payment/strategy/SimulatedOnlinePaymentProcessor.java` -
`payment/application/PaymentService.java` - Payment repository interface
and file implementation - `console/PaymentMenu.java` - Runtime files
under `data/payments/`

### Work

1.  Define payment ID, student ID, amount, date, and status.
2.  Define a payment processor interface.
3.  Implement cash and simulated online processors.
4.  Use polymorphism to select a processor.
5.  Validate positive amounts and valid student IDs.
6.  Record successful and failed simulated payments.
7.  Calculate total paid and outstanding fees.
8.  Generate a receipt with a unique payment ID.
9.  Persist payment history.
10. Test calculations and failure cases.

### Concepts

Interfaces, strategy pattern, polymorphism, enums, `BigDecimal` for
money, exceptions, file persistence.

### Completion check

Payment records and balances are consistent after restart. No real
payment credentials are requested or stored.

### Refactor checkpoint

Adding a new simulated payment processor should not require rewriting
the fee calculation logic.

------------------------------------------------------------------------

## Phase 12 --- Reports and advanced Java

**Goal:** Add reusable reports and apply selected advanced language
features.

### Files

Create: - `reporting/ReportService.java` -
`reporting/ReportFormatter.java` - Modify relevant menus

### Work

1.  Generate student lists and course rosters.
2.  Generate exam-result summaries and attendance reports.
3.  Generate fee summaries.
4.  Use streams for suitable filtering, grouping, and aggregation.
5.  Use lambdas for sorting and predicates.
6.  Use `Optional` for potentially missing lookups where it improves
    clarity.
7.  Use `StringBuilder` for multi-line report formatting.
8.  Use `java.time` for dates.
9.  Consider a background report task only if reports are sufficiently
    large to justify threading.
10. Keep reports independent of console prompts.

### Concepts

Streams, lambdas, method references, `Optional`, `StringBuilder`,
date/time, and optionally `ExecutorService`.

### Completion check

Reports are generated from services/repositories and can be displayed in
the console. The report logic can be tested separately from printing.

### Refactor checkpoint

Avoid using streams just to appear advanced. Use a normal loop when it
is clearer.

------------------------------------------------------------------------

## Phase 13 --- Tests, hardening, and final refactor

**Goal:** Make the application safe to change and easier to maintain.

### Files

Add test files that mirror production packages, for example: -
`src/test/java/com/university/student/StudentServiceTest.java` -
`src/test/java/com/university/student/FileStudentRepositoryTest.java` -
`src/test/java/com/university/course/CourseServiceTest.java` -
`src/test/java/com/university/examination/ExaminationServiceTest.java` -
`src/test/java/com/university/attendance/AttendanceServiceTest.java` -
`src/test/java/com/university/payment/PaymentServiceTest.java`

Add `pom.xml` when introducing JUnit 5.

### Work

1.  Test domain validation.
2.  Test service success and failure cases.
3.  Test duplicate and missing records.
4.  Test file persistence using temporary directories.
5.  Test that a failed write is not reported as a successful operation.
6.  Test enrollment and payment calculations.
7.  Review every class for too many responsibilities.
8.  Remove dead code and unused methods.
9.  Reduce duplicated logic where a simple shared component is
    justified.
10. Review package dependencies.
11. Update README and user guide.
12. Run the full test suite after each significant refactor.

### Concepts

JUnit, unit tests, integration tests, test doubles, dependency
injection, SOLID, refactoring, clean code.

### Completion check

The full application runs from the console, data persists, core rules
have tests, and the README explains how to build and use it.

------------------------------------------------------------------------

# 6. Java concept coverage checklist

Use this checklist to track your learning. Mark a concept complete only
after you have implemented it and can explain it.

  -----------------------------------------------------------------------
  Concept                 Planned location        Status
  ----------------------- ----------------------- -----------------------
  Classes and objects     Domain models           \[ \]

  Fields and methods      Domain models           \[ \]

  Constructors            Person and domain       \[ \]
                          models                  

  Constructor overloading Domain models           \[ \]

  Encapsulation           Student, Teacher,       \[ \]
                          Payment                 

  `this`                  Constructors and        \[ \]
                          instance methods        

  `super`                 Student/Teacher         \[ \]
                          constructors            

  Single inheritance      Student extends Person  \[ \]

  Hierarchical            Student and Teacher     \[ \]
  inheritance             extend Person           

  Multilevel inheritance  GraduateStudent extends \[ \]
                          Student                 

  Abstract class          Person                  \[ \]

  Abstract method         Person behavior         \[ \]

  Interface               Repository and          \[ \]
                          processor contracts     

  Multiple interface      A class implementing    \[ \]
  implementation          focused interfaces      

  Method overloading      Registration/use-case   \[ \]
                          APIs                    

  Method overriding       Person subclasses and   \[ \]
                          strategies              

  Compile-time            Overloaded methods      \[ \]
  polymorphism                                    

  Runtime polymorphism    Parent/interface        \[ \]
                          references              

  Dynamic binding         Overridden method calls \[ \]

  `final` variable        Fixed                   \[ \]
                          limits/configuration    

  `final` method          Only where extension    \[ \]
                          must be prohibited      

  `final` class           Only for a genuinely    \[ \]
                          closed utility/value    
                          type                    

  `static` field/method   ID or utility behavior  \[ \]
                          where appropriate       

  Access modifiers        All packages            \[ \]

  Packages and imports    Whole application       \[ \]

  Exceptions              Validation and          \[ \]
                          persistence             

  Custom exceptions       Common exception        \[ \]
                          package                 

  Arrays                  Early practice or       \[ \]
                          fixed-size examples     

  Collections             Repositories and        \[ \]
                          reports                 

  Generics                Repository contracts    \[ \]

  `List`, `Map`, `Set`    Storage and uniqueness  \[ \]

  Enum                    Status types            \[ \]

  File I/O                File repositories       \[ \]

  Try-with-resources      File operations         \[ \]

  Serialization concepts  Optional learning       \[ \]
                          extension; not required 
                          for CSV storage         

  Date and Time API       Enrollment, exam,       \[ \]
                          attendance, payment     
                          dates                   

  Lambda expressions      Sorting/filtering       \[ \]

  Streams API             Reports                 \[ \]

  `Optional`              Repository lookup       \[ \]

  `StringBuilder`         Report formatting       \[ \]

  Multithreading          Optional background     \[ \]
                          reports                 

  Unit testing            Service/domain tests    \[ \]

  Refactoring             Every phase             \[ \]

  SOLID                   Service/repository      \[ \]
                          boundaries              
  -----------------------------------------------------------------------

**Important:** Some concepts are alternatives rather than things that
must all be used in production code. For example, CSV file storage does
not require Java object serialization. Learn serialization separately if
you want to cover it, but don't add it without a reason.

------------------------------------------------------------------------

# 7. Definition of done for each feature

Before considering a feature complete, verify:

-   [ ] The feature works from the console.
-   [ ] Input is validated.
-   [ ] Invalid operations produce understandable errors.
-   [ ] Business logic is outside the console menu.
-   [ ] Storage logic is outside the domain model and service.
-   [ ] The service depends on an interface where storage is
    replaceable.
-   [ ] The code does not duplicate existing logic unnecessarily.
-   [ ] The feature has been manually tested.
-   [ ] Automated tests exist once the testing phase is reached.
-   [ ] The README or design journal is updated if the design changed.

------------------------------------------------------------------------

# 8. Suggested Git workflow

Use Git to keep each milestone safe.

Example commit sequence:

``` text
chore: create Java project skeleton
feat: add console main menu
feat: add person and student domain models
feat: introduce person inheritance
feat: add student repository interface
feat: implement in-memory student repository
feat: add student service
feat: add student console operations
feat: add file-based student persistence
refactor: separate student validation
test: add student service tests
```

Commit after each working milestone. Before a large refactor, make sure
you have a clean commit so you can compare or revert safely.

------------------------------------------------------------------------

# 9. Final acceptance checklist

The project is complete when:

-   [ ] It starts from a console entry point.
-   [ ] All modules can be navigated from the main menu.
-   [ ] Students and teachers can be managed.
-   [ ] Courses and enrollments work.
-   [ ] Examinations and results work.
-   [ ] Attendance can be recorded and summarized.
-   [ ] Payments can be recorded and summarized.
-   [ ] Records persist in local files.
-   [ ] Invalid input and missing records are handled.
-   [ ] Services are independent of console input/output.
-   [ ] Storage can be swapped behind repository interfaces.
-   [ ] The main business rules have automated tests.
-   [ ] Code has been refactored without changing expected behavior.
-   [ ] The README explains setup, execution, features, and storage
    format.

------------------------------------------------------------------------

# 10. How to work through this plan

Work on **one phase at a time**. For each phase:

1.  Read the goal and file list.
2.  Create only the files required for that phase.
3.  Implement the smallest working version.
4.  Compile and run it.
5.  Test normal and invalid cases.
6.  Explain the design in your own words.
7.  Refactor only after the behavior works.
8.  Commit the completed milestone.

Do not try to write the entire project in one sitting or generate all
classes at once. The value of this project is in understanding how the
pieces fit together.

**First task:** Complete Phase 0 and Phase 1. Once the console shell
works, start modeling `Person`, `Student`, and `Teacher`. This gives you
a stable foundation for the rest of the application.
