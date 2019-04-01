package com.pe1999.comprobe;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class COMPortServer implements SerialPortEventListener {

    private SerialPort serialPort;

    public COMPortServer(String serialPort) {
        this.serialPort = new SerialPort(serialPort);
        try {
            this.serialPort.openPort();
            this.serialPort.addEventListener(this);
        } catch (SerialPortException e) {
            System.out.println(e);
        }
    }

    public void serialEvent(SerialPortEvent serialPortEvent) {
        if(serialPortEvent.isRXCHAR() && serialPortEvent.getEventValue() > 0) {
            try {
                String data = serialPort.readString();
                System.out.println("In SerialPortListener!");
                serialPort.writeString(data + " - Ok!");

            } catch (SerialPortException e) {
                System.out.println(e);
            }
        }
    }
}
