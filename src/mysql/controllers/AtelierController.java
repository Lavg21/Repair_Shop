package mysql.controllers;

import mysql.DatabaseConnection;
import mysql.models.Deviz;
import mysql.models.Piesa;
import mysql.views.AtelierView;
import mysql.views.TableView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AtelierController {
    private AtelierView view;
    private DatabaseConnection databaseConnection;

    public AtelierController(AtelierView view, DatabaseConnection databaseConnection) {
        this.view = view;
        this.databaseConnection = databaseConnection;
        this.view.add3aListener(new Cerinta3aListener());
        this.view.add3bListener(new Cerinta3bListener());
        this.view.add4aListener(new Cerinta4aListener());
        this.view.add4bListener(new Cerinta4bListener());
        this.view.add5aListener(new Cerinta5aListener());
        this.view.add5bListener(new Cerinta5bListener());
        this.view.add6aListener(new Cerinta6aListener());
        this.view.add6bListener(new Cerinta6bListener());
    }

    class Cerinta3aListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                CallableStatement cs = connection.prepareCall("{CALL cerinta3a}");
                ResultSet resultSet = cs.executeQuery();
                String s = "";

                DefaultTableModel dataModel = new DefaultTableModel();
                dataModel.addColumn("ID");
                dataModel.addColumn("data_introducere");
                dataModel.addColumn("aparat");
                dataModel.addColumn("simptome");
                dataModel.addColumn("defect");
                dataModel.addColumn("data_constatare");
                dataModel.addColumn("data_finalizare");
                dataModel.addColumn("durata");
                dataModel.addColumn("manopera_ora");
                dataModel.addColumn("total");
                dataModel.addColumn("id_client");
                dataModel.addColumn("id_depanator");

                while (resultSet.next()) {
                    Deviz deviz = new Deviz(
                            resultSet.getInt(1),
                            resultSet.getDate(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getDate(6),
                            resultSet.getDate(7),
                            resultSet.getInt(8),
                            resultSet.getInt(9),
                            resultSet.getInt(10),
                            resultSet.getInt(11),
                            resultSet.getInt(12));

                    List<Object> obj = new ArrayList<>();
                    obj.add(resultSet.getInt(1));
                    obj.add(resultSet.getDate(2));
                    obj.add(resultSet.getString(3));
                    obj.add(resultSet.getString(4));
                    obj.add(resultSet.getString(5));
                    obj.add(resultSet.getDate(6));
                    obj.add(resultSet.getDate(7));
                    obj.add(resultSet.getInt(8));
                    obj.add(resultSet.getInt(9));
                    obj.add(resultSet.getInt(10));
                    obj.add(resultSet.getInt(11));
                    obj.add(resultSet.getInt(12));

                    dataModel.addRow(obj.toArray());

                    s += deviz.toString() + "\n\n";
                }

                //view.table.setModel(dataModel);
                TableView table = new TableView(view);

                table.table.setModel(dataModel);
                table.setVisible(true);

                //view.setResultTextAreaValue(s); // punem in caseta text rezultatul query-ului ca string

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class Cerinta3bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                CallableStatement cs = connection.prepareCall("{CALL cerinta3b}");
                ResultSet resultSet = cs.executeQuery();
                String s = "";

                DefaultTableModel dataModel = new DefaultTableModel();

                dataModel.addColumn("ID");
                dataModel.addColumn("descriere");
                dataModel.addColumn("fabricant");
                dataModel.addColumn("cantitate_stoc");
                dataModel.addColumn("pret");

                while (resultSet.next()) {

                    Piesa piesa = new Piesa(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getDouble(5));

                    List<Object> obj = new ArrayList<>();
                    obj.add(resultSet.getInt(1));
                    obj.add(resultSet.getString(2));
                    obj.add(resultSet.getString(3));
                    obj.add(resultSet.getInt(4));
                    obj.add(resultSet.getDouble(5));

                    dataModel.addRow(obj.toArray());

                    s += piesa.toString() + "\n\n";
                }

                TableView table = new TableView(view);

                table.table.setModel(dataModel);
                table.setVisible(true);

                //view.setResultTextAreaValue(s); // punem in caseta text rezultatul query-ului ca string

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class Cerinta4aListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                CallableStatement cs = connection.prepareCall("{CALL cerinta4a}");
                ResultSet resultSet = cs.executeQuery();
                String s1 = "";
                String s2 = "";

                DefaultTableModel dataModel = new DefaultTableModel();
                dataModel.addColumn("id_d");
                dataModel.addColumn("descriere");
                dataModel.addColumn("fabricant");
                dataModel.addColumn("pret catalog");
                dataModel.addColumn("pret real");

                while (resultSet.next()) {
                    s2 = "id_d: " + resultSet.getInt(1)
                            + "\ndescriere: " + resultSet.getString(2)
                            + "\nfabricant: " + resultSet.getString(3)
                            + "\npret catalog: " + resultSet.getDouble(4)
                            + "\npret real: " + resultSet.getDouble(5);

                    s1 += s2 + "\n\n";

                    List<Object> obj = new ArrayList<>();

                    obj.add(resultSet.getInt(1));
                    obj.add(resultSet.getString(2));
                    obj.add(resultSet.getString(3));
                    obj.add(resultSet.getDouble(4));
                    obj.add(resultSet.getDouble(5));

                    dataModel.addRow(obj.toArray());
                }

                TableView table = new TableView(view);

                table.table.setModel(dataModel);
                table.setVisible(true);

                //view.setResultTextAreaValue(s1); // punem in caseta text rezultatul query-ului ca string

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class Cerinta4bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                CallableStatement cs = connection.prepareCall("{CALL cerinta4b}");
                ResultSet resultSet = cs.executeQuery();
                String s1 = "";
                String s2 = "";

                DefaultTableModel dataModel = new DefaultTableModel();

                dataModel.addColumn("Prima piesa");
                dataModel.addColumn("A doua piesa");
                dataModel.addColumn("Descriere 1");
                dataModel.addColumn("Fabricant 1");
                dataModel.addColumn("Descriere 2");
                dataModel.addColumn("Fabricant 2");


                while (resultSet.next()) {
                    s2 = "Prima piesa: " + resultSet.getInt(1)
                            + "\nA doua piesa: " + resultSet.getInt(2)
                            + "\nDescriere 1: " + resultSet.getString(3)
                            + "\nFabricant 1: " + resultSet.getString(4)
                            + "\nDescriere 2: " + resultSet.getString(5)
                            + "\nFabricant 2: " + resultSet.getString(6);

                    s1 += s2 + "\n\n";

                    List<Object> obj = new ArrayList<>();

                    obj.add(resultSet.getInt(1));
                    obj.add(resultSet.getInt(2));
                    obj.add(resultSet.getString(3));
                    obj.add(resultSet.getString(4));
                    obj.add(resultSet.getString(5));
                    obj.add(resultSet.getString(6));

                    dataModel.addRow(obj.toArray());
                }

                TableView table = new TableView(view);

                table.table.setModel(dataModel);
                table.setVisible(true);

                //view.setResultTextAreaValue(s1); // punem in caseta text rezultatul query-ului ca string

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class Cerinta5aListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                CallableStatement cs = connection.prepareCall("{CALL cerinta5a}");
                ResultSet resultSet = cs.executeQuery();
                String s1 = "";
                String s2 = "";

                DefaultTableModel dataModel = new DefaultTableModel();

                dataModel.addColumn("id_d");
                dataModel.addColumn("data introducere");
                dataModel.addColumn("aparat");
                dataModel.addColumn("simptome");
                dataModel.addColumn("defect");
                dataModel.addColumn("data constatare");
                dataModel.addColumn("data finalizare");
                dataModel.addColumn("durata");
                dataModel.addColumn("manopera_ora");
                dataModel.addColumn("total");
                dataModel.addColumn("id_client");
                dataModel.addColumn("id_depanator");

                while (resultSet.next()) {
                    s2 = "id_d: " + resultSet.getInt(1)
                            + "\ndata introducere: " + resultSet.getDate(2)
                            + "\naparat: " + resultSet.getString(3)
                            + "\nsimptome: " + resultSet.getString(4)
                            + "\ndefect: " + resultSet.getString(5)
                            + "\ndata constatare: " + resultSet.getString(6)
                            + "\ndata finalizare: " + resultSet.getString(7)
                            + "\ndurata: " + resultSet.getInt(8)
                            + "\nmanopera ora: " + resultSet.getInt(9)
                            + "\ntotal: " + resultSet.getInt(10)
                            + "\nid_client: " + resultSet.getInt(11)
                            + "\nid_depanator: " + resultSet.getInt(12);

                    List<Object> obj = new ArrayList<>();

                    obj.add(resultSet.getInt(1));
                    obj.add(resultSet.getDate(2));
                    obj.add(resultSet.getString(3));
                    obj.add(resultSet.getString(4));
                    obj.add(resultSet.getString(5));
                    obj.add(resultSet.getString(6));
                    obj.add(resultSet.getString(7));
                    obj.add(resultSet.getInt(8));
                    obj.add(resultSet.getInt(9));
                    obj.add(resultSet.getInt(10));
                    obj.add(resultSet.getInt(11));
                    obj.add(resultSet.getInt(12));

                    dataModel.addRow(obj.toArray());

                    s1 += s2 + "\n\n";
                }

                TableView table = new TableView(view);

                table.table.setModel(dataModel);
                table.setVisible(true);

                //view.setResultTextAreaValue(s1); // punem in caseta text rezultatul query-ului ca string

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class Cerinta5bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                CallableStatement cs = connection.prepareCall("{CALL cerinta5b}");
                ResultSet resultSet = cs.executeQuery();
                String s1 = "";
                String s2 = "";

                DefaultTableModel dataModel = new DefaultTableModel();

                dataModel.addColumn("id_d");
                dataModel.addColumn("data introducere");
                dataModel.addColumn("aparat");
                dataModel.addColumn("simptome");
                dataModel.addColumn("defect");
                dataModel.addColumn("data constatare");
                dataModel.addColumn("data finalizare");
                dataModel.addColumn("durata");
                dataModel.addColumn("manopera_ora");
                dataModel.addColumn("total");
                dataModel.addColumn("id_client");
                dataModel.addColumn("id_depanator");

                while (resultSet.next()) {
                    s2 = "id_d: " + resultSet.getInt(1)
                            + "\ndata introducere: " + resultSet.getDate(2)
                            + "\naparat: " + resultSet.getString(3)
                            + "\nsimptome: " + resultSet.getString(4)
                            + "\ndefect: " + resultSet.getString(5)
                            + "\ndata constatare: " + resultSet.getString(6)
                            + "\ndata finalizare: " + resultSet.getString(7)
                            + "\ndurata: " + resultSet.getInt(8)
                            + "\nmanopera ora: " + resultSet.getInt(9)
                            + "\ntotal: " + resultSet.getInt(10)
                            + "\nid_client: " + resultSet.getInt(11)
                            + "\nid_depanator: " + resultSet.getInt(12);

                    s1 += s2 + "\n\n";

                    List<Object> obj = new ArrayList<>();

                    obj.add(resultSet.getInt(1));
                    obj.add(resultSet.getDate(2));
                    obj.add(resultSet.getString(3));
                    obj.add(resultSet.getString(4));
                    obj.add(resultSet.getString(5));
                    obj.add(resultSet.getString(6));
                    obj.add(resultSet.getString(7));
                    obj.add(resultSet.getInt(8));
                    obj.add(resultSet.getInt(9));
                    obj.add(resultSet.getInt(10));
                    obj.add(resultSet.getInt(11));
                    obj.add(resultSet.getInt(12));

                    dataModel.addRow(obj.toArray());

                }

                TableView table = new TableView(view);

                table.table.setModel(dataModel);
                table.setVisible(true);

                //view.setResultTextAreaValue(s1); // punem in caseta text rezultatul query-ului ca string

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class Cerinta6aListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                CallableStatement cs = connection.prepareCall("{CALL cerinta6a}");
                ResultSet resultSet = cs.executeQuery();
                String s1 = "";
                String s2 = "";

                DefaultTableModel dataModel = new DefaultTableModel();

                dataModel.addColumn("Nume depanator");
                dataModel.addColumn("Cate devize");

                while (resultSet.next()) {
                    s2 = "Nume depanator: " + resultSet.getString(1)
                            + "\nCate devize: " + resultSet.getInt(2);

                    s1 += s2 + "\n\n";

                    List<Object> obj = new ArrayList<>();

                    obj.add(resultSet.getString(1));
                    obj.add(resultSet.getInt(2));

                    dataModel.addRow(obj.toArray());

                }

                TableView table = new TableView(view);

                table.table.setModel(dataModel);
                table.setVisible(true);

                //view.setResultTextAreaValue(s1); // punem in caseta text rezultatul query-ului ca string

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class Cerinta6bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                CallableStatement cs = connection.prepareCall("{CALL cerinta6b}");
                ResultSet resultSet = cs.executeQuery();
                String s1 = "";
                String s2 = "";

                DefaultTableModel dataModel = new DefaultTableModel();

                dataModel.addColumn("Descriere");
                dataModel.addColumn("Fabricant");
                dataModel.addColumn("Cantitate totala");

                while (resultSet.next()) {
                    s2 = "Descriere: " + resultSet.getString(1)
                            + "\nFabricant: " + resultSet.getString(2)
                            + "\nCantitate totala: " + resultSet.getInt(3);

                    s1 += s2 + "\n\n";

                    List<Object> obj = new ArrayList<>();

                    obj.add(resultSet.getString(1));
                    obj.add(resultSet.getString(2));
                    obj.add(resultSet.getInt(3));

                    dataModel.addRow(obj.toArray());

                }

                TableView table = new TableView(view);

                table.table.setModel(dataModel);
                table.setVisible(true);

                //view.setResultTextAreaValue(s1); // punem in caseta text rezultatul query-ului ca string

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
