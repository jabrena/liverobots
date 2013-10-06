Live Robots
==========
 
Live Robots, is a educative project designed to create robots with Behaviors.
The project will use the educative platform Lego Mindstorms EV3.
http://www.lego.com/en-us/mindstorms

## Project status ##

    2013/10/06: Refactoring code...
    2013/10/05: First FSM running in EV3
    2013/10/02: Stable ANT file to build, package (Runnable Jar) and deploy in EV3 brick
    2013/09/20: I run LeJOS on EV3 brick
    2013/09/14: I received my first EV3 brick.

Note: Many thanks to Andy Shaw & Lawrie Griffiths with their notes. I learn so much with them.

## Brity robot ##

Brity is a Home EV3 robot designed interact with Humans and Cats. 
The behaviours are modelled with a FSM using Apache Commons SCXML.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/scxml/BrityModel.png)

Id Software popularized the FSM concept when they  published the source code of the video game Quake. 
In this example, it is possible to see the design for a bot in Quake.

![ScreenShot](http://ai-depot.com/FiniteStateMachines/FSM7.png)

The final goal of this project, is the development a Java solution to model complex behaviors for EV3 robots.

### Class diagram ###

With EV3, the development is easier than with a NXT brick or a RCX brick using Java 7 and LeJOS project.
I think that it is a good practice if you view your Class diagrams to discover bad designs.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/uml/graph.png)

Note: In this graph, I notice some problems... :)

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

## Getting started with SCXML FSM in LeJOS for EV3 ##

### BumperCar ###

#### Introduction ####

BumperCar is the classic example to understand the behaviour concept. 
LeJOS project has support for Subsumption Architecture.

EV3 Example: http://sourceforge.net/p/lejos/ev3/ci/master/tree/EV3BumperCar

NXT Example: http://sourceforge.net/p/lejos/code/HEAD/tree/trunk/samples/src/org/lejos/sample/bumpercar

#### Modelling Bumper as a SCXML file ####

In this project, I will try to explore another way to model behaviours with SCXML.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/scxml/BrityModel.png)

#### Youtube ####

BumperCar running in a EV3 robot using a FSM.

http://www.youtube.com/watch?v=lU_vTx0f-vU&feature=youtu.be

#### Preliminar results ####

Current solution runs in Local and a EV3 brick.

