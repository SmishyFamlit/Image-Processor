##image-processing
a program that manipulates images similar to photoshop

#new updates to the program 
we added a user friendly interface that will manipulate the images


------------------------------------------------------------------------------------------------------------------

#manipulating images using the GUI
file and edit have all the features to manipulate an image

in order to manipulate the image you must load the image first


------------------------------------------------------------------------------------------------------------------
##Interfaces

#commands package


#Interface ImageCommands 
commands that ImageProcessingModel provides for the command design pattern of the controller

#Interface Controller
Provides methods that control the manipulation of the images

#Interface ImageProcessingModel
Provides methods that manipulates the images 

#Interface View
Provides methods that view the changes to the ImageProcessingModel


------------------------------------------------------------------------------------------------------------------
##Classes

#ImageController
Controls the manipulation of images using text-based scripting

#ImageNotFoundException
Exception that is throne when the image that the client is trying to manipulate is not able to be found

#ImageProcessor 
is a ImageProcessingModel and implements all the manipulation methods 

#Pixel
represents a pixel of an image where you can set and get the RGB value from 0 - 255 inclusive of 0 and 255

#ImageProcessorView
is a view that renders messages for the text-based scripting



------------------------------------------------------------------------------------------------------------------

##Commands and examples on how to type them into the program

#List of all of the commands and how to use them 
load <filename> <image-name>
save <image-name> <filepath>
horizontal-flip <image-name> <new-image-name>
vertical-flip <image-name> <new-image-name>
luma <image-name> <new-image-name>
value <image-name> <new-image-name>
intensity <image-name> <new-image-name>
brighten <image-name> <value> <new-image-name>
darken <image-name> <value> <new-image-name>
grayscale <RGB component> <image-name> <new-image-name>
quit
--help

#load waffleOriginal.ppm and call it waffle
load res/waffleOriginal.ppm waffle

#vertically flips waffle and call it waffleFlip1
vertical-flip waffle waffleFlip1

#brightens waffleFlips1 by 50 and call it waffleFlip1Bright
brighten waffleFlips1 50 waffleFlip1Bright

#turns waffleFlip1Bright into a grayscale image of the red components
grayscale red waffleFlip1Bright everythingWaffleGray

#saves a .ppm file called everythingWaffleGray into the res folder
save red everythingWaffleGray res/everythingWaffleGray.ppm

------------------------------------------------------------------------------------------------------------------

##How to run the program
1.) go to the main class and click run 
2.) in the console load the image you would like manipulate, where <filename> is the location and name.ppm of the file (eg. load res/waffleOriginal.ppm waffle)
4.) types quit when to terminate the program
3.) if help is needed type "--help"


------------------------------------------------------------------------------------------------------------------

Cuphead image credit to @Rachel Boden on Pinterest https://www.pinterest.com/pin/703968985494506467/