# TapSearch Api

This project is about building a word search engine from a long paragrahs. The link to visit the app is: https://kshitijkc.github.io/.

## Challenge

### Objective

The objective of this app is are as follows : 

1. To take in multiple paragraphs of text, assigns a unique ID to each paragraph and stores the words to paragraph mappings on an inverted index. This is similar to what elasticsearch does. This paragraph can also be referred to as a "Document".

2. Given a word to search for, it lists out atmost top 10 paragraphs in which the word is present.


### What It Does

1. Tokenizes words by splitting at whitespace and some special characters like: \s \n

2. Converts all words to lowercase

3. Indexes these words against the documents they are from

4. Generates a unique ID for every document that is indexed


### Important Files

1. index.html - This file is the main file which is currently hosted by this repository at https://kshitijkc.github.io/. It requires [FastPriorityQueue.js](https://github.com/Kshitijkc/Kshitijkc.github.io/blob/master/FastPriorityQueue.js) and [headerFooter.css](https://github.com/Kshitijkc/Kshitijkc.github.io/blob/master/headerFooter.css) for implementing PriorityQueue and Styling puspose respectively.

2. Main.class - This is the compiled form of the [Main.java](https://github.com/Kshitijkc/Kshitijkc.github.io/blob/master/Main.java). It's the same thing as the web app [index.html](https://github.com/Kshitijkc/Kshitijkc.github.io/blob/master/index.html) to run from Command Line Interface like: >> java Main.

3. para.txt & word.txt - These files are required by Main.class at runtime. [para.txt](https://github.com/Kshitijkc/Kshitijkc.github.io/blob/master/para.txt) is for holding the paragraphs as input for indexing purpose and [word.txt](https://github.com/Kshitijkc/Kshitijkc.github.io/blob/master/word.txt) contains list of words separated by one or more space to be searched in the paragraph.


The web app is purely client side app and java CLI app can be run on any platform having JDK installed. ``Java Application is tested with Java SE Development Kit 8``. The output of both the app is quite same and can be changed as per the requirement like not restricting ourself to only few character set for spiliting purpose and unlocking the app to get the full visualization by not restricting the app to get atmost first 10 paragraph only.
