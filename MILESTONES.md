Add entries to this file summarising each project milestone. Don't forget that these need to have been discussed with your TA before the milestone deadline; also, remember to commit and push them by then!

# MILESTONE 4

## Status of implementation
Completed issues:
* [Milestone 2](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/15)
* [UI Implementation Discussion](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/14)
* [First User Study](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/9)
* [General Framework of Project](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/7)
* [Tokenizer](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/5)
* [Sprint Planning Session 1](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/4)
* [EBNF](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/3)
* [Brainstorm Functionality](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/2)

      

## Plans for final user study
Each group member will conduct their own user study and then mid-next week we will have a meeting to share our ideas.

## Planned timeline for the remaining days
To be completed by October 12: 
* [Parser](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/6)
* [Validator](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/10)
* [Animator](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/18)
* [Renderer](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/17)
      
To be completed by October 16: 
* [Final User Study](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/13)
* [Video](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/11)

# MILESTONE 3
- Notes from the first user study and design changes are in "User Study 1.txt"
- EBNF and sample input are in "EBNF.txt"

# MILESTONE 2
## Roadmap
linked here: https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues/15

## Assignment of tasks 
attached to each issue, as listed here: https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues

## Summary of Progress:
### COMPLETED:
- we have defined a general idea of what our DSL will do and what it will look like
- we've laid out a roadmap as linked above and divided our current tasks
### IN PROGRESS:
- we are each running a first user study and will compile the 5 sets of feedback after Mon Sept 28
- we are finishing the design of our EBNF (meeting Fri Sept 25)
- we are collecting clip art to use in the gifs
- we're building the file structure for our code base (we have a main class and will add more components after the user study)
### TODO:
- see open issues here: https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/issues


# MILESTONE 1

## Project: Gif Comic DSL

## BRIEF DESCRIPTION

1. Users can choose from a Library of images to refer to as objects (primitive constants?)

      (a) Users can then assign positions, movements or switch of images to the object
      
      (b) Users can define the time frame of the loop
      
      (c) Add user ability to add their own library of images to use (future implementation)
      
2. Language assigns movements (x y axis), position (coordinates), speed (fps), size (ratio). Order of hierarchy is as follows:

        Container (comic book panel)
          Frame (still images for reference)
            Image 
              Source image
              Position
              Size
            TextBox /speech bubble
              Textinput
              Size
              Fonts
              Position based off Image
          Transition (how images move from 1 frame to another)
            Movement (walk, run, jump, fade, etc)
            Source object (Image or TextBox)

3. Each frame is a GIF from top to bottom (in the code)

Use Case: Digital gif comic book creation to tell a story/create art

User Group: General population (whoever wishes to create a gif comic)

## NOTES OF ANY IMPORTANT CHANGES/FEEDBACK FROM TA DISCUSSION

  TA suggests that this idea has less of a “form” format than all our other ideas and would be easier to extend for user creativity. He also mentioned that having a well defined use case / user group would help in the further development of the DSL.

## ANY PLANNED FOLLOW-UP TASKS OR FEATURES STILL TO DESIGN

  Nothing as of right now, just the next milestone
