/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 *
 * @author USER
 */
public class BTH2 {
    public static byte[] compress(byte[]data) throws IOException{
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer); // returns the generated code... index
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        byte[] output = outputStream.toByteArray();
        deflater.end();
        System.out.println("Original: " + (float) data.length / 1024f + " Kb");
        System.out.println("Compressed: " + (float) output.length / 1024f + " Kb");
        return output;
    }
    public static byte[] decompress(byte[] data) throws IOException,DataFormatException {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new
        ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
        int count = inflater.inflate(buffer);
        outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        byte[] output = outputStream.toByteArray();
        inflater.end();
        System.out.println("Original: " + (float) data.length / 1024 + " Kb");
        System.out.println("Uncompressed: " + (float) output.length / 1024 + " Kb");
        return output;
    }
}
