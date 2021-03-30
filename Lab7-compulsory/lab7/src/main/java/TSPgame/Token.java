package TSPgame;

import java.util.Objects;

public class Token implements Comparable {
    private int value1, value2, specialValue;

    public Token(int value1, int value2, int specialValue) {
        this.value1 = value1;
        this.value2 = value2;
        this.specialValue = specialValue;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getSpecialValue() {
        return specialValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return value1 == token.value1 && value2 == token.value2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2);
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return -1;
        Token token = (Token) o;
        if (value1 < token.value1) return -1;
        if (value1 > token.value1) return 1;
        return Integer.compare(value2, token.value2);
    }

    @Override
    public String toString() {
        return "Token{ " + value1 + ' ' + value2 + ' ' + specialValue + " }";
    }
}
