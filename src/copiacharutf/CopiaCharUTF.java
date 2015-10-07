/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copiacharutf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class CopiaCharUTF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("texto3.txt")));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("texto3.txt", true)));
            int cont = 0;
            dos.writeUTF("Esta e unha cadea\n");
            System.out.println("Se escribio en UTF: esta e unha cadea");
            System.out.println("Se escribieron UTF: " + (dos.size() - cont) + " Bytes");
            cont = dos.size();
            dos.writeChars("Esta e unha cadea\n");
            System.out.println("Se escribio en Chars: esta e unha cadea");
            System.out.println("Se escribieron Chars: " + (dos.size() - cont) + " Bytes");
            cont = dos.size();
            dos.writeUTF("Esta e unha cadea\n");
            System.out.println("Se escribio en UTF: esta e unha cadea");
            System.out.println("Se escribieron UTF: " + (dos.size() - cont) + " Bytes");
            System.out.println("Total escrito: " + dos.size() + " Bytes\n");
            dos.close();

            int lineas = 0;
            while (dis.available() != 0) {

                System.out.println("Tamaño: " + dis.available() + " Bytes");
                //READ UTF
                int leido = dis.available();
                String linea = dis.readUTF();
                System.out.println("Linea leida UTF: " + linea);
                leido = leido - dis.available();
                System.out.println("Leidos: " + leido + " Bytes");
                System.out.println("Quedan: " + dis.available() + " Bytes");
                lineas++;
                //READ Char
                String lineaChar = "";
                for (int i = 0; i < 18; i++) {
                    lineaChar += dis.readChar();
                }
                System.out.println("Linea leida CHAR: " + lineaChar);
                System.out.println("Leidos 36 Bytes");
                System.out.println("Quedan: " + dis.available() + " Bytes");
                lineas++;
                //READ UTF
                leido = dis.available();
                linea = dis.readUTF();
                System.out.println("Linea leida UTF: " + linea);
                leido = leido - dis.available();
                System.out.println("Leidos: " + leido + " Bytes");
                System.out.println("Quedan: " + dis.available() + " Bytes");
                lineas++;

            }
            System.out.println("Lineas leidas: " + lineas);
            dis.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopiaCharUTF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CopiaCharUTF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
