
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s284089
 */
public class fastaFileClass extends myFrame {
    
    // method for reading input file and putting it in a HashMap
    public void fastaMethod(JTextArea textArea) {
        FileDialog nameBox;//creates a namebox
        nameBox = new FileDialog(this, "Open Fasta File", FileDialog.LOAD);// links namebox to to jmenu item
        nameBox.setVisible(true);// displays namebox to browse through directories
        String fastaFileDirectory = nameBox.getDirectory();// lets the user to get teh directoruy
        myFilename = nameBox.getFile();//retrieves the filename
        String fastaFilename = fastaFileDirectory.concat(fastaFileClass.myFilename);//cancatenates filename and directtory
        if (fastaFilename.contains(".fa")) {//detects if the input is a .fasta file to kkep it specific
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fastaFilename));

                textArea.setText(null);//clears teh text area before anything is done
                String readNextLine;// reads first line
                String contig = "";
                StringBuilder build = new StringBuilder();// builds the string from input file
                while ((readNextLine = reader.readLine()) != null) {// checks if the line isempty or not
                    if (readNextLine.contains(">")) {//checks if the fasta file line contains > as it has to be ignored
                        build.setLength(0);
                        contig = readNextLine.substring(1, readNextLine.length()); // for contigs
                    } else {
                        build.append(readNextLine);

                    }
                    sequenceList.put(contig, build.toString());//puts it in the HashMap as per the key set
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
}
