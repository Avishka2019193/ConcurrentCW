import utils.Utility;

import static java.lang.Thread.sleep;

public class TonerTechnician implements  Runnable {
    private String name;
    private ThreadGroup group;
    private ServicePrinter printer;

    public TonerTechnician(String name, ThreadGroup group, ServicePrinter printer) {
        super();
        this.name = name;
        this.group = group;
        this.printer = printer;
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {

                System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Toner Technician] : Requested replace Toner");

                ((LaserPrinter) printer).replaceTonerCartridge();


                System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Toner Technician] :" + " Printer Status" + printer.toString());

                sleep(Utility.generateRandomWaitTime());
            } catch (InterruptedException e) {
                System.out.println(e.toString());

            }
        }

//        int count = 0;
//        for (int i = 0; i < 3; i++) {
//            printer.replaceTonerCartridge();
//            if (((LaserPrinter) printer).isToner_Replaced()) {
//                count++;
//
//            }
//            int num = ((int) Math.random() * 100 + 1);// math.random gives value between 0.0 to 1.0 that is why multiply by 100. and then type cast it to the integer.
//
//            try {
//
//                Thread.sleep(num);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Toner Technician finished, Toner used :" + count);
//        }


    }

}