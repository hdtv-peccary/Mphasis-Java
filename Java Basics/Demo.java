class Derived extends Base{

    @Override
    public void test1(){
        System.out.printf("test1 from derived");
    }
    public void test2(){
        System.out.printf("test2 from derived");
    }
}
public class demo {
    public static void main(String[]args){
    Base b =new Derived();
    b.test1();
    if(b instanceof Derived) {
        Derived derived =(Derived)b;
        derived.test1();
        derived.test2();
    }
    }
}
