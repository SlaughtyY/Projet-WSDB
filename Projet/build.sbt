name := """play-java-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.2"

libraryDependencies += guice


//pour persistance
//lazy val myProject = (project in file(".")).enablePlugins(PlayJava, PlayEbean)