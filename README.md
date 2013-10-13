Live Robots
==========
 
Live Robots, is a educative project designed to create robots with Behaviors.
The project will use the educative platform Lego Mindstorms EV3.
http://www.lego.com/en-us/mindstorms

## Project status ##

    2013/10/07: HFSM running in EV3
    2013/10/05: FSM running in EV3
    2013/10/02: Stable ANT file to build, package (Runnable Jar) and deploy in EV3 brick
    2013/09/20: I run LeJOS on EV3 brick
    2013/09/14: I received my first EV3 brick.

Note: Many thanks to Andy Shaw & Lawrie Griffiths with their notes and advices. I learn so much with them.

## Roadmap ##

This is the roadmap for the project:

    Develop a DAO
    Research SCXML
    Design HFSM for Brity

## Brity robot ##

Brity is a Home EV3 robot designed interact with Humans and Cats. 
The behaviours are modelled with a HFSM using Apache Commons SCXML.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/ideas/Brity1.png)

SCXML: https://github.com/jabrena/liverobots/blob/master/lib/Brity1.scxml

Id Software popularized the FSM concept when they  published the source code of the video game Quake. 
In this example, it is possible to see the design for a bot in Quake.

![ScreenShot](http://ai-depot.com/FiniteStateMachines/FSM7.png)

The final goal of this project, is the development a Java solution to model complex behaviors for EV3 robots.

### Class diagram ###

With EV3, the development is easier than with a NXT brick or a RCX brick using Java 7 and LeJOS project.
I think that it is a good practice if you view your Class diagrams to discover bad designs.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/uml/graph.png)

### Build.xml ###

With EV3, you can cover all software engineer processes with a unique file. 
ANT files are great technology.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/vizant/build.png)

Try to to reuse if you like this idea.
https://github.com/jabrena/liverobots/blob/master/build.xml

### Virtual Sensors ###

In many cases, EV3 robots have a Internet connection, so it is a good practice to use information about the network in some scenarios.
In this case, I have created a "Virtual Sensor" (The sensor doesn't have a physical wire) to get time from the public Webservices http://www.geonames.org 
If you used NXT platform, the unique way to getTime was using a physical sensor to get time. 

Example: https://github.com/jabrena/liverobots/blob/master/src/test/java/jab/lejos/ev3/sensors/net/EV3TimeSensorTest.java  

## Getting started with a HFSM in LeJOS for EV3 ##

### Introduction ###

The Finite State Machine (FSM) is a design pattern in which actions are determined by events and the current context of the system.
The Hierarchical FSM is an extension of the FSM concept. In this case, any state can be a substate of some larger state.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/scxml/HFSM.png)

SCXML: https://github.com/jabrena/liverobots/blob/master/lib/hfsm.scxml

### Development ###

The development of a HFSM is the same of a FSM. Take a look the following classes:

HFSM: https://github.com/jabrena/liverobots/blob/master/src/main/java/jab/lejos/liverobots/hfsm/HFSM.java
FSM: https://github.com/jabrena/liverobots/blob/master/src/main/java/jab/lejos/liverobots/fsm/FSM.java

## Getting started with a FSM in LeJOS for EV3 ##

### Beetle ###

#### Introduction ####

Lejla Banjanovic-Mehmedovic from University of Tuzla wrote the paper "BEETLE-INSPIRED BEHAVIOR OF MOBILE ROBOT WITH A FINITE STATE MACHINE DESIGN" (See reference section)
This work describes a Physical platform to emulate a real Beetle. To model the behaviours, the studying used a FSM.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/ideas/BEETLE-INSPIRED-BEHAVIOR-MODEL.png)

This platform is very similar to Brity platform using 3 sensors to measure distances and 2 motors to navigate. 
It is necessary to understand that Brity plaform doesn't include a rear bumper in the platform.

#### FSM Modelling ####

Original FSM Design for this Beetle robot was the following one:

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/ideas/BEETLE-INSPIRED-BEHAVIOR-FSM.png)

This FSM desing has been modelled in SCXML in the following way:

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/scxml/Beetle1.png)

SCXML: https://github.com/jabrena/liverobots/blob/master/lib/Beetle1.scxml

I have removed the behaviour about rear bumper and I have added a new behaviour to detect low battery. 
In my opinion, this behaviour is required for Robotics.

States:

    Calibrate
    Explore
    Scan
    GoAhead
    GoLeft
    GoRight
    GoBack
    Sleep

Transitions:

    goExploring
    goAhead
    goLeft
    goRight
    goScan
    lowBattery

#### Development ####

Comming soon...

### BumperCar ###

#### Introduction ####

BumperCar is a classic example to understand the behaviour concept. 
LeJOS project has support for Subsumption Architecture.
In the following examples, will see how to use LeJOS with Subsumption for NXT and EV3:

EV3 Example: http://sourceforge.net/p/lejos/ev3/ci/master/tree/EV3BumperCar

NXT Example: http://sourceforge.net/p/lejos/code/HEAD/tree/trunk/samples/src/org/lejos/sample/bumpercar

#### Modelling Bumper as a SCXML file ####

In this project, I will try to explore another way to model behaviours. In this case using a FSM with SCXML.

Open the file: https://github.com/jabrena/liverobots/blob/master/lib/BrityModel.scxml 
Using the following FSM tool: http://code.google.com/p/scxmlgui/source/browse/trunk/extra/fsm-editor.jar 

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/scxml/BumperCar.png)

