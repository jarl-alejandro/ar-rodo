# ArTodo

### Abstract
This is project aims to allow users create tasks and organize
them by categories that could be created.

### Goal/Objectives
This project implemented to put into practice the concepts of
clean architecture (ports and adapter) and domain events.

##### Stakeholders
- Project owner: Alejandro Rivas.
- Open-source community: anyone interested in using this software for learning purposes or those allowed by MIT License.

### Supported use-cases
- The api will allow users to register and login.
- Users will be able to create, edit, view categories and delete categories
  (when deleting the category all tasks will be deleted)
- Users will be able to create, edit, view tasks and delete task
- When creating a task, the counter of how many tasks a category has should be increased.
- You can mark a task as complete (Doing this will update the counter of completed tasks
  in the category).

### Out of scope
- Send any kind of notifications
- Create a user interface
- Deploy the api to production
- Create task or categories in real time

### Proposal
#### Architecture 
The app is implementing with "ports and adapter" architecture so that ut is scalable
to integrate new functionalities