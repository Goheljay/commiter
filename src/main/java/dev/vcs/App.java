package dev.vcs;

import dev.vcs.controller.RouteController;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) {
        System.out.println( "Show Main Options::::::" );

        UUID  uuid = UUID.randomUUID();
        System.out.println(uuid);

        System.out.println(args[0]);
        RouteController menus = RouteController.getInstance();

        try{
            menus.showAllMenus(args[0]);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
