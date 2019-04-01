package com.pe1999.comprobe;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import static java.lang.Thread.sleep;

public class Comprobe {
    public static void main(String[] args) {
        String[] ports = SerialPortList.getPortNames();
        for (String port : ports) {
            System.out.println(port);
        }

        COMPortServer comPortServer = new COMPortServer("COM6");

        SerialPort comport = new SerialPort("COM7");
        try {
            comport.openPort();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
        try {
            comport.writeString("Hi!");
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(comport.readString());
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
