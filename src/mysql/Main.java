package mysql;

import mysql.controllers.AtelierController;
import mysql.views.AtelierView;

public class Main {
    public static void main(String[] args) {
        AtelierView atelierView = new AtelierView();

        DatabaseConnection databaseConnection = new DatabaseConnection();

        AtelierController atelierController = new AtelierController(atelierView, databaseConnection);
    }
}
