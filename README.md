# BSUIR Cryptography labs – RSA implementation

A CLI tool to demonstrate the RSA algorithm. It uses 1024-bit key by default to save some 
time, so it's terribly unsafe in the real world scenarios. Please do not use it

To see this project in action, run ```./gradlew run``` or ```./gradlew.bat run```

To add options for app, pass args to gradle via: ```./gradlew run --args="-key value"```. 
You can see list of the available command line options below:

* -f, or --file – (optional) file to read cleartext from.
