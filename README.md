
dumper
---------------

    a collection of tiny utilities to dump whatever you want to a mongodb store.

    dumper          -   dump anything
    dumper-learn    -   create/update local indices for faster search
    dumper-search   -   search from dumped data

build
---------------
    $ sbt update
    $ sbt assembly
    //find fat-jar >> dumper/target/scala-2.9.2/dumper-assembly-1.0.jar


setup
---------------
    Make sure you have mongodb datastore available somewhere.
    Register on mongolab or similar to get a free one.

    update config file with the connection information


why?
---------------
    Learning scala. This is my hello world project.
    I wanted something like this for myself too. as in my own.

usage
---------------
Usage: dumper [options] data

  -t <value> | --type <value>
        type of data. text|url|imageurl
  -T <value> | --tags <value>
        list of related tags separated by space in double quotes
  --help
        prints this usage text
  data
        data to be dumped


