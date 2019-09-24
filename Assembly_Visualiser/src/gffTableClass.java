
import au.com.bytecode.opencsv.CSVReader;
import java.awt.FileDialog;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PramodEerolla
 */
public class gffTableClass extends myFrame {
    
    public void gffTableMethod(JTable gffTable){
        FileDialog nameBox;//creates a namebox
        // links namebox to to jmenu item
        nameBox = new FileDialog(this, "Open GFF File", FileDialog.LOAD);
        nameBox.setVisible(true);// displays namebox to browse through directories
        gffFileDir = nameBox.getDirectory();// lets the user to get teh directoruy
        gffFilename = nameBox.getFile();//retrieves the filename
        gffFilename = gffFileDir.concat(gffFilename);//cancatenates filename and directtory
        // get default table model
        DefaultTableModel table = (DefaultTableModel) gffTable.getModel();
        try {// CSV reader to detect the input and seperate it by tab
            CSVReader reader = new CSVReader(new FileReader(gffFilename),'\t');
            String[] nextLine;// reads first line
            while ((nextLine = reader.readNext())!=null) {// checks if the line isempty or not
                // make sure to ignore information at the begining of the tabele
                if(!Arrays.toString(nextLine).contains("#")){ //checks if the fasta file line contains # as it has to be ignored 
                    // reads through thefiles and populates them into table model according to ther columns headers
                    table.addRow(new Object[]{nextLine[0],nextLine[2],nextLine[3],nextLine[4],nextLine[5]});
                }else{                     
                }                
            }                        
        } catch (IOException e) {
            System.out.println("file not found" + e);// Catches is the file is not found
        }        
    }    
}
