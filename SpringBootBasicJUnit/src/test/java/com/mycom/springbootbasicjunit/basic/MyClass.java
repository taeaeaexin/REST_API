package com.mycom.springbootbasicjunit.basic;

import java.util.Objects;

public class MyClass {
    int n = 10;

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyClass other = (MyClass) obj;
        return n == other.n;
    }

    boolean getResult() {
        return false;
    }

    String getString() {
        return null;
    }

    public int getStringLength(String str) {
        return str.length();
    }
}
