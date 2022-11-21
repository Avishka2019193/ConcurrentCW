import utils.Utility;
public class PrintingSystem {
//    public static String getCurrentDateTime(){
//        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("HH:mm:ss:SSS");
//        LocalDateTime now =LocalDateTime.now();
//        return(dtf.format(now));
//    }
    public static void main(String[] args) {

        ServicePrinter printer = new LaserPrinter("Printer_J",1,250,500,0);
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] "+"Initialised Printer.");


        ThreadGroup threadGroup_student = new ThreadGroup("Student");
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] CREATED THREAD GROUP "+threadGroup_student.getName());
        ThreadGroup threadGroup_technician = new ThreadGroup( "Technician");
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] CREATED THREAD GROUP "+threadGroup_technician.getName());

        Runnable student_1 = new Student("Han",threadGroup_student,printer);
        Runnable student_2 = new Student("Janice",threadGroup_student,printer);
        Runnable student_3 = new Student("Kumar",threadGroup_student,printer);
        Runnable student_4 = new Student("Navi",threadGroup_student,printer);


        Thread student_thread_01 = new Thread(threadGroup_student,student_1,"Han");
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Initializing Student       : " +student_thread_01.getName());
        Thread student_thread_02 = new Thread(threadGroup_student,student_2,"Janice");
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Initializing Student       : " +student_thread_02.getName());
        Thread student_thread_03 = new Thread(threadGroup_student,student_3,"Kumar");
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Initializing Student       : " +student_thread_03.getName());
        Thread student_thread_04 = new Thread(threadGroup_student,student_4,"Navi");
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Initializing Student       : " +student_thread_04.getName());



        Runnable paperTechnician = new PaperTechnician("John",threadGroup_technician,printer);
        Runnable tonerTechnician = new TonerTechnician("DonDee",threadGroup_technician,printer);

        Thread paperTechnician_thread = new Thread(threadGroup_technician,paperTechnician, "John");
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Initializing Technician    : " +paperTechnician_thread.getName());
        Thread tonerTechnician_thread = new Thread(threadGroup_technician,tonerTechnician,"DonDee");
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Initializing Technician    : " +tonerTechnician_thread.getName());


        student_thread_01.start();
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Started Student            : " + student_thread_01.getName() );
        student_thread_02.start();
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Started Student            : "+ student_thread_02.getName() );
        student_thread_03.start();
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Started Student            : "+ student_thread_03.getName() );
        student_thread_04.start();
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Started Student            : "+ student_thread_04.getName() );

        paperTechnician_thread.start();
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Started Technician         : "+ paperTechnician_thread.getName() );
        tonerTechnician_thread.start();
        System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System] Started Technician         : "+ tonerTechnician_thread.getName() );


        try {
            student_thread_01.join();
            System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Student] : "+ student_thread_01.getName()+"Completed Printing.");
            student_thread_02.join();
            System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Student] : "+ student_thread_02.getName()+"Completed Printing.");
            student_thread_03.join();
            System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Student] : "+ student_thread_03.getName()+"Completed Printing.");
            student_thread_04.join();
            System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Student] : "+ student_thread_04.getName()+"Completed Printing.");

            paperTechnician_thread.join();
            System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Paper Technician] : "+ paperTechnician_thread.getName()+"Completed refilling paper.");
            tonerTechnician_thread.join();
            System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Toner Technician] : "+ tonerTechnician_thread.getName()+"Completed replacing cartridge.");

            System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System]  : All the tasks are completed.");
            System.out.println("["+ Utility.getCurrentDateTime()+"]"+"   [Printing System]  : "+printer.toString());
        } catch (InterruptedException e) {
           e.printStackTrace();
        }


    }

}
