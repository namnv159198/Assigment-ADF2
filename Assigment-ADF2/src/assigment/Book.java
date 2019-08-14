/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment;



import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author Admin
 */
public class Book {
    public String id ;
    public String title ;
    public String author ;
    public LocalDate releaseDate ;
    public String content;
    Scanner in = new Scanner(System.in);
    public ArrayList <Book> listBook  = new ArrayList<>();
    public  Book(){
    
    }
    public Book(String id, String title, String author, LocalDate releaseDate, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.content = content;
    }
    

   
    public void Add() {
        String id ;
        String title ;
        String author ;
        String content;
        LocalDate date;
        System.out.print("Input ID : ");
        id = in.nextLine();
        System.out.print("Input Title : ");
        title = in.nextLine();
        String Rdate;
        do {            
        System.out.println("Input Release Date : ");
        System.out.print("DAY : ");
        int day = Integer.parseInt(in.nextLine());
        System.out.print("MONTH : ");
        int month = Integer.parseInt(in.nextLine());
        System.out.print("YEAR : ");
        int year = Integer.parseInt(in.nextLine());
         Rdate = String.format("%02d", day)+"/"+String.format("%02d", month)+"/"+year;
         if (isValidDate(Rdate) == false) {
             System.out.println("Date is not valid ! Input return !");
         }
        } while (isValidDate(Rdate) == false);
        date = RT(Rdate);
        System.out.print("Input Author : ");
        author = in.nextLine();
        System.out.print("Input Content : ");
        content = in.nextLine();
        Book b = new Book(id, title, author, date, content);
        listBook.add(b);
    }

    
    public void SearchID(){
        System.out.print("Input ID : ");
        String b = in.nextLine();
        boolean c = false;
        for (int i = 0; i < listBook.size(); i++) {
            if (b.equals(listBook.get(i).id)) {
            System.out.println("-------------- Book --------------");
            System.out.println("ID           : " + listBook.get(i).id);
            System.out.println("Title        : " + listBook.get(i).title);
            System.out.println("Release Date : " + listBook.get(i).releaseDate);
            System.out.println("Author       : " + listBook.get(i).author);
            System.out.println("Content      : " + listBook.get(i).content);
            System.out.println("-----------------------------------------");
            System.out.println(" FIND SUCCESS !");
            c = true;
            break;
            }
        }
        if (!c) {
            System.out.println("NOT FIND BOOK ID ! ");
        }
        
    }
    public void SearchNAME(){
        System.out.print("Input Name :");
        String b = in.nextLine();
        boolean c = false;
        for (int i = 0; i < listBook.size(); i++) {
            if (b.equals(listBook.get(i).title)) {
            System.out.println("-------------- Book --------------");
            System.out.println("ID           : " + listBook.get(i).id);
            System.out.println("Title        : " + listBook.get(i).title);
            System.out.println("Release Date : " + listBook.get(i).releaseDate);
            System.out.println("Author       : " + listBook.get(i).author);
            System.out.println("Content      : " + listBook.get(i).content);
            System.out.println("------------------------------------------");
            System.out.println(" FIND SUCCESS !");
            c = true;
            break;
            }
        }
        if (!c) {
            System.out.println("NOT FIND  BOOK TITLE  ! ");
        }
        
    }
    public void ListView(){
        int k =1 ;
        System.out.println("-------------- Book --------------");
         for (int i = 0; i < listBook.size(); i++) {
            System.out.println(k+"."); 
            System.out.println("ID           : " + listBook.get(i).id);
            System.out.println("Title        : " + listBook.get(i).title);
            System.out.println("Release Date : " + listBook.get(i).releaseDate);
            System.out.println("Author       : " + listBook.get(i).author);
            System.out.println("Content      : " + listBook.get(i).content);
            k++;
        }
        System.out.println("------------------------------------------------");
    }
    public void View() {
        int choose;
        do {            
            
            MenuView();
            do {                
                System.out.println("Input option (0/1/2/3) : ");
                choose = Integer.parseInt(in.nextLine());
                if (choose < 0 || choose > 3) {
                    System.out.println("Error ! Pleas choose again !");
                }
            } while (choose < 0 || choose > 3);
            switch(choose){
                case 1:
                    SearchID();
                    break;
                case 2:
                    SearchNAME();
                    break;
                case 3:
                    ListView();
                    break;
                case 0:
                    return;
            }
        } while (choose != 0);
    }

