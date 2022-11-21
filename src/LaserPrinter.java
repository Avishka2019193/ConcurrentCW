import utils.Utility;

public class LaserPrinter implements ServicePrinter {

    private String name;
    private int printer_id;
    private int current_paper_level;
    private int current_toner_level;
    private int  document_printed;
    private boolean paper_Re_Filled = false ; // to keep track of call to refill paper() is successful or not.

    private boolean toner_Replaced = false ; //to keep track of call to tonerreplaced() is successful or not.

    public LaserPrinter(String name, int printer_id, int current_paper_level, int current_toner_level, int document_printed) {
        super();
        this.name = name;
        this.printer_id = printer_id;
        this.current_paper_level = current_paper_level;
        this.current_toner_level = current_toner_level;
        this.document_printed = 0; //(+= 1 )
    }

    public boolean isToner_Replaced() {
        return toner_Replaced;
    }

    public boolean isPaper_Re_Filled() {
        return paper_Re_Filled;
    }
    public int getCurrent_paper_level() {
        return current_paper_level;
    }

    public int getCurrent_toner_level() {
        return current_toner_level;
    }

    @Override
    public  synchronized void printDocument(Document document) {
        while(!(document.getNumberOfPages()<= current_paper_level) && document.getNumberOfPages() <= current_toner_level) {
//            if (current_toner_level < Minimum_Toner_Level - 1) {//added due to some validations errors to check
                try {
                    wait();// Exception using to stop occurring interruption because of the wait method.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//        }
                this.current_paper_level -= document.getNumberOfPages();
                this.current_toner_level -= document.getNumberOfPages();
                this.document_printed++;

                System.out.println("[" + Utility.getCurrentDateTime() + "]" + "   [Printer] : " + document);

                notifyAll();
            }





    @Override
    public synchronized void replaceTonerCartridge() {
        boolean tried_refill_Toner = false ;
        this. toner_Replaced = false;
        while(this.current_toner_level > (Minimum_Toner_Level - 1)){
            if (tried_refill_Toner){
                break;
            }
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tried_refill_Toner = true;
        }
        if(this.current_toner_level < Minimum_Toner_Level){
            this.current_toner_level = 500 ;
            this. toner_Replaced = true;
        }
        notifyAll();

    }
//        int count_1 = 0 ;
//        while(count_1 < 2){
//                if(this.current_toner_level > (Minimum_Toner_Level - 1)){
//                    this.current_toner_level = 500 ;
//                    break;
//                }
//                else {
//                    try {
//                        wait(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    this.current_toner_level = PagesPerTonerCartridge;
//                    notifyAll();
//                }
//        }
//    }

    @Override
    public synchronized void refillPaper() {
        boolean tried_refill = false ;
        this.paper_Re_Filled = false ;
        while (!(this.current_paper_level <= (Full_Paper_Tray - 50))) {
            if (tried_refill == true) {
                break;
            }
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tried_refill = true;
        }
            if(this.current_paper_level <= (Full_Paper_Tray - 50)){
                this.current_paper_level += 50;
                this.paper_Re_Filled = true ;
            }
            notifyAll();

        }



//        int count_2 = 0 ;
//            //currentpaperlevel = 201 count = 0
//           // 0 < 2 = true
//        while(count_2 < 2){
//            // 201 <= 200 = false goes to else
//            if( this.current_paper_level <= (Full_Paper_Tray - 50 )){
//                this.current_paper_level += 50;
//                break;
//            }else {
//                if (count_2 == 1){
//                    break;
//                }
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            count_2++;
//
//        }}




    @Override
    public String toString() {
        return "LaserPrinter { " +
                "Printer Id=" + name + printer_id +
                ", Current Paper Level=" + current_paper_level +
                ", Current Toner Level=" + current_toner_level +
                ", Documents Printed : " + document_printed +
                '}';
    }
}
