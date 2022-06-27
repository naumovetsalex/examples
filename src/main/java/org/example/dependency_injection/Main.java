package org.example.dependency_injection;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Main {

    public static void main(String[] args) {
        Inject inject = new Inject("field1", "field2", "field3");
        Domain1 domain1 = new Domain1(inject);
        System.err.println(domain1 + "\n");
        Domain2 domain2 = new Domain2();
        domain2.setInjectable(inject);
        System.err.println(domain2 + "\n");
        Domain3 domain3 = new Domain3();
        domain3.setInjectable(inject);
        System.err.println(domain3 + "\n");
    }
}

@Data
class Domain1 {

    private final Injectable injectable;

    Domain1(Injectable injectable) {
        this.injectable = injectable;
    }

}

@Data
class Domain2 {

    private Injectable injectable;

    void setInjectable(Injectable injectable) {
        this.injectable = injectable;
    }

}

@Data
class Domain3 implements InjectableSetter {

    private Injectable injectable;

    @Override
    public void setInjectable(Injectable injectable) {
        this.injectable = injectable;
    }
}

@Data
@AllArgsConstructor
class Inject implements Injectable{

    private String field1;
    private String field2;
    private String field3;

    @Override
    public void doInject() {
        System.err.println("field1: " + this.field1);
        System.err.println("field2: " + this.field2);
        System.err.println("field3: " + this.field3);
    }
}

interface Injectable {

    void doInject();
}


interface InjectableSetter {

    void setInjectable(Injectable injectable);
}
