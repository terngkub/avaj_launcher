#!/bin/sh
find src -name "*.java" > sources.txt
javac -d src @sources.txt
