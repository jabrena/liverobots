Live Robots
==========
 
Live Robots, is a educative project designed to create robots with Behaviors.
The project will be developed using the educative platform Lego Mindstorms EV3.

## Brity project ##

Brity is a project designed to develop EV3 robot and java software.
Robot will use a FSM with SCXML to model behaviours.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/scxml/BrityModel.png)

### Example: ###

In local:

    2013-10-06 00:05:25,429  INFO [main] (BrityFSM4.java:64) - STATE: Iddle
    2013-10-06 00:05:25,441  INFO [main] (BrityFSM4.java:73) - STATE: DriveForward
    2013-10-06 00:05:25,442  INFO [main] (BrityFSM4.java:76) - Voltage: 500
    2013-10-06 00:05:25,442  INFO [main] (BrityFSM4.java:82) - Distance: 24
    2013-10-06 00:05:25,443  INFO [main] (BrityFSM4.java:96) - STATE: DetectWall
    2013-10-06 00:05:25,444  INFO [main] (BrityFSM4.java:99) - Voltage: 500
    2013-10-06 00:05:25,444  INFO [main] (BrityFSM4.java:104) - Go backward
    2013-10-06 00:05:25,944  INFO [main] (BrityFSM4.java:106) - Turn left
    2013-10-06 00:05:26,446  INFO [main] (BrityFSM4.java:73) - STATE: DriveForward
    2013-10-06 00:05:26,447  INFO [main] (BrityFSM4.java:76) - Voltage: 70
    2013-10-06 00:05:26,449  INFO [main] (BrityFSM4.java:117) - STATE: Disconnected

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



This example is an alternative to use Subsumption Architecture to model behaviours in Robots.

http://sourceforge.net/p/lejos/ev3/ci/master/tree/EV3BumperCar/

### Class diagram ###

Current class diagram for Brity Project.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/uml/graph.png)


## Modeling behaviors with LeJOS ##

One goal of this project is the research about behavior modelling with Java.
Currently, the alternatives are:

FSM
HFSM
Subsumption

### SCXML ###

W3 SCXML: http://www.w3.org/TR/scxml/

Apache Commons SCXML: http://commons.apache.org/proper/commons-scxml/

Apache Commons API: http://commons.apache.org/proper/commons-scxml/apidocs/

SCXML Editor: http://scxmlgui.googlecode.com/svn/trunk/extra/fsm-editor.jar

### Subsumption architecture ###

Wikipedia: http://en.wikipedia.org/wiki/Subsumption_architecture

# Build.xml #

Take a look latest version of Build.xml for EV3 project.

![ScreenShot](https://raw.github.com/jabrena/liverobots/master/docs/vizant/build.png)