    public void Update() {
        int choose;
        System.out.println("Input ID or NAME : ");
        String b = in.nextLine();
        boolean c = false;
        for (int i = 0; i < listBook.size(); i++) {
            if (b.equals(listBook.get(i).id) ||b.equals(listBook.get(i).title)) {
                do {            
                      MenuUpdate();
                do {                
                System.out.println("Input option (0/1/2/3/4/5) : ");
                choose = Integer.parseInt(in.nextLine());
                if (choose < 0 || choose > 5) {
                    System.out.println("Error ! Pleas choose again !");
                }
            } while (choose < 0 || choose > 5);
                
            switch(choose){
                case 1:
                    System.out.print("ID : "+listBook.get(i).id+" --> ID NEW : ");
                    String n = in.nextLine();
                    listBook.get(i).id = n;
                    break;
                case 2:
                    System.out.print("TITLE NEW : ");
                    String t = in.nextLine();
                    listBook.get(i).title = t;
                    break;
                case 3:
                    String Rdate;
                    do {            
                        System.out.println("Input Release Date : ");
                        System.out.print("DAY : ");
                        int day = Integer.parseInt(in.nextLine());
                        System.out.print("MONTH : ");
                        int month = Integer.parseInt(in.nextLine());
                        System.out.print("YEAR : ");
                        int year = Integer.parseInt(in.nextLine());
                        Rdate = String.format("%02d", day)+"/"+String.format("%02d", month)+"/"+year;
                         if (isValidDate(Rdate) == false) {
                         System.out.println("Date is not valid ! Input return !");
                            }
                        } while (isValidDate(Rdate) == false);
                    listBook.get(i).releaseDate = RT(Rdate);
                    break;
                case 4:
                    System.out.print("NEW AUTHOR : ");
                    String a = in.nextLine();
                    listBook.get(i).author = a;
                    break;
                case 5:
                    System.out.print("NEW CONTENT : ");
                    String co = in.nextLine();
                    listBook.get(i).content = co;
                    break;
                case 0:
                    return;
            }
        } while (choose != 0);
            c = true;
            break;
            }
        }
        if (!c) {
            System.out.println("NOT FIND BOOK ! REMOVE FAILES ! ");
        }
    }

    public void Remove() {
        System.out.print("Input ID or NAME : ");
        String b = in.nextLine();
        boolean c = false;
        for (int i = 0; i < listBook.size(); i++) {
            if (b.equals(listBook.get(i).id) ||b.equals(listBook.get(i).title)) {
                listBook.remove(i);
                System.out.println("REMOVE SUCCESS !");
            c = true;
            break;
            }
        }
        if (!c) {
            System.out.println("NOT FIND BOOK ! REMOVE FAILES ! ");
        }
    }
    
    public void MenuUpdate(){
        System.out.println("-------- UPDATE ---------");
            System.out.println("1.ID ");
            System.out.println("2.TITLE");
            System.out.println("3.RELEASE DATE");
            System.out.println("4.AUTHOR");
            System.out.println("5.CONTENT");
            System.out.println("0.Exit");
    }
    public void MenuView(){
        System.out.println("-------- VIEW ---------");
            System.out.println("1.Search a book by ID ");
            System.out.println("2.Search book by NAME");
            System.out.println("3.List all book from database");
            System.out.println("0.Exit");
    }
    public void MenuExport(){
            System.out.println("-------- EXPORT ---------");
            System.out.println("1.EXPORT A BOOK TO TXT FILE ");
            System.out.println("2.EXPORT LIST BOOK TO LIST TXT FILE");
            System.out.println("0.Exit");
    }
    
