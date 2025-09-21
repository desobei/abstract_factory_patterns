// ----- Product Interface -----
interface Car {
    void assemble();
}

// ----- Concrete Products -----
class Sedan implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling a Sedan");
    }
}

class SUV implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling an SUV");
    }
}

// ----- Factory Method Pattern -----
interface CarFactory {
    Car createCar();
}

class SedanFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Sedan();
    }
}

class SUVFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new SUV();
    }
}

// ----- Abstract Factory Pattern -----
interface RegionalCarFactory {
    Car createSedan();
    Car createSUV();
}

// ----- Concrete Regional Factories -----
class EuropeCarFactory implements RegionalCarFactory {
    @Override
    public Car createSedan() {
        return new Sedan() {
            @Override
            public void assemble() {
                System.out.println("Assembling a European Sedan with Euro standards");
            }
        };
    }

    @Override
    public Car createSUV() {
        return new SUV() {
            @Override
            public void assemble() {
                System.out.println("Assembling a European SUV with Euro safety regulations");
            }
        };
    }
}

class USACarFactory implements RegionalCarFactory {
    @Override
    public Car createSedan() {
        return new Sedan() {
            @Override
            public void assemble() {
                System.out.println("Assembling a USA Sedan with EPA compliance");
            }
        };
    }

    @Override
    public Car createSUV() {
        return new SUV() {
            @Override
            public void assemble() {
                System.out.println("Assembling a USA SUV with US safety standards");
            }
        };
    }
}

// ----- Client -----
class CarClient {
    private final CarFactory carFactory;
    private final RegionalCarFactory regionalCarFactory;

    public CarClient(CarFactory carFactory, RegionalCarFactory regionalCarFactory) {
        this.carFactory = carFactory;
        this.regionalCarFactory = regionalCarFactory;
    }

    public void buildFactoryMethodCar() {
        Car car = carFactory.createCar();
        car.assemble();
    }

    public void buildAbstractFactoryCars() {
        Car sedan = regionalCarFactory.createSedan();
        sedan.assemble();

        Car suv = regionalCarFactory.createSUV();
        suv.assemble();
    }
}

// ----- Application Initializer -----
class Application {
    private final CarClient europeanClient;
    private final CarClient usaClient;

    public Application() {
        this.europeanClient = new CarClient(new SedanFactory(), new EuropeCarFactory());
        this.usaClient = new CarClient(new SUVFactory(), new USACarFactory());
    }

    public void run() {
        europeanClient.buildFactoryMethodCar();
        europeanClient.buildAbstractFactoryCars();

        System.out.println("-----");

        usaClient.buildFactoryMethodCar();
        usaClient.buildAbstractFactoryCars();
    }
}

// ----- Entry Point -----
public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
