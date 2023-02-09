# PathUtils
Simple library to access and manipulate paths in any device.
Managing paths are very important because you don't want to have invalid path in youre application or it maybe crash. <\br>

Not only this library will give you tools to manipulate path but also you have access to apache commons-io library classes and methods too.


## Usage
Create instance of the class and start using it.

```java
var pth = new PathUtils("Invalid path", true);
var filePath = "content.txt";

System.out.printf("Path: %s\n", pth.getPath(filePath));
System.out.printf("Base name: %s\n", pth.getBaseName(filePath));
System.out.printf("Normalize: %s\n", pth.normalize(filePath, false));
```

