# PathUtils
Simple library to access and manipulate paths in any device.


## Usage
Create instance of the class and start using it.

```java
var pth = new PathUtils("Invalid path", true);
var filePath = "content.txt";

System.out.printf("Path: %s\n", pth.getPath(filePath));
System.out.printf("Base name: %s\n", pth.getBaseName(filePath));
System.out.printf("Normalize: %s\n", pth.normalize(filePath, false));
```

