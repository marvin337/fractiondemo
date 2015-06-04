# Example to compile class file
D:\marvin\projects\fractiondemo\src>javac -classpath ..\lib\commons-lang-2.4.jar com\marvin\project\FractionDemo.java

# Example to create jar file
D:\marvin\projects\fractiondemo\src>jar cvf fractiondemo.jar com\marvin\project\FractionDemo.class
added manifest
adding: com/marvin/project/FractionDemo.class(in = 3590) (out= 1825)(deflated 49%)

# Example to run without the right paramter
D:\marvin\projects\fractiondemo\src>java -cp ..\lib\commons-lang-2.4.jar;fractiondemo.jar com.marvin.project.FractionDemo
Expecting a parameter with directory path. Eg. C://tmp/

# Example to run with C:/tmp/mathprob directory with input files
D:\marvin\projects\fractiondemo\src>java -cp ..\lib\commons-lang-2.4.jar;fractiondemo.jar com.marvin.project.FractionDemo C:/tmp/mathprob
File=C:\tmp\mathprob\tc1.txt
2/3 + (-2) = (-1 1/3)
2/3 - (-2) = 2 2/3
2/3 * (-2) = (-1 1/3)
2/3 / (-2) = (-1/3)

File=C:\tmp\mathprob\tc2.txt
1 2/3 + 0/6 = 1 2/3
1 2/3 - 0/6 = 1 2/3
1 2/3 * 0/6 = 0/18
Inf
