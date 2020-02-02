# Discord Interpreter

A quick, responsive bot :robot: that provides speech to text for [Discord](https://www.google.com "Discord Homepage") voice channels.

Built with JDA, CMUSphinx and a focus on accessibility, Discord Interpreter provides text reference to live voice channels with easy to use commands and minimal interference to the overall UI of Discord.

## Table of Contents
1. [Install](#install)
2. [Introduction](#introduction)
3. [Commands](#commands)
4. [Technologies](#technologies)
5. [Useful links](#useful-links)
6. [Code Progress](#code-progress)
7. [Challenges](#challenges)
8. [Code Team](#code-team)

## Install

Standard download of the files from this site applies. No other versions are officially supported

## Introduction

Accessibility is an important part of giving people from all walks of life equal access and and equal opportunities. Especially on the internet, including Discord, more people can participate more actively in communities and activities if they have the right tools available to them.

**TL:DR**

* People of disability who cannot directly listen to voice channels may want to participate in community voice chats
* Voice channels are also used by gamers worldwide in order to communicate realtime in time sensitive games to provide an advantage in communication
* Social activities such as simply hanging out and communicating through a voice chat is another type of usage for this bot

Discord Interpreter can provide a bridge to helping those which want to actively participate in these communities and activities.

### Compatability
Discord Interpreter can run on any device and server which supports installation of discord bots 

### Java Coding Standards
Our team made an effort to follow the [Java coding standards](https://www.oracle.com/technetwork/java/codeconvtoc-136057.html "Java Coding Standards") and adhere to the foundational principles of coding.

## Commands

| Name             | Description                                                              |
| ---------------- | ------------------------------------------------------------------------ |
| **!!WakeUp**     | Responds with 'Ok, I'm up!'                                              |
| **hello**        | Responds with 'Hi, Welcome'                                              |

## Technologies

This project uses Java SDK v13.0.2

#### JDA (Java Discord API)
* JDA strives to provide a clean and full wrapping of the Discord REST api and its Websocket-Events for Java. This library is a helpful tool that provides the functionality to create a discord bot in java.
#### CMUSphinx
* Provides state of art speech recognition algorithms for efficient speech recognition. CMUSphinx tools are designed specifically for low-resource platforms and supports several languages such as US English, UK English, French, Mandarin, German, Dutch, Russian and ability to build a models for others. It also has a wide range of tools for many speech-recognition related purposes (keyword spotting, alignment, pronuncation evaluation).
#### Google Cloud's speech API
* Google Speech-to-Text lets developers convert audio to text by applying neural network models in an easy-to-use API. The API recognizes 120 languages to support a global user base. You can enable voice command-and-control, transcribe audio from call centers, and more. It can also process real-time streaming or prerecorded audio with machine learning technology.
##### Languages
* Discord Interpreter is based in Java thanks to JDA which provides a wrapping of the Discord API for Java code. 

## Useful Links

* [JDA (Java Discord API)](https://github.com/DV8FromTheWorld/JDA "Java Discord API github home page")
* [JDA Wiki](https://github.com/DV8FromTheWorld/JDA/wiki "JDA wiki")
* [CMUSphinx](https://cmusphinx.github.io/ "CMUSphinx github home page")
* [CMUSphinx Wiki](https://cmusphinx.github.io/wiki/faq/ "CMUSphinx wiki")
* [Google Speech-to-Text](https://cloud.google.com/speech-to-text "Google speech-to-text")
* [Google Speech-to-Text Wiki](https://cloud.google.com/speech-to-text/docs/ "Google speech-to-text")

## Code Progress
![project progress image 1 showing base project plan](https://github.com/VartanKazar/DiscordInterpreter/blob/dev-josue/docs/images/taskList1.jpg)

This project started off with us deciding to start with the coding language of Javascript and Node.js as our runtime environment. We setup our baseline repository with SourceTree and our IDE with Visual Studio Code. We started early on with documentation and our presentation to help us maximize time spent coding. We planned to create a base text channel which would output text created by our speech to text engine. Another planned feature was a notification based text system which would allow users to get a voice channels text as notifications if they didnt want discord occupying a part of their active screen.

![project progress image 2 showing base project plan](https://github.com/VartanKazar/DiscordInterpreter/blob/dev-josue/docs/images/taskList2.jpg)

As we progressed we realized we wanted to switch over to Java, and moved onto JDA to serve as our Java wrapper and IntelliJ as our IDE. This decision was made as a group due to our higher level of comfort with the Java language as a whole versus having to get Node.js to work with us. In addition during thsi stage several key roadblocks were met with establishing our repository and maintaining the proper git methodology. We established timelines in order to help us keep on track and manage our commitment.

![project progress image 3 showing base project plan](https://github.com/VartanKazar/DiscordInterpreter/blob/dev-josue/docs/images/taskList3.jpg)

As we came to the stage that we became familiar with what we truly wanted from the app we experienced several other coding challenges which hinder our overall productivity. We had to scrap some ideas due to the limitations of Discord bots and leave other out due to time. Overall all progress we made in terms of our code helped us learn a lot about Discord's API, Java wrappers, importing and setting up libraries, maintaining proper git repositories, establishing timelines, delegating tasks and managing a project's desired abilities vs actual abilities.

## Challenges

* We did not start off with a functional git management system. We did not have a lot of experience with managing branching, committing vs pushing, pulling and fetching software. Over the course of the construction of the bot we learned more about the proper git methodology that is necessary to streamline the creation phase of our bot.
* Given the little experience we had with Node.js and javascript itself we pivoted to using a Java wrapper for the Discord API and stick with JAVA with which we were all more familiar. This made our repositories get corrupted and we moved onto making a new one from scratch. 
* Due to the differences of JDK and IDE preferences within each computer our shared code in our repository didnt always work. We had to get togther and stop coding and address the issue as a group, in order to make sure all computers were using the same underlying base software so that we didnt run into errors in running out program.
* Discord's auth token did not want to be hard coded into our program. We had to shift its location into a seperate text file in the gitignore file and call the value from that location in order to make our program process the token value correctly. This way we got the code to run correctly and safely.

## Code Team

<table>
  <tbody>
    <tr>
      <td align="center" width="20%" valign="top">
        <img width="150" height="150" src="https://github.com/VartanKazar/DiscordInterpreter/blob/dev-josue/docs/images/astghik_hovhannisyan_profile.jpg">
        <br>
        <a href="https://github.com/AstghikHov">Astghik Hovhannisyan</a>
        <p>Presentation</p>
        <br>
      </td>
      <td align="center" width="20%" valign="top">
        <img width="150" height="150" src="https://github.com/VartanKazar/DiscordInterpreter/blob/dev-josue/docs/images/josue_orellana_profile.JPG">
        <br>
        <a href="https://github.com/jiorellana">Josue Orellana</a>
        <p>Documentation</p>
        <br>
      </td>
      <td align="center" width="20%" valign="top">
        <img width="150" height="150" src="https://github.com/VartanKazar/DiscordInterpreter/blob/dev-josue/docs/images/vartan_kazaryan_profile.jpg">
        <br>
        <a href="https://github.com/VartanKazar">Vartan Kazaryan</a>
        <p>Discord API &amp; development</p>
        <br>
      </td>
      <td align="center" width="20%" valign="top">
        <img width="150" height="150" src="https://github.com/VartanKazar/DiscordInterpreter/blob/dev-josue/docs/images/mikael_kuyumchyan_profile.jpg">
        <br>
        <a href="https://github.com/MikaelKuyumchyan">Mikael Kuyumchyan</a>
        <p>S2T engine integration</p>
        <br>
      </td>
      <td align="center" width="20%" valign="top">
        <img width="150" height="150" src="https://github.com/VartanKazar/DiscordInterpreter/blob/dev-josue/docs/images/tracy_smart_profile.jpg">
        <br>
        <a href="https://github.com/TracySmart795">Tracy Smart</a>
        <p>Discord API &amp; development</p>
        <br>
  </tbody>
</table>
