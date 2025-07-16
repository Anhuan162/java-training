package enums;

import java.util.Scanner;

public enum PaymentMethod {
    CASH("Tiền mặt"),
    CARD("Thẻ"),
    BANK("Chuyển khoản");

    private final String label;

    PaymentMethod(String label) {
        this.label = label;
    }

    public static PaymentMethod fromLabel(String text) {
        for (PaymentMethod p : values()) {
            if (p.label.equalsIgnoreCase(text)) return p;
        }
        throw new IllegalArgumentException("Không tìm thấy: " + text);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fromLabel(sc.next()));
    }
}