In local:

    2013-10-06 01:22:28,309  INFO [main] (BrityFSM.java:78) - STATE: Iddle
    2013-10-06 01:22:28,320  INFO [main] (BrityFSM.java:87) - STATE: DriveForward
    2013-10-06 01:22:28,322  INFO [main] (DriveForward.java:17) - STATE: DriveForward
    2013-10-06 01:22:28,323  INFO [main] (DriveForward.java:25) - Voltage: 500
    2013-10-06 01:22:28,323  INFO [main] (DriveForward.java:30) - Distance: 46
    2013-10-06 01:22:28,324  INFO [main] (BrityFSM.java:95) - STATE: DetectWall
    2013-10-06 01:22:28,325  INFO [main] (DetectWall.java:14) - STATE: DetectWall
    2013-10-06 01:22:28,325  INFO [main] (DetectWall.java:20) - Voltage: 500
    2013-10-06 01:22:28,325  INFO [main] (DetectWall.java:24) - Go backward
    2013-10-06 01:22:28,826  INFO [main] (DetectWall.java:26) - Turn left
    2013-10-06 01:22:29,328  INFO [main] (BrityFSM.java:87) - STATE: DriveForward
    2013-10-06 01:22:29,329  INFO [main] (DriveForward.java:17) - STATE: DriveForward
    2013-10-06 01:22:29,329  INFO [main] (DriveForward.java:25) - Voltage: 500
    2013-10-06 01:22:29,329  INFO [main] (DriveForward.java:30) - Distance: 81
    2013-10-06 01:22:29,331  INFO [main] (BrityFSM.java:95) - STATE: DetectWall
    2013-10-06 01:22:29,331  INFO [main] (DetectWall.java:14) - STATE: DetectWall
    2013-10-06 01:22:29,336  INFO [main] (DetectWall.java:20) - Voltage: 500
    2013-10-06 01:22:29,336  INFO [main] (DetectWall.java:24) - Go backward
    2013-10-06 01:22:29,837  INFO [main] (DetectWall.java:26) - Turn left
    2013-10-06 01:22:30,339  INFO [main] (BrityFSM.java:87) - STATE: DriveForward
    2013-10-06 01:22:30,339  INFO [main] (DriveForward.java:17) - STATE: DriveForward
    2013-10-06 01:22:30,340  INFO [main] (DriveForward.java:25) - Voltage: 500
    2013-10-06 01:22:30,340  INFO [main] (DriveForward.java:30) - Distance: 70
    2013-10-06 01:22:30,341  INFO [main] (BrityFSM.java:95) - STATE: DetectWall
    2013-10-06 01:22:30,342  INFO [main] (DetectWall.java:14) - STATE: DetectWall
    2013-10-06 01:22:30,342  INFO [main] (DetectWall.java:20) - Voltage: 500
    2013-10-06 01:22:30,342  INFO [main] (DetectWall.java:24) - Go backward
    2013-10-06 01:22:30,843  INFO [main] (DetectWall.java:26) - Turn left
    2013-10-06 01:22:31,345  INFO [main] (BrityFSM.java:87) - STATE: DriveForward
    2013-10-06 01:22:31,345  INFO [main] (DriveForward.java:17) - STATE: DriveForward
    2013-10-06 01:22:31,346  INFO [main] (DriveForward.java:25) - Voltage: 500
    2013-10-06 01:22:31,346  INFO [main] (DriveForward.java:30) - Distance: 75
    2013-10-06 01:22:31,347  INFO [main] (BrityFSM.java:95) - STATE: DetectWall
    2013-10-06 01:22:31,348  INFO [main] (DetectWall.java:14) - STATE: DetectWall
    2013-10-06 01:22:31,348  INFO [main] (DetectWall.java:20) - Voltage: 500
    2013-10-06 01:22:31,348  INFO [main] (DetectWall.java:24) - Go backward
    2013-10-06 01:22:31,849  INFO [main] (DetectWall.java:26) - Turn left
    2013-10-06 01:22:32,351  INFO [main] (BrityFSM.java:87) - STATE: DriveForward
    2013-10-06 01:22:32,351  INFO [main] (DriveForward.java:17) - STATE: DriveForward
    2013-10-06 01:22:32,352  INFO [main] (DriveForward.java:25) - Voltage: 500
    2013-10-06 01:22:32,352  INFO [main] (DriveForward.java:30) - Distance: 62
    2013-10-06 01:22:32,354  INFO [main] (BrityFSM.java:95) - STATE: DetectWall
    2013-10-06 01:22:32,354  INFO [main] (DetectWall.java:14) - STATE: DetectWall
    2013-10-06 01:22:32,354  INFO [main] (DetectWall.java:20) - Voltage: 500
    2013-10-06 01:22:32,355  INFO [main] (DetectWall.java:24) - Go backward
    2013-10-06 01:22:32,855  INFO [main] (DetectWall.java:26) - Turn left
    2013-10-06 01:22:33,357  INFO [main] (BrityFSM.java:87) - STATE: DriveForward
    2013-10-06 01:22:33,358  INFO [main] (DriveForward.java:17) - STATE: DriveForward
    2013-10-06 01:22:33,358  INFO [main] (DriveForward.java:25) - Voltage: 31
    2013-10-06 01:22:33,359  INFO [main] (BrityFSM.java:103) - STATE: Disconnected
In EV3:

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

### Gallery ###

Current physical base for Brity using EV3 and some NXT sensors.

![ScreenShot](https://pbs.twimg.com/media/BUwVm1xCUAAcRKQ.jpg:small)

## References ##

### FSM ###

http://ai-depot.com/FiniteStateMachines/FSM.html

http://www.ai-junkie.com/architecture/state_driven/tut_state1.html

http://ai.eecs.umich.edu/cogarch2/specific.html

http://www.cs.umd.edu/~darsana/papers/dissertation/node145.html


### SCXML ###

W3C SCXML: http://www.w3.org/TR/scxml/

Apache Commons SCXML: http://commons.apache.org/proper/commons-scxml/

Apache Commons API: http://commons.apache.org/proper/commons-scxml/apidocs/

SCXML Editor: http://scxmlgui.googlecode.com/svn/trunk/extra/fsm-editor.jar

## Subsumption architecture ##

Wikipedia: http://en.wikipedia.org/wiki/Subsumption_architecture

Janus: http://www.janus.demon.co.uk/alife/index.html





