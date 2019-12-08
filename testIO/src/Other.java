/**
* This is an example entity class. * Do not forget to write 'implements java.io.Serializable'.*/
public class Other implements java.io.Serializable {
String data;
public Other() { // default constructor
}
public void writeData(){
System.out.println(data);
}
}