package cgginterns.hibernate;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("Program created....");
        //sesiosnfactory is an interface 
        //SessionFactory factory = new Configuration().configure().buildSessionFactory();
        //above command in 3 steps
        //if the hibernate.cfg.xml is in some other path mention that path in configure;
        //->cfg.configure(cgginterns/hibernate/hibernate.cfg.xml);--path
        //if name ther cfg.configure(hiber.cfg.xml);---name
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        
        
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
        Student student = new Student();//creating student object
        student.setId(31);
        student.setName( "Bass");
        student.setCity("Sejur");
        
        //create addresss object
        
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("hyd");
        ad.setOpen(true);
        ad.setX(12.345);
        ad.setAddedDate(new Date());
        
        //reading and storing image
        try(FileInputStream fis=new FileInputStream("src/main/java/R.jfif");){
        	byte [] data =new byte[fis.available()];
        	fis.read(data);
        	ad.setImage(data);
        }
        catch(FileNotFoundException e){
        	e.printStackTrace();
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        
 //       Session session = factory.openSession(); //ask session for  factory to save object ask factory to give a session
        
//        session.beginTransaction();//for dml transaction is needed --ask session for txn
//        
//        session.save(student);//ask session to save student object
//        
//        session.getTransaction().commit();//commit code->save the object
        //second way of txn
        
        Session session=factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(student);
        session.save(ad);
        tx.commit();
        
        session.close();//need to close the session
        factory.close();
        
    }
}
