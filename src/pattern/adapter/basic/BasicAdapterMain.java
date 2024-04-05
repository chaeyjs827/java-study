package pattern.adapter.basic;

public class BasicAdapterMain {

    public static void main(String[] args) {

        BasicAdaptee basicAdaptee = new BasicAdaptee();
        basicAdaptee.a = 100;
        basicAdaptee.b = 200;

        BasicTarget adapter = new BasicAdapter(basicAdaptee);
        System.out.println("number : " + adapter.getNumber());

    }

}
