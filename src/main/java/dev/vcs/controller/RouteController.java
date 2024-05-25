package dev.vcs.controller;

import java.io.File;
import java.util.Scanner;

public class RouteController {

   private static RouteController obj = null;

   public static synchronized RouteController getInstance() {
       if (obj == null) {
            obj = new RouteController();
       }
       return obj;
   }


   public void showAllMenus(String path) {
       if (!new File(path).isDirectory()) {
           System.out.println("Invalid Path argument : " + path);
           return;
       }
       Scanner scanner = new Scanner(System.in);
       while(true){
           System.out.println("1. Initialize = init\n2. Commit = commit\n3. Create Branch = branches");
           String  choice = scanner.next();
           switch (choice) {
               case "init":
                   return;
               case "commit":
                   return;
               case "branches":
                   return;
               default:
                   System.out.println("No commands found with "+choice+" Name");

           }
       }
   }
}
