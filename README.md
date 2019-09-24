# Assembly Visualiser using Java

Java program for visualising assembly scaffolds or contigs and compute the assembly quality metrics N50, Average scaffold/contig length, Total length, Largest scaffold and largest contig, total no. of contigs. 


## Requirements

* This program requires Java vesrion 8 or later installed.
* The program uses `jfreechart-1.0.23.jar` and `jcommon-1.0.19.jar` to compute and display the bar chart. These two files are attached within this repository. You will need to add them to libraries if it is being run using an IDE.
* The datasets `genome.scf.fasta` and `Blast2GO_gff.gff` are available within this repository.

The distribution `Assembly_Viewer.jar` file is found in the `Assembly_Visualiser/dist` folder. Running this `.jar` file will open up the GUI window where user can load both `FASTA` and `GFF` files using the file menu.

**Note: Larger assemblies take longer to load. The `genome.scf.fasta` may take 20-30 seconds to load as it perform statisitcs and visualisation in the background.**


## Expected Results

![alt text](https://github.com/eerollapramod/Assembly_Visualiser/blob/master/Assembly_visualiser.png)

In the image above:
* The "Assembly information" section shows the filename of the assembly along with its essential statistics like No.of sequences, N50, Average sequence length, Total length, and the largest sewuence length.
* The Text area below "Assembly information" section shows the sequence of the very first contig of the assembly. 
* The labels below the sequence show "contig length", and the "GC content" of displayed/selected contig/scaffold.
* The scroll bar shows the identifier of the scaffold/contig that is displayed in the text area.
* User can select desired scaffold using the scroll bar to get the sequence, the contig length and the GC content of that contig.
* The program visualises the the contig/scaffolds in the "Bar Chart" area. It highlights the contig of N50 in blue color.
* The sequence ID, Type, Start & End positions, and the Scores are displayed in the table once the `GFF` file is loaded using "File" tab.