  public LocalDate RT(String d){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate releaseDate = LocalDate.parse(d,formatter);
        return releaseDate;
  }
  
  
  public void Export(Book b) throws IOException{
               int choose;
                do {            
                      MenuExport();
                do {                
                System.out.println("Input option (0/1/2) : ");
                choose = Integer.parseInt(in.nextLine());
                if (choose < 0 || choose > 2) {
                    System.out.println("Error ! Pleas choose again !");
                }
            } while (choose < 0 || choose > 2);
                
            switch(choose){
                case 1:
                    b.ExportBookFile();
                    break;
                case 2:
                    b.ExportListBookFile();
                    break;
                case 0:
                    return;
            }
        } while (choose != 0);
           
  }
  public void ExportBookFile() throws IOException{
      boolean c = false;
        System.out.println("Input ID or NAME : ");
        String b = in.nextLine();
      FileWriter writer = new FileWriter("C:\\Users\\Admin\\Desktop\\JAVA\\Assigment\\outputBook.txt");
      BufferedWriter buffer = new BufferedWriter(writer);
      buffer.write("-------------- Book --------------\n");
      for (int i = 0; i < listBook.size(); i++) {
          if (b.equals(listBook.get(i).id) ||b.equals(listBook.get(i).title)) {
            buffer.write("ID           : " + listBook.get(i).id+"\n");
            buffer.write("Title        : " + listBook.get(i).title+"\n");
            buffer.write("Release Date : " + listBook.get(i).releaseDate+"\n");
            buffer.write("Author       : " + listBook.get(i).author+"\n");
            buffer.write("Content      : " + listBook.get(i).content+"\n");
            buffer.close();
            System.out.println("EXPORT BOOK SUCCESS !");
            c = true;
            break;
          }
          if (!c) {
            System.out.println("NOT FIND BOOK ! EXPORT FAILES");
        }
      }
  }
      public void ExportListBookFile() throws IOException{
      FileWriter writer = new FileWriter("C:\\Users\\Admin\\Desktop\\JAVA\\Assigment\\outputListBook.txt");
      BufferedWriter buffer = new BufferedWriter(writer);
      int k = 1;
      buffer.write("-------------- Book --------------\n");
      for (int i = 0; i < listBook.size(); i++) { 
            buffer.write(k+".");
            buffer.write("ID           : " + listBook.get(i).id+"\n");
            buffer.write("Title        : " + listBook.get(i).title+"\n");
            buffer.write("Release Date : " + listBook.get(i).releaseDate+"\n");
            buffer.write("Author       : " + listBook.get(i).author+"\n");
            buffer.write("Content      : " + listBook.get(i).content+"\n");
            k++;
  }
      buffer.close();
       System.out.println("EXPORT LIST BOOK TO FILE SUCCESS !");
      }
 
private static Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
 
    public static boolean isValidDate(String dateString) {
        Matcher dateMatcher = dateRegexPattern.matcher(dateString);
 
        if (dateMatcher.matches()) {
 
           dateMatcher.reset();
 
           if (dateMatcher.find()) {
               String day = dateMatcher.group(1);
               String month = dateMatcher.group(2);
               int year = Integer.parseInt(dateMatcher.group(3));
 
               if ("31".equals(day) && 
                  ("4".equals(month) || "6".equals(month) || "9".equals(month) ||
                   "11".equals(month) || "04".equals(month) || "06".equals(month) || 
                   "09".equals(month))) {
                   return false; // 1, 3, 5, 7, 8, 10, 12 has 31 days
               } else if ("2".equals(month) || "02".equals(month)) {
                    //leap year
                    if (year % 4 == 0) {
                        return !"30".equals(day) && !"31".equals(day);
                    } else {
                        return !"29".equals(day) && !"30".equals(day) && !"31".equals(day);
                    }
               } else {
                   return true;
               }
           } else {
               return false;
           }
        } else {
            return false;
        }
    }
    
}
