# Project #2: My Life In Stardew Valley

* Author: Carson Keller
* Class: CS321 - 4001
* Semester: Spring 2023

## Overview

This program uses a predefined class to simulate a basic version of the
Stardew Valley game, augmented by self-authored Task, TaskGenerator,
MaxHeap, and MyPriorityQueue classes to serve as the backbone and main
data structure allow the simulation to run.

## Reflection

This project was a really great way to implement the max heap data 
structure. Despite it being a pretty substantial project, the fact that
it was emulating a game lightened up the pressure a bit. Thus, I think
the purpose of the project, to gain experience writing and using that
data structure, was easily achieved. It was also great experience to have
to dive into the provided code to find information about how to implement
the code we were expected to write. Unlike previous classes, where aspects
such as the type of the variable are explicitly provided (among other things),
this project felt much more like a real-world coding scenario where I had
to do some digging in order to figure out how to implement the solution.

I tried to challenge myself by using JUnit to write my tests and had to
learn about it as a test writing system. This made testing fairly simple
and clean which I really appreciated. I found the tutors to be amazingly
helpful too. I didn't need much direction, but prior to jumping in and
coding, it was really helpful to talk through the data structure, how it
functions, and its purpose. That really helped me contextualize it before 
having to write it myself. I would say this project was the perfect level
of difficulty as it wasn't stressing me out beyond my ability, but I felt
like I learned a lot from doing it. I didn't really have any issues beyond
just needing to talk through the data structure with the tutors. 

## Compiling & Using

The following files are included and, with the exception of this README, all are
required to run and test this program:

* HeapException.java - source file
* MaxHeap.java - source file
* MaxHeapTest.java - test file
* MyLifeInStardew.java - source file
* MyPriorityQueue.java - source file
* PriorityQueueInterface.java - source file
* README.md - this file
* run-tests.sh - shell script file to run tests
* StardewDailyClock.java - source file
* Task.java - source file
* TaskGenerator.java - source file
* TaskGeneratorInterface.java - source file
* TaskInterface.java - source file
* test-cases/ - directory containing 6 tests to compare my output to

From the directory containing all the required source, interface, and test files, run
the following command to compile all the necessary java source code:

> $ javac *.java

Run the compiled source code using the shell script using the command:

> $ ./run-tests.sh

Console output will return the results of the test script.

## Results

Per the console output after running the shell script, all output from my program
matches the expected outcomes.

## Sources Used

Aside from the provided source code class files, shell script, and
test files, the only outside sources I utilized were the tutors during their tutor
sessions and online tutorials to implement JUnit.