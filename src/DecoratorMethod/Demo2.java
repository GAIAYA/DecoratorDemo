package DecoratorMethod;

//实现方法
interface Method{
    void score_decorator();//成绩装饰
}
//学生抽象类
abstract class Student implements Method{
    public int score = 60;
    public Method method;
    public Student(Method method){
        this.method = method;
    }
    @Override
    public void score_decorator() {
        method.score_decorator();
    }
}
//成绩有进步
class Progress extends Student{

    public Progress(Method method) {
        super(method);
    }
    @Override
    public void score_decorator() {
        super.score_decorator();
        get_Progress();
    }
    //装饰方法
    public void get_Progress(){
        System.out.println("但是成绩比上一次有进步");
        System.out.println("家长比较高兴");
    }
}
//成绩与第一名很近
class Close_NO1 extends Student{

    public Close_NO1(Method method) {
        super(method);
    }
    @Override
    public void score_decorator() {
        super.score_decorator();
        get_close_to_NO1();
    }
    //装饰方法
    public void get_close_to_NO1(){
        System.out.println("但是第一名就高我几分");
        System.out.println("家长比较高兴");
    }
}
//成绩名列前茅
class Top_Score extends Student{

    public Top_Score(Method method) {
        super(method);
    }
    @Override
    public void score_decorator() {
        super.score_decorator();
        top_score();
    }
    //装饰方法
    public void top_score(){
        System.out.println("但是成绩名列前茅");
        System.out.println("家长比较高兴");
    }
}
//创建一名学生
class New_Student implements Method{

    @Override
    public void score_decorator() {
        System.out.println("这次考试只考了60分");
        System.out.println("家长很生气");
    }

}

public class Demo2 {
    public static void main(String[] args) {
        Method method = new New_Student();
        Student student1 = new Progress(method);//进步装饰器
        student1.score_decorator();
        Student student2 = new Close_NO1(method);//成绩接近第一装饰器
        student2.score_decorator();
        Student student3 = new Top_Score(method);//成绩名列前茅装饰器
        student3.score_decorator();
    }
}
