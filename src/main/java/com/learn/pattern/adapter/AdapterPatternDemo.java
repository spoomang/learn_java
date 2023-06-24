package com.learn.pattern.adapter;

import com.learn.pattern.adapter.interfaces.SocketAdapter;
import com.learn.pattern.adapter.model.SocketAdapter120Volts;
import com.learn.pattern.adapter.model.SocketAdapter240Volts;
import com.learn.pattern.adapter.model.Volt;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        test120VoltAdapter();
        //test240VoltAdapter();
    }

    static void test120VoltAdapter() {
        SocketAdapter adapter = new SocketAdapter120Volts();
        Volt v1 = getVolt(adapter, 1);
        Volt v3 = getVolt(adapter, 3);
        Volt v12 = getVolt(adapter, 12);
        Volt v120 = getVolt(adapter, 120);

        System.out.println("Voltage 1 from 120 volt adapter: "+v1.getVolt());
        System.out.println("Voltage 3 from 120 volt adapter: "+v3.getVolt());
        System.out.println("Voltage 12 from 120 volt adapter: "+v12.getVolt());
        System.out.println("Voltage 120 from 120 volt adapter: "+v120.getVolt());
    }

    static void test240VoltAdapter() {
        SocketAdapter adapter = new SocketAdapter240Volts();

        Volt v1 = getVolt(adapter, 1);
        Volt v3 = getVolt(adapter, 1);
        Volt v12 = getVolt(adapter, 1);
        Volt v120 = getVolt(adapter, 1);

        System.out.println("Voltage 1 from adapter: "+v1.getVolt());
        System.out.println("Voltage 3 from adapter: "+v3.getVolt());
        System.out.println("Voltage 12 from adapter: "+v12.getVolt());
        System.out.println("Voltage 120 from adapter: "+v120.getVolt());
    }


    static Volt getVolt(SocketAdapter adapter, int volt) {
        switch (volt) {
            case 1:
                return adapter.get1Volt();
            case 3:
                return adapter.get3Volt();
            case 12:
                return adapter.get12Volt();
            default:
                return adapter.get120Volt();
        }
    }
}
