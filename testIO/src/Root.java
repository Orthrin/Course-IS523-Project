import java.util.List;
/**
* This is an example root, it contains all other objects. * Do not forget to write 'implements
java.io.Serializable'.
*/ public class Root implements java.io.Serializable {
/**
* Keep each type of object (that needs persistence) in a separate container...
*/
List<Other> otherObjects;
public Root() { // default constructor
}
public void aMethod() {
}
}