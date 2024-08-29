package dev.vcs;

import dev.vcs.controller.RouteController;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws Exception {
        UUID  uuid = UUID.randomUUID();
        System.out.println(uuid);

//        String currentPath = System.getProperty("user.dir");
//        System.out.println(currentPath);
//
//        File rootDir = new File(currentPath);
//        File kuFlexDir = new File(rootDir, ".commiter");
//        if (!kuFlexDir.mkdir()) {
//            throw new Exception("Failed to create " + ".commiter" + " repository folder");
//        }
        System.out.println(args[0]);
        RouteController menus = RouteController.getInstance();

        try{
            menus.showAllMenus(args[0]);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
