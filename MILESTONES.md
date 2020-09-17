Add entries to this file summarising each project milestone. Don't forget that these need to have been discussed with your TA before the milestone deadline; also, remember to commit and push them by then!

MILESTONE 1

Project: Gif Comic DSL

BRIEF DESCRIPTION

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

NOTES OF ANY IMPORTANT CHANGES/FEEDBACK FROM TA DISCUSSION

  TA suggests that this idea has less of a “form” format than all our other ideas and would be easier to extend for user creativity. He also mentioned that having a well defined use case / user group would help in the further development of the DSL.

ANY PLANNED FOLLOW-UP TASKS OR FEATURES STILL TO DESIGN

  Nothing as of right now, just the next milestone
