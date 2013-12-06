biodanza
========

Software to manage and create Biodanza classes. 

Biodanza is described in wikipedia (http://en.wikipedia.org/wiki/Biodanza) as:

Biodanza is defined as a "human integration system of organic renewal, of affective re-education,and of relearning of Life's original functions. Its application consists in leading vivencias through music, singing, movements and group encounter situations".[2][3]
It is a method which aims the development of human capacities, including the feeling of happiness, communication skills and improving of relationships.[4]

This software is designed for Biodanza teachers to organize their classes and to assist them in quickly switching songs and reading information about the class exercises. It also allows the use and creation of exercises templates, and provide a system to organize songs (currently it only works with .mp3 songs).

Biodanza classes are organized in Packages which  are composed of several Exercises. There are also template exercises which can be used to quickly create a new exercise. Exercises can be associated with tags.

Collections contain Albums, which are composed of Songs. A Song can be associated with one or more tags, and each tag which can be linked to several specific Exercises. The system provides a way of searching Songs by tags and also searching all the Songs associated with a single tag.

In order to work properly the system needs a file named PathLinux.txt or PathWindows.txt (depending on the OS) which has to contain the Path to the Songs folder. In the Songs folder first there must be folders with the Collections, then each Collection should contain Albums and each Album should contain the songs as .mp3 files.

The template, classes and exercises should be added manually through the UI.
