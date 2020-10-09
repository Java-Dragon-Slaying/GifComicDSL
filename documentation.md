
![image](https://www.pinclipart.com/picdir/big/40-407293_clipart-royalty-free-library-pop-art-comics-book.png)

Welcome to **Gif Comic DSL** (Domain Specific Language) Documentation! You can use our DSL to generate comic panels that contain gifs within them.

* [Creating a Comic](#creating-a-comic)
* [Declaring Images](#declaring-images)
* [Creating a Panel](#creating-a-panel)
* [Adding Images within a Panel](#adding-images-within-a-panel)
* [Moving Images within a Panel](#moving-images-within-a-panel)
* [Removing Images within a Panel](#removing-images-within-a-panel)
* [Supported Conditional Logic](#supported-conditional-logic)
* [Optional Grammar: Semicolons and Commas](#optional-grammar)
* [Details about Gif Loop](#details-about-gif-loop)
* [DSL Demo](#dsl-demo)
* [Support](#support)
* [Image Library](#image-library)


## Creating a Comic

<!-- is the order here ok: 1. syntax 2. example 3. Explanation
do we want to change the order, maybe put example after explanation
do we want to add any other section within the documentation-->

***Syntax*** <br>
`comic <comic_name>`

***Example***<br>
`comic myNewComic` <!-- do we want to enforce a naming convention here, eg. underscore, camelcase etc. -->

Every Gif Comic program needs to begin with creating a comic. The syntax is as shown above. *Images cannot be added and panels cannot be created until the comic and its name have been declared*.
  

## Declaring Images 

***Syntax***<br>
`use image <image name from library> as <variable name> (Optional) ;`

***Example***<br>
`use image tall_guy as bob;`

Before creating a panel and using an image within it, the *image must be declared outside of the panel first*. This documentation also contains an [Image Library](#image-library) from which the user can find most images they are looking for. Once the user has decided an image from the [Image Library](#image-library), place it after `image` and before `as`, as indicated above in the syntax. Next, the user must decide a name for this generic image before they are able to add this image within a panel. Optionally, a semicolon may be added at the end of the statement for better user readability. 


## Creating a Panel

***Syntax***<br>
`create panel <size> background <variable name of image> (Optional) text fontsize <fontsize> <text>`

***Example***<br>
`create panel (100,100) background forest text fontsize 10 "Good Morning"`

To create a panel, size must be provided as an x,y coordinate. <!-- we may want to elaborate on the valid values of the x,y coordinates here too --> Then, a background must be set using the variable name of an image declared outside of the panel. Optionally, the user may add text to the panel, which will appear in the top right corner of the panel <!-- where do we want to place the text on the panel, will it interfere with the placement of the images? --> Fontsize (an integer between 1 and 30 <!-- do we want to place a limit on fontsize depending on panel size? -->) and the actual text must then be provided next, as shown in the syntax and example above.

## Adding Images within a Panel

***Syntax***<br>
`add <variable name of image> <position> (Optional) (, | ;)`

***Example***<br>
`add bob (50, 100)`

To add an image within a panel, *it must first have been declared outside of the panel (see [Declaring Images](#declaring-images))*. Once declared, the image can be added into the panel using the variable name of the image followed by a position (in x,y coordinates <!-- we may want to elaborate on the valid values of the x,y coordinates here too -->). Position must be within the coordinates of the panel. Optionally, a comma may be added at the end of the statement if the user intends to add more statements within the panel. If this statement is the last statement in the panel, a semi-colon may also be optionally added. The option to use commas and semicolons exists for better readability for users.

## Moving Images within a Panel

***Syntax***<br>
(a) `move`: `move <variable name of image> <position> (Optional) (, | ;)` <br>
(b) `run`: `run <variable name of image> <position> (Optional) (, | ;)` <br>
(c) `jump`: `jump <variable name of image> <position> (Optional) (, | ;)` <br>

***Example***<br>
(a) `move`: `move bob (70, 100),` <br>
(b) `run`: `move kate (100, 100),`<br>
(c) `jump`: `move alice (10, 40);`<br>

There are 3 types of movements within a panel: `move`, `run`, and `jump`. `move` mimicks a walking notion and requires the variable name of the image and a position to move/walk it to. `run` mimicks a running notion, so it is faster than move and also requires the variable name of the image, along with a position to run it to. `jump` mimicks a quick jumping notion and, you guessed it, requires the variable name of the image and a position to jump it to. Each movement statement may optionally end with a comma if more statements within the panel succeed it, or end with a semi-colon if it is the last statement within the panel. *Note that an image cannot be move, run, or jump if it is not first declared outside the panel and then added within the panel.*


## Removing Images within a Panel

***Syntax***<br>
`remove <variable name of image>`

***Example***<br>
`remove bob`

To remove an image from a panel, perhaps after doing some movements with it, follow the syntax above. 


## Supported Conditional Logic

***Syntax***<br>
`<add | type of movement> <variable name of image> <position> (Optional) AND <type of movement> <variable name of image> <position> (Optional) AND ...`

***Examples***<br>
(a) `move bob (20, 10) AND run kate (70, 30),` <br>
(b) `add alice (45, 10) AND jump bob (20, 50)` <br>

The conditional logical operator `AND` is supported within, *and only within*, the statements of a panel. Using the `AND` operator, multiple images can be added at once or multiple movements can be done at once. <!-- is it at once or in very quick succession? -->



## Optional Grammar

***Syntax***<br>
`,` | `;`

***Examples***<br>
(a) `use image tall_guy as bill;` <br>
(b) `use image tall_guy as bill`<br> 
(c) `add bill,`<br>
(d) `remove bill`<br>
(e) `add kate AND move kate (20, 50);`<br>
(f) `add kate AND move kate (20, 50)`<br>

As mentioned earlier within the Gif Comic DSL documentation, commas and semicolons are optional grammar for ease of user readability. Recommended convention for adding semicolons is as follows:
1. After declaring images outside of a panel<br>
2. After the last line within a panel<br>

Recommended convention for adding commas is after every statement within a panel, provided there are more statements succeeding it. 

## Details about Gif Loop

Gif looping within the panels is done automatically. User does not need to explicitly loop each panel. Each panel, then, is a gif and the total number of panels, each containing their own gifs, make up the comic. Multiple comics cannot be created within a single input file, but up to x <!-- max num of panels --> panels may be added within a comic.


## DSL Demo

Example Input DSL: <!-- this example input can be modified as needed -->
```
comic my_comic
  use image tall_guy as astrozhu;
  use image short_guy as bill;
  use image class_room as classroom;
  create panel (0,0) background classroom text fontsize 20 "What's Up"
    add astrozhu (10,10),
    add bill (30,10),
    move astro (20,10),
    move astro (30,10) AND move bill (10,10),
    remove bill;
```

Output HTML: <!-- insert output html here once project is finished -->

## Support

If you would like any support with our Gif Comic DSL, please contact any of the creators: 
* Alex (<aaack.ubc@gmail.com>)
* Jen (<jyan317@gmail.com>)
* Astro (<astroycz@gmail.com>)
* Abraham (<abrahamwong9704@hotmail.com>)
* Ravina (<ravinakaur@hotmail.com>)

## Image Library

<!-- insert image library enum here, mapping the generic term for the image to the actual image itself, is this possible? -->
