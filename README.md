# BSUIR Cryptography labs – RSA implementation

A CLI tool to demonstrate the RSA algorithm. Please do not use it for encryption, it's just a demo

To see this project in action, run ```./gradlew run``` or ```./gradlew.bat run```

To add options for app, pass args to gradle via: ```./gradlew run --args="-key value"```. 
You can see list of the available command line options below:

* `-f`, or `--file` – (optional) file to read cleartext from.
* `-l`, or `--length` – (optional) key length. Default is 1024.
