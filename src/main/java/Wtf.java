import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class Wtf {


}


class TeacherDao {

    public void teach() {
        System.out.println("Fucking...");
    }
}

class ProxyFactory implements MethodInterceptor {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(
            Object o,
            Method method,
            Object[] objects,
            MethodProxy methodProxy){

        return null;
    }
}

abstract class SoyaMilk {

    public final void make() {
        select();
        if (customerWantCondiments()) {
            addCondiments();
        }
        soak();
        beat();
    }

    protected final void select() {
        System.out.println("select");
    }

    abstract void addCondiments();

    protected final void soak() {
        System.out.println("soak");
    }

    protected final void beat() {
        System.out.println("beat");
    }

    boolean customerWantCondiments() {
        return true;
    }
}

class RedBeanSoyaMilk extends SoyaMilk {

    @Override
    void addCondiments() {
        System.out.println("RedBeanSoyaMilk addCondiments");
    }
}

class PureSoyaMilk extends SoyaMilk {

    @Override
    protected void addCondiments() {
        System.out.println("PureSoyaMilk addCondiments");
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}


class PeanutSoyaMilk extends SoyaMilk {

    @Override
    protected void addCondiments() {
        System.out.println("PeanutSoyaMilk addCondiments");
    }

    public static void main(String[] args) {
        System.out.println("制作红豆豆浆");
        SoyaMilk PureSoyaMilk = new PureSoyaMilk();
        PureSoyaMilk.make();
    }
}

class Department {

    private String name;
    private String desc;

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


class ComputerCollegeIterator<Department> implements Iterator<Department> {

    private final Department[] departments;
    private int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return position < departments.length
                &&
                departments[position] != null;
    }

    @Override
    public Department next() {

        Department department = departments[position];
        position++;
        return department;
    }
}



class InfoCollegeIterator<Department> implements Iterator<Department> {

    private final List<Department> departments;
    private int index = -1;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (index >= departments.size() - 1) {
            return false;
        } else {
            index++;
            return true;
        }
    }

    @Override
    public Department next() {

        return departments.get(index);
    }
}

interface College<Department> {

    String getName();
    void addDepartment(String name, String desc);
    Iterator<Department> createIterator();
}

class ComputerCollege implements College<Department> {

    private  Department[] departments;
    int numOfDepartment = 0;


    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        departments = new Department[5];
    }

    @Override
    public Iterator<Department> createIterator() {
        return null;
    }
}

interface Subject {

    void registerObserver(Observer observer);
    void remove(Observer observer);
    void notify(Observer observer);
}

interface Observer {

    void update(float tem, float pre, float hum);
}

class WeatherData implements Subject{

    private List<Observer> observers;

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void remove(Observer observer) {

    }

    @Override
    public void notify(Observer observer) {

    }
}

class Baidu implements Observer {

    @Override
    public void update(float tem, float pre, float hum) {
        System.out.println("aa");
    }
}

class Sina implements Observer {

    @Override
    public void update(float tem, float pre, float hum) {
        System.out.println("hot-fix merge3");
        System.out.println("hot fix 1");
    }
}




