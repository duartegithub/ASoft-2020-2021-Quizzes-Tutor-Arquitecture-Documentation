[< Back to SAD](SAD.md)

# Quizzes-Tutor - System Overview

**Quizzes-tutor** is an under-development, open-source application, aimed at improving the teaching and learning experience between students and teachers. For a more detailed description, refer to the **Purpose and Scope** section of the [Documentation Roadmap](documentation_roadmap.md#purpose-and-scope).

## Business Goals

The functionalities and quality attribute scenarios that follow were infered from the following business goals:

- **BG1:** The quizzes-tutor supports a course that follows the flipped classroom model relaxing the load on the teaching body while promoting the student's engagement in the course.
- **BG2:** The quizzes-tutor promotes the students learning process and self-assessment of their knowledge.
- **BG3:** The quizzes-tutor is used as a pedagogical tool, such that groups of students can easily use the system in their projects to learn how to develop a web application.

## Functionalities

- **UC1:** Professors should have the possibility to reuse questions between annual/semiannual executions of a course. Relates to **BG1**.
- **UC2:** Professors should be able to evaluate the students using quizzes-tutor. Relates to **BG1**.
- **UC3:** Students should be able to answer quizzes for evaluation and self-assessment. Relates to **BG1** and **BG2**.
- **UC4:** Quizzes-tutor should support engagement functionalities, such as discussions, tournaments, statistics (for gamification) and others. Relates to **BG1**, **BG2** and **BG3** (in the last case, we're looking at the groups of students themselves, as developers, but also as end-users of this particular business goal).

## Quality Attribute Scenarios

### Modifiability

- **MS1:** A developer adds, deletes or modifies types of questions, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modification with small effort and without adding defects to the existing code. Relates to **BG1**.
- **MS2:** A developer adds, deletes or modifies engagement functionalities, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modification with small effort and without adding defects to the existing code. Relates to **BG1**.
- **MS3:** A Software Engineering student understands quizzes-tutor to the point of being able to add, delete or modify an engagement functionality, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modifications within the duration of the project and without adding defects to the existing code. Relates to **BG3**.
- **MS4:** A Software Architectures student understands quizzes-tutor to the point of being able to change a quality attribute, such as improving performance during the process of answering a quiz, requiring change to the code and possibly data, interfaces, components, resources and configurations of quizzes-tutor during design time. The objective is to make, test and deploy the modifications within the duration of the project and without adding defects to the existing code. Relates to **BG3**.
- **MS5:** A Software Engineering student refactors the system in order to decouple the question bank from the curriculum structure of a course. This will require changes to the code and data structures. The objective is to make, test and deploy the modifications within the duration of the project. Relates to **BG1**.

### Availability

This SAD won't be focusing on Availability, but rather on Modifiability. However, it's worth mentioning that the system should be highly available, as it's used by students for formal evaluation. In this context, a myriad of scenarios that differentiate sources and types of stimulus exist, but a single more general scenario is considered here, for simplicity purposes.

- **AS1:** An internal, omission fault (such as a student requesting a quiz and the quiz not appearing; or a question in a quiz being skipped without the student's consent, among others) happens during the normal operation of the system, in particular during the period of evaluation of a student, causing an unfair grade to be registered in the database. The fault must be isolated, preventing it from becoming a failure, and it must be logged to safeguard the student's evaluation. A good measure would be the percentage of evaluation of a course lost during the semester. Relates to **BG2**.

  >Example: In a semester with 10 students, each answering 10 5-question quizzes, each question equates to (100/(10 x 10 x 5)) % = 0,2%. If, over the semester, student A fails to answer one question due to a fault, and the same happens to student B, the amount of lost evaluation during the semester would be of 0,4%.

### Security 

Similarly to the Availability consideration above, Security won't be the main focus of this SAD. However, due to an identified potential vulnerability in the quizzes-tutor demo user functionality, which may hinder the availability of the system, particularly during quizz assessments, the following scenario was written in order to document this issue.

- **SS1:** An attacker (possibly internal to the organization, using demo user credentials) launches a Denial of Service attack (using jmeter scripts or others) at the quizzes-tutor services and/or data consumed by these, reducing the overall availability of the system during normal operation, in particular during the period of evaluation of the students. The attack must be detected and assurances must be put in place to allow the data and system services to be available for legitimate use. A good measure would be the percentage of evaluation of a course lost during the semester. Relates to **BG2**.

## Appendix

- Refer to [QA Formal Scenarios](quality_attribute_formal_scenarios.md) for a formal description of the identified QA scenarios.

- Refer to [Business Goals General Scenarios](business_goals_general_scenarios.md) for a better understanding of the proposed business goals.
