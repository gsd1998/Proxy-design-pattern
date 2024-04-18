package proxy;

public class ItEmployee implements IEmployee{

    private int id;
    private String name;
    private double salary;

    @Override
    public void giveHike(double amount) {
       this.salary = this.salary + amount;

    }

    @Override
    public void payCut(double amount) {
        this.salary = this.salary - amount;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name= name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary=salary;
    }
}
