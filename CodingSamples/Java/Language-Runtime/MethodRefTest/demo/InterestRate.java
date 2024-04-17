//Functional interface contaions exactly one abstract method,
//runtime converts a method reference to a functional interface
//by generating implementation of this interface so that it
//invokes the referenced method
interface InterestRate {
    double forPeriod(int years);
}
