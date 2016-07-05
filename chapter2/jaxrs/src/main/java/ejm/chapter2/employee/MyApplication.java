package ejm.chapter2.employee;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ejm.chapter2.employee.controller.AddressController;
import ejm.chapter2.employee.controller.EmployeeController;

/**
 * @author Ken Finnigan
 */
@ApplicationPath("/")
public class MyApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public MyApplication() {
        this.singletons.add(new AddressController());
        this.singletons.add(new EmployeeController());
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CORSFilter.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return this.singletons;
    }
}
