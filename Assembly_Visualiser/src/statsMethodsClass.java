
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PramodEerolla
 */
public class statsMethodsClass extends myFrame{
    
//        // Method for calculating total genome length
    public int genomeLengthMethod() {
        genomeLength = 0;
        genomeString = "";

        for (String value : sequenceList.values()) {//gats values
            genomeLength += value.length();//for genome length estimation, it counts the values and saves it in the variable.
            genomeString += value;// for creating genome as a string to use in N50 calculation
        }
        
        return genomeLength;//returns genome length
    }
//
//    // method for counting N50
    public int N50countMethod() {
        int seqLength = 0;
        int sequencesLength = genomeString.length();
        int halfGenomelength = sequencesLength / 2;
        //gets values related to the keys and saves them into an array
        seqsArray = sequenceList.values().toArray(new String[0]);
        // sorts the array in descending order
        Arrays.sort(seqsArray, Comparator.comparingInt(String::length).reversed());

        int myN50 = 0;
        //for loop to count N50
        for (int i = 0; i < seqsArray.length; i++) {//loops through the array created above
            myN50 = myN50 + seqsArray[i].length();//saves the contig length into myN50 variable
            if (myN50 >= halfGenomelength) {// checks if the value is less than the half of genome length
                myN50 = seqsArray[i].length();// saves it into the variable if it meets the requirement
                break;// breaks out of the loop if the value meets the requirement
            }
        }
        return myN50;
    }
    // method for getting largest sequence in the genome assembly
    public int largestSeqLengthMethod() {
        maxlen = 0;
        int minlen = 2147483647;//sets min length 
        for (String key : sequenceList.keySet()) {
            //Math.max checks which sequence is the longest
            maxlen = Math.max(maxlen, sequenceList.get(key).length());            
        }
        return maxlen;// returns max length
    }

    // method for calculating GC content of selected contigs
    @SuppressWarnings({"ResultOfMethodCallIgnored", "element-type-mismatch"})
    public String GCcontentMethod(JComboBox box) {
        //combobox gets the selected item
        selectedContigs = sequenceList.get(box.getSelectedItem());
        selectedContigs.toLowerCase();//turns the sequece into ower case to compare G and C
        double gc = 0.0;
        for (int i = 0; i < selectedContigs.length(); i++) {
            char c = selectedContigs.charAt(i);
            if (c == 'G' || c == 'C') {// checks if the character is equal to G or C
                gc++;
            }            
        }
        //formula for calculating GC content
        gcContent = (gc / selectedContigs.length() * 100);        
        f = new DecimalFormat("##.00");// limiting ddecimal values to 2 point
        String formattedGC = f.format(gcContent); // formats the the gcContent and saves as a string
        return formattedGC;  
        
    }    
}
