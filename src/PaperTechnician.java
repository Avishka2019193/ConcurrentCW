import utils.Utility;

import static java.lang.Thread.sleep;

public class PaperTechnician implements Runnable {


    private String name;
    private ThreadGroup group;
    private ServicePrinter printer;

    public PaperTechnician(String name, ThreadGroup group, ServicePrinter printer) {
        super();
        this.name = name;
        this.group = group;
        this.printer = printer;
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("["+ Utility.getCurrentDateTime()+"] "+"  [Paper Technician] : Requested refill paper. ");
                ((LaserPrinter)printer).refillPaper();

                System.out.println("[" + Utility.getCurrentDateTime() + "] "+"  [Paper Technician] :" +" Printer Status : " + printer.toString());
                sleep(Utility.generateRandomWaitTime());

            } catch (InterruptedException e) {
                System.out.println(e.toString());;
            }

        }
    }
}


//    }
//}
//        int count = 0;
//        for (int i = 0; i < 3; i++) {
//            printer.refillPaper();
//
//            if (((LaserPrinter) printer).isPaper_Re_Filled()) {
//                count++;
//
//            }
//            int num = ((int) Math.random() * 100 + 1); // math.random gives value between 0.0 to 1.0 that is why multiply by 100. and then type cast it to the integer.
//
//            try {
//                Thread.sleep(num);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Paper Technician finished, packs of paper used :" + count);
//        }
//
//    }
//        for (int i = 0 ; i < 3 ; i++ ) {
//            int prev = ((LaserPrinter)printer).getCurrent_paper_level();
//            printer.refillPaper();
//            int currnt = ((LaserPrinter)printer).getCurrent_toner_level();
//            if(prev+ ServicePrinter.SheetsPerPack == currnt){//important ==> this is buggy , fix it
//                count_1++;
//            }
//            int num = ((int)Math.random()*100 + 1); // math.random gives value between 0.0 to 1.0 that is why multiply by 100. and then type cast it to the integer.
//            try {
//                Thread.sleep(num);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

//    }
//}
