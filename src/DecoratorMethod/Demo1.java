package DecoratorMethod;
//基本实现的一些方法接口
interface Character{
    void State();//状态
    void Attack();//攻击
}
//抽象角色类
abstract class Character_Decorator implements Character{
    public double attack = 10.0;
    public double defence = 20.0;
    public double speed = 5.0;
    public Character character;
    public Character_Decorator(Character character){
        this.character = character;
    }
    @Override
    public void State(){
        character.State();
    }
    @Override
    public void Attack(){
        character.Attack();
    }
}
//装饰：改变角色状态（狂暴，无敌，眩晕，虚弱，中毒等）
class Change_state extends Character_Decorator{
    public Change_state(Character character){
        super(character);
    }
    //巨人化
    public void get_gigantize(){
        attack *= 1.5;
        defence *= 1.5;
        speed *= 0.8;
        System.out.println("巨人化,攻击、防御上升,速度下降...");
    }
    //狂暴化
    public void get_furious(){
        attack *= 2;
        defence *= 1;
        speed *= 1.5;
        System.out.println("狂暴化,攻击、速度上升,...");
    }
    //无敌
    public void get_invincible(){
        attack *= 99999;
        defence *= 99999;
        speed *= 1;
        System.out.println("无敌了...");
    }
    @Override
    public void State(){
        super.State();
        get_gigantize();
        get_furious();
        get_invincible();
    }
    @Override
    public void Attack(){
        super.Attack();
    }
}
//装饰：改变角色装备equipment（武器，盔甲等）
class Change_equipment extends Character_Decorator{
    public Change_equipment(Character character){
        super(character);
    }
    //可以创建一个装备类设置数值用来改变角色属性
    public void get_weapon(){
        attack += 10;
        System.out.println("获得武器，攻击加强");
    }
    public void get_armour(){
        defence += 10;
        System.out.println("获得防具，防御加强");
    }
    @Override
    public void State(){
        super.State();
    }
    @Override
    public void Attack(){
        super.Attack();
        get_weapon();
        get_armour();
    }
}
class new_Character implements Character{
    public new_Character(){
        System.out.println("角色创建成功...");
    }
    @Override
    public void State() {
        System.out.println("正在走路......");
    }
    @Override
    public void Attack() {
        System.out.println("正在攻击......");
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Character cha = new new_Character();
        //通过抽象类的子类实例化抽象类
        Character_Decorator character1 = new Change_equipment(new Change_state(cha));
        character1.State();
        character1.Attack();
    }
}
