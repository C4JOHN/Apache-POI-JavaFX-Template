package readingfromexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ContactView extends Application {
    
    TableColumn<Contacts,String> nameColumn=new TableColumn<>();
    TableColumn<Contacts,String> phoneColumn=new TableColumn<>();
    TableColumn<Contacts,String> addressColumn=new TableColumn<>();
    TableColumn<Contacts,Integer> ageColumn=new TableColumn<>();
    TableColumn<Contacts,Boolean> professionColumn=new TableColumn<>();
    BorderPane root = new BorderPane();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        ObservableList<Contacts> contactList=getContacts();
        
        TableView contactsTable=new TableView();
      
        contactsTable.autosize();
        contactsTable.setItems(contactList);
        
        nameColumn.setMinWidth(50);
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        
        phoneColumn.setMinWidth(80);
        phoneColumn.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
        
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory("address"));
        addressColumn.setCellFactory(new Callback<TableColumn<Contacts,String>, TableCell<Contacts,String>>()
        {
            @Override
            public TableCell<Contacts, String> call(TableColumn<Contacts, String> param) {
            TableCell<Contacts,String>cell=new TableCell<>();
            Text text=new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(addressColumn.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
            }
            });        
         
        ageColumn.setMinWidth(50);
        ageColumn.setCellValueFactory(new PropertyValueFactory("age"));
        
        professionColumn.setMinWidth(40);
        professionColumn.setCellValueFactory(new PropertyValueFactory("profession"));
        
        contactsTable.getColumns().addAll(nameColumn,phoneColumn,addressColumn,ageColumn,professionColumn);
        
        contactsTable.setPadding(new Insets(10,10,10,10));
    
        root.setCenter(contactsTable);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Contact Sheet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public ObservableList<Contacts> getContacts() throws IOException{
        ObservableList<Contacts> list=FXCollections.observableArrayList();
        XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(
                "C:\\Users\\removevirus\\Desktop\\apache.xlsx"));
        Iterator<Sheet> sheetIterator=workbook.iterator();
        while(sheetIterator.hasNext()){
            Sheet sheet=sheetIterator.next();
            for(int i=0;i<=sheet.getLastRowNum();i++){
                Row row=sheet.getRow(i);
                if(i==0){
                    for(int x=0;x<row.getLastCellNum();x++){
                        if(x==0)
                            nameColumn.setText(row.getCell(x).getStringCellValue());
                        if(x==1)
                            phoneColumn.setText(row.getCell(x).getStringCellValue());
                        if(x==2)
                            addressColumn.setText(row.getCell(x).getStringCellValue());
                        if(x==3)
                            ageColumn.setText(row.getCell(x).getStringCellValue());
                        if(x==4)
                            professionColumn.setText(row.getCell(x).getStringCellValue());
                    }
                }else{
                Contacts contacts=new Contacts();
                for(int x=0;x<row.getLastCellNum();x++){
                    Cell cell=row.getCell(x);
                    if(x==0){
                        contacts.setName(cell.getStringCellValue());
                    }if(x==1){
                        contacts.setPhoneNumber(cell.getNumericCellValue());
                    }if(x==2){
                        contacts.setAddress(cell.getStringCellValue());
                    }if(x==3){
                        contacts.setAge(cell.getNumericCellValue());
                    }if(x==4){
                        contacts.setProfession(cell.getStringCellValue());
            }
            }list.add(contacts);
        }
        }
        }
        
        return list;
    }
    
}


//           while(rowIterator.hasNext())
//            {
//                Contacts contact=new Contacts();
//                Iterator<Cell> cellIterator=rowIterator.next().iterator();
//                while(cellIterator.hasNext()){
//                    Cell cell=cellIterator.next();
//                    if(cell.getCellTypeEnum()== CellType.STRING ){
//                        System.out.println(cell.getStringCellValue());
//                        contact.setName(cell.getStringCellValue());
//                    }else if(cell.getCellTypeEnum()==CellType.BOOLEAN){
//                        System.out.println(cell.getBooleanCellValue());
//                        contact.setIsAStudent(cell.getBooleanCellValue());
//                    }else if(cell.getCellTypeEnum()==CellType.NUMERIC){
//                        System.out.println(cell.getNumericCellValue());
//                        contact.setAge(cell.getNumericCellValue());
//                    }
//                   
//                } 
//                list.add(contact);
//            }
//  if(cell.getCellTypeEnum()==CellType.STRING){
//                    System.out.println(cell.getStringCellValue());
//                   
//                }
//                    if(cell.getCellTypeEnum()==CellType.NUMERIC){
//                    System.out.println(cell.getNumericCellValue());
//                }