SCXML: https://github.com/jabrena/liverobots/blob/master/lib/BumperCar.scxml

Once you have designed the behaviours for your robot, it is required to create a FSM. 
In this case, I followed the approach from the class AbstractStateMachine:
http://commons.apache.org/proper/commons-scxml/apidocs/org/apache/commons/scxml/env/AbstractStateMachine.html 
and I added some methods to replicated every stated modelled in the SCXML file.

Console:

Local:

    2013-10-06 17:46:52,763  INFO [main] (BumperCar.java:59) - STATE: Iddle
    2013-10-06 17:46:52,778  INFO [main] (RobotFactory.java:12) - Returning a Simulated robot
    2013-10-06 17:46:52,781  INFO [main] (BumperCar.java:68) - STATE: DriveForward
    2013-10-06 17:46:52,783  INFO [main] (DriveForward.java:27) - Voltage: 500
    2013-10-06 17:46:52,783  INFO [main] (DriveForward.java:31) - Go forward
    2013-10-06 17:46:52,784  INFO [main] (RobotSimulated.java:59) - FORWARD
    2013-10-06 17:46:52,784  INFO [main] (DriveForward.java:34) - Distance: 35
    2013-10-06 17:46:52,785  INFO [main] (BumperCar.java:75) - STATE: DetectWall
    2013-10-06 17:46:52,786  INFO [main] (DetectWall.java:24) - Voltage: 73
    2013-10-06 17:46:52,787  INFO [main] (BumperCar.java:82) - STATE: Disconnected

EV3:

    run:
         [echo] Running software.
      [sshexec] Connecting to 192.168.43.62:22
      [sshexec] cmd : cd /home/root/lejos/examples/Brity/; jrun -jar Brity-20131006.jar 
      [sshexec] 2000-01-01 00:05:16,167  INFO [main] (?:?) - STATE: Iddle
      [sshexec] 2000-01-01 00:05:16,584  INFO [main] (?:?) - STATE: DriveForward
      [sshexec] 2000-01-01 00:05:16,602  INFO [main] (?:?) - Voltage: 500
      [sshexec] 2000-01-01 00:05:16,613  INFO [main] (?:?) - Distance: 99
      [sshexec] 2000-01-01 00:05:16,675  INFO [main] (?:?) - STATE: DetectWall
      [sshexec] 2000-01-01 00:05:16,697  INFO [main] (?:?) - Voltage: 500
      [sshexec] 2000-01-01 00:05:16,715  INFO [main] (?:?) - Go backward
      [sshexec] 2000-01-01 00:05:17,229  INFO [main] (?:?) - Turn left
      [sshexec] 2000-01-01 00:05:17,770  INFO [main] (?:?) - STATE: DriveForward
      [sshexec] 2000-01-01 00:05:17,782  INFO [main] (?:?) - Voltage: 109
      [sshexec] 2000-01-01 00:05:17,825  INFO [main] (?:?) - STATE: Disconnected

#### Visual example ####

Video: http://www.youtube.com/watch?v=lU_vTx0f-vU&feature=youtu.be

#### Gallery ####

Current physical base for Brity using EV3 and some NXT sensors.

![ScreenShot](https://pbs.twimg.com/media/BUwVm1xCUAAcRKQ.jpg:small)

## References ##

### LEJOS ###

LeJOS Project: http://lejos.sourceforge.net/

EV3 Wiki: http://sourceforge.net/p/lejos/wiki/Home/

EV3 Repository: http://sourceforge.net/p/lejos/ev3/ci/master/tree/

### HFSM ###

https://code.google.com/p/scxml4flex/

http://www.cs.mcgill.ca/~cdrage/projects.html

http://mammoth.cs.mcgill.ca/openprojects

http://gram.cs.mcgill.ca/statecharts/index.php

### FSM ###

http://ai-depot.com/FiniteStateMachines/FSM.html

http://www.ai-junkie.com/architecture/state_driven/tut_state1.html

http://ai.eecs.umich.edu/cogarch2/specific.html

http://www.cs.umd.edu/~darsana/papers/dissertation/node145.html

BEETLE INSPIRED BEHAVIOR OF MOBILE ROBOT WITH A FINITE STATE MACHINE DESIGN http://www.academypublish.org/papers/pdf/1907.pdf

## Subsumption architecture ##

Wikipedia: http://en.wikipedia.org/wiki/Subsumption_architecture

Janus: http://www.janus.demon.co.uk/alife/index.html

### SCXML ###

W3C SCXML: http://www.w3.org/TR/scxml/

Apache Commons SCXML: http://commons.apache.org/proper/commons-scxml/

Apache Commons API: http://commons.apache.org/proper/commons-scxml/apidocs/

SCXML Editor: http://scxmlgui.googlecode.com/svn/trunk/extra/fsm-editor.jar

http://genesyslab.info/wiki/index.php?title=SCXML_Language_Reference

http://wiki.apache.org/commons/SCXML/Tutorials

http://commons.apache.org/proper/commons-scxml/guide/scxml-documents.html

## UML ###

http://www.objectmentor.com/resources/articles/umlfsm.pdf

## Behaviors ###

PLEO: http://www.robotsandcomputers.com/robots/manuals/Pleo.pdf

Tamagotchi: https://github.com/angryzor/tamagotchi-project/blob/master/waste-fsm.scm






