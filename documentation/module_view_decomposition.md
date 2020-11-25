# Module View: Decomposition View

## Primary Presentation

<img src="pictures/Decomposition View.png" width="600" >


Fig 1. Decomposition View graphic representation. Modules in white are strictly part of the business logic. Modules in grey are not part of the business logic.

## Element Catalog

### <span style="color:#0080ff">quizzes-tutor</span>
 This module equates to the whole of quizzes-tutor. The functionalities it provides include:
- Users (students and teachers) may submit multiple choice questions based on topics and create quizzes based on the existing questions in the system;
- Multiple courses are supported, a course can have distinct executions over the years, with reuse of questions;
- Teachers can approve or vet question submissions;
- Teachers can create topics;
- Students may answer quizzes;
- Discussions between users can be created and carried for each quizz question;
- Tournaments between students can be organized. These tournaments may be password restricted;
- Student are allowed to view their current stats.

### <span style="color:#0080ff">answer</span>
This module contains the business logic related to the answer to a question

### <span style="color:#0080ff">auth</span>
This module provides the means to authenticate a user into the system using token-based authentication. 

### <span style="color:#0080ff">course</span>
This module contains the business logic related to a course. A distinction is done between a Cource and a CourceExecution, since a course can be executed multiple times over the years, and with different students, but the same questions.

### <span style="color:#0080ff">discussion</span>
This module contains the business logic related to the discussions functionality and management of replies.

### <span style="color:#0080ff">question</span>
This module contains the business logic related to questions and topics. A Topic has a set of Questions and a Question has a Topic.

### <span style="color:#0080ff">questionsubmission</span>
This module contains the business logic related to question submissions and posterior review/vetting of such submissions.

### <span style="color:#0080ff">quiz</span>
This module contains the business logic related to quizzes, including the ordering of the questions, among others.

### <span style="color:#0080ff">statement</span>
This module contains services to handle the data colected in the various stages of a student answering the quiz, including the start of the quiz, when there's a click in a multiple choice answer, or the quiz is completed.
*This module is deprecated so, in the future it will disappear and all data is to be handled directly by other elements of the domain.*

### <span style="color:#0080ff">statistics</span>
This module doesn't have persistent content and is simply used to present data.

### <span style="color:#0080ff">tournament</span>
This module contains the business logic related with the tournaments functionality.

### <span style="color:#0080ff">user</span>
This module contains the business logic related with a user. In particular, it contains the god class User.
*In the future, to migrate quizzes-tutor into a microservices architecture, this module may be turned into an event published publishing events to all the other modules. In turn the other modules would have a specific partition of the original user module, relevant in that context, that would adapt to the changed brought by the events.*


## Context Diagram

## Rationale

## Related Views