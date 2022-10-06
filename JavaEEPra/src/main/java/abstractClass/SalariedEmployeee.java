package abstractClass;

/**
 * @author Mr.wxx
 * @create 2022-10-02-0:07
 **/
public class SalariedEmployeee extends Employee {

    private Integer monthlySalary;

    public SalariedEmployeee(String name, Integer number, MyDate birthday) {
        super(name, number, birthday);
    }

    @Override
    public void earnings() {
        return;
    }
}
