package springTest;

import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   StaticTest staticTest = new StaticTest();
	   staticTest.i=3;
       staticTest.name="sss";
       StaticTest  staticTest2 = new StaticTest();
       staticTest2.i=8;
       System.out.println(staticTest.i);
       StaticTest  staticTest3=new StaticTest();
       
	}

}
