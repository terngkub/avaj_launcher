#!/bin/sh
find src -name "*.java" > sources.txt
javac --release 7 -Xlint:-options -sourcepath src @sources.txt
