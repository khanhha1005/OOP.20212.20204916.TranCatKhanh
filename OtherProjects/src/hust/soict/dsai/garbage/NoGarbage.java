package hust.soict.dsai.garbage;

public class NoGarbage {
	String filename="test.exe";// test.exe is the name or path to an executable file
	byte[]inputBytes={0};
	long startTime, endTime;
	inputBytes=Files.readAllBytes(Paths.get(filename));
	startTime=System.currentTimeMillis();
	StringBuilder outputStringBuilder=new StringBuilder();
	for(byte b:inputBytes){
	    outputStringBuilder.append((char) b);
	}
	endTime=System.currentTimeMillis();
	System.out.println(endTime-startTime);
}
}
