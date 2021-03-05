public class Address {
    String line1;
    String line2;
    String city;
    int pinCode;

    String display() {
        String res = "";

        res += line1 + ",\n";
        res += line2 + ",\n";
        res += city + " ";

        res += pinCode;

        return res;
    }

    Address() {}

    Address(String line1, String line2, String city, int pinCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.pinCode = pinCode;
    }
}