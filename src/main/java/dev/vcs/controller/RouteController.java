package dev.vcs.controller;

import dev.vcs.service.RepoService;
import dev.vcs.serviceImpl.RepoServiceImpl;

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
           RepoService repoService = RepoServiceImpl.getInstance();
           switch (choice) {
               case "init":
                   System.out.println("Enter creator Name");
                   String creatorName = scanner.next();
                   repoService.initializeTheRepo(path, creatorName);
                   break;
               case "commit":
                   break;
               case "branches":
                   break;
               default:
                   System.out.println("No commands found with "+choice+" Name");

           }
       }
   }
}
