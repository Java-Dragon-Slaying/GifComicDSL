
![image](https://www.pinclipart.com/picdir/big/40-407293_clipart-royalty-free-library-pop-art-comics-book.png)

Welcome to **Gif Comic DSL** (Domain Specific Language) Documentation! You can use our DSL to generate comic panels that contain gifs within them.

* [Creating a Comic](#creating-a-comic)
* [Declaring Images](#declaring-images)
* [Creating a Panel](#creating-a-panel)
* [Adding Images within a Panel](#adding-images-within-a-panel)
* [Moving Images within a Panel](#moving-images-within-a-panel)
* [Removing Images within a Panel](#removing-images-within-a-panel)
* [Supported Conditional Logic](#supported-conditional-logic)
* [Details about Gif Loop](#details-about-gif-loop)
* [DSL Demo](#dsl-demo)
* [Support](#support)
* [Image Library](#image-library)


## Creating a Comic

***Syntax*** <br>
`comic <comic_name>`

***Example***<br>
`comic my_comic`

Every Gif Comic program needs to begin with creating a comic. The syntax is as shown above. *Images cannot be added and panels cannot be created until the comic and its name have been declared*.
  

## Declaring Images 

***Syntax***<br>
`use image <image name from library> as <variable name> ;(semi-colon optional)`

***Example (both are valid)***<br>
`use image tall_guy as bob`

`use image tall_guy as bob;`

Before creating a panel and using an image within it, the *image must be declared outside of the panel first*. This documentation also contains an [Image Library](#image-library) from which the user can find most images they are looking for. Once the user has decided an image from the [Image Library](#image-library), place it after `image` and before `as`, as indicated above in the syntax. Next, the user must decide a name for this generic image before they are able to add this image within a panel. Optionally, a semicolon may be added at the end of the statement for better user readability. 


## Creating a Panel

***Syntax***<br>
`create panel <size> background <variable name of image to use as background>`

Optionally add a text header using `text <text>`

Or add a text header with a specific font size using `text fontsize <fontsize> <text>`

***Examples***<br>
`create panel (100,100) background forest`

`create panel (100,100) background forest text "Good Morning"`

`create panel (100,100) background forest text fontsize 10 "Good Morning"`

To create a panel, size must be provided as an x,y coordinate. The maximum size of a panel is (1000,1000) and the minimum size is (0,0), although a panel of this size isn't very useful. Then, a background must be set using the variable name of an image declared outside of the panel. Optionally, the user may add a text header to the panel. An optional fontsize (an integer between 1 and 30) can also be added, as shown in the syntax and example above. Within a panel, a comma may be added at the end of panel statements if the user intends to add more statements. If a statement is the last statement in a panel, a semi-colon may also be optionally added. The option to use commas and semicolons exists for better readability for users.

## Adding Images within a Panel

***Syntax***<br>
`add <variable name of image> <position> , (comma optional)`

***Example***<br>
`add bob (50,100)`

`add bob (50,100),`

To add an image within a panel, *it must first have been declared outside of the panel (see [Declaring Images](#declaring-images))*. Once declared, the image can be added into the panel using the variable name of the image followed by a position (in x,y coordinates). Position must be within the coordinates of the panel.

## Moving Images within a Panel

***Syntax***<br>
(a) `move`: `move <variable name of image> <position> , (comma optional)` <br>
(b) `jump`: `jump <variable name of image> <position> , (comma optional)` <br>

***Example***<br>
(a) `move`: `move bob (70, 100),` <br>
(b) `jump`: `move alice (10, 40)`<br>

There are 2 types of movements within a panel: `move` and `jump`. `move` mimicks a walking notion and requires the variable name of the image and a position to move/walk it to. `jump` mimicks a quick jumping notion and requires the variable name of the image and a position to jump it to. Each movement statement may optionally end with a comma if more statements within the panel succeed it, or end with a semi-colon if it is the last statement within the panel. *Note that an image cannot be move or jump if it is not first declared outside the panel and then added within the panel.*
-->

## Removing Images within a Panel

***Syntax***<br>
`remove <variable name of image> , (comma optional)`

***Example***<br>
`remove bob`

`remove bob,`

To remove an image from a panel, perhaps after doing some movements with it, follow the syntax above. 


## Supported Conditional Logic

***Syntax***<br>
`<image declaration> AND <image declaration of the same type> AND <more declarations of the same type as needed> ...`

***Examples***<br>
(a) `move bob (20, 10) AND move kate (70, 30),` <br>
(b) `add alice (45, 10) AND add bob (20, 50)` <br>

The conditional logical operator `AND` is supported within, *and only within*, the statements of a panel that are of the same type. Using `AND` between an add and move statement, for example, is invalid. Using `AND` between two adds or between two moves is valid. Using the `AND` operator, multiple images can be added at once or multiple movements can be done at once, instead of each declaration appearing sequentially.

## Details about Gif Loop

Gif looping within the panels is done automatically; the user does not need to explicitly loop each panel. Each panel is a gif, and the set of all panels makes up the comic. 


## DSL Demo

Example Input DSL: <!-- this example input can be modified as needed -->
```
comic my_comic
  use image sky_blue_background as sky;
  use image canada as flag;
  use image snowboarder as jerry;
  create panel (500,500) background flag text fontsize 20 "oh Canada!"
    add jerry (100,200)
    jump jerry (400,200)
```

Output HTML: ![my_comic](https://media.github.students.cs.ubc.ca/user/1538/files/c48fdb80-0cdd-11eb-9fc8-4110ac19b554)

## Support

If you would like any support with our Gif Comic DSL, please contact any of the creators: 
* Alex (<aaack.ubc@gmail.com>)
* Jen (<jyan317@gmail.com>)
* Astro (<astroycz@gmail.com>)
* Abraham (<abrahamwong9704@hotmail.com>)
* Ravina (<ravinakaur@hotmail.com>)

## Image Library

<!-- insert image library enum here, mapping the generic term for the image to the actual image itself, is this possible? -->
microphone: ![mic](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3A4.png) <br>
canada: ![canada](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F1E8-1F1E6.png) <br>
movie_camera: ![die](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3A5.png) <br>
bullseye: ![die](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3AF.png) <br>
eight_ball: ![die](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3B1.png) <br>
die: ![die](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3B2.png) <br>
music_notes_1: ![music1](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3B5.png) <br>
music_notes_2: ![music2](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3B6.png) <br>
basketball: ![bball](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3C0.png) <br>
snowboarder: ![snowboarder](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3C2.png) <br>
runner: ![runner](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3C3.png) <br>
surfer: ![surfer](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3C4.png) <br>
trophy: ![trophy](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3C6.png) <br>
horse_rider: ![horse_rider](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3C7.png) <br>
football: ![football](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3C8.png) <br>
mountain: ![mountain](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3D4.png) <br>
sky_blue_background: ![blue_background](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F3F3-FE0F-200D-1F7E6.png) <br>
champagne: ![champagne](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F37E.png) <br>
shhh: ![shhh](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F92B.png) <br>
angry: ![angry](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F92C.png) <br>
cover_mouth: ![cover_mouth](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F92D.png) <br>
vomit: ![vomit](https://github.students.cs.ubc.ca/cpsc410-2020w-t1/cpsc410_project1_team2/blob/master/images_lib/1F92E.png) <br>
