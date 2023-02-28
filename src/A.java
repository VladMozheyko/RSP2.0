public class A {
    static String BanKName = "Tinkoff";
    int balance;

    public A(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "A{" +
                "balance=" + balance +
                '}';
    }
}
