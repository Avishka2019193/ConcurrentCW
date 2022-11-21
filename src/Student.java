import utils.Utility;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Student implements Runnable {

    private String name;
    private ThreadGroup group;
    private Printer printer;

    public Student(String name, ThreadGroup group, Printer printer) {
        super();
        this.name = name;
        this.group = group;
        this.printer = printer;
    }

    public String getName() {
        return name;
    }
    //Generate Document id using student name and DocName(which is initialised in the for loop).
    private  String generateDocumentID(String studentName, String documentName) {
        return studentName+"_"+ documentName;
    }
    //Generate Random page count for the documents.
    private  int generateRandomPageCount(){
        return new Random().nextInt(20)+1;
    }
    //Generate Random sleep(wait) time for the process.

    @Override
    public void run() {
//
//        Document[] document = new Document[4];
//        document[0] = new Document("Doc001", "6SENG006C_CW", 20);
//        document[1] = new Document("Doc002", "6C0SCO23C_CW01_PP", 3);
//        document[2] = new Document("Doc003", "6C0SCO23C_CW02_PSPD", 7);
//        document[3] = new Document("Doc004", "6SENG005C_CW01", 3);
////        document[4] = new Document("Doc005", "Final_Project_Draft", 20);
        int noOfPages = 0;

        for (int i = 0; i < 5; i++) {
            String docName = "doc" + (i + 1);
            Document document = new Document(generateDocumentID(this.getName(), docName), docName, generateRandomPageCount());
            System.out.println("[" + Utility.getCurrentDateTime() + "]" + "   [Student] : " + this.getName() + " Request to print : " + document);

            printer.printDocument(document);

            System.out.println("[" + Utility.getCurrentDateTime() + "]" + "   [Student] :" + " Printer Status : " + printer.toString());
            try {
                sleep(Utility.generateRandomWaitTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//        for (Document doc:document){
//            printer.printDocument(doc);
//            noOfPages += doc.getNumberOfPages();
//
//            int num = ((int)Math.random()*100 + 1); // math.random gives value between 0.0 to 1.0 that is why multiply by 100. and then type cast it to the integer.
//
//            try {
//               Thread.sleep(num);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//        System.out.println(Thread.currentThread().getName()+"Finished Printing: 5 Documents ," + noOfPages + " pages "); //Printing Student Name whose document is finished priting
//
//    }
//}
