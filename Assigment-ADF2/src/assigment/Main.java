/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Book b = new Book();
        menu(b);
    }
    public static void menu(Book b) throws IOException{
        Scanner in = new Scanner(System.in);
        int choose;
        do {            
            System.out.println("-------- MENU ---------");
            System.out.println("1.Add ");
            System.out.println("2.VIEW");
            System.out.println("3.UPDATE");
            System.out.println("4.REMOVE");
            System.out.println("5.EXPORT");
            System.out.println("6.Read a book with Auto scroll");
            System.out.println("0.Exit");
            do {                
                System.out.println("Input option (0/1/2/3/4/5/6) : ");
                choose = Integer.parseInt(in.nextLine());
                if (choose < 0 || choose > 6) {
                    System.out.println("Error ! Pleas choose again !");
                }
            } while (choose < 0 || choose > 6);
            switch(choose){
                case 1:
                    b.Add();
                    break;
                case 2:
                    b.View();
                    break;
                case 3:
                    b.Update();
                    break;
                case 4:
                    b.Remove();
                    break;
                case 5:
                   b.Export(b);
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choose != 0);
    }
    
}
