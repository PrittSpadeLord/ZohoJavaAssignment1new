public class Address {
    String line1;
    String line2;
    String line3;
    int pinCode;

    String display() {
        String res = "";

        res += line1 + ",\n";
        res += line2 + ",\n";
        res += line3 + " ";

        res += pinCode;

        return res;
    }

    Address() {}

    Address(String line1, String line2, String line3, int pinCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.pinCode = pinCode;
    }
